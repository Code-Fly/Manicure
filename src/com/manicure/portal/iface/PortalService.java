/**
 * 
 */
package com.manicure.portal.iface;

import java.util.List;

/**
 * @author Administrator
 *
 */
public interface PortalService {
  List<String> getPortalIdsByProductId(String productId);
}
