/**
 * 
 */
$(document).on('pagecontainershow', function(e, ui) {
	(function() {
		if (ui.toPage[0].id != "order-page")
			return;
		$("#order-header").text("我的米宝");
		var openId = "oxgY4xDnXebndNr-B6r5fRDXrHFo";
		$(document).on("click", "#page-order-btn-list-all", function() {
			queryOrder(0);
		});
		$(document).on("click", "#page-order-btn-list-processing", function() {
			queryOrder(2);
		});
		$(document).on("click", "#page-order-btn-list-not-evaluated", function() {			
			queryOrder(3);
		});

		$("#page-order-btn-list-all").click();

		function queryOrder(status) {
			$("#page-order-list-orders").hide();
			$.mobile.loading("show");
			$.getJSON(_ctx + "/api/keystone/order/list/" + status, function(json) {
				if (null == json) {
					alert("null");
					return;
				}
				if (0 != json.errcode) {
					alert(json.errmsg);
					return;
				}
				loadOrderList(json.order_list);
				$.mobile.loading("hide");
				$("#page-order-list-orders").fadeIn();				
			});
		}

		function loadOrderList(json) {
			$("#page-order-list-orders").empty();
			var jList = json;
			for (var i = 0; i < jList.length; i++) {
				var bId = jList[i].buyer_openid;
				if(bId != openId){
					continue;
				}
				var pName = jList[i].product_name;
				var pid = jList[i].product_id;
				var pImage = jList[i].product_img;
				var oId = jList[i].order_id;
				var status = jList[i].order_status;
				if("2"==status){
					status = "进行中";
				}else if("3"==status){
					status = "待评价"
				}
				else if("4"==status){
					status = "已完成"
				}
				var link = "#";
				AppendListItem("#page-order-list-orders", oId, link, pid, pName, pImage, status);

			}
			$("#page-order-list-orders").listview('refresh');
		}


		function AppendListItem(target, oId, link, pid, pName, pImage, status) {
			var elmLi = $(document.createElement("li"));
			var elmImg = $(document.createElement("img"));
			var elmA = $(document.createElement("a"));
			var elmH2 = $(document.createElement("h2"));
			var elmP = $(document.createElement("p"));

			var listLi = elmLi.clone();
			var listA = elmA.clone().attr("href", link);
			var listImg = elmImg.clone().attr("src", pImage).addClass("ui-li-thumb").css("width", "100%").css("height", "100%");
			var listH2 = elmH2.clone().text(pName);
			var listP = elmP.clone().text(oId);
			var listSt = elmP.clone().addClass("ui-li-aside").css("color", "orange").text(status);

			listA.append(listImg);
			listA.append(listH2);
			listA.append(listP);
			listA.append(listSt);
			listLi.append(listA);
			$(target).append(listLi);
		}
	})();

});
