# Manicure
A WeChat server

###	Server API
##### core
http://www.mydomain.com/api/keystone/core<br/>
##### Refresh access token
http://www.mydomain.com/api/keystone/token/refresh<br/>
##### Get access token
http://www.mydomain.com/api/keystone/token/query<br/>
##### Get JS API ticket
http://www.mydomain.com/api/keystone/jsapi/ticket/query<br/>
##### Get image location on server
http://www.mydomain.com/api/keystone/file/image/product<br/>
method: POST<br/>
param: "url", required = true<br/>
param: "pid", required = true<br/>
##### Get UTF-8 encoded url
http://www.mydomain.com/api/keystone/url/encode<br/>
method: POST<br/>
param: "url", required = true<br/>

###	Menu API
##### create
http://www.mydomain.com/api/keystone/menu/create<br/>

###	User API
##### Get SNS user
http://www.mydomain.com/api/keystone/user/query/sns/{openId}/{accessToken}<br/>
method: GET<br/>
##### SNS user OAuth
http://www.mydomain.com/api/keystone/user/sns/oauth<br/>
method: GET<br/>
##### Get WeChat user
http://www.mydomain.com/api/keystone/user/query/{openId}<br/>
method: GET<br/>
##### Get WeChat user
http://www.mydomain.com/api/keystone/user/list/{nextOpenId}<br/>
method: GET<br/>
##### Get WeChat user group list
http://www.mydomain.com/api/keystone/user/group/list<br/>
method: GET<br/>
##### Get WeChat user group by openid
http://www.mydomain.com/api/keystone/user/group/query/{openId}<br/>
method: GET<br/>

###	Material API
##### Get material
http://www.mydomain.com/api/keystone/material/query/{mediaId}<br/>
method: GET<br/>
##### Get material list
http://www.mydomain.com/api/keystone/material/list<br/>
method: GET<br/>

###	Shop API
##### Get shop
http://www.mydomain.com/api/keystone/shop/query/{poiId}<br/>
method: GET<br/>
##### Get shop list
http://www.mydomain.com/api/keystone/shop/list<br/>
method: GET<br/>
param: "begin", required = false<br/>
param: "limit", required = false<br/>

###	Product API
##### Get product
http://www.mydomain.com/api/keystone/product/query/{productId}<br/>
method: GET<br/>
##### Get product list
http://www.mydomain.com/api/keystone/product/list/{status}<br/>
method: GET<br/>
param: "groupId", required = false<br/>
param: "orderBy", required = false<br/>
param: "sort", required = false<br/>
param: "minPrice", required = false<br/>
param: "maxPrice", required = false<br/>
##### Get product group list
http://www.mydomain.com/api/keystone/product/group/list<br/>
method: GET<br/>
##### Get product group detail by groupId
http://www.mydomain.com/api/keystone/product/group/query/{groupId}<br/>
method: GET<br/>

###	Order API
##### Get order
http://www.mydomain.com/api/keystone/order/query/{orderId}<br/>
method: GET<br/>
##### Get order list
http://www.mydomain.com/api/keystone/order/list/{status}<br/>
method: GET<br/>
param: "beginTime", required = false<br/>
param: "endTime", required = false<br/>

###	Merchant API
##### Send redpack
http://www.mydomain.com/api/keystone/merchant/redpack/send/{openId}<br/>
##### Send coupon (doesn't work)
http://www.mydomain.com/api/keystone/merchant/coupon/send/{couponStockId}/{openId}<br/>
##### Pay refund (doesn't work)
http://www.mydomain.com/api/keystone/merchant/pay/refund/{tradeId}<br/>

###	CustomerService API
##### Send coupon
http://www.mydomain.com/api/keystone/customerservice/coupon/send<br/>
method: POST<br/>
param: "touser", required = true<br/>
param: "cardId", required = true<br/>

###	Mobile web page
##### Index
http://www.mydomain.com/mobile/<br/>
http://www.mydomain.com/mobile/index<br/>
##### Home
http://www.mydomain.com/mobile/home<br/>
##### Service choose
http://www.mydomain.com/mobile/service<br/>
##### Order list
http://www.mydomain.com/mobile/order<br/>
##### Product list
http://www.mydomain.com/mobile/list<br/>
##### Space list
http://www.mydomain.com/mobile/space<br/>
##### Product detail
http://www.mydomain.com/mobile/product/{productId}<br/>

###### 查询a服务在b店里可选的技师列表
http://www.mydomain.com/api/technician/query/productId/portalId
###### 根据服务查看能做该服务的所有技师
http://www.mydomain.com/api/technician/query?productId={productId}
###### 根据技师详细信息
http://www.mydomain.com/api/technician/query/{tecId}
###### 查看能做该服务的所有门店id
http://www.mydomain.com/api/portal/query?productId={productId}
###### 查看技师的订单时间
http://www.mydomain.com/api/technician/{tecId}/orderstime/
###### 查询对技师的评价
http://www.mydomain.com/api/order/ordercomment/query?tecId={tecId}
###### 查询对技师能做的所有服务信息
http://www.mydomain.com/api/technician/{tecId}/products
###### 微信支付完成后 回调改接口 关联微信订单表和本服务订单扩展表
http://http://www.mydomain.com/api/order/orderextend/update
method:put
param:orderId required=true
param:openId required=true
param:productId required=true
####### 处理下订单状态 增加已经评价状态
http://www.mydomain.com/api/order/list/{status}?beginTime={beginTime}&&endTime={endTime}
##### 添加订单扩展信息
http://www.mydomain.com/api/order/orderextend/add
method:post
{
"buyerOpenid": buyerOpenid,required=true
"productId":productId,required=true
"tecId":tecId,required=false
"buyerNick":buyerNick,required=false
"name":name,required=false
"orderTime":orderTime,required=true
"orderType":orderType,required=false
"address":address,required=false
"tel":tel required=false
}

##### 添加评价信息
http://www.mydomain.com/api/order/ordercomment/add
method:post
{
"orderId"：orderId,required=true
"evaluation":evaluation,required=false
"stars":stars,required=false
"profnalScore":profnalScore,required=false
"moveScore":moveScore,required=false
"punctualScore":punctualScore,required=false
"description":description,required=true
"time":time,required=false
"pic1":pic1, required=false
"pic2":pic2, required=false
"pic3":pic3 required=false
}
##### 添加收藏
http://www.mydomain.com/api/favorite/add
method:post
{
"buyerOpenid":buyerOpenid,required=true
"productId":productId required=true
}


##### 查询收藏
http://www.mydomain.com/api/favorite/query?buyerOpenid={buyerOpenid}



