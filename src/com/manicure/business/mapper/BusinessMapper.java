package com.manicure.business.mapper;

import com.manicure.business.entity.Business;
import com.manicure.business.entity.BusinessExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BusinessMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table business
     *
     * @mbggenerated Sun Aug 02 15:50:38 CST 2015
     */
    int countByExample(BusinessExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table business
     *
     * @mbggenerated Sun Aug 02 15:50:38 CST 2015
     */
    int deleteByExample(BusinessExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table business
     *
     * @mbggenerated Sun Aug 02 15:50:38 CST 2015
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table business
     *
     * @mbggenerated Sun Aug 02 15:50:38 CST 2015
     */
    int insert(Business record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table business
     *
     * @mbggenerated Sun Aug 02 15:50:38 CST 2015
     */
    int insertSelective(Business record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table business
     *
     * @mbggenerated Sun Aug 02 15:50:38 CST 2015
     */
    List<Business> selectByExample(BusinessExample example);
    
    /**
     * 
     * @param tecId
     * @return
     */
    List<Business> selectByTecId(Integer tecId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table business
     *
     * @mbggenerated Sun Aug 02 15:50:38 CST 2015
     */
    Business selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table business
     *
     * @mbggenerated Sun Aug 02 15:50:38 CST 2015
     */
    int updateByExampleSelective(@Param("record") Business record, @Param("example") BusinessExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table business
     *
     * @mbggenerated Sun Aug 02 15:50:38 CST 2015
     */
    int updateByExample(@Param("record") Business record, @Param("example") BusinessExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table business
     *
     * @mbggenerated Sun Aug 02 15:50:38 CST 2015
     */
    int updateByPrimaryKeySelective(Business record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table business
     *
     * @mbggenerated Sun Aug 02 15:50:38 CST 2015
     */
    int updateByPrimaryKey(Business record);
}