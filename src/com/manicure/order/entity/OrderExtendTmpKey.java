package com.manicure.order.entity;

public class OrderExtendTmpKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_extend_tmp.buyer_openid
     *
     * @mbggenerated Fri Aug 07 12:18:24 CST 2015
     */
    private String buyerOpenid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_extend_tmp.product_id
     *
     * @mbggenerated Fri Aug 07 12:18:24 CST 2015
     */
    private String productId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_extend_tmp.buyer_openid
     *
     * @return the value of order_extend_tmp.buyer_openid
     *
     * @mbggenerated Fri Aug 07 12:18:24 CST 2015
     */
    public String getBuyerOpenid() {
        return buyerOpenid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_extend_tmp.buyer_openid
     *
     * @param buyerOpenid the value for order_extend_tmp.buyer_openid
     *
     * @mbggenerated Fri Aug 07 12:18:24 CST 2015
     */
    public void setBuyerOpenid(String buyerOpenid) {
        this.buyerOpenid = buyerOpenid == null ? null : buyerOpenid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_extend_tmp.product_id
     *
     * @return the value of order_extend_tmp.product_id
     *
     * @mbggenerated Fri Aug 07 12:18:24 CST 2015
     */
    public String getProductId() {
        return productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_extend_tmp.product_id
     *
     * @param productId the value for order_extend_tmp.product_id
     *
     * @mbggenerated Fri Aug 07 12:18:24 CST 2015
     */
    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }
}