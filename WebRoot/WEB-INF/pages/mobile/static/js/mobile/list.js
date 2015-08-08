/**
 * 
 */
$(document).on(
		'pagecontainershow',
		function(e, ui) {
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
				var minPrice = GetQueryString("minPrice");
				if (null == minPrice) {
					minPrice = "?";
				}
				var maxPrice = GetQueryString("maxPrice");
				if (null == maxPrice) {
					maxPrice = "?";
				}

				$("#list-select-sort").change(function() {
					selected = $(this).children("option:selected").val();
					if ("null" != selected) {
						var pageUrl = window.location.href.split("?")[0];
						window.location.href = pageUrl + "?groupId=" + groupId + "&orderBy=" + orderBy + "&sort=" + selected + "&minPrice=" + minPrice + "&maxPrice=" + maxPrice;
					}
				});

				$("#list-select-orderBy").change(function() {
					selected = $(this).children("option:selected").val();
					if ("null" != selected) {
						var pageUrl = window.location.href.split("?")[0];
						window.location.href = pageUrl + "?groupId=" + groupId + "&orderBy=" + selected + "&sort=" + sort + "&minPrice=" + minPrice + "&maxPrice=" + maxPrice;
					}
				});
				$("#list-select-price").change(function() {
					selected = $(this).children("option:selected").val();
					if ("null" != selected) {
						var selected_0 = selected.split("-")[0];
						var selected_1 = selected.split("-")[1];
						var pageUrl = window.location.href.split("?")[0];
						window.location.href = pageUrl + "?groupId=" + groupId + "&orderBy=" + orderBy + "&sort=" + sort + "&minPrice=" + selected_0 + "&maxPrice=" + selected_1;
					}
				});
				// meijia
				$("#list-btn-meijia").attr("href", _ctx + "/mobile/list?groupId=" + GROUP_ID_MEIJIA_JIANYUE).addClass(GROUP_ID_MEIJIA_JIANYUE).addClass(GROUP_ID_MEIJIA_CAIZHUANG).addClass(
						GROUP_ID_MEIJIA_FASHI).addClass(GROUP_ID_MEIJIA_RIHAN);

				$("#list-btn-meijia-jianyue").attr("href", _ctx + "/mobile/list?groupId=" + GROUP_ID_MEIJIA_JIANYUE).addClass(GROUP_ID_MEIJIA_JIANYUE);
				$("#list-btn-meijia-caizhuang").attr("href", _ctx + "/mobile/list?groupId=" + GROUP_ID_MEIJIA_CAIZHUANG).addClass(GROUP_ID_MEIJIA_CAIZHUANG);
				$("#list-btn-meijia-fashi").attr("href", _ctx + "/mobile/list?groupId=" + GROUP_ID_MEIJIA_FASHI).addClass(GROUP_ID_MEIJIA_FASHI);
				$("#list-btn-meijia-rihan").attr("href", _ctx + "/mobile/list?groupId=" + GROUP_ID_MEIJIA_RIHAN).addClass(GROUP_ID_MEIJIA_RIHAN);
				// meizu
				$("#list-btn-meizu").attr("href", _ctx + "/mobile/list?groupId=" + GROUP_ID_MEIZU_JIANYUE).addClass(GROUP_ID_MEIZU_JIANYUE).addClass(GROUP_ID_MEIZU_CAIHUI);

				$("#list-btn-meizu-jianyue").attr("href", _ctx + "/mobile/list?groupId=" + GROUP_ID_MEIZU_JIANYUE).addClass(GROUP_ID_MEIZU_JIANYUE);
				$("#list-btn-meizu-caihui").attr("href", _ctx + "/mobile/list?groupId=" + GROUP_ID_MEIZU_CAIHUI).addClass(GROUP_ID_MEIZU_CAIHUI);

				// meijie
				$("#list-btn-meijie").attr("href", _ctx + "/mobile/list?groupId=" + GROUP_ID_MEIJIE).addClass(GROUP_ID_MEIJIE);

				// huazhuang
				$("#list-btn-huazhuang").attr("href", _ctx + "/mobile/list?groupId=" + GROUP_ID_HUAZHUANG_XINNIANG).addClass(GROUP_ID_HUAZHUANG_XINNIANG).addClass(GROUP_ID_HUAZHUANG_WUTAI);

				$("#list-btn-huazhuang-xinniang").attr("href", _ctx + "/mobile/list?groupId=" + GROUP_ID_HUAZHUANG_XINNIANG).addClass(GROUP_ID_HUAZHUANG_XINNIANG);
				$("#list-btn-huazhuang-wutai").attr("href", _ctx + "/mobile/list?groupId=" + GROUP_ID_HUAZHUANG_WUTAI).addClass(GROUP_ID_HUAZHUANG_WUTAI);

				// huli
				$("#list-btn-huli").attr("href", _ctx + "/mobile/list?groupId=" + GROUP_ID_HULI_SHOUBU).addClass(GROUP_ID_HULI_SHOUBU).addClass(GROUP_ID_HULI_ZUBU).addClass(GROUP_ID_HULI_PIFU);

				$("#list-btn-huli-shoubu").attr("href", _ctx + "/mobile/list?groupId=" + GROUP_ID_HULI_SHOUBU).addClass(GROUP_ID_HULI_SHOUBU);
				$("#list-btn-huli-zubu").attr("href", _ctx + "/mobile/list?groupId=" + GROUP_ID_HULI_ZUBU).addClass(GROUP_ID_HULI_ZUBU);
				$("#list-btn-huli-pifu").attr("href", _ctx + "/mobile/list?groupId=" + GROUP_ID_HULI_PIFU).addClass(GROUP_ID_HULI_PIFU);

				$("." + groupId).addClass("ui-btn-active");

				if (groupId == GROUP_ID_MEIJIA_JIANYUE || groupId == GROUP_ID_MEIJIA_FASHI || groupId == GROUP_ID_MEIJIA_CAIZHUANG || groupId == GROUP_ID_MEIJIA_RIHAN) {
					$("#list-btn-group-meijia").show();
					queryList();
				} else if (groupId == GROUP_ID_MEIZU_JIANYUE || groupId == GROUP_ID_MEIZU_CAIHUI) {
					$("#list-btn-group-meizu").show();
					queryList();
				} else if (groupId == GROUP_ID_MEIJIE) {
					queryList();
				} else if (groupId == GROUP_ID_HUAZHUANG_WUTAI || groupId == GROUP_ID_HUAZHUANG_XINNIANG) {
					$("#list-btn-group-huazhuang").show();
					queryList();
				} else if (groupId == GROUP_ID_HULI_PIFU || groupId == GROUP_ID_HULI_SHOUBU || groupId == GROUP_ID_HULI_ZUBU) {
					$("#list-btn-group-huli").show();
					queryList();
				} else {
					queryList();
				}

				function queryList() {
					$.mobile.loading("show");
					$.getJSON(_ctx + "/api/keystone/product/list/1", {
						groupId : groupId,
						orderBy : orderBy,
						sort : sort,
						minPrice : minPrice,
						maxPrice : maxPrice
					}, function(json) {
						if (null == json) {
							alert("null");
							return;
						}
						if (0 != json.errcode) {
							alert(json.errmsg);
							return;
						}
						loadProductList(json.products_info);
						$.mobile.loading("hide");
					});
				}

				function loadProductList(json) {
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
				// AppendListItem("#page-list-list-service", pid, link,
				// main_img, name,
				// description, price);
				//
				// // $.post(_ctx + "/api/keystone/file/image/product", {
				// // url : url,
				// // pid : pid
				// // }, function(data) {
				// // var main_img = _ctx + data;
				// // var link = _ctx + "/mobile/product/" + pid;
				// // callBack("#page-list-list-service", pid, link, main_img,
				// name,
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
