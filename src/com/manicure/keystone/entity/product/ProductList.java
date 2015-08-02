/**
 * 
 */
package com.manicure.keystone.entity.product;

import java.util.List;

import com.manicure.base.entity.BaseEntity;

/**
 * @author Barrie
 *
 */
public class ProductList extends BaseEntity {
	private int errcode;
	private String errmsg;
	private List<ProductInfo> products_info;

	/**
	 * @return the errcode
	 */
	public int getErrcode() {
		return errcode;
	}

	/**
	 * @param errcode
	 *            the errcode to set
	 */
	public void setErrcode(int errcode) {
		this.errcode = errcode;
	}

	/**
	 * @return the errmsg
	 */
	public String getErrmsg() {
		return errmsg;
	}

	/**
	 * @param errmsg
	 *            the errmsg to set
	 */
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	/**
	 * @return the products_info
	 */
	public List<ProductInfo> getProducts_info() {
		return products_info;
	}

	/**
	 * @param products_info
	 *            the products_info to set
	 */
	public void setProducts_info(List<ProductInfo> products_info) {
		this.products_info = products_info;
	}

}
