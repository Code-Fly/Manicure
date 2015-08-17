/**
 * 
 */
package com.manicure.order.iface;

import java.util.HashMap;
import java.util.List;

import com.manicure.order.entity.OrderComment;

/**
 * @author zhangqw
 *
 */
public interface OrderServiceInterface {
	HashMap<String,Object> queryOrderCommentsByTecId(int tecId);
	void updateOrderExtendTmp(String orderId,String productId,String openId);
}
