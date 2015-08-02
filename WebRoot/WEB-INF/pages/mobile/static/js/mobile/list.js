/**
 * 
 */
$(document).on('pagecontainershow', function(e, ui) {
	(function() {
		if (ui.toPage[0].id != "list-page")
			return;
		$("#list-header").text("米宝服务");
		$.getJSON(_ctx + "/api/keystone/product/list/1/0", function(json) {
			if (null == json) {
				alert("null");
				return;
			}
			if (0 != json.errcode) {
				alert(json);
				return;
			}
			loadAllProduct(json.products_info);
		});

		function loadAllProduct(json) {
			// var descLen = $(".ui-li-has-thumb a p").width() / 15;
			var descLen = $("#page-list-list-service").width() / 2 / 21
			// alert(descLen);
			if (descLen == 0) {
				descLen = 6
			}
			$("#page-list-list-service").empty();
			var jList = json;
			for (var i = 0; i < jList.length; i++) {
				var pid = jList[i].product_id;
				var main_img = jList[i].product_base.main_img;
				var name = jList[i].product_base.name;
				var description = jList[i].product_base.detail_html.replace(/<[^>]+>/g, "");
				if (description.length > descLen) {
					description = description.substring(0, descLen) + '...';
				}
				var price = "¥" + (jList[i].sku_list[0].price / 100).toFixed(2);
				//formatData(main_img, pid, name, description, price);
				var link = _ctx + "/mobile/product/" + pid;
				AppendListItem("#page-list-list-service", pid, link, main_img, name, description, price);


			}
			$("#page-list-list-service").listview('refresh');
		}

//		function formatData(url, pid, name, description, price) {
//			var main_img = _ctx + $.ajax({
//				type : "POST",
//				url : _ctx + "/api/keystone/file/image/product",
//				data : {
//					"url" : url,
//					"pid" : pid
//				},
//				async : false
//			}).responseText;
//			var link = _ctx + "/mobile/product/" + pid;
//			AppendListItem("#page-list-list-service", pid, link, main_img, name, description, price);
//
//			// $.post(_ctx + "/api/keystone/file/image/product", {
//			// url : url,
//			// pid : pid
//			// }, function(data) {
//			// var main_img = _ctx + data;
//			// var link = _ctx + "/mobile/product/" + pid;
//			// callBack("#page-list-list-service", pid, link, main_img, name,
//			// description, price);
//			// $("#page-list-list-service").listview('refresh');
//			// });
//		}

		function AppendListItem(target, pid, href, img, title, discription, status) {
			var elmLi = $(document.createElement("li"));
			var elmImg = $(document.createElement("img"));
			var elmA = $(document.createElement("a"));
			var elmH2 = $(document.createElement("h2"));
			var elmP = $(document.createElement("p"));

			var listLi = elmLi.clone();
			var listA = elmA.clone().attr("href", href).attr("id", pid).addClass("product-item");
			var listImg = elmImg.clone().attr("src", img).addClass("ui-li-thumb").css("width", "100%").css("height", "100%");
			var listH2 = elmH2.clone().text(title);
			var listP = elmP.clone().text(discription);
			var listSt = elmP.clone().addClass("ui-li-aside").css("color", "white").text(status);

			listA.append(listImg);
			listA.append(listH2);
			listA.append(listP);
			listA.append(listSt);
			listLi.append(listA);
			$(target).append(listLi);
		}

	})();

});
