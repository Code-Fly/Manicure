/**
 * 
 */
package com.manicure.order.iface;

import java.util.HashMap;

import com.manicure.order.entity.OrderComment;
import com.manicure.order.entity.OrderExtendTmp;

/**
 * @author zhangqw
 *
 */
public interface OrderServiceInterface {
	HashMap<String,Object> queryOrderCommentsByTecId(int tecId);
	void updateOrderExtendTmp(String orderId,String productId,String openId);
	OrderComment selectByPrimaryKey(String orderId);
	int insertSelective(OrderExtendTmp record);
}
