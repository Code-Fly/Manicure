/**
 * 
 */
package com.manicure.web.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;

import com.manicure.base.helper.HttpClientUtil;
import com.manicure.base.helper.UrlUtil;
import com.manicure.base.service.BaseService;
import com.manicure.keystone.entity.user.WeChatUserInfo;
import com.manicure.web.service.iface.IMobileService;

/**
 * @author Barrie
 *
 */
@Service
public class MobileService extends BaseService implements IMobileService {
	public void setUser(HttpServletRequest request, HttpSession session) {
		WeChatUserInfo userInfo = new WeChatUserInfo();

		String code = request.getParameter("code");

		WeChatUserInfo currentUser = (WeChatUserInfo) session.getAttribute("user");
		// null == currentUser.getOpenid()
		if (null == currentUser || null == currentUser.getOpenid()) {
			String url = UrlUtil.getServerUrl(request, "/api/keystone/user/sns/oauth");
			Map<String, String> params = new HashMap<String, String>();
			params.put("code", code);
			String resp = HttpClientUtil.doPost(url, params, "UTF-8");
			if (null == resp) {
				logger.error("fail to post");
			}
			JSONObject jUserInfo = JSONObject.fromObject(resp);
			if (!jUserInfo.containsKey("errcode")) {
				userInfo = (WeChatUserInfo) JSONObject.toBean(jUserInfo, WeChatUserInfo.class);
				session.setMaxInactiveInterval(-1);
				session.setAttribute("user", userInfo);
			} else {
				logger.error(jUserInfo.toString());
			}
			
		}
		//session.removeAttribute("user");
		//session.setAttribute("user", new WeChatUserInfo());
		//System.out.println(new WeChatUserInfo());
	}
}
