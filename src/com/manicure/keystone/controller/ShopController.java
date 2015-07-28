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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.manicure.base.controller.BaseController;
import com.manicure.base.helper.KeystoneUtil;
import com.manicure.keystone.service.impl.CoreService;
import com.manicure.keystone.service.impl.ShopService;

/**
 * @author Barrie
 *
 */
@Controller
@RequestMapping(value = "/api/keystone")
public class ShopController extends BaseController {
	@Resource
	CoreService coreService;
	@Resource
	ShopService shopService;

	@RequestMapping(value = "/shop/query/{poiId}")
	@ResponseBody
	public String getShop(HttpServletRequest request, HttpServletResponse response, @PathVariable String poiId) {
		String at = KeystoneUtil.accessToken;
		if (null == at) {
			logger.error(KeystoneUtil.errmsg);
			return KeystoneUtil.errmsg;
		}

		JSONObject resp = shopService.getShop(at, poiId);
		if (resp.containsKey("errcode") && !resp.getString("errcode").equals("0")) {
			logger.error(resp.toString());
			return resp.toString();
		}
		return resp.toString();

	}

	@RequestMapping(value = "/shop/list/{begain}/{limit}")
	@ResponseBody
	public String getShopList(HttpServletRequest request, HttpServletResponse response, @PathVariable int begain, @PathVariable int limit) {
		String at = KeystoneUtil.accessToken;
		if (null == at) {
			logger.error(KeystoneUtil.errmsg);
			return KeystoneUtil.errmsg;
		}

		JSONObject resp = shopService.getShopList(at, begain, limit);
		if (resp.containsKey("errcode") && !resp.getString("errcode").equals("0")) {
			logger.error(resp.toString());
			return resp.toString();
		}
		return resp.toString();
	}
}
