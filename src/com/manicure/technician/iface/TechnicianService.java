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
	List<Technician> queryTechsByProductIdAndPortalId(String productId,String portalId);
	Technician queryTechInfoById(int id);
	List<String> queryTechOrderTime(int id);
}
