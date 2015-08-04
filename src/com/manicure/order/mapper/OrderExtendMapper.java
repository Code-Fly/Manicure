package com.manicure.order.mapper;

import com.manicure.order.entity.OrderExtend;
import com.manicure.order.entity.OrderExtendExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderExtendMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table order_extend
	 * @mbggenerated  Tue Aug 04 15:31:16 CST 2015
	 */
	int countByExample(OrderExtendExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table order_extend
	 * @mbggenerated  Tue Aug 04 15:31:16 CST 2015
	 */
	int deleteByExample(OrderExtendExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table order_extend
	 * @mbggenerated  Tue Aug 04 15:31:16 CST 2015
	 */
	int deleteByPrimaryKey(String orderId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table order_extend
	 * @mbggenerated  Tue Aug 04 15:31:16 CST 2015
	 */
	int insert(OrderExtend record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table order_extend
	 * @mbggenerated  Tue Aug 04 15:31:16 CST 2015
	 */
	int insertSelective(OrderExtend record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table order_extend
	 * @mbggenerated  Tue Aug 04 15:31:16 CST 2015
	 */
	List<OrderExtend> selectByExample(OrderExtendExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table order_extend
	 * @mbggenerated  Tue Aug 04 15:31:16 CST 2015
	 */
	OrderExtend selectByPrimaryKey(String orderId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table order_extend
	 * @mbggenerated  Tue Aug 04 15:31:16 CST 2015
	 */
	int updateByExampleSelective(@Param("record") OrderExtend record,
			@Param("example") OrderExtendExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table order_extend
	 * @mbggenerated  Tue Aug 04 15:31:16 CST 2015
	 */
	int updateByExample(@Param("record") OrderExtend record,
			@Param("example") OrderExtendExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table order_extend
	 * @mbggenerated  Tue Aug 04 15:31:16 CST 2015
	 */
	int updateByPrimaryKeySelective(OrderExtend record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table order_extend
	 * @mbggenerated  Tue Aug 04 15:31:16 CST 2015
	 */
	int updateByPrimaryKey(OrderExtend record);
}