/**
 * 
 */
package com.manicure.order.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;

import com.manicure.base.controller.BaseController;
import com.manicure.base.helper.HttpClientUtil;
import com.manicure.commmon.JsonUtil;
import com.manicure.keystone.entity.order.OrderBase;
import com.manicure.keystone.entity.order.OrderList;
import com.manicure.keystone.service.impl.OrderService;
import com.manicure.order.entity.OrderComment;
import com.manicure.order.entity.OrderExtendTmp;
import com.manicure.order.iface.OrderServiceInterface;

/**
 * @author zhangqw
 * 
 */
@Controller
@RequestMapping(value = "/api/order")
public class OrdersController extends BaseController {
	
	@Autowired
	private OrderServiceInterface ordersService;

	@Resource
	OrderService orderServiceimp;
	
	@ResponseBody
	@RequestMapping(value = "/ordercomment/query", method = RequestMethod.GET)
	public String getOrderCommentsByTecId(@RequestParam("tecId") int tecId) {
		return JsonUtil.jsonMap2Sting(ordersService.queryOrderCommentsByTecId(tecId));
	}
	
	/**
	 * 接收微信支付完成后的信息，获得订单id 插入到order_extend表
	 * @param params
	 */
	@RequestMapping(value = "/orderextend/update", method = RequestMethod.PUT)
	public void updateOrderExtendTmp(@RequestBody String params){
		JSONObject map = JSONObject.fromObject(params);
		String orderId = map.getString("orderId");
		String openId = map.getString("openId");
		String productId = map.getString("productId");
		ordersService.updateOrderExtendTmp(orderId, productId, openId);
	}
	
	/**
	 * 订单支付之前先把订单扩展信息存入临时表
	 * @param orderExtend
	 */
	@RequestMapping(value = "/orderextend/add", method = RequestMethod.POST ,headers = "Content-Type=application/json")
	public @ResponseBody String addOrderExtend(@RequestBody OrderExtendTmp orderExtend){
		ordersService.insertExtendSelective(orderExtend);
		return "0";
	}
	
	/**
	 * 保存订单评价信息
	 * @param params
	 */
	@RequestMapping(value = "/ordercomment/add", method = RequestMethod.POST,headers = "Content-Type=application/json")
	public @ResponseBody String addOrderComment(@RequestBody OrderComment orderComment){
		ordersService.insertCommentSelective(orderComment);
		return "0";
	}
	

	
	/***
	 * 处理下订单状态 增加已经评价状态
	 * 当评价表中有评价记录则该订单状态改成已经评价（前提是该订单已经在微信里是发货 （3）状态）
	 * @param request
	 * @param response
	 * @param status  传 3 其它无意义
	 * @param beginTime
	 * @param endTime
	 * @return 
	 */
	@RequestMapping(value = "/list/{status}")
	@ResponseBody
	public String getOrderList(HttpServletRequest request, HttpServletResponse response, @PathVariable String status, @RequestParam(value = "beginTime", required = false) String beginTime,
			@RequestParam(value = "endTime", required = false) String endTime) {
		String path = request.getContextPath();
		int port = request.getServerPort();
		String basePath = null;
		if (80 == port) {
			basePath = request.getScheme() + "://" + request.getServerName() + path;
		} else {
			basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
		}
		String url = basePath + "/api/keystone/order/list/"+ status;
		Map<String,String>  params =  new HashMap<String,String>();  
		params.put("beginTime", beginTime);
		params.put("endTime", endTime);
		String resp = HttpClientUtil.doGet(url, params, "UTF-8");
		Map<String, Class> classMap = new HashMap<String, Class>();
		classMap.put("order_list", OrderBase.class);
		JSONObject orderListJson = JSONObject.fromObject(resp);
		OrderList oList = (OrderList) JSONObject.toBean(orderListJson, OrderList.class, classMap);
		List<OrderBase> oInfos = oList.getOrder_list();
		for (int i = 0; i < oInfos.size(); i++) {
			OrderBase oInfo =oInfos.get(i);
			if(null != ordersService.selectByPrimaryKey(oInfo.getOrder_id())){
				// 已经评价 4
				oInfo.setOrder_status("4");
			}
			oInfos.set(i, oInfo);
		}
		oList.setOrder_list(oInfos);
		return JsonUtil.json2Sting(oList);
	}
}
