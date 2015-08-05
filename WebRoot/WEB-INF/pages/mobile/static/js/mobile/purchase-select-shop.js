$(document).on('pagecontainershow', function(e, ui) {
	(function() {
		if (ui.toPage[0].id != "purchase-select-shop-page")
			return;

		$.getJSON(_ctx + "/api/keystone/shop/list", function(json) {
			if (null == json) {
				alert("null");
				return;
			}
			if (0 != json.errcode) {
				alert(json.errmsg);
				return;
			}
			// alert(JSON.stringify(json));
			loadShop(json.business_list);

		});

		function loadShop(json) {
			$("#page-purchase-select-shop-list").empty();

			var jList = json;
			for (var i = 0; i < jList.length; i++) {
				if (jList[i].base_info.available_state != 3) {
					continue;
				}
				var name = jList[i].base_info.business_name;
				var photoUrl = jList[i].base_info.photo_list[0].photo_url;
				var city = jList[i].base_info.city;
				var province = jList[i].base_info.province;
				var address = jList[i].base_info.address;
				var poiId = jList[i].base_info.poi_id;
				var link = "#";
				AppendListItem("#page-purchase-select-shop-list", poiId, link, name, photoUrl, province, city, address);

			}
			$("#page-purchase-select-shop-list").listview('refresh');

			$(".purchase-select-shop-btn-next").on("click", function(event) {
				// Prevent the usual navigation behavior
				event.preventDefault();

				SessionCache.set("customerShopId", $(this).attr("poi-id"));
				SessionCache.set("customerShopName", $(this).attr("poi-name"));

				$.mobile.changePage(_ctx + "/mobile/purchase-select-employee?pid=" + GetQueryString("pid"));
			});
		}

		function AppendListItem(target, poiId, link, name, photoUrl, province, city, address) {
			var elmLi = $(document.createElement("li"));
			var elmImg = $(document.createElement("img"));
			var elmA = $(document.createElement("a"));
			var elmH2 = $(document.createElement("h2"));
			var elmP = $(document.createElement("p"));

			var listLi = elmLi.clone();
			var listA = elmA.clone().attr("href", link).attr("poi-id", poiId).attr("poi-name", name).addClass("purchase-select-shop-btn-next");

			var listImg = elmImg.clone().attr("src", photoUrl).addClass("ui-li-thumb").css("width", "100%").css("height", "100%");
			var listH2 = elmH2.clone().text(name);

			var listP = elmP.clone().text(address);
			var listSt = elmP.clone().addClass("ui-li-aside").css("color", "orange").text(city);

			listA.append(listImg);
			listA.append(listH2);
			listA.append(listP);
			listA.append(listSt);
			listLi.append(listA);
			$(target).append(listLi);
		}
	})();

});