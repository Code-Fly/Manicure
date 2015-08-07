package com.manicure.order.mapper;

import com.manicure.order.entity.OrderExtendTmp;
import com.manicure.order.entity.OrderExtendTmpExample;
import com.manicure.order.entity.OrderExtendTmpKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderExtendTmpMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_extend_tmp
     *
     * @mbggenerated Fri Aug 07 12:18:25 CST 2015
     */
    int countByExample(OrderExtendTmpExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_extend_tmp
     *
     * @mbggenerated Fri Aug 07 12:18:25 CST 2015
     */
    int deleteByExample(OrderExtendTmpExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_extend_tmp
     *
     * @mbggenerated Fri Aug 07 12:18:25 CST 2015
     */
    int deleteByPrimaryKey(OrderExtendTmpKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_extend_tmp
     *
     * @mbggenerated Fri Aug 07 12:18:25 CST 2015
     */
    int insert(OrderExtendTmp record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_extend_tmp
     *
     * @mbggenerated Fri Aug 07 12:18:25 CST 2015
     */
    int insertSelective(OrderExtendTmp record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_extend_tmp
     *
     * @mbggenerated Fri Aug 07 12:18:25 CST 2015
     */
    List<OrderExtendTmp> selectByExample(OrderExtendTmpExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_extend_tmp
     *
     * @mbggenerated Fri Aug 07 12:18:25 CST 2015
     */
    OrderExtendTmp selectByPrimaryKey(OrderExtendTmpKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_extend_tmp
     *
     * @mbggenerated Fri Aug 07 12:18:25 CST 2015
     */
    int updateByExampleSelective(@Param("record") OrderExtendTmp record, @Param("example") OrderExtendTmpExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_extend_tmp
     *
     * @mbggenerated Fri Aug 07 12:18:25 CST 2015
     */
    int updateByExample(@Param("record") OrderExtendTmp record, @Param("example") OrderExtendTmpExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_extend_tmp
     *
     * @mbggenerated Fri Aug 07 12:18:25 CST 2015
     */
    int updateByPrimaryKeySelective(OrderExtendTmp record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_extend_tmp
     *
     * @mbggenerated Fri Aug 07 12:18:25 CST 2015
     */
    int updateByPrimaryKey(OrderExtendTmp record);
}