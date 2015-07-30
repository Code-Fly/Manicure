# Manicure
A WeChat server

###	Server API
##### core
http://www.mydomain.com/api/keystone/core/
##### Get image location on server
http://www.mydomain.com/api/keystone/file/image/product
REQUEST {url:URL,pid:PRODUCT_ID}

###	Menu API
##### create
http://www.mydomain.com/api/keystone/menu/create 

###	User API
##### Get SNS user
http://www.mydomain.com/api/keystone/user/query/sns/{openId}/{accessToken}
##### SNS user OAuth
http://www.mydomain.com/api/keystone/user/sns/oauth 
##### Get WeChat user
http://www.mydomain.com/api/keystone/user/query/{openId} 
##### Get WeChat user
http://www.mydomain.com/api/keystone/user/list/{nextOpenId}
##### Get WeChat user group list
http://www.mydomain.com/api/keystone/user/group/list
##### Get WeChat user group by openid
http://www.mydomain.com/api/keystone/user/group/query/{openId}


###	Material API
##### Get material
http://www.mydomain.com/api/keystone/material/query/{mediaId}
##### Get material list
http://www.mydomain.com/api/keystone/material/list

###	Shop API
##### Get shop
http://www.mydomain.com/api/keystone/shop/query/{poiId}
##### Get shop list
http://www.mydomain.com/api/keystone/shop/list/{begain}/{limit}

###	Product API
##### Get product
http://www.mydomain.com/api/keystone/product/query/{productId}
##### Get product list
http://www.mydomain.com/api/keystone/product/list/{status}

###	Order API
##### Get order
http://www.mydomain.com/api/keystone/order/query/{orderId}
##### Get order list
http://www.mydomain.com/api/keystone/order/list/{status}/{beginTime}/{endTime}

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

