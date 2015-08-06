package com.manicure.technician.mapper;

import com.manicure.technician.entity.Technician;
import com.manicure.technician.entity.TechnicianExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface TechnicianMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table technician
     *
     * @mbggenerated Thu Jul 30 16:33:22 CST 2015
     */
    int countByExample(TechnicianExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table technician
     *
     * @mbggenerated Thu Jul 30 16:33:22 CST 2015
     */
    int deleteByExample(TechnicianExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table technician
     *
     * @mbggenerated Thu Jul 30 16:33:22 CST 2015
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table technician
     *
     * @mbggenerated Thu Jul 30 16:33:22 CST 2015
     */
    int insert(Technician record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table technician
     *
     * @mbggenerated Thu Jul 30 16:33:22 CST 2015
     */
    int insertSelective(Technician record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table technician
     *
     * @mbggenerated Thu Jul 30 16:33:22 CST 2015
     */
    List<Technician> selectByExample(TechnicianExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table technician
     *
     * @mbggenerated Thu Jul 30 16:33:22 CST 2015
     */
    Technician selectByPrimaryKey(Integer id);
    
    /**
     * 查询能做该产品的技师
     * @param productId
     * @return
     */
    List<Technician>  selectByProductid(String productId);
    
    /**
     * selectByProductidAndPortalId
     * 根据产品和门店查询技师
     */
    List<Technician>  selectByProductidAndPortalId(@Param("productId")String productId,@Param("portalId")String portalId);
 
    /**
     * 查询c技师的最近一周的订单时间
     * 
     */
    List<String> selectTecOrdersTime(Integer id);
    
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table technician
     *
     * @mbggenerated Thu Jul 30 16:33:22 CST 2015
     */
    int updateByExampleSelective(@Param("record") Technician record, @Param("example") TechnicianExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table technician
     *
     * @mbggenerated Thu Jul 30 16:33:22 CST 2015
     */
    int updateByExample(@Param("record") Technician record, @Param("example") TechnicianExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table technician
     *
     * @mbggenerated Thu Jul 30 16:33:22 CST 2015
     */
    int updateByPrimaryKeySelective(Technician record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table technician
     *
     * @mbggenerated Thu Jul 30 16:33:22 CST 2015
     */
    int updateByPrimaryKey(Technician record);
    
    
}