/**
 * 
 */
package com.manicure.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.manicure.base.controller.BaseController;
import com.manicure.web.service.impl.MobileService;

/**
 * @author Barrie
 *
 */
@Controller
@RequestMapping(value = "/mobile")
public class MobileController extends BaseController {
	@Resource
	MobileService mobileService;

	@RequestMapping(value = "/home")
	public String home(HttpServletRequest request, HttpServletResponse response) {
		mobileService.setUser(request);
		return "/mobile/home";
	}

	@RequestMapping(value = "/order")
	public String order(HttpServletRequest request, HttpServletResponse response) {
		mobileService.setUser(request);
		return "/mobile/order";
	}

	@RequestMapping(value = "/service")
	public String service(HttpServletRequest request, HttpServletResponse response) {
		mobileService.setUser(request);
		return "/mobile/service";
	}

	@RequestMapping(value = "/list")
	public String list(HttpServletRequest request, HttpServletResponse response) {
		mobileService.setUser(request);
		return "/mobile/list";
	}

	@RequestMapping(value = "/space")
	public String space(HttpServletRequest request, HttpServletResponse response) {
		mobileService.setUser(request);
		return "/mobile/space";
	}

	@RequestMapping(value = "/product/{productId}")
	public String item(HttpServletRequest request, HttpServletResponse response, ModelMap model, @PathVariable String productId) {
		model.addAttribute("pid", productId);
		mobileService.setUser(request);
		return "/mobile/product";
	}

	@RequestMapping(value = "/purchase-input-address")
	public String purchaseInputAddress(HttpServletRequest request, HttpServletResponse response) {
		mobileService.setUser(request);
		return "/mobile/purchase-input-address";
	}

	@RequestMapping(value = "/purchase-select-shop")
	public String purchaseSelectShop(HttpServletRequest request, HttpServletResponse response) {
		mobileService.setUser(request);
		return "/mobile/purchase-select-shop";
	}

	@RequestMapping(value = "/purchase-select-employee")
	public String purchaseSelectEmployee(HttpServletRequest request, HttpServletResponse response) {
		mobileService.setUser(request);
		return "/mobile/purchase-select-employee";
	}

	@RequestMapping(value = "/purchase-select-time")
	public String purchaseSelectTime(HttpServletRequest request, HttpServletResponse response) {
		mobileService.setUser(request);
		return "/mobile/purchase-select-time";
	}

	@RequestMapping(value = "/purchase-confirm")
	public String purchaseConfirm(HttpServletRequest request, HttpServletResponse response) {
		mobileService.setUser(request);
		return "/mobile/purchase-confirm";
	}

	@RequestMapping(value = "/technician")
	public String technicion(HttpServletRequest request, HttpServletResponse response) {
		mobileService.setUser(request);
		return "/mobile/technician";
	}

	@RequestMapping(value = { "/", "/index" })
	public String index(HttpServletRequest request, HttpServletResponse response) {

		mobileService.setUser(request);
		return "/mobile/home";
	}
}
