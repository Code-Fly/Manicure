/**
 * 
 */
package com.manicure.order.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manicure.order.entity.OrderComment;
import com.manicure.order.iface.OrderServiceInterface;
import com.manicure.order.mapper.OrderCommentMapper;

/**
 * @author VM
 *
 */
@Service("ordersService")
public class OrderServiceImp implements OrderServiceInterface {
	
	@Autowired
	private OrderCommentMapper ocmapper;

	/* (non-Javadoc)
	 * @see com.manicure.order.iface.OrderServiceInterface#queryOrderCommentsByTecId(int)
	 */
	@Override
	public List<OrderComment> queryOrderCommentsByTecId(int tecId) {
		return ocmapper.getCommentListByTecId(tecId);
	}

}
