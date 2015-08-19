$(document).on('pagecontainershow', function(e, ui) {
	(function() {
		if (ui.toPage[0].id != "technician-comment-list-page")
			return;

		var tid = GetQueryString("tid");

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

		function loadComment(json) {

			$("#technician-comment-list").empty();
			var jList = json;
			for (var i = 0; i < jList.length; i++) {
				var buyerNick = jList[i].buyer_nick;
				var time = jList[i].time;
				var buyerOpenid = jList[i].buyer_openid;
				var description = jList[i].description.replace(/<[^>]+>/g, "");
				var pic1 = jList[i].pic1;
				var pic2 = jList[i].pic2;
				var pic3 = jList[i].pic3;

				AppendListItem("#technician-comment-list", buyerNick, time, buyerOpenid, description, pic1, pic2, pic3);

			}
			$("#technician-comment-list").listview('refresh');
		}

		function AppendListItem(target, buyerNick, time, buyerOpenid, description, pic1, pic2, pic3) {
			var elmLi = $(document.createElement("li"));
			var elmImg = $(document.createElement("img"));
			var elmA = $(document.createElement("a"));
			var elmH2 = $(document.createElement("h2"));
			var elmP = $(document.createElement("p"));

			var listLi = elmLi.clone().attr("data-icon", "false");
			var listA = elmA.clone().attr("href", "#");

			var listH2 = elmH2.clone().text(buyerNick);
			var listP = elmP.clone().text(description);
			var listSt = elmP.clone().addClass("ui-li-aside").css("color", "grey").text(time);
			var listPicP = elmP.clone();
			var listPic1 = elmImg.clone().attr("src", pic1).attr("width", "30%").attr("height", "80px").css("margin-left", "5px").css("margin-right", "5px");
			var listPic2 = elmImg.clone().attr("src", pic2).attr("width", "30%").attr("height", "80px").css("margin-left", "5px").css("margin-right", "5px");
			var listPic3 = elmImg.clone().attr("src", pic3).attr("width", "30%").attr("height", "80px").css("margin-left", "5px").css("margin-right", "5px");
			listA.append(listH2);
			listA.append(listP);
			listA.append(listSt);
			if ("" != pic1) {
				listPicP.append(listPic1);
			}
			if ("" != pic2) {
				listPicP.append(listPic2);
			}
			if ("" != pic3) {
				listPicP.append(listPic3);
			}
			if ("" != listPicP.html()) {
				listA.append(listPicP);
			}
			listLi.append(listA);
			$(target).append(listLi);
		}
	})();

});