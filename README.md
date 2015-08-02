# Manicure
A WeChat server

###	Server API
##### core
http://www.mydomain.com/api/keystone/core/
##### Get image location on server
http://www.mydomain.com/api/keystone/file/image/product
method: POST
param: "url", required = true
param: "pid", required = true

###	Menu API
##### create
http://www.mydomain.com/api/keystone/menu/create

###	User API
##### Get SNS user
http://www.mydomain.com/api/keystone/user/query/sns/{openId}/{accessToken}
method: GET
##### SNS user OAuth
http://www.mydomain.com/api/keystone/user/sns/oauth 
method: GET
##### Get WeChat user
http://www.mydomain.com/api/keystone/user/query/{openId}
method: GET
##### Get WeChat user
http://www.mydomain.com/api/keystone/user/list/{nextOpenId}
method: GET
##### Get WeChat user group list
http://www.mydomain.com/api/keystone/user/group/list
method: GET
##### Get WeChat user group by openid
http://www.mydomain.com/api/keystone/user/group/query/{openId}
method: GET

###	Material API
##### Get material
http://www.mydomain.com/api/keystone/material/query/{mediaId}
method: GET
##### Get material list
http://www.mydomain.com/api/keystone/material/list
method: GET

###	Shop API
##### Get shop
http://www.mydomain.com/api/keystone/shop/query/{poiId}
method: GET
##### Get shop list
http://www.mydomain.com/api/keystone/shop/list/{begain}/{limit}
method: GET

###	Product API
##### Get product
http://www.mydomain.com/api/keystone/product/query/{productId}
method: GET
##### Get product list
http://www.mydomain.com/api/keystone/product/list/{status}
method: GET
param: "groupId", required = false
param: "orderBy", required = false
param: "sort", required = false
param: "minPrice", required = false
param: "maxPrice", required = false
##### Get product group list
http://www.mydomain.com/api/keystone/product/group/list
method: GET
##### Get product group detail by groupId
http://www.mydomain.com/api/keystone/product/group/query/{groupId}
method: GET

###	Order API
##### Get order
http://www.mydomain.com/api/keystone/order/query/{orderId}
method: GET
##### Get order list
http://www.mydomain.com/api/keystone/order/list/{status}/{beginTime}/{endTime}
method: GET

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

