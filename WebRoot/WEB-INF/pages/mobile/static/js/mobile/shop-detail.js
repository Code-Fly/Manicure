$(document).on('pagecontainershow', function(e, ui) {
	(function() {
		if (ui.toPage[0].id != "shop-detail-page")
			return;
		var sId = GetQueryString("sId");

		queryShop(sId);

		function queryShop(sId) {
			$.mobile.loading("show");
			$.getJSON(_ctx + "/api/keystone/shop/query/" + sId, function(json) {
				if (null == json) {
					alert("null");
					return;
				}
				if (0 != json.errcode) {
					alert(json.errmsg);
					return;
				}
				loadShop(json.business.base_info)
				$.mobile.loading("hide");
			});
		}
		function loadShop(json) {
			var jList = json;

			var main_img = jList.photo_list[0].photo_url;
			var location = jList.city + " " + jList.district + " " + jList.address;
			var tel = jList.telephone;
			var opentime = jList.open_time;
			var recommend = jList.recommend;
			var special = jList.special;
			var name = jList.business_name

			$("#shop-main-img").attr("src", main_img).attr("data-src", main_img);
			$("#shop-location").text(location);
			$("#shop-tel").text(tel);
			$("#shop-opentime").text(opentime);
			$("#shop-recommend").text(recommend);
			$("#shop-special").text(special);
			$("#shop-name").text(name);

			$("#shop-slider").sliderPro({
				width : "100%",
				aspectRatio : 1.4,
				arrows : false,
				buttons : false,
				fullScreen : false,
				touchSwipe : false,
			});
		}

	})();

});