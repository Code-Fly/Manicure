$(document).on('pagecontainershow', function(e, ui) {
	(function() {
		if (ui.toPage[0].id != "purchase-confirm-page")
			return;
		var payUrl = "http://mp.weixin.qq.com/bizmall/malldetail?id=&pid=PRODUCT_ID&biz=MzI5MjAwNjA4Ng==&scene=&action=show_detail&showwxpaytitle=1#wechat_redirect";
		$("#purchase-select-confirm-btn-next").attr("href", payUrl.replace("PRODUCT_ID", GetQueryString("pid")));
		
	})();

});