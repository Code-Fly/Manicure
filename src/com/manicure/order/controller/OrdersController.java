/**
 * 
 */
package com.manicure.order.controller;

import org.springframework.stereotype.Controller;
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
		return JsonUtil.jsonArray2Sting(ordersService.queryOrderCommentsByTecId(tecId));
	}
}
