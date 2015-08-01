/**
 * 
 */
package com.manicure.keystone.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.manicure.base.controller.BaseController;
import com.manicure.base.helper.Const;
import com.manicure.base.helper.FileUtil;
import com.manicure.base.helper.KeystoneUtil;
import com.manicure.keystone.entity.product.Product;
import com.manicure.keystone.entity.product.ProductBase;
import com.manicure.keystone.entity.product.ProductInfo;
import com.manicure.keystone.entity.product.ProductList;
import com.manicure.keystone.service.impl.CoreService;
import com.manicure.keystone.service.impl.ProductService;

/**
 * @author Barrie
 *
 */
@Controller
@RequestMapping(value = "/api/keystone")
public class ProductController extends BaseController {
	@Resource
	CoreService coreService;
	@Resource
	ProductService productService;

	@RequestMapping(value = "/product/list/{status}")
	@ResponseBody
	public String getProductList(HttpServletRequest request, HttpServletResponse response, @PathVariable int status) {
		String at = KeystoneUtil.accessToken;
		if (null == at) {
			logger.error(KeystoneUtil.errmsg);
			return KeystoneUtil.errmsg;
		}

		JSONObject resp = productService.getProductList(at, status);
		if (resp.containsKey("errcode") && !resp.getString("errcode").equals("0")) {
			logger.error(resp.toString());
			return resp.toString();
		}
		Map<String, Class> classMap = new HashMap<String, Class>();
		classMap.put("products_info", ProductInfo.class);
		ProductList pList = (ProductList) JSONObject.toBean(resp, ProductList.class,classMap);
		List<ProductInfo> pInfos = pList.getProducts_info();
		for (int i = 0; i < pInfos.size(); i++) {
			ProductInfo pInfo = pInfos.get(i);
			ProductBase pBase = pInfo.getProduct_base();
			String imageUrl = Const.getServerUrl(request) + FileUtil.getWeChatImage(pBase.getMain_img(), FileUtil.CATEGORY_PRODUCT, pInfo.getProduct_id(), false);
			pBase.setMain_img(imageUrl);
			pInfo.setProduct_base(pBase);
			pInfos.set(i, pInfo);
		}
		pList.setProducts_info(pInfos);
		return JSONObject.fromObject(pList).toString();
	}

	@RequestMapping(value = "/product/query/{productId}")
	@ResponseBody
	public String getProduct(HttpServletRequest request, HttpServletResponse response, @PathVariable String productId) {
		String at = KeystoneUtil.accessToken;
		if (null == at) {
			logger.error(KeystoneUtil.errmsg);
			return KeystoneUtil.errmsg;
		}

		JSONObject resp = productService.getProduct(at, productId);
		if (resp.containsKey("errcode") && !resp.getString("errcode").equals("0")) {
			logger.error(resp.toString());
			return resp.toString();
		}
		Product p = (Product) JSONObject.toBean(resp, Product.class);
		ProductInfo pInfo = p.getProduct_info();
		ProductBase pBase = pInfo.getProduct_base();

		String imageUrl = Const.getServerUrl(request) + FileUtil.getWeChatImage(pBase.getMain_img(), FileUtil.CATEGORY_PRODUCT, pInfo.getProduct_id(), false);
		pBase.setMain_img(imageUrl);
		pInfo.setProduct_base(pBase);
		p.setProduct_info(pInfo);
		return JSONObject.fromObject(p).toString();
	}

	@RequestMapping(value = "/product/group/list")
	@ResponseBody
	public String getProductGroupList(HttpServletRequest request, HttpServletResponse response) {
		String at = KeystoneUtil.accessToken;
		if (null == at) {
			logger.error(KeystoneUtil.errmsg);
			return KeystoneUtil.errmsg;
		}

		JSONObject resp = productService.getProductGroupList(at);
		if (resp.containsKey("errcode") && !resp.getString("errcode").equals("0")) {
			logger.error(resp.toString());
			return resp.toString();
		}
		return resp.toString();
	}

	@RequestMapping(value = "/product/group/query/{groupId}")
	@ResponseBody
	public String getProductGroupDetail(HttpServletRequest request, HttpServletResponse response, @PathVariable String groupId) {
		String at = KeystoneUtil.accessToken;
		if (null == at) {
			logger.error(KeystoneUtil.errmsg);
			return KeystoneUtil.errmsg;
		}

		JSONObject resp = productService.getProductGroupDetail(at, groupId);
		if (resp.containsKey("errcode") && !resp.getString("errcode").equals("0")) {
			logger.error(resp.toString());
			return resp.toString();
		}
		return resp.toString();
	}
}
