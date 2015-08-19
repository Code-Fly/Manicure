package com.manicure.favorite.iface;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.manicure.favorite.entity.Favorite;
import com.manicure.keystone.entity.product.ProductInfo;

public interface FavoriteService {
	int insertSelective(Favorite record);
	List<ProductInfo> queryFavoriteProductByOpenId(HttpServletRequest request,String openId);
}
