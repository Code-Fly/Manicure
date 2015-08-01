/**
 * 
 */
package com.manicure.base.helper;

/**
 * @author Barrie
 *
 */
public class Const {
	public static final String propertiesFile = "wechat.properties";

	public static final String MERCHANT_NAME = ConfigUtil.getProperty(propertiesFile, "merchant.name");
	// 第三方用户唯一凭证
	public static final String APP_ID = ConfigUtil.getProperty(propertiesFile, "appId");
	// 第三方用户唯一凭证密钥
	public static final String APP_SECRET = ConfigUtil.getProperty(propertiesFile, "appSecret");

	public static final String MCH_ID = ConfigUtil.getProperty(propertiesFile, "mchId");

	public static final String MCH_SECRET = ConfigUtil.getProperty(propertiesFile, "mchSecret");

	public static final String MCH_KEYSTONE = ConfigUtil.getProperty(propertiesFile, "mchKeystone");

	public static final String MCH_KEYSTONE_SECRET = ConfigUtil.getProperty(propertiesFile, "mchKeystoneSecret");
	// 与接口配置信息中的Token要一致
	public static final String TOKEN = ConfigUtil.getProperty(propertiesFile, "token");
	// 获取access_token的接口地址（GET） 限200（次/天）
	public static final String URL_GET_ACCESS_TOKEN = ConfigUtil.getProperty(propertiesFile, "url.access.token");
	// 菜单创建（POST） 限100（次/天）
	public static final String URL_MENU_CREATE = ConfigUtil.getProperty(propertiesFile, "url.menu.create");

	public static final String URL_MENU_GET = ConfigUtil.getProperty(propertiesFile, "url.menu.get");

	public static final String URL_MENU_DELETE = ConfigUtil.getProperty(propertiesFile, "url.menu.delete");

	public static final String URL_SNS_OAUTH2_REDIRECT = ConfigUtil.getProperty(propertiesFile, "url.sns.oauth2.redirect");

	public static final String URL_SNS_OAUTH2_TOKEN_GET = ConfigUtil.getProperty(propertiesFile, "url.sns.oauth2.token.get");

	public static final String URL_SNS_OAUTH2_TOKEN_REFRESH = ConfigUtil.getProperty(propertiesFile, "url.sns.oauth2.token.refresh");
	// 获取用户信息
	public static final String URL_USER_GET_SNS_INFO = ConfigUtil.getProperty(propertiesFile, "url.user.get.sns.info");

	public static final String URL_USER_GET_INFO = ConfigUtil.getProperty(propertiesFile, "url.user.get.info");

	public static final String URL_USER_GET_LIST = ConfigUtil.getProperty(propertiesFile, "url.user.get.list");

	public static final String URL_USER_GROUP_GET_LIST = ConfigUtil.getProperty(propertiesFile, "url.user.group.get.list");

	public static final String URL_USER_GROUP_GET_BY_OPENID = ConfigUtil.getProperty(propertiesFile, "url.user.group.get.by.openid");

	public static final String URL_MATERIAL_GET_LIST = ConfigUtil.getProperty(propertiesFile, "url.material.get.list");

	public static final String URL_MATERIAL_GET_DETAIL = ConfigUtil.getProperty(propertiesFile, "url.material.get.detail");

	public static final String URL_SHOP_GET_LIST = ConfigUtil.getProperty(propertiesFile, "url.shop.get.list");

	public static final String URL_SHOP_GET_DETAIL = ConfigUtil.getProperty(propertiesFile, "url.shop.get.detail");

	public static final String URL_PROGUCT_GET_LIST = ConfigUtil.getProperty(propertiesFile, "url.product.get.list");

	public static final String URL_PROGUCT_GET_DETAIL = ConfigUtil.getProperty(propertiesFile, "url.product.get.detail");

	public static final String URL_PROGUCT_GROUP_GET_LIST = ConfigUtil.getProperty(propertiesFile, "url.product.group.get.list");

	public static final String URL_PROGUCT_GROUP_GET_DETAIL = ConfigUtil.getProperty(propertiesFile, "url.product.group.get.detail");

	public static final String URL_ORDER_GET_LIST = ConfigUtil.getProperty(propertiesFile, "url.order.get.list");

	public static final String URL_ORDER_GET_DETAIL = ConfigUtil.getProperty(propertiesFile, "url.order.get.detail");

	public static final String URL_MERCHANT_COUPON_SEND = ConfigUtil.getProperty(propertiesFile, "url.merchant.coupon.send");

	public static final String URL_MERCHANT_COUPON_GET_DETAIL = ConfigUtil.getProperty(propertiesFile, "url.merchant.coupon.get.detail");

	public static final String URL_MERCHANT_REDPACK_SEND = ConfigUtil.getProperty(propertiesFile, "url.merchant.redpack.send");

	public static final String URL_MERCHANT_PAY_REFUND = ConfigUtil.getProperty(propertiesFile, "url.merchant.pay.refund");

	public static String getServerPath() {
		String path = Thread.currentThread().getContextClassLoader().getResource("/").getPath();
		path = "/" + path.substring(1, path.indexOf("/classes"));
		return path;
	}
}
