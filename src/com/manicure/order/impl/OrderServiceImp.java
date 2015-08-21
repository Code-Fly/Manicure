/**
 * 
 */
package com.manicure.order.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manicure.order.entity.OrderComment;
import com.manicure.order.entity.OrderExtendTmp;
import com.manicure.order.entity.OrderExtendTmpKey;
import com.manicure.order.iface.OrderServiceInterface;
import com.manicure.order.mapper.OrderCommentMapper;
import com.manicure.order.mapper.OrderExtendTmpMapper;

/**
 * @author VM
 *
 */
@Service("ordersService")
public class OrderServiceImp implements OrderServiceInterface {
	
	@Autowired
	private OrderCommentMapper ocmapper;
	
	@Autowired
	private OrderExtendTmpMapper oetmapper;

	/* (non-Javadoc)
	 * @see com.manicure.order.iface.OrderServiceInterface#queryOrderCommentsByTecId(int)
	 */
	@Override
	public List<HashMap<String,Object>> queryOrderCommentsByTecId(int tecId) {
		return ocmapper.getCommentListByTecId(tecId);
	}

	@Override
	public void updateOrderExtendTmp(String orderId, String productId,
			String openId) {
		OrderExtendTmpKey oetKey = new OrderExtendTmpKey();
		oetKey.setBuyerOpenid(openId);
		oetKey.setProductId(productId);
		OrderExtendTmp record = new OrderExtendTmp();
		record.setOrderId(orderId);
		record.setBuyerOpenid(openId);
		record.setProductId(productId);
		oetmapper.updateByPrimaryKeySelective(record);
		// 更新成功删除临时数据
		oetmapper.deleteByPrimaryKey(oetKey);
	}

	@Override
	public OrderComment selectByPrimaryKey(String orderId) {
		return ocmapper.selectByPrimaryKey(orderId);
	}

	@Override
	public int insertExtendSelective(OrderExtendTmp record) {
		if (null == oetmapper.selectByPrimaryKey(record)){
			return oetmapper.insertSelective(record);
		} else {
			/**
			 *  order id 不为空证明已经支付完成
			 *  order id 为空 证明该商品之前有一次未支付的，则此次购买该商品，覆盖之前之前未支付的记录
			 */
			int num = oetmapper.updateByPrimaryKeySelective(record);
			if(null != record.getOrderId() && !record.getOrderId().trim().isEmpty()){
				// 支付完成后删除该条临时记录（确保下次购买同样商品时 能插入到临时数据表）
				oetmapper.deleteByPrimaryKey(record);
			}
			return num;
		}
	}

	@Override
	public int insertCommentSelective(OrderComment record) {
		if(null == ocmapper.selectByPrimaryKey(record.getOrderId())){
			return ocmapper.insertSelective(record);
		} else {
			return ocmapper.updateByPrimaryKeySelective(record);
		}
	}
}
