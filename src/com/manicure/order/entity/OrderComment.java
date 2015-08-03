package com.manicure.order.entity;

import java.util.Date;
import java.math.BigDecimal;

public class OrderComment {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column order_comment.order_id
	 * @mbggenerated  Sun Aug 02 16:18:04 CST 2015
	 */
	private Integer orderId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column order_comment.stars
	 * @mbggenerated  Sun Aug 02 16:18:04 CST 2015
	 */
	private BigDecimal stars;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column order_comment.profnal_score
	 * @mbggenerated  Sun Aug 02 16:18:04 CST 2015
	 */
	private BigDecimal profnalScore;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column order_comment.move_score
	 * @mbggenerated  Sun Aug 02 16:18:04 CST 2015
	 */
	private BigDecimal moveScore;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column order_comment.punctual_score
	 * @mbggenerated  Sun Aug 02 16:18:04 CST 2015
	 */
	private BigDecimal punctualScore;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column order_comment.description
	 * @mbggenerated  Sun Aug 02 16:18:04 CST 2015
	 */
	private String description;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column order_comment.time
	 * @mbggenerated  Sun Aug 02 16:18:04 CST 2015
	 */
	private Date time;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column order_comment.pic1
	 * @mbggenerated  Sun Aug 02 16:18:04 CST 2015
	 */
	private String pic1;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column order_comment.pic2
	 * @mbggenerated  Sun Aug 02 16:18:04 CST 2015
	 */
	private String pic2;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column order_comment.pic3
	 * @mbggenerated  Sun Aug 02 16:18:04 CST 2015
	 */
	private String pic3;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column order_comment.order_id
	 * @return  the value of order_comment.order_id
	 * @mbggenerated  Sun Aug 02 16:18:04 CST 2015
	 */
	public Integer getOrderId() {
		return orderId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column order_comment.order_id
	 * @param orderId  the value for order_comment.order_id
	 * @mbggenerated  Sun Aug 02 16:18:04 CST 2015
	 */
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column order_comment.stars
	 * @return  the value of order_comment.stars
	 * @mbggenerated  Sun Aug 02 16:18:04 CST 2015
	 */
	public BigDecimal getStars() {
		return stars;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column order_comment.stars
	 * @param stars  the value for order_comment.stars
	 * @mbggenerated  Sun Aug 02 16:18:04 CST 2015
	 */
	public void setStars(BigDecimal stars) {
		this.stars = stars;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column order_comment.profnal_score
	 * @return  the value of order_comment.profnal_score
	 * @mbggenerated  Sun Aug 02 16:18:04 CST 2015
	 */
	public BigDecimal getProfnalScore() {
		return profnalScore;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column order_comment.profnal_score
	 * @param profnalScore  the value for order_comment.profnal_score
	 * @mbggenerated  Sun Aug 02 16:18:04 CST 2015
	 */
	public void setProfnalScore(BigDecimal profnalScore) {
		this.profnalScore = profnalScore;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column order_comment.move_score
	 * @return  the value of order_comment.move_score
	 * @mbggenerated  Sun Aug 02 16:18:04 CST 2015
	 */
	public BigDecimal getMoveScore() {
		return moveScore;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column order_comment.move_score
	 * @param moveScore  the value for order_comment.move_score
	 * @mbggenerated  Sun Aug 02 16:18:04 CST 2015
	 */
	public void setMoveScore(BigDecimal moveScore) {
		this.moveScore = moveScore;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column order_comment.punctual_score
	 * @return  the value of order_comment.punctual_score
	 * @mbggenerated  Sun Aug 02 16:18:04 CST 2015
	 */
	public BigDecimal getPunctualScore() {
		return punctualScore;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column order_comment.punctual_score
	 * @param punctualScore  the value for order_comment.punctual_score
	 * @mbggenerated  Sun Aug 02 16:18:04 CST 2015
	 */
	public void setPunctualScore(BigDecimal punctualScore) {
		this.punctualScore = punctualScore;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column order_comment.description
	 * @return  the value of order_comment.description
	 * @mbggenerated  Sun Aug 02 16:18:04 CST 2015
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column order_comment.description
	 * @param description  the value for order_comment.description
	 * @mbggenerated  Sun Aug 02 16:18:04 CST 2015
	 */
	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column order_comment.time
	 * @return  the value of order_comment.time
	 * @mbggenerated  Sun Aug 02 16:18:04 CST 2015
	 */
	public Date getTime() {
		return time;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column order_comment.time
	 * @param time  the value for order_comment.time
	 * @mbggenerated  Sun Aug 02 16:18:04 CST 2015
	 */
	public void setTime(Date time) {
		this.time = time;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column order_comment.pic1
	 * @return  the value of order_comment.pic1
	 * @mbggenerated  Sun Aug 02 16:18:04 CST 2015
	 */
	public String getPic1() {
		return pic1;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column order_comment.pic1
	 * @param pic1  the value for order_comment.pic1
	 * @mbggenerated  Sun Aug 02 16:18:04 CST 2015
	 */
	public void setPic1(String pic1) {
		this.pic1 = pic1 == null ? null : pic1.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column order_comment.pic2
	 * @return  the value of order_comment.pic2
	 * @mbggenerated  Sun Aug 02 16:18:04 CST 2015
	 */
	public String getPic2() {
		return pic2;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column order_comment.pic2
	 * @param pic2  the value for order_comment.pic2
	 * @mbggenerated  Sun Aug 02 16:18:04 CST 2015
	 */
	public void setPic2(String pic2) {
		this.pic2 = pic2 == null ? null : pic2.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column order_comment.pic3
	 * @return  the value of order_comment.pic3
	 * @mbggenerated  Sun Aug 02 16:18:04 CST 2015
	 */
	public String getPic3() {
		return pic3;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column order_comment.pic3
	 * @param pic3  the value for order_comment.pic3
	 * @mbggenerated  Sun Aug 02 16:18:04 CST 2015
	 */
	public void setPic3(String pic3) {
		this.pic3 = pic3 == null ? null : pic3.trim();
	}
}