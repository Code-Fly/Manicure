/**
 * 
 */
package com.manicure.keystone.service.iface;

import net.sf.json.JSONObject;

/**
 * @author Barrie
 *
 */
public interface IOrderService {
	public JSONObject getOrderList(String accessToken, String status, String beginTime, String endTime);

	public JSONObject getOrder(String accessToken, String orderId);

	public int getOrderCount(JSONObject oList, String productId);
}
