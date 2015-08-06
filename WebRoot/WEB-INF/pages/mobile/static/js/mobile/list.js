/**
 * 
 */
$(document).on('pagecontainershow', function(e, ui) {
	(function() {
		if (ui.toPage[0].id != "list-page")
			return;
		$("#list-header").text("米宝服务");
		var groupId = GetQueryString("groupId");
		if (null == groupId) {
			groupId = "0";
		}
		var orderBy = GetQueryString("orderBy");
		if (null == orderBy) {
			orderBy = "sales";
		}
		var sort = GetQueryString("sort");
		if (null == sort) {
			sort = "desc";
		}

		$("#list-radio-meijia-jianyue").on("click", function(event) {
			// Prevent the usual navigation behavior
			event.preventDefault();
			queryList(GROUP_ID_MEIJIA_JIANYUE);
		});
		$("#list-radio-meijia-caihui").on("click", function(event) {
			// Prevent the usual navigation behavior
			event.preventDefault();
			queryList(GROUP_ID_MEIJIA_CAIZHUANG);
		});
		$("#list-radio-meijia-fashi").on("click", function(event) {
			// Prevent the usual navigation behavior
			event.preventDefault();
			queryList(GROUP_ID_MEIJIA_FASHI);
		});
		$("#list-radio-meijia-rihan").on("click", function(event) {
			// Prevent the usual navigation behavior
			event.preventDefault();
			queryList(GROUP_ID_MEIJIA_RIHAN);
		});
		//
		$("#list-radio-meizu-jianyue").on("click", function(event) {
			// Prevent the usual navigation behavior
			event.preventDefault();
			queryList(GROUP_ID_MEIZU_JIANYUE);
		});
		$("#list-radio-meizu-caihui").on("click", function(event) {
			// Prevent the usual navigation behavior
			event.preventDefault();
			queryList(GROUP_ID_MEIZU_CAIHUI);
		});
		//
		$("#list-radio-huazhuang-xinniang").on("click", function(event) {
			// Prevent the usual navigation behavior
			event.preventDefault();
			queryList(GROUP_ID_HUAZHUANG_XINNIANG);
		});
		$("#list-radio-huazhuang-wutai").on("click", function(event) {
			// Prevent the usual navigation behavior
			event.preventDefault();
			queryList(GROUP_ID_HUAZHUANG_WUTAI);
		});
		//
		$("#list-radio-huli-shoubu").on("click", function(event) {
			// Prevent the usual navigation behavior
			event.preventDefault();
			queryList(GROUP_ID_HULI_SHOUBU);
		});
		$("#list-radio-huli-zubu").on("click", function(event) {
			// Prevent the usual navigation behavior
			event.preventDefault();
			queryList(GROUP_ID_HULI_ZUBU);
		});
		$("#list-radio-huli-pifu").on("click", function(event) {
			// Prevent the usual navigation behavior
			event.preventDefault();
			queryList(GROUP_ID_HULI_PIFU);
		});

		$("#list-btn-meijia").on("click", function(event) {
			// Prevent the usual navigation behavior
			event.preventDefault();
			$("#list-radio-group-meijia").show();
			$("#list-radio-group-meizu").hide();
			$("#list-radio-group-huazhuang").hide();
			$("#list-radio-group-huli").hide();

			$("#list-radio-meijia-jianyue").click();

		});

		$("#list-btn-meizu").on("click", function(event) {
			// Prevent the usual navigation behavior
			event.preventDefault();
			$("#list-radio-group-meijia").hide();
			$("#list-radio-group-meizu").show();
			$("#list-radio-group-huazhuang").hide();
			$("#list-radio-group-huli").hide();
			queryList(GROUP_ID_MEIZU_JIANYUE);
		});

		$("#list-btn-meijie").on("click", function(event) {
			// Prevent the usual navigation behavior
			event.preventDefault();
			$("#list-radio-group-meijia").hide();
			$("#list-radio-group-meizu").hide();
			$("#list-radio-group-huazhuang").hide();
			$("#list-radio-group-huli").hide();
			queryList(GROUP_ID_MEIJIE);
		});

		$("#list-btn-huazhuang").on("click", function(event) {
			// Prevent the usual navigation behavior
			event.preventDefault();
			$("#list-radio-group-meijia").hide();
			$("#list-radio-group-meizu").hide();
			$("#list-radio-group-huazhuang").show();
			$("#list-radio-group-huli").hide();
			queryList(GROUP_ID_HUAZHUANG_XINNIANG);
		});

		$("#list-btn-huli").on("click", function(event) {
			// Prevent the usual navigation behavior
			event.preventDefault();
			$("#list-radio-group-meijia").hide();
			$("#list-radio-group-meizu").hide();
			$("#list-radio-group-huazhuang").hide();
			$("#list-radio-group-huli").show();
			queryList(GROUP_ID_HULI_SHOUBU);
		});
		if (groupId == GROUP_ID_MEIJIA_JIANYUE || groupId == GROUP_ID_MEIJIA_FASHI || groupId == GROUP_ID_MEIJIA_CAIZHUANG || groupId == GROUP_ID_MEIJIA_RIHAN) {
			$("#list-btn-meijia").click();
		} else if (groupId == GROUP_ID_MEIZU_JIANYUE || groupId == GROUP_ID_MEIZU_CAIHUI) {
			$("#list-btn-meizu").click();
		} else if (groupId == GROUP_ID_MEIJIE) {
			$("#list-btn-meijie").click();
		} else if (groupId == GROUP_ID_HUAZHUANG_WUTAI || groupId == GROUP_ID_HUAZHUANG_XINNIANG) {
			$("#list-btn-huazhuang").click();
		} else if (groupId == GROUP_ID_HULI_PIFU || groupId == GROUP_ID_HULI_SHOUBU || groupId == GROUP_ID_HULI_ZUBU) {
			$("#list-btn-huli").click();
		} else {
			$("#list-radio-group-meijia").hide();
			$("#list-radio-group-meizu").hide();
			$("#list-radio-group-huazhuang").hide();
			$("#list-radio-group-huli").hide();
			queryList(groupId);
		}

		function queryList(groupId) {
			$.getJSON(_ctx + "/api/keystone/product/list/1", {
				groupId : groupId,
				orderBy : orderBy,
				sort : sort
			}, function(json) {
				if (null == json) {
					alert("null");
					return;
				}
				if (0 != json.errcode) {
					alert(json.errmsg);
					return;
				}
				loadAllProduct(json.products_info);
			});
		}

		function loadAllProduct(json) {
			// var descLen = $(".ui-li-has-thumb a p").width() / 15;
			var descLen = $("#page-list-list-service").width() / 2 / 25
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
				// formatData(main_img, pid, name, description, price);
				var link = _ctx + "/mobile/product/" + pid;
				AppendListItem("#page-list-list-service", pid, link, main_img, name, description, price);

			}
			$("#page-list-list-service").listview('refresh');
		}

		// function formatData(url, pid, name, description, price) {
		// var main_img = _ctx + $.ajax({
		// type : "POST",
		// url : _ctx + "/api/keystone/file/image/product",
		// data : {
		// "url" : url,
		// "pid" : pid
		// },
		// async : false
		// }).responseText;
		// var link = _ctx + "/mobile/product/" + pid;
		// AppendListItem("#page-list-list-service", pid, link, main_img, name,
		// description, price);
		//
		// // $.post(_ctx + "/api/keystone/file/image/product", {
		// // url : url,
		// // pid : pid
		// // }, function(data) {
		// // var main_img = _ctx + data;
		// // var link = _ctx + "/mobile/product/" + pid;
		// // callBack("#page-list-list-service", pid, link, main_img, name,
		// // description, price);
		// // $("#page-list-list-service").listview('refresh');
		// // });
		// }

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
