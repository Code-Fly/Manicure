package com.manicure.favorite.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manicure.base.helper.HttpClientUtil;
import com.manicure.base.service.BaseService;
import com.manicure.favorite.entity.Favorite;
import com.manicure.favorite.entity.FavoriteExample;
import com.manicure.favorite.iface.FavoriteService;
import com.manicure.favorite.mapper.FavoriteMapper;
import com.manicure.keystone.entity.product.ProductInfo;
import com.manicure.keystone.entity.product.ProductList;
import com.manicure.keystone.entity.product.SkuList;

/**
 * 
 * @author zhangqw
 *
 */
@Service("favoriteService")
public class FavoriteServiceImp extends BaseService implements FavoriteService {
	
	@Autowired
	private FavoriteMapper favoriteMapper;
	@Override
	public int insertSelective(Favorite record) {
		FavoriteExample fe = new FavoriteExample();
		fe.or().andBuyerOpenidEqualTo(record.getBuyerOpenid()).andProductIdEqualTo(record.getProductId());
		// 同一个商品不能收藏两次
		if (null == favoriteMapper.selectByExample(fe)){
			return favoriteMapper.insertSelective(record);
		} 
		else
		{
			return favoriteMapper.updateByExampleSelective(record, fe);
		}
		
	}
	@Override
	public List<ProductInfo> queryFavoriteProductByOpenId(
			HttpServletRequest request, String openId) {
		List<ProductInfo>  productsInfo = new ArrayList<>();
		FavoriteExample fe = new FavoriteExample();
		fe.or().andBuyerOpenidEqualTo(openId);
		List<Favorite> favorites = favoriteMapper.selectByExample(fe);
		if(0 == favorites.size())
			return productsInfo;
		String path = request.getContextPath();
		int port = request.getServerPort();
		String basePath = null;
		if (80 == port) {
			basePath = request.getScheme() + "://" + request.getServerName() + path;
		} else {
			basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
		}
		String url = basePath + "/api/keystone/product/list/1";
		Map<String, String> params = new HashMap<String, String>();
		String resp = HttpClientUtil.doGet(url, params, "UTF-8");
		if (null == resp) {
			logger.error("fail to get");
		}
		JSONObject productInfo = JSONObject.fromObject(resp);
		if (!productInfo.containsKey("errcode")) {
			return productsInfo;
		} else {
			logger.info(productInfo.toString());
		}
		Map<String, Class> classMap = new HashMap<String, Class>();
		classMap.put("products_info", ProductInfo.class);
		classMap.put("sku_list", SkuList.class);

		ProductList product = (ProductList) JSONObject.toBean(productInfo, ProductList.class,classMap);
		List<ProductInfo> products_info = product.getProducts_info();
		if(null == products_info || 0==products_info.size())
			return productsInfo;
		for(Favorite favorite : favorites){
			for(ProductInfo p : products_info ){
				if(p.getProduct_id().equals(favorite.getProductId())){
					productsInfo.add(p);
				}
			}
		}
		return productsInfo;
	}

}
