/**
 * 
 */
package com.manicure.portal.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manicure.portal.iface.PortalService;
import com.manicure.technician.entity.Technician;
import com.manicure.technician.mapper.TechnicianMapper;

/**
 * @author zhangquanwei
 *
 */
@Service("portalService")
public class PortalServiceImp implements PortalService {
	
	 @Autowired
	 private TechnicianMapper tecMapper;
	 
	public List<String> getPortalIdsByProductId(String productId) {
		List<String> portalIds = new ArrayList<>();
		List<Technician> technicians = tecMapper.selectByProductid(productId);
		if (technicians.size() > 0) {
			for (Technician technician : technicians) {
				portalIds.add(technician.getProtalId());
			}
		} 
		return portalIds;
	}

}
