/**
 * 
 */
package com.manicure.order.impl;

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
	public List<OrderComment> queryOrderCommentsByTecId(int tecId) {
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

}
