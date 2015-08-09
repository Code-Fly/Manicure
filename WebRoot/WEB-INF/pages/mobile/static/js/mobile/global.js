var APP_ID = "wxed9be34978201242";

var GROUP_ID_MEIJIA_JIANYUE = "208009326";
var GROUP_ID_MEIJIA_FASHI = "208009315";
var GROUP_ID_MEIJIA_CAIZHUANG = "208009328";
var GROUP_ID_MEIJIA_RIHAN = "208009345";

var GROUP_ID_MEIZU_JIANYUE = "208009349";
var GROUP_ID_MEIZU_CAIHUI = "208009354";

var GROUP_ID_MEIJIE = "208009355";

var GROUP_ID_HUAZHUANG_XINNIANG = "208009365";
var GROUP_ID_HUAZHUANG_WUTAI = "208009367";

var GROUP_ID_HULI_SHOUBU = "208275848";
var GROUP_ID_HULI_ZUBU = "208275849";
var GROUP_ID_HULI_PIFU = "208275858";

var GROUP_ID_NEW = "208216165";

var PRODUCT_LIST_ORDERBY_PRICE = "price";
var PRODUCT_LIST_ORDERBY_SALES = "sales";

var PRODUCT_LIST_SORT_ASC = "asc";
var PRODUCT_LIST_SORT_DESC = "desc";

var URL_SNS_OAUTH2_REDIRECT = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";

$(document).on("click", "a", function() {
	// if ($(this).attr("href") != "#") {
	$.mobile.loading("show");
	// }
})
$(function() {
	$("[data-role='navbar']").navbar();
	$("[data-role='header'], [data-role='footer']").toolbar();
});
// Update the contents of the toolbars
$(document).on("pagecontainerchange", function() {
	// Each of the four pages in this demo has a data-title attribute
	// which value is equal to the text of the nav button
	// For example, on first page: <div data-role="page" data-title="Info">
	var current = $(".ui-page-active").jqmData("title");
	// Change the heading
	$("#footer-nav h1").text(current);
	// Remove active class from nav buttons
	$("#footer-nav a.ui-btn-active").removeClass("ui-btn-active");
	// Add active class to current nav button
	$("#footer-nav a").each(function() {
		if ($(this).text() === current) {
			$(this).addClass("ui-btn-active");
		}
	});

});

$.datepicker.regional["zh-CN"] = {
	closeText : "关闭",
	prevText : "&#x3c;上月",
	nextText : "下月&#x3e;",
	currentText : "今天",
	monthNames : [ "一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月" ],
	monthNamesShort : [ "一", "二", "三", "四", "五", "六", "七", "八", "九", "十", "十一", "十二" ],
	dayNames : [ "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" ],
	dayNamesShort : [ "周日", "周一", "周二", "周三", "周四", "周五", "周六" ],
	dayNamesMin : [ "日", "一", "二", "三", "四", "五", "六" ],
	weekHeader : "周",
	dateFormat : "yy-mm-dd",
	firstDay : 1,
	isRTL : !1,
	showMonthAfterYear : !0,
	yearSuffix : "年"
}

$.datepicker.setDefaults($.datepicker.regional["zh-CN"]);

function GetQueryString(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if (r != null)
		return unescape(r[2]);
	return null;
}

// 临时存储
var SessionCache = {
	set : function(key, value) {
		sessionStorage.setItem(key, value);
	},
	get : function(key) {
		return sessionStorage.getItem(key);
	},
	remove : function(key) {
		return sessionStorage.removeItem(key);
	},
	update : function(key, value) {
		sessionStorage.removeItem(key);
		sessionStorage.setItem(key, value);
	},
	clear : function() {
		return sessionStorage.clear();
	}
};

/**
 * @synopsis 签名算法
 * 
 * @param jsapi_ticket
 *            用于签名的 jsapi_ticket
 * @param url
 *            用于签名的 url ，注意必须动态获取，不能 hardcode
 * 
 * @returns
 */
var wxSign = function(jsapi_ticket, url) {
	var createNonceStr = function() {
		return Math.random().toString(36).substr(2, 15);
	};

	var createTimestamp = function() {
		return parseInt(new Date().getTime() / 1000) + '';
	};

	var raw = function(args) {
		var keys = Object.keys(args);
		keys = keys.sort()
		var newArgs = {};
		keys.forEach(function(key) {
			newArgs[key.toLowerCase()] = args[key];
		});

		var string = '';
		for ( var k in newArgs) {
			string += '&' + k + '=' + newArgs[k];
		}
		string = string.substr(1);
		return string;
	};
	var ret = {
		jsapi_ticket : jsapi_ticket,
		nonceStr : createNonceStr(),
		timestamp : createTimestamp(),
		url : url
	};

	var string = raw(ret);
	var shaObj = new jsSHA("SHA-1", "TEXT");
	shaObj.update(string);
	var hash = shaObj.getHash("HEX")
	ret.signature = hash;

	return ret;
};

module.exports = wxSign;
