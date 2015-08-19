/**
 * 
 */
package com.manicure.technician.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;

import com.manicure.base.controller.BaseController;
import com.manicure.commmon.JsonUtil;
import com.manicure.keystone.entity.product.ProductInfo;
import com.manicure.technician.entity.Technician;
import com.manicure.technician.iface.TechnicianService;

/**
 * @author VM
 *
 */
@Controller
@RequestMapping(value = "/api/technician")
public class TechnicianController extends BaseController {
	
	@Autowired
	TechnicianService techService;
	
	/**
	 * 根据productId 查找能做该产品的技师
	 * @param productId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public String getTechByProductId(@RequestParam("productId") String productId){
		List<Technician> techs = techService.queryTechsByProductId(productId);
		return JsonUtil.jsonArray2Sting(techs);
	}
	

	/**
	 * 根据productId 查找能做该产品的技师
	 * @param productId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/query/{id}", method = RequestMethod.GET)
	public String getTechInfoById(@PathVariable  int id){
		Technician tech = techService.queryTechInfoById(id);
		if (null == tech) {
			return "";
		}
		return JsonUtil.json2Sting(tech);
	}
	
	
	/**
	 * 根据productId 查询A服务在B店里可选的技师列表
	 * @param productId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/query/{productId}/{portalId}", method = RequestMethod.GET)
	public String getTechByProductIdAndPortalId(@PathVariable("productId") String productId,@PathVariable("portalId") String portalId){
		List<Technician> techs = techService.queryTechsByProductIdAndPortalId(productId,portalId);
		return JsonUtil.jsonArray2Sting(techs);
	}
	
	/**
	 * 查询A服务在C技师的最近一周的预定单的时间
	 * @param params
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/{id}/orderstime", method = RequestMethod.GET)
	public String getTechOrdersTime(@PathVariable("id")int id){
		List<String> ordersTime = techService.queryTechOrderTime(id);
		return  JsonUtil.jsonArray2Sting(ordersTime);
	}
	
	/**
	 * 查询技师能做的所有服务
	 * @param params
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/{id}/products", method = RequestMethod.GET)
	public String getTechProducts(HttpServletRequest request,@PathVariable("id") int id){
		List<ProductInfo> productList = techService.queryTechProducts(request, id);
		return JsonUtil.jsonArray2Sting(productList);
	}
	

	/**
	 * 查询三好学员
	 * 好评分数最高的前十名技师
	 * @param params
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/query3good", method = RequestMethod.GET)
	public String get3GoodTechs(){
		List<Technician> tecs = techService.query3GoodTechs();
		return JsonUtil.jsonArray2Sting(tecs);
	}
}
