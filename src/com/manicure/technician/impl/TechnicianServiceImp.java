/**
 * 
 */
package com.manicure.technician.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	/* (non-Javadoc)
	 * @see com.manicure.technician.iface.TechnicianService#queryTechsByProductId(java.lang.String)
	 */
	@Override
	public List<Technician> queryTechsByProductId(String productId) {
		return tecMapper.selectByProductid(productId);
	}

}
