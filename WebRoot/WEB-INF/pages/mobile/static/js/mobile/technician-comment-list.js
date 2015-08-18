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
				
				AppendListItem("#technician-comment-list", buyerNick, time, buyerOpenid, description);
				
			}
			$("#technician-comment-list").listview('refresh');
		}

		function AppendListItem(target, buyerNick, time, buyerOpenid, description) {
			var elmLi = $(document.createElement("li"));
			var elmImg = $(document.createElement("img"));
			var elmA = $(document.createElement("a"));
			var elmH2 = $(document.createElement("h2"));
			var elmP = $(document.createElement("p"));

			var listLi = elmLi.clone().attr("data-icon","false");
			var listA = elmA.clone().attr("href", "#");
			
			var listH2 = elmH2.clone().text(buyerNick);
			var listP = elmP.clone().text(description);
			var listSt = elmP.clone().addClass("ui-li-aside").css("color", "grey").text(time);

			listA.append(listH2);
			listA.append(listP);
			listA.append(listSt);
			listLi.append(listA);
			$(target).append(listLi);
		}
	})();

});