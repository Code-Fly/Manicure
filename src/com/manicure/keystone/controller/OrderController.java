/**
 * 
 */
package com.manicure.keystone.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.manicure.base.controller.BaseController;
import com.manicure.base.helper.KeystoneUtil;
import com.manicure.keystone.service.impl.CoreService;
import com.manicure.keystone.service.impl.OrderService;

/**
 * @author Barrie
 *
 */
@Controller
@RequestMapping(value = "/api/keystone")
public class OrderController extends BaseController {
	@Resource
	CoreService coreService;
	@Resource
	OrderService orderService;

	@RequestMapping(value = "/order/list/{status}")
	@ResponseBody
	public String getOrderList(HttpServletRequest request, HttpServletResponse response, @PathVariable String status, @RequestParam(value = "beginTime", required = false) String beginTime,
			@RequestParam(value = "endTime", required = false) String endTime) {
		if (null == beginTime) {
			beginTime = "0";
		}
		if (null == endTime) {
			endTime = "0";
		}

		String at = KeystoneUtil.getAccessToken();
		if (null == at) {
			logger.error(KeystoneUtil.getErrmsg());
			return KeystoneUtil.getErrmsg();
		}
		JSONObject resp = orderService.getOrderList(request, at, status, beginTime, endTime);
		if (resp.containsKey("errcode") && !resp.getString("errcode").equals("0")) {
			logger.error(resp.toString());
			return resp.toString();
		}

		return resp.toString();
	}

	@RequestMapping(value = "/order/query/{orderId}")
	@ResponseBody
	public String getOrder(HttpServletRequest request, HttpServletResponse response, @PathVariable String orderId) {
		String at = KeystoneUtil.getAccessToken();
		if (null == at) {
			logger.error(KeystoneUtil.getErrmsg());
			return KeystoneUtil.getErrmsg();
		}

		JSONObject resp = orderService.getOrder(request, at, orderId);
		if (resp.containsKey("errcode") && !resp.getString("errcode").equals("0")) {
			logger.error(resp.toString());
			return resp.toString();
		}
		return resp.toString();

	}
}
