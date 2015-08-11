$(document).on('pagecontainershow', function(e, ui) {
	(function() {
		if (ui.toPage[0].id != "purchase-confirm-page")
			return;
		var payUrl = "http://mp.weixin.qq.com/bizmall/malldetail?id=&pid=PRODUCT_ID&biz=MzI5MjAwNjA4Ng==&scene=&action=show_detail&showwxpaytitle=1#wechat_redirect";
		var myAddr = SessionCache.get("customerAddr");
		var myBiz = SessionCache.get("customerBiz");
		var myTel = SessionCache.get("customerTel");
		var myLng = SessionCache.get("customerLng");
		var myLat = SessionCache.get("customerLat");
		var tId = SessionCache.get("customerTecId");
		var tName = SessionCache.get("customerTecName");
		var sId = SessionCache.get("customerShopId");
		var sName = SessionCache.get("customerShopName");
		var oDate = SessionCache.get("customerDate");
		var oTime = SessionCache.get("customerTime");
		var oType = SessionCache.get("customerServiceType");
		var pInfo = eval("(" + SessionCache.get("customerProduct") + ")");

		loadOrderConfirmation();
		
		$("#purchase-select-confirm-btn-next").attr("href", payUrl.replace("PRODUCT_ID", pInfo.product_id));
		
		
		function loadOrderConfirmation(){
			$.mobile.loading("show");
			if (null != _user) {
				var uId = SessionCache.get(_user.openid);
				var uName = SessionCache.get(_user.nickname);
			} else {
				var uId = SessionCache.get("null");
				var uName = SessionCache.get("null");
			}
			$("#confirm-my-name").text(uName);
			$("#confirm-my-business").text(myBiz);
			$("#confirm-my-address").text(myAddr);
			$("#confirm-my-tel").text(myTel);
			$("#confirm-technician-name").text(tName);
			$("#confirm-shop-name").text(sName);
			$("#confirm-date").text(oDate);
			$("#confirm-time").text(oTime);
			$("#confirm-product-name").text(pInfo.product_base.name);
			$("#confirm-product-description").text(pInfo.product_base.detail_html.replace(/<[^>]+>/g, ""));
			$("#confirm-product-img").attr("src", pInfo.product_base.main_img).css("width", "100%").css("height", "100%");
			$("#confirm-type").text(oType);

			if ("上门服务" == oType) {
				$("#confirm-list-my-info").show();
			}
			$("#page-confirm-detail-list").listview('refresh');
			$.mobile.loading("hide");
		}
	})();

});