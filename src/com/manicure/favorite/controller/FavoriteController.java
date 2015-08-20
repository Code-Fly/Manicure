package com.manicure.favorite.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.manicure.base.controller.BaseController;
import com.manicure.commmon.JsonUtil;
import com.manicure.favorite.entity.Favorite;
import com.manicure.favorite.iface.FavoriteService;

/**
 * 
 * @author zhangqw
 *
 */
@Controller
@RequestMapping(value = "/api/favorite")
public class FavoriteController extends BaseController {
	
	@Autowired
	private FavoriteService favoriteService;
	
	/**
	 * 收藏产品
	 * @param record
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST ,headers = "Content-Type=application/json")
	public @ResponseBody String addFavorite(@RequestBody Favorite record){
		favoriteService.insertSelective(record);
		return "success";
	}
	
	
	/**
	 * 获取收藏的产品信息
	 * @param record
	 */
	@ResponseBody
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public String queryFavorite(HttpServletRequest request,@RequestParam("buyerOpenid")String buyerOpenid){
		return JsonUtil.jsonArray2Sting(favoriteService.queryFavoriteProductByOpenId(request, buyerOpenid));
	}
}
