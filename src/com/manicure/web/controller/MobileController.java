/**
 * 
 */
package com.manicure.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	public String home(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		mobileService.setUser(request, session);
		return "/mobile/home";
	}

	@RequestMapping(value = "/order-list")
	public String order(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		mobileService.setUser(request, session);
		return "/mobile/order-list";
	}

	@RequestMapping(value = "/service")
	public String service(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		mobileService.setUser(request, session);
		return "/mobile/service";
	}

	@RequestMapping(value = "/product-list")
	public String productList(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		mobileService.setUser(request, session);
		return "/mobile/product-list";
	}

	@RequestMapping(value = "/space")
	public String space(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		mobileService.setUser(request, session);
		return "/mobile/space";
	}

	@RequestMapping(value = "/product/{productId}")
	public String productDetail(HttpServletRequest request, HttpServletResponse response, HttpSession session, ModelMap model, @PathVariable String productId) {
		model.addAttribute("pid", productId);
		mobileService.setUser(request, session);
		return "/mobile/product-detail";
	}

	@RequestMapping(value = "/purchase-input-address")
	public String purchaseInputAddress(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		mobileService.setUser(request, session);
		return "/mobile/purchase-input-address";
	}

	@RequestMapping(value = "/purchase-select-shop")
	public String purchaseSelectShop(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		mobileService.setUser(request, session);
		return "/mobile/purchase-select-shop";
	}

	@RequestMapping(value = "/purchase-select-employee")
	public String purchaseSelectEmployee(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		mobileService.setUser(request, session);
		return "/mobile/purchase-select-employee";
	}

	@RequestMapping(value = "/purchase-select-time")
	public String purchaseSelectTime(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		mobileService.setUser(request, session);
		return "/mobile/purchase-select-time";
	}

	@RequestMapping(value = "/purchase-confirm")
	public String purchaseConfirm(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		mobileService.setUser(request, session);
		return "/mobile/purchase-confirm";
	}

	@RequestMapping(value = "/technician")
	public String technicion(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		mobileService.setUser(request, session);
		return "/mobile/technician";
	}
	
	@RequestMapping(value = "/shop-list")
	public String shopList(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		mobileService.setUser(request, session);
		return "/mobile/shop-list";
	}
	
	@RequestMapping(value = "/shop-detail")
	public String shopDetail(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		mobileService.setUser(request, session);
		return "/mobile/shop-detail";
	}
	
	@RequestMapping(value = "/technician-comment-list")
	public String technicianCommentList(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		mobileService.setUser(request, session);
		return "/mobile/technician-comment-list";
	}

	@RequestMapping(value = { "/", "/index" })
	public String index(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		mobileService.setUser(request, session);
		return "/mobile/home";
	}
}
