package com.manicure.product.entity;

import java.util.Date;

public class ServiceComment {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column service_comment.id
     *
     * @mbggenerated Wed Jul 22 20:39:19 CST 2015
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column service_comment.serviceid
     *
     * @mbggenerated Wed Jul 22 20:39:19 CST 2015
     */
    private Integer serviceid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column service_comment.stars
     *
     * @mbggenerated Wed Jul 22 20:39:19 CST 2015
     */
    private Integer stars;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column service_comment.description
     *
     * @mbggenerated Wed Jul 22 20:39:19 CST 2015
     */
    private String description;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column service_comment.userid
     *
     * @mbggenerated Wed Jul 22 20:39:19 CST 2015
     */
    private Integer userid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column service_comment.time
     *
     * @mbggenerated Wed Jul 22 20:39:19 CST 2015
     */
    private Date time;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column service_comment.orderid
     *
     * @mbggenerated Wed Jul 22 20:39:19 CST 2015
     */
    private Integer orderid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column service_comment.id
     *
     * @return the value of service_comment.id
     *
     * @mbggenerated Wed Jul 22 20:39:19 CST 2015
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column service_comment.id
     *
     * @param id the value for service_comment.id
     *
     * @mbggenerated Wed Jul 22 20:39:19 CST 2015
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column service_comment.serviceid
     *
     * @return the value of service_comment.serviceid
     *
     * @mbggenerated Wed Jul 22 20:39:19 CST 2015
     */
    public Integer getServiceid() {
        return serviceid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column service_comment.serviceid
     *
     * @param serviceid the value for service_comment.serviceid
     *
     * @mbggenerated Wed Jul 22 20:39:19 CST 2015
     */
    public void setServiceid(Integer serviceid) {
        this.serviceid = serviceid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column service_comment.stars
     *
     * @return the value of service_comment.stars
     *
     * @mbggenerated Wed Jul 22 20:39:19 CST 2015
     */
    public Integer getStars() {
        return stars;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column service_comment.stars
     *
     * @param stars the value for service_comment.stars
     *
     * @mbggenerated Wed Jul 22 20:39:19 CST 2015
     */
    public void setStars(Integer stars) {
        this.stars = stars;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column service_comment.description
     *
     * @return the value of service_comment.description
     *
     * @mbggenerated Wed Jul 22 20:39:19 CST 2015
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column service_comment.description
     *
     * @param description the value for service_comment.description
     *
     * @mbggenerated Wed Jul 22 20:39:19 CST 2015
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column service_comment.userid
     *
     * @return the value of service_comment.userid
     *
     * @mbggenerated Wed Jul 22 20:39:19 CST 2015
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column service_comment.userid
     *
     * @param userid the value for service_comment.userid
     *
     * @mbggenerated Wed Jul 22 20:39:19 CST 2015
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column service_comment.time
     *
     * @return the value of service_comment.time
     *
     * @mbggenerated Wed Jul 22 20:39:19 CST 2015
     */
    public Date getTime() {
        return time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column service_comment.time
     *
     * @param time the value for service_comment.time
     *
     * @mbggenerated Wed Jul 22 20:39:19 CST 2015
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column service_comment.orderid
     *
     * @return the value of service_comment.orderid
     *
     * @mbggenerated Wed Jul 22 20:39:19 CST 2015
     */
    public Integer getOrderid() {
        return orderid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column service_comment.orderid
     *
     * @param orderid the value for service_comment.orderid
     *
     * @mbggenerated Wed Jul 22 20:39:19 CST 2015
     */
    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }
}