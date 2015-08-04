/**
 * 
 */
package com.manicure.technician.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manicure.business.entity.Business;
import com.manicure.business.mapper.BusinessMapper;
import com.manicure.order.entity.OrderExtendExample;
import com.manicure.order.mapper.OrderCommentMapper;
import com.manicure.order.mapper.OrderExtendMapper;
import com.manicure.technician.entity.Technician;
import com.manicure.technician.iface.TechnicianService;
import com.manicure.technician.mapper.TechnicianMapper;

/**
 * @author VM
 *
 */
@Service("techService")
public class TechnicianServiceImp implements TechnicianService {
	
	 @Autowired
	 private TechnicianMapper tecMapper;
	 
	 @Autowired
	 private OrderExtendMapper orexMapper;
	 
	 @Autowired
	 private OrderCommentMapper orcMapper;
	 
	 @Autowired
	 private BusinessMapper busnMapper;
	 
	/* (non-Javadoc)
	 * @see com.manicure.technician.iface.TechnicianService#queryTechsByProductId(java.lang.String)
	 */
	@Override
	public List<Technician> queryTechsByProductId(String productId) {
		return tecMapper.selectByProductid(productId);
	}

	@Override
	public Technician queryTechInfoById(int id) {
		Technician tec = tecMapper.selectByPrimaryKey(id);
		if (null != tec) {
			OrderExtendExample  oee = new OrderExtendExample();
			oee.or().andTecIdEqualTo(id);
			int orderCount = orexMapper.countByExample(oee);
			tec.setOrderCount((long)orderCount);
			HashMap<String,Object> commentHashMap = orcMapper.getCommentInfoByTecId(id);
			tec.setCommentCount((Long)commentHashMap.get("comment_count"));
			tec.setEvaluation((BigDecimal)commentHashMap.get("evaluation"));
			tec.setStars((BigDecimal)commentHashMap.get("stars"));
			tec.setProfnalScore((BigDecimal)commentHashMap.get("profnal_score"));
			tec.setMoveScore((BigDecimal)commentHashMap.get("move_score"));
			tec.setPunctualScore((BigDecimal)commentHashMap.get("punctual_score"));
			List<Business> business = busnMapper.selectByTecId(id);
			StringBuffer busnName = new StringBuffer();
			for(Business bus:business){
				busnName.append(bus.getName()).append(",");
			}
			if(busnName.length() > 1){
				tec.setBusiness(busnName.substring(0, busnName.length() -1));
			} 
		}
		return tec;
	}

	@Override
	public List<Technician> queryTechsByProductIdAndPortalId(String productId, String portalId) {
		return  tecMapper.selectByProductidAndPortalId(productId,portalId);
	}

}
