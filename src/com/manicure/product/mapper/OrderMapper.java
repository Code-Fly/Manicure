package com.manicure.product.mapper;

import com.manicure.product.entity.Order;
import com.manicure.product.entity.OrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table order
	 * @mbggenerated  Mon Jul 20 20:27:17 CST 2015
	 */
	int countByExample(OrderExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table order
	 * @mbggenerated  Mon Jul 20 20:27:17 CST 2015
	 */
	int deleteByExample(OrderExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table order
	 * @mbggenerated  Mon Jul 20 20:27:17 CST 2015
	 */
	int deleteByPrimaryKey(Integer orderid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table order
	 * @mbggenerated  Mon Jul 20 20:27:17 CST 2015
	 */
	int insert(Order record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table order
	 * @mbggenerated  Mon Jul 20 20:27:17 CST 2015
	 */
	int insertSelective(Order record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table order
	 * @mbggenerated  Mon Jul 20 20:27:17 CST 2015
	 */
	List<Order> selectByExample(OrderExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table order
	 * @mbggenerated  Mon Jul 20 20:27:17 CST 2015
	 */
	Order selectByPrimaryKey(Integer orderid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table order
	 * @mbggenerated  Mon Jul 20 20:27:17 CST 2015
	 */
	int updateByExampleSelective(@Param("record") Order record,
			@Param("example") OrderExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table order
	 * @mbggenerated  Mon Jul 20 20:27:17 CST 2015
	 */
	int updateByExample(@Param("record") Order record,
			@Param("example") OrderExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table order
	 * @mbggenerated  Mon Jul 20 20:27:17 CST 2015
	 */
	int updateByPrimaryKeySelective(Order record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table order
	 * @mbggenerated  Mon Jul 20 20:27:17 CST 2015
	 */
	int updateByPrimaryKey(Order record);
}