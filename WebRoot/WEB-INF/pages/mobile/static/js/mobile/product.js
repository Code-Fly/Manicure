$(document).on('pagecontainershow', function(e, ui) {
	(function() {
		if (ui.toPage[0].id != "product-page")
			return;

		var _pid = window.location.href.replace(_ctx + "/mobile/product/", "")
		var payUrl = "http://mp.weixin.qq.com/bizmall/malldetail?id=&pid=PRODUCT_ID&biz=MzI5MjAwNjA4Ng==&scene=&action=show_detail&showwxpaytitle=1#wechat_redirect";

		$.getJSON(_ctx + "/api/keystone/product/query/" + _pid, function(json) {
			if (null == json) {
				alert("null");
				return;
			}
			if (0 != json.errcode) {
				alert(json);
				return;
			}
			
			loadProduct(json.product_info);
			
			
		});
		
		function loadProduct(json) {
			var jList = json;
			
			var main_img = jList.product_base.main_img;
			var name = jList.product_base.name;
			var description = jList.product_base.detail_html.replace(/<[^>]+>/g, "");
			var price = "¥" + (jList.sku_list[0].price / 100).toFixed(2);
			var oriPrice = "¥" + (jList.sku_list[0].ori_price / 100).toFixed(2);
			var property = jList.product_base.property;
			var cost = "0分钟";
			var last = "0天";
			for (var i = 0; i < property.length; i++) {
				if ("保持" == property[i].id) {
					last = property[i].vid;
				}
				if ("耗时" == property[i].id) {
					cost = property[i].vid;
				}
			}
			
			$("#product-header").text(name);
			$("#product-main-img").attr("src", main_img).attr("data-src", main_img);
			$("#product-ori-price").text(oriPrice);
			$("#product-price").text(price);
			$("#product-description").text(description);
			$("#product-cost").text(cost);
			$("#product-last").text(last);
			// $("#product-btn-pay").attr("href", payUrl.replace("PRODUCT_ID", _pid));			
			$("#product-btn-to-door-service").attr("href", _ctx + "/mobile/purchase-input-address?type=todoor&pid=" + _pid);
			$("#product-btn-to-shop-service").attr("href", _ctx + "/mobile/purchase-input-address?type=toshop&pid=" + _pid);
			
			$("#product-slider").sliderPro({
				width : "100%",
				aspectRatio : 1.4,
				arrows : false,
				buttons : false,
				fullScreen : false,
				touchSwipe : false,
			});
			
			//formatData(main_img, _pid, name, description, price, oriPrice, property, cost, last);

		}

//		function formatData(url, pid, name, description, price, oriPrice, property, cost, last) {
//			$.post(_ctx + "/api/keystone/file/image/product", {
//				url : url,
//				pid : pid
//			}, function(data) {
//				var main_img = _ctx + data;
//				$("#product-header").text(name);
//				$("#product-main-img").attr("src", main_img).attr("data-src", main_img);
//				$("#product-ori-price").text(oriPrice);
//				$("#product-price").text(price);
//				$("#product-description").text(description);
//				$("#product-cost").text(cost);
//				$("#product-last").text(last);
//				// $("#product-btn-pay").attr("href",
//				// payUrl.replace("PRODUCT_ID", _pid));
//				$("#product-btn-to-door-service").attr("href", _ctx + "/mobile/purchase-input-address?type=todoor&pid=" + pid);
//				$("#product-btn-to-shop-service").attr("href", _ctx + "/mobile/purchase-input-address?type=toshop&pid=" + pid);
//				$('#product-slider').sliderPro({
//					width : "100%",
//					aspectRatio : 1.4,
//					arrows : false,
//					buttons : false,
//					fullScreen : false,
//					touchSwipe : false,
//				});
//			});
//		}

	})();

});