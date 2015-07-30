/**
 * 
 */
package com.manicure.keystone.entity.request.order;

/**
 * @author Barrie
 *
 */
public class OrderListReq {
	private String status;
	private String begintime;
	private String endtime;

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the begintime
	 */
	public String getBegintime() {
		return begintime;
	}

	/**
	 * @param begintime
	 *            the begintime to set
	 */
	public void setBegintime(String begintime) {
		this.begintime = begintime;
	}

	/**
	 * @return the endtime
	 */
	public String getEndtime() {
		return endtime;
	}

	/**
	 * @param endtime
	 *            the endtime to set
	 */
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

}
