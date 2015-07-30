/**
 * 
 */
package com.manicure.keystone.service.impl;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;

import com.manicure.base.helper.HttpClientUtil;
import com.manicure.base.service.BaseService;
import com.manicure.keystone.entity.error.ErrorMsg;
import com.manicure.keystone.service.iface.ICoreService;
import com.manicure.keystone.service.iface.IProductService;

/**
 * @author Barrie
 *
 */
@Service
public class ProductService extends BaseService implements IProductService {
	@Resource
	ICoreService coreService;

	public final int STATUS_ALL = 0;
	public final int STATUS_ON_SHELVES = 1;
	public final int STATUS_OFF_SHELVES = 2;

	/**
	 * 
	 */
	public JSONObject getProductList(String accessToken, int status) {
		String url = URL_PROGUCT_GET_LIST.replace("ACCESS_TOKEN", accessToken);

		JSONObject request = new JSONObject();
		request.put("status", status);

		JSONObject response = HttpClientUtil.doHttpsPost(url, "POST", request.toString());

		if (null == response) {
			ErrorMsg errMsg = new ErrorMsg();
			errMsg.setErrcode("-1");
			errMsg.setErrmsg("server is busy");

			return JSONObject.fromObject(errMsg);
		}

		return response;
	}

	public JSONObject getProduct(String accessToken, String productId) {
		String url = URL_PROGUCT_GET_DETAIL.replace("ACCESS_TOKEN", accessToken);

		JSONObject request = new JSONObject();
		request.put("product_id", productId);

		JSONObject response = HttpClientUtil.doHttpsPost(url, "POST", request.toString());

		if (null == response) {
			ErrorMsg errMsg = new ErrorMsg();
			errMsg.setErrcode("-1");
			errMsg.setErrmsg("server is busy");

			return JSONObject.fromObject(errMsg);
		}

		return response;
	}

	public JSONObject getProductGroupList(String accessToken) {
		String url = URL_PROGUCT_GROUP_GET_LIST.replace("ACCESS_TOKEN", accessToken);

		JSONObject response = HttpClientUtil.doHttpsPost(url, "GET", null);

		if (null == response) {
			ErrorMsg errMsg = new ErrorMsg();
			errMsg.setErrcode("-1");
			errMsg.setErrmsg("server is busy");

			return JSONObject.fromObject(errMsg);
		}

		return response;
	}

	public JSONObject getProductGroupDetail(String accessToken, String groupId) {
		String url = URL_PROGUCT_GROUP_GET_DETAIL.replace("ACCESS_TOKEN", accessToken);

		JSONObject request = new JSONObject();
		request.put("group_id", groupId);
		JSONObject response = HttpClientUtil.doHttpsPost(url, "POST", request.toString());

		if (null == response) {
			ErrorMsg errMsg = new ErrorMsg();
			errMsg.setErrcode("-1");
			errMsg.setErrmsg("server is busy");

			return JSONObject.fromObject(errMsg);
		}

		return response;
	}
}
