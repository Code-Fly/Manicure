/**
 * 
 */
package com.manicure.keystone.service.iface;

import net.sf.json.JSONObject;

/**
 * @author Barrie
 *
 */
public interface IMenuManager{
	public int create(JSONObject json, String accessToken);
}
