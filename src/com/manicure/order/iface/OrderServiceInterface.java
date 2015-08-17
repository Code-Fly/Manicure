/**
 * 
 */
package com.manicure.order.iface;

import java.util.HashMap;

import com.manicure.order.entity.OrderComment;

/**
 * @author zhangqw
 *
 */
public interface OrderServiceInterface {
	HashMap<String,Object> queryOrderCommentsByTecId(int tecId);
	void updateOrderExtendTmp(String orderId,String productId,String openId);
	OrderComment selectByPrimaryKey(String orderId);
}
