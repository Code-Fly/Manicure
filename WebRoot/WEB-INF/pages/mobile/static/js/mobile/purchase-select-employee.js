$(document).on('pagecontainershow', function(e, ui) {
	(function() {
		if (ui.toPage[0].id != "purchase-select-employee-page")
			return;
		var pid = GetQueryString("pid");
		var poiId = SessionCache.get("customerShopId");

		$.getJSON(_ctx + "/api/technician/query/" + pid + "/" + poiId, function(json) {
			if (null == json) {
				alert("null");
				return;
			}
			// alert(JSON.stringify(json));
			loadEmployee(json);

		});
		
		function loadEmployee(json){
			$("#page-purchase-select-employee-list").empty();
			var jList = json;
			for (var i = 0; i < jList.length; i++) {
				var name = jList[i].name;
				var moveScore = jList[i].moveScore;
				var profnalScore = jList[i].profnalScore;
				var punctualScore = jList[i].punctualScore;
				var orderCount = jList[i].orderCount;
				var headerPic = jList[i].headerPic;
				var tid = jList[i].id;
				var link = "";
				
				AppendListItem("#page-purchase-select-employee-list", tid, link, name, moveScore, profnalScore, punctualScore, orderCount, headerPic)
			
			}
			$("#page-purchase-select-employee-list").listview('refresh');
			
			$(".purchase-select-employee-btn-next").on("click", function(event) {
				// Prevent the usual navigation behavior
				event.preventDefault();

				SessionCache.set("customerTecId", $(this).attr("t-id"));

				$.mobile.changePage(_ctx + "/mobile/purchase-select-time?pid=" + pid);
			});
		}
		
		function AppendListItem(target, tid, link, name, moveScore, profnalScore, punctualScore, orderCount, headerPic) {

			var elmLi = $(document.createElement("li"));
			var elmImg = $(document.createElement("img"));
			var elmA = $(document.createElement("a"));
			var elmH2 = $(document.createElement("h2"));
			var elmP = $(document.createElement("p"));
			var elmSpan = $(document.createElement("span"));

			var listLi = elmLi.clone();
			var listA = elmA.clone().attr("href", link).attr("t-id", tid).addClass("purchase-select-employee-btn-next");
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
	})();

});