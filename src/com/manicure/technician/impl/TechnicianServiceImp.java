/**
 * 
 */
package com.manicure.technician.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manicure.base.helper.HttpClientUtil;
import com.manicure.base.service.BaseService;
import com.manicure.business.entity.Business;
import com.manicure.business.mapper.BusinessMapper;
import com.manicure.keystone.entity.product.ProductInfo;
import com.manicure.keystone.entity.product.ProductList;
import com.manicure.keystone.entity.product.SkuList;
import com.manicure.keystone.service.impl.ProductService;
import com.manicure.order.entity.OrderExtendExample;
import com.manicure.order.entity.TecService;
import com.manicure.order.entity.TecServiceExample;
import com.manicure.order.mapper.OrderCommentMapper;
import com.manicure.order.mapper.OrderExtendMapper;
import com.manicure.order.mapper.TecServiceMapper;
import com.manicure.technician.entity.Technician;
import com.manicure.technician.iface.TechnicianService;
import com.manicure.technician.mapper.TechnicianMapper;

import net.sf.json.JSONObject;

/**
 * @author VM
 *
 */
@Service("techService")
public class TechnicianServiceImp extends BaseService implements TechnicianService {

	@Autowired
	private TechnicianMapper tecMapper;

	@Autowired
	private OrderExtendMapper orexMapper;

	@Autowired
	private OrderCommentMapper orcMapper;

	@Autowired
	private BusinessMapper busnMapper;

	@Autowired
	private TecServiceMapper tecserviceMapper;

	@Resource
	private ProductService productService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.manicure.technician.iface.TechnicianService#queryTechsByProductId(
	 * java.lang.String)
	 */
	@Override
	public List<Technician> queryTechsByProductId(String productId) {
		List<Technician> techs = tecMapper.selectByProductid(productId);
		for (Technician tec : techs) {
			OrderExtendExample oee = new OrderExtendExample();
			oee.or().andTecIdEqualTo(tec.getId());
			int orderCount = orexMapper.countByExample(oee);
			tec.setOrderCount((long) orderCount);
			HashMap<String, Object> commentHashMap = orcMapper.getCommentInfoByTecId(tec.getId());
			tec.setCommentCount((Long) commentHashMap.get("comment_count"));
			tec.setEvaluation((BigDecimal) commentHashMap.get("evaluation"));
			tec.setStars((BigDecimal) commentHashMap.get("stars"));
			tec.setProfnalScore((BigDecimal) commentHashMap.get("profnal_score"));
			tec.setMoveScore((BigDecimal) commentHashMap.get("move_score"));
			tec.setPunctualScore((BigDecimal) commentHashMap.get("punctual_score"));
			List<Business> business = busnMapper.selectByTecId(tec.getId());
			StringBuffer busnName = new StringBuffer();
			for (Business bus : business) {
				busnName.append(bus.getName()).append(",");
			}
			if (busnName.length() > 1) {
				tec.setBusiness(busnName.substring(0, busnName.length() - 1));
			}
		}
		return techs;
	}

	@Override
	public Technician queryTechInfoById(int id) {
		Technician tec = tecMapper.selectByPrimaryKey(id);
		if (null != tec) {
			OrderExtendExample oee = new OrderExtendExample();
			oee.or().andTecIdEqualTo(id);
			int orderCount = orexMapper.countByExample(oee);
			tec.setOrderCount((long) orderCount);
			HashMap<String, Object> commentHashMap = orcMapper.getCommentInfoByTecId(id);
			tec.setCommentCount((Long) commentHashMap.get("comment_count"));
			tec.setEvaluation((BigDecimal) commentHashMap.get("evaluation"));
			tec.setStars((BigDecimal) commentHashMap.get("stars"));
			tec.setProfnalScore((BigDecimal) commentHashMap.get("profnal_score"));
			tec.setMoveScore((BigDecimal) commentHashMap.get("move_score"));
			tec.setPunctualScore((BigDecimal) commentHashMap.get("punctual_score"));
			List<Business> business = busnMapper.selectByTecId(id);
			StringBuffer busnName = new StringBuffer();
			for (Business bus : business) {
				busnName.append(bus.getName()).append(",");
			}
			if (busnName.length() > 1) {
				tec.setBusiness(busnName.substring(0, busnName.length() - 1));
			}
		}
		return tec;
	}

	@Override
	public List<Technician> queryTechsByProductIdAndPortalId(String productId, String portalId) {
		List<Technician> techs = tecMapper.selectByProductidAndPortalId(productId, portalId);
		for (Technician tec : techs) {
			OrderExtendExample oee = new OrderExtendExample();
			oee.or().andTecIdEqualTo(tec.getId());
			int orderCount = orexMapper.countByExample(oee);
			tec.setOrderCount((long) orderCount);
			HashMap<String, Object> commentHashMap = orcMapper.getCommentInfoByTecId(tec.getId());
			tec.setCommentCount((Long) commentHashMap.get("comment_count"));
			tec.setEvaluation((BigDecimal) commentHashMap.get("evaluation"));
			tec.setStars((BigDecimal) commentHashMap.get("stars"));
			tec.setProfnalScore((BigDecimal) commentHashMap.get("profnal_score"));
			tec.setMoveScore((BigDecimal) commentHashMap.get("move_score"));
			tec.setPunctualScore((BigDecimal) commentHashMap.get("punctual_score"));
			List<Business> business = busnMapper.selectByTecId(tec.getId());
			StringBuffer busnName = new StringBuffer();
			for (Business bus : business) {
				busnName.append(bus.getName()).append(",");
			}
			if (busnName.length() > 1) {
				tec.setBusiness(busnName.substring(0, busnName.length() - 1));
			}
		}
		return techs;
	}

	@Override
	public List<String> queryTechOrderTime(int tecId) {
		return tecMapper.selectTecOrdersTime(tecId);
	}

	@Override
	public List<ProductInfo> queryTechProducts(HttpServletRequest request, int id) {
		TecServiceExample tecServiceExample = new TecServiceExample();
		tecServiceExample.or().andTecIdEqualTo(id);
		List<TecService> tecServices = tecserviceMapper.selectByExample(tecServiceExample);
		if (null == tecServices) {
			return null;
		}
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
			return null;
		} else {
			logger.error(productInfo.toString());
		}
		Map<String, Class> classMap = new HashMap<String, Class>();
		classMap.put("products_info", ProductInfo.class);
		classMap.put("sku_list", SkuList.class);

		ProductList product = (ProductList) JSONObject.toBean(productInfo, ProductList.class,classMap);
		List<ProductInfo> tecProducts = new ArrayList<>();
		List<ProductInfo> products_info = product.getProducts_info();
		for (TecService tecService : tecServices) {
			for (ProductInfo productInfo2 : products_info) {
				if (null != tecService.getProductId()
						&& tecService.getProductId().equals(productInfo2.getProduct_id())) {
					tecProducts.add(productInfo2);
				}
			}
		}

		return tecProducts;
	}

}
