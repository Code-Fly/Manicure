/**
 * 
 */
package com.manicure.technician.controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;

import com.manicure.base.controller.BaseController;
import com.manicure.commmon.Constant;
import com.manicure.technician.entity.Technician;
import com.manicure.technician.iface.TechnicianService;

/**
 * @author VM
 *
 */
@Controller
@RequestMapping(value = "/api/technician")
public class TechnicianController extends BaseController {
	
	@Autowired
	TechnicianService techService;
	/**
	 * 根据productId 查找能做该产品的技师
	 * @param productId
	 * @return
	 */
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public ModelAndView getTechByProductId(@RequestParam("productId") String productId){
		ModelAndView model = new ModelAndView(Constant.TECH_MODEL);
		List<Technician> techs = techService.queryTechsByProductId(productId);
		model.addObject(techs);
		return model;
		
	}
}
