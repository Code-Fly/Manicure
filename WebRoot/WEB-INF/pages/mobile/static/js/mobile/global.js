//$(document)
//		.on(
//				"click",
//				"a",
//				function() {
//					// if ($(this).attr("href") != "#") {
//					var $this = $(this), theme = $this.jqmData("theme")
//							|| $.mobile.loader.prototype.options.theme, msgText = $this
//							.jqmData("msgtext")
//							|| $.mobile.loader.prototype.options.text, textVisible = $this
//							.jqmData("textvisible")
//							|| $.mobile.loader.prototype.options.textVisible, textonly = !!$this
//							.jqmData("textonly");
//					html = $this.jqmData("html") || "";
//					$.mobile.loading("show", {
//						text : msgText,
//						textVisible : textVisible,
//						theme : theme,
//						textonly : textonly,
//						html : html
//					});
//					// }
//				})

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