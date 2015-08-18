$(document).on('pagecontainershow', function(e, ui) {
	(function() {
		if (ui.toPage[0].id != "technician-page")
			return;

		var tid = GetQueryString("tid");

		$(document).on("click", "#technician-comment-list-btn", function() {
			$.mobile.changePage(_ctx + "/mobile/technician-comment-list?tid=" + tid);

		});
		queryTechnician();
		queryProductList();
		queryComment();

		function queryComment() {

			$.get(_ctx + "/api/order/ordercomment/query", {
				tecId : tid
			}, function(json) {

				if (null == json) {
					return;
				}

				loadComment(eval("(" + json + ")"));

			});
		}

		function queryProductList() {
			$.mobile.loading("show");
			$.getJSON(_ctx + "/api/technician/" + tid + "/products", function(json) {
				if (null == json) {
					alert("null");
					return;
				}
				loadProductList(json);
				$.mobile.loading("hide");
			});
		}
		function queryTechnician() {
			$.getJSON(_ctx + "/api/technician/query/" + tid, function(json) {
				if (null == json) {
					alert("null");
					return;
				}
				loadTechnician(json);
			});
		}

		function loadComment(json) {
			$("#technician-comment-count").text(json.length);
		}

		function loadTechnician(json) {
			$("#technician-headerPic").attr("src", json.headerPic);
			$("#technician-name").text(json.name);
			$("#technician-jobTitle").text(json.jobTitle);
			var stars = "";
			for (var i = 0; i < json.stars; i++) {
				stars += "★";
			}

			$("#technician-stars").text(stars);

			$("#technician-orderCount").text("接单数：" + json.orderCount);
			$("#technician-moveScore").text(json.moveScore);
			$("#technician-profnalScore").text(json.profnalScore);
			$("#technician-punctualScore").text(json.punctualScore);

			$("#technician-selfDesc").text(json.selfDesc);
			$("#technician-business").text(json.business);

			$("#technician-tabs").tabs();
			$("#technician-tabs").tabs({
				selected : 1
			});
		}

		function loadProductList(json) {
			// var descLen = $(".ui-li-has-thumb a p").width() / 15;
			var descLen = $("#page-technician-list-product").width() / 2 / 25
			// alert(descLen);
			if (descLen == 0) {
				descLen = 6
			}
			$("#page-technician-list-product").empty();
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
				var link = _ctx + "/mobile/product/" + pid;
				AppendListItem("#page-technician-list-product", pid, link, main_img, name, description, price);

			}
			$("#page-technician-list-product").listview('refresh');
		}

		function AppendListItem(target, pid, href, img, title, discription, status) {
			var elmLi = $(document.createElement("li"));
			var elmImg = $(document.createElement("img"));
			var elmA = $(document.createElement("a"));
			var elmH2 = $(document.createElement("h2"));
			var elmP = $(document.createElement("p"));

			var listLi = elmLi.clone();
			var listA = elmA.clone().attr("href", href).attr("id", pid).addClass("product-item").attr("data-ajax", "false");
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