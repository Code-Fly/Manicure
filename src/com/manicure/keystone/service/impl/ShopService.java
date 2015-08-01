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
import com.manicure.keystone.service.iface.IShopService;

/**
 * @author Barrie
 *
 */
@Service
public class ShopService extends BaseService implements IShopService {
	@Resource
	ICoreService coreService;

	/**
	 * 
	 */
	public JSONObject getShopList(String accessToken, int begin, int limit) {
		String url = URL_SHOP_GET_LIST.replace("TOKEN", accessToken);
		JSONObject request = new JSONObject();
		request.put("begin", begin);
		request.put("limit", limit);

		JSONObject response = HttpClientUtil.doHttpsRequest(url, "POST", request.toString());

		if (null == response) {
			ErrorMsg errMsg = new ErrorMsg();
			errMsg.setErrcode("-1");
			errMsg.setErrmsg("server is busy");

			return JSONObject.fromObject(errMsg);
		}
		return response;
	}

	/**
	 * 
	 */
	public JSONObject getShop(String accessToken, String poi_id) {
		String url = URL_SHOP_GET_DETAIL.replace("TOKEN", accessToken);

		JSONObject request = new JSONObject();
		request.put("poi_id", poi_id);

		JSONObject response = HttpClientUtil.doHttpsRequest(url, "POST", request.toString());

		if (null == response) {
			ErrorMsg errMsg = new ErrorMsg();
			errMsg.setErrcode("-1");
			errMsg.setErrmsg("server is busy");

			return JSONObject.fromObject(errMsg);
		}
		return response;
	}

}
