/**
 * 
 */
package com.manicure.keystone.entity.product;

import com.manicure.base.entity.BaseEntity;

/**
 * @author Barrie
 *
 */
public class AttrExt extends BaseEntity {
	private boolean isPostFree;
	private boolean isHasReceipt;
	private boolean isUnderGuaranty;
	private boolean isSupportReplace;
	private Location location;

	/**
	 * @return the isPostFree
	 */
	public boolean isPostFree() {
		return isPostFree;
	}

	/**
	 * @param isPostFree
	 *            the isPostFree to set
	 */
	public void setPostFree(boolean isPostFree) {
		this.isPostFree = isPostFree;
	}

	/**
	 * @return the isHasReceipt
	 */
	public boolean isHasReceipt() {
		return isHasReceipt;
	}

	/**
	 * @param isHasReceipt
	 *            the isHasReceipt to set
	 */
	public void setHasReceipt(boolean isHasReceipt) {
		this.isHasReceipt = isHasReceipt;
	}

	/**
	 * @return the isUnderGuaranty
	 */
	public boolean isUnderGuaranty() {
		return isUnderGuaranty;
	}

	/**
	 * @param isUnderGuaranty
	 *            the isUnderGuaranty to set
	 */
	public void setUnderGuaranty(boolean isUnderGuaranty) {
		this.isUnderGuaranty = isUnderGuaranty;
	}

	/**
	 * @return the isSupportReplace
	 */
	public boolean isSupportReplace() {
		return isSupportReplace;
	}

	/**
	 * @param isSupportReplace
	 *            the isSupportReplace to set
	 */
	public void setSupportReplace(boolean isSupportReplace) {
		this.isSupportReplace = isSupportReplace;
	}

	/**
	 * @return the location
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * @param location
	 *            the location to set
	 */
	public void setLocation(Location location) {
		this.location = location;
	}

}
