/**
 * 
 */
package com.manicure.keystone.entity.product;

import com.manicure.base.entity.BaseEntity;

/**
 * @author Barrie
 *
 */
public class DeliveryInfo extends BaseEntity {
	private int delivery_type;
	private String template_id;

	/**
	 * @return the delivery_type
	 */
	public int getDelivery_type() {
		return delivery_type;
	}

	/**
	 * @param delivery_type
	 *            the delivery_type to set
	 */
	public void setDelivery_type(int delivery_type) {
		this.delivery_type = delivery_type;
	}

	/**
	 * @return the template_id
	 */
	public String getTemplate_id() {
		return template_id;
	}

	/**
	 * @param template_id
	 *            the template_id to set
	 */
	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}

}
