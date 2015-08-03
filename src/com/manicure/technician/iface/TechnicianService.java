/**
 * 
 */
package com.manicure.technician.iface;

import java.util.List;

import com.manicure.technician.entity.Technician;

/**
 * @author VM
 *
 */
public interface TechnicianService {
	List<Technician> queryTechsByProductId(String productId);
	
	Technician queryTechInfoById(int id);
}
