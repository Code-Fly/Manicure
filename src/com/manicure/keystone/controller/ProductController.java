/**
 * 
 */
package com.manicure.keystone.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.manicure.base.controller.BaseController;
import com.manicure.base.helper.Const;
import com.manicure.base.helper.FileUtil;
import com.manicure.base.helper.KeystoneUtil;
import com.manicure.keystone.entity.product.Product;
import com.manicure.keystone.entity.product.ProductBase;
import com.manicure.keystone.entity.product.ProductInfo;
import com.manicure.keystone.entity.product.ProductList;
import com.manicure.keystone.entity.product.SkuList;
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

	@RequestMapping(value = "/product/list/{status}/{groupId}/{orderBy}/{sort}")
	@ResponseBody
	public String getProductList(HttpServletRequest request, HttpServletResponse response, @PathVariable int status, @PathVariable String groupId, @PathVariable String orderBy,
			@PathVariable String sort, @RequestParam(value = "minPrice", required = false) String minPrice, @RequestParam(value = "maxPrice", required = false) String maxPrice) {
		Map<String, String> filter = new HashMap<String, String>();
		if (null != minPrice) {
			filter.put("minPrice", minPrice);
		}
		if (null != maxPrice) {
			filter.put("maxPrice", maxPrice);
		}
		String at = KeystoneUtil.accessToken;
		if (null == at) {
			logger.error(KeystoneUtil.errmsg);
			return KeystoneUtil.errmsg;
		}
		ProductList pList = new ProductList();
		if ("0".equals(groupId)) {
			JSONObject resp = productService.getProductList(at, status);
			if (resp.containsKey("errcode") && !resp.getString("errcode").equals("0")) {
				logger.error(resp.toString());
				return resp.toString();
			}
			Map<String, Class> classMap = new HashMap<String, Class>();
			classMap.put("products_info", ProductInfo.class);
			classMap.put("sku_list", SkuList.class);
			pList = (ProductList) JSONObject.toBean(resp, ProductList.class, classMap);
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
		} else {
			JSONObject respGroupDetail = productService.getProductGroupDetail(at, groupId);
			if (respGroupDetail.containsKey("errcode") && !respGroupDetail.getString("errcode").equals("0")) {
				logger.error(respGroupDetail.toString());
				return respGroupDetail.toString();
			}
			List<String> pIds = respGroupDetail.getJSONObject("group_detail").getJSONArray("product_list");
			List<ProductInfo> pInfos = new ArrayList<ProductInfo>();
			for (int i = 0; i < pIds.size(); i++) {
				JSONObject respProduct = productService.getProduct(at, pIds.get(i));
				if (respProduct.containsKey("errcode") && !respProduct.getString("errcode").equals("0")) {
					logger.error(respProduct.toString());
					return respProduct.toString();
				}
				Product p = (Product) JSONObject.toBean(respProduct, Product.class);
				ProductInfo pInfo = p.getProduct_info();
				pInfos.add(pInfo);

			}
			pList.setProducts_info(pInfos);
		}
		pList.sort(orderBy, sort, filter);

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
