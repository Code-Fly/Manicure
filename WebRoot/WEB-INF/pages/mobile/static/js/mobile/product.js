$(document).on(
		'pagecontainershow',
		function(e, ui) {
			(function() {
				if (ui.toPage[0].id != "product-page")
					return;

				var _pid = window.location.href.replace(_ctx + "/mobile/product/", "")
				var payUrl = "http://mp.weixin.qq.com/bizmall/malldetail?id=&pid=PRODUCT_ID&biz=MzI5MjAwNjA4Ng==&scene=&action=show_detail&showwxpaytitle=1#wechat_redirect";

				queryProduct();
				queryTechnician();

				function queryProduct() {
					$.mobile.loading("show");
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
						$.mobile.loading("hide");
					});

				}

				function queryTechnician() {
					$.getJSON(_ctx + "/api/technician/query", {
						productId : _pid
					}, function(json) {
						if (null == json) {
							alert("null");
							return;
						}

						loadTechnician(json);						
					});
				}

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
					// $("#product-btn-pay").attr("href",
					// payUrl.replace("PRODUCT_ID",
					// _pid));
					$("#product-btn-to-door-service").on("click", function(event) {
						// Prevent the usual navigation behavior
						event.preventDefault();
						SessionCache.set("customerServiceType", "上门服务");
						SessionCache.set("customerProduct", JSON.stringify(json));
						$.mobile.changePage(_ctx + "/mobile/purchase-select-shop");
					});

					$("#product-btn-to-shop-service").on("click", function(event) {
						// Prevent the usual navigation behavior
						event.preventDefault();
						SessionCache.set("customerServiceType", "到店服务");
						SessionCache.set("customerProduct", JSON.stringify(json));
						$.mobile.changePage(_ctx + "/mobile/purchase-select-shop");
					});

					$("#product-slider").sliderPro({
						width : "100%",
						aspectRatio : 1.4,
						arrows : false,
						buttons : false,
						fullScreen : false,
						touchSwipe : false,
					});

					share(name, window.location.href, main_img, description);
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

				function share(shareTitle, shareLink, shareImg, shareDesc) {
					var jsapiTicket = $.ajax({
						type : "GET",
						url : _ctx + "/api/keystone/jsapi/ticket/query",
						async : false
					}).responseText;

					var urlEncoded = $.ajax({
						type : "POST",
						url : _ctx + "/api/keystone/url/encode",
						data : {
							"url" : shareLink
						},
						async : false
					}).responseText;

					var shareLink = URL_SNS_OAUTH2_REDIRECT.replace("REDIRECT_URI", urlEncoded).replace("APPID", APP_ID).replace("SCOPE", "snsapi_base")

					var currentUrl = window.location.href;
					var sign = wxSign(jsapiTicket, currentUrl);

					wx.config({
						debug : false,
						appId : APP_ID,
						timestamp : sign.timestamp,
						nonceStr : sign.nonceStr,
						signature : sign.signature,
						jsApiList : [ "checkJsApi", "onMenuShareTimeline", "onMenuShareAppMessage", "onMenuShareQQ", "onMenuShareWeibo", "hideMenuItems", "showMenuItems", "hideAllNonBaseMenuItem",
								"showAllNonBaseMenuItem", "translateVoice", "startRecord", "stopRecord", "onRecordEnd", "playVoice", "pauseVoice", "stopVoice", "uploadVoice", "downloadVoice",
								"chooseImage", "previewImage", "uploadImage", "downloadImage", "getNetworkType", "openLocation", "getLocation", "hideOptionMenu", "showOptionMenu", "closeWindow",
								"scanQRCode", "chooseWXPay", "openProductSpecificView", "addCard", "chooseCard", "openCard" ]
					});

					wx.ready(function() {
						wx.onMenuShareTimeline({
							title : shareTitle,
							link : shareLink,
							imgUrl : shareImg,
							trigger : function(res) {
								// 不要尝试在trigger中使用ajax异步请求修改本次分享的内容，因为客户端分享操作是一个同步操作，这时候使用ajax的回包会还没有返回
								alert('用户点击分享到朋友圈');
							},
							success : function(res) {
								alert('已分享');
							},
							cancel : function(res) {
								alert('已取消');
							},
							fail : function(res) {
								alert(JSON.stringify(res));
							}
						});

						wx.onMenuShareAppMessage({
							title : shareTitle,
							desc : shareDesc,
							link : shareLink,
							imgUrl : shareImg,
							trigger : function(res) {
								// 不要尝试在trigger中使用ajax异步请求修改本次分享的内容，因为客户端分享操作是一个同步操作，这时候使用ajax的回包会还没有返回
								alert('用户点击发送给朋友');
							},
							success : function(res) {
								alert('已分享');
							},
							cancel : function(res) {
								alert('已取消');
							},
							fail : function(res) {
								alert(JSON.stringify(res));
							}
						});

						wx.onMenuShareQQ({
							title : shareTitle,
							desc : shareDesc,
							link : shareLink,
							imgUrl : shareImg,
							trigger : function(res) {
								alert('用户点击分享到QQ');
							},
							complete : function(res) {
								alert(JSON.stringify(res));
							},
							success : function(res) {
								alert('已分享');
							},
							cancel : function(res) {
								alert('已取消');
							},
							fail : function(res) {
								alert(JSON.stringify(res));
							}
						});

						wx.onMenuShareWeibo({
							title : shareTitle,
							desc : shareDesc,
							link : shareLink,
							imgUrl : shareImg,
							trigger : function(res) {
								alert('用户点击分享到微博');
							},
							complete : function(res) {
								alert(JSON.stringify(res));
							},
							success : function(res) {
								alert('已分享');
							},
							cancel : function(res) {
								alert('已取消');
							},
							fail : function(res) {
								alert(JSON.stringify(res));
							}
						});

						wx.onMenuShareQZone({
							title : shareTitle,
							desc : shareDesc,
							link : shareLink,
							imgUrl : shareImg,
							trigger : function(res) {
								alert('用户点击分享到QZone');
							},
							complete : function(res) {
								alert(JSON.stringify(res));
							},
							success : function(res) {
								alert('已分享');
							},
							cancel : function(res) {
								alert('已取消');
							},
							fail : function(res) {
								alert(JSON.stringify(res));
							}
						});

					});

					wx.error(function(res) {
						alert(res.errMsg);
					});
				}

			})();

		});