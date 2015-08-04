package com.manicure.order.mapper;

import com.manicure.order.entity.OrderComment;
import com.manicure.order.entity.OrderCommentExample;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface OrderCommentMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table order_comment
	 * @mbggenerated  Tue Aug 04 15:30:56 CST 2015
	 */
	int countByExample(OrderCommentExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table order_comment
	 * @mbggenerated  Tue Aug 04 15:30:56 CST 2015
	 */
	int deleteByExample(OrderCommentExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table order_comment
	 * @mbggenerated  Tue Aug 04 15:30:56 CST 2015
	 */
	int deleteByPrimaryKey(String orderId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table order_comment
	 * @mbggenerated  Tue Aug 04 15:30:56 CST 2015
	 */
	int insert(OrderComment record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table order_comment
	 * @mbggenerated  Tue Aug 04 15:30:56 CST 2015
	 */
	int insertSelective(OrderComment record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table order_comment
	 * @mbggenerated  Tue Aug 04 15:30:56 CST 2015
	 */
	List<OrderComment> selectByExample(OrderCommentExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table order_comment
	 * @mbggenerated  Tue Aug 04 15:30:56 CST 2015
	 */
	OrderComment selectByPrimaryKey(String orderId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table order_comment
	 * @mbggenerated  Tue Aug 04 15:30:56 CST 2015
	 */
	int updateByExampleSelective(@Param("record") OrderComment record,
			@Param("example") OrderCommentExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table order_comment
	 * @mbggenerated  Tue Aug 04 15:30:56 CST 2015
	 */
	int updateByExample(@Param("record") OrderComment record,
			@Param("example") OrderCommentExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table order_comment
	 * @mbggenerated  Tue Aug 04 15:30:56 CST 2015
	 */
	int updateByPrimaryKeySelective(OrderComment record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table order_comment
	 * @mbggenerated  Tue Aug 04 15:30:56 CST 2015
	 */
	int updateByPrimaryKey(OrderComment record);

	/**
	 * 
	 * @param tecId
	 * @return
	 */
	HashMap<String,Object> getCommentInfoByTecId(Integer tecId);
	
}