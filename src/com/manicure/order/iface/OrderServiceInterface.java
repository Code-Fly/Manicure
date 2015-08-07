/**
 * 
 */
package com.manicure.order.iface;

import java.util.List;

import com.manicure.order.entity.OrderComment;

/**
 * @author zhangqw
 *
 */
public interface OrderServiceInterface {
	List<OrderComment> queryOrderCommentsByTecId(int tecId);
	void updateOrderExtendTmp(String orderId,String productId,String openId);
}
