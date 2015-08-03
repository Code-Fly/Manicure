/**
 * 
 */
package com.manicure.technician.controller;


import java.util.List;

import net.sf.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;

import com.manicure.base.controller.BaseController;
import com.manicure.technician.entity.Technician;
import com.manicure.technician.iface.TechnicianService;

/**
 * @author VM
 *
 */
@Controller
@RequestMapping(value = "/technician")
public class TechnicianController extends BaseController {
	
	@Autowired
	TechnicianService techService;
	/**
	 * 根据productId 查找能做该产品的技师
	 * @param productId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public String getTechByProductId(@RequestParam("productId") String productId){
		List<Technician> techs = techService.queryTechsByProductId(productId);
		return JSONArray.fromObject(techs).toString();
	}
}