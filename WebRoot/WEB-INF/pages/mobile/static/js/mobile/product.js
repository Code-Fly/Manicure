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
				alert("商品可能已下架");
				return;
			}

			loadProduct(json.product_info);

		});

		$.getJSON(_ctx + "/api/technician/query", {
			productId : _pid
		}, function(json) {
			if (null == json) {
				alert("null");
				return;
			}

			loadTechnician(json);
		});

		function loadTechnician(json) {
			$("#page-product-list-technician").empty();
			var jList = json;

			for (var i = 0; i < jList.length; i++) {
				var name = jList[i].name;
				var moveScore = jList[i].moveScore;
				var profnalScore = jList[i].profnalScore;
				var punctualScore = jList[i].punctualScore;
				var orderCount = jList[i].orderCount;
				var headerPic = jList[i].headerPic;
				var tid = jList[i].id;
				var link = _ctx + "/mobile/technician?tid=" + tid;

				AppendListItem("#page-product-list-technician", tid, link, name, moveScore, profnalScore, punctualScore, orderCount, headerPic);
			}

			$("#page-product-list-technician").listview('refresh');
		}

		function AppendListItem(target, tid, link, name, moveScore, profnalScore, punctualScore, orderCount, headerPic) {

			var elmLi = $(document.createElement("li"));
			var elmImg = $(document.createElement("img"));
			var elmA = $(document.createElement("a"));
			var elmH2 = $(document.createElement("h2"));
			var elmP = $(document.createElement("p"));
			var elmSpan = $(document.createElement("span"));

			var listLi = elmLi.clone();
			var listA = elmA.clone().attr("href", link).attr("id", tid).attr("data-ajax", "false");
			var listImg = elmImg.clone().attr("src", headerPic);
			var listH2 = elmH2.clone().text(name);
			var listP = elmP.clone();

			var listSpan1 = elmSpan.clone().text("专业:");
			var listSpan2 = elmSpan.clone().text(profnalScore).css("color", "blue");
			var listSpan3 = elmSpan.clone().text(" 感动:");
			var listSpan4 = elmSpan.clone().text(moveScore).css("color", "green");
			var listSpan5 = elmSpan.clone().text(" 守时:");
			var listSpan6 = elmSpan.clone().text(punctualScore).css("color", "red");

			listP.append(listSpan1);
			listP.append(listSpan2);
			listP.append(listSpan3);
			listP.append(listSpan4);
			listP.append(listSpan5);
			listP.append(listSpan6);
			var listSt = elmP.clone().addClass("ui-li-aside").text("服务" + orderCount + "次").css("color", "orange");

			listA.append(listImg);
			listA.append(listH2);
			listA.append(listP);
			listA.append(listSt);
			listLi.append(listA);
			$(target).append(listLi);
		}

		function loadProduct(json) {
			var jList = json;

			var main_img = jList.product_base.main_img;
			var name = jList.product_base.name;
			var description = jList.product_base.detail_html.replace(/<[^>]+>/g, "");
			var price = "¥" + (jList.sku_list[0].price / 100).toFixed(2);
			var oriPrice = "¥" + (jList.sku_list[0].ori_price / 100).toFixed(2);
			var property = jList.product_base.property;
			var sales = jList.product_base.detail[0];
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
			$("#product-sales").text(sales);
			$("#product-header").text(name);
			$("#product-main-img").attr("src", main_img).attr("data-src", main_img);
			$("#product-ori-price").text(oriPrice);
			$("#product-price").text(price);
			$("#product-description").text(description);
			$("#product-cost").text(cost);
			$("#product-last").text(last);
			// $("#product-btn-pay").attr("href", payUrl.replace("PRODUCT_ID",
			// _pid));
			$("#product-btn-to-door-service").on("click", function(event) {
				// Prevent the usual navigation behavior
				event.preventDefault();
				SessionCache.set("customerType", "toDoor");				
				$.mobile.changePage(_ctx + "/mobile/purchase-input-address?pid=" + _pid);
			});
			
			$("#product-btn-to-shop-service").on("click", function(event) {
				// Prevent the usual navigation behavior
				event.preventDefault();
				SessionCache.set("customerType", "toShop");				
				$.mobile.changePage(_ctx + "/mobile/purchase-select-shop?pid=" + _pid);
			});
			
			
			$("#product-slider").sliderPro({
				width : "100%",
				aspectRatio : 1.4,
				arrows : false,
				buttons : false,
				fullScreen : false,
				touchSwipe : false,
			});

			// formatData(main_img, _pid, name, description, price, oriPrice,
			// property, cost, last);

		}

		// function formatData(url, pid, name, description, price, oriPrice,
		// property, cost, last) {
		// $.post(_ctx + "/api/keystone/file/image/product", {
		// url : url,
		// pid : pid
		// }, function(data) {
		// var main_img = _ctx + data;
		// $("#product-header").text(name);
		// $("#product-main-img").attr("src", main_img).attr("data-src",
		// main_img);
		// $("#product-ori-price").text(oriPrice);
		// $("#product-price").text(price);
		// $("#product-description").text(description);
		// $("#product-cost").text(cost);
		// $("#product-last").text(last);
		// // $("#product-btn-pay").attr("href",
		// // payUrl.replace("PRODUCT_ID", _pid));
		// $("#product-btn-to-door-service").attr("href", _ctx +
		// "/mobile/purchase-input-address?type=todoor&pid=" + pid);
		// $("#product-btn-to-shop-service").attr("href", _ctx +
		// "/mobile/purchase-input-address?type=toshop&pid=" + pid);
		// $('#product-slider').sliderPro({
		// width : "100%",
		// aspectRatio : 1.4,
		// arrows : false,
		// buttons : false,
		// fullScreen : false,
		// touchSwipe : false,
		// });
		// });
		// }

	})();

});