/**
 * 
 */
package com.manicure.order.controller;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;

import com.manicure.base.controller.BaseController;
import com.manicure.commmon.JsonUtil;
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

	@ResponseBody
	@RequestMapping(value = "/ordercomment/query", method = RequestMethod.GET)
	public String getOrderCommentsByTecId(@RequestParam("tecId") int tecId) {
		return JsonUtil.mapToJson(ordersService.queryOrderCommentsByTecId(tecId));
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
}
