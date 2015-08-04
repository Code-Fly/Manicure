# Manicure
A WeChat server

###	Server API
##### core
http://www.mydomain.com/api/keystone/core/
##### Get image location on server
http://www.mydomain.com/api/keystone/file/image/product<br/>
method: POST<br/>
param: "url", required = true<br/>
param: "pid", required = true<br/>

###	Menu API
##### create
http://www.mydomain.com/api/keystone/menu/create

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
http://www.mydomain.com/api/keystone/redpack/send/{openId}
##### Send coupon (doesn't work)
http://www.mydomain.com/api/keystone/coupon/send/{couponStockId}/{openId}
##### Pay refund (doesn't work)
http://www.mydomain.com/api/keystone/pay/refund/{tradeId}

###	Mobile web page
##### Index
http://www.mydomain.com/mobile/
http://www.mydomain.com/mobile/index
##### Home
http://www.mydomain.com/mobile/home
##### Service choose
http://www.mydomain.com/mobile/service
##### Order list
http://www.mydomain.com/mobile/order
##### Product list
http://www.mydomain.com/mobile/list
##### Space list
http://www.mydomain.com/mobile/space
##### Product detail
http://www.mydomain.com/mobile/product/{productId}

###### 根据服务查看能做该服务的所有技师
http://www.mydomain.com/api/technician/query?productId={productId}
###### 根据技师详细信息
http://www.mydomain.com/api/technician/query/{tecId}
###### 查看能做该服务的所有门店id
http://www.mydomain.com/api/portal/query?productId={productId}