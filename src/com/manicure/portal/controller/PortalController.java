/**
 * 
 */
package com.manicure.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.manicure.base.controller.BaseController;
import com.manicure.portal.iface.PortalService;

import net.sf.json.JSONArray;

/**
 * @author zhangquanwei
 *
 */
@Controller
@RequestMapping(value = "/portal")
public class PortalController extends BaseController {
	
	
	@Autowired
	PortalService portalService;
	
	/**
	 * 根据服务id 查处能做该服务的门店id
	 * @param productId
	 * @return
	 */
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public  String  getPortalIds(@RequestParam("productId") String productId){
		logger.info("productId:"+productId);
		List<String> ids = portalService.getPortalIdsByProductId(productId);
		String portalIds = JSONArray.fromObject(ids).toString();
		logger.info(portalIds);
		return portalIds;
	}
}
