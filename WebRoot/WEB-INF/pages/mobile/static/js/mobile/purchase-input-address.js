$(document).on(
		'pagecontainershow',
		function(e, ui) {
			(function() {
				if (ui.toPage[0].id != "purchase-input-address-page")
					return;
				// $("#purchase-input-address-addr").text(SessionCache.get("customerAddr"));
				// $("#purchase-input-address-biz").text(SessionCache.get("customerBiz"));
				// $("#purchase-input-address-tel").text(SessionCache.get("customerTel"));
				// $("#purchase-input-address-point-lng").text(SessionCache.get("customerLng"));
				// $("#purchase-input-address-point-lat").text(SessionCache.get("customerLat"));

				
				loadLocation();

				$("#purchase-input-address-btn-next").click(
						function() {
							if ("" == $("#purchase-input-address-addr").val() || "" == $("#purchase-input-address-biz").text() || "" == $("#purchase-input-address-tel").val()
									|| "" == $("#purchase-input-address-point-lng").val() || "" == $("#purchase-input-address-point-lat").val()) {
								$("#purchase-input-address-pop-alert .pop-alert-header").text("提示");
								$("#purchase-input-address-pop-alert .pop-alert-content").text("请将信息填写完整");
								$("#purchase-input-address-pop-alert").popup("open");
							} else {
								SessionCache.set("customerAddr", $("#purchase-input-address-addr").val());
								SessionCache.set("customerBiz", $("#purchase-input-address-biz").text());
								SessionCache.set("customerTel", $("#purchase-input-address-tel").val());
								SessionCache.set("customerLng", $("#purchase-input-address-point-lng").val());
								SessionCache.set("customerLat", $("#purchase-input-address-point-lat").val());
								window.location.href = _ctx + "/mobile/purchase-select-time"
								// $.mobile.changePage(_ctx +
								// "/mobile/purchase-select-time");
							}

						});

				var ac = new BMap.Autocomplete( // 建立一个自动完成的对象
				{
					"input" : "purchase-input-address-addr"
				});

				ac.addEventListener("onconfirm", function(e) { // 鼠标点击下拉列表后的事件
					var _value = e.item.value;
					var addr = _value.province + _value.city + _value.district + _value.street + _value.business;
					setPlace(addr);
				});

				function setPlace(addr) {// 创建地址解析器实例
					var myGeo = new BMap.Geocoder();// 将地址解析结果显示在地图上,并调整地图视野
					myGeo.getPoint(addr, function(point) {
						if (point) {
							myGeo.getLocation(point, function(rs) {								
								$("#purchase-input-address-biz").text(rs.business);
								$("#purchase-input-address-point-lng").val(rs.point.lng);
								$("#purchase-input-address-point-lat").val(rs.point.lat);
							});
						}
					}, "全国");
				}

				function loadLocation() {
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
						wx.getLocation({
							success : function(res) {
								//alert(JSON.stringify(res));
								var latitude = res.latitude; // 纬度，浮点数，范围为90 ~ -90
						        var longitude = res.longitude; // 经度，浮点数，范围为180 ~ -180。
						        var speed = res.speed; // 速度，以米/每秒计
						        var accuracy = res.accuracy; // 位置精度
						        
						        var myGeo = new BMap.Geocoder();// 将地址解析结果显示在地图上,并调整地图视野								
						        myGeo.getLocation(new BMap.Point(longitude,latitude), function(rs) {
						        	$("#purchase-input-address-addr").val(rs.address);
						        	$("#purchase-input-address-biz").text(rs.business);
									$("#purchase-input-address-point-lng").val(rs.point.lng);
									$("#purchase-input-address-point-lat").val(rs.point.lat);									
								});
						        
							},
							cancel : function(res) {
								//alert('用户拒绝授权获取地理位置');
							}
						});
					});

					wx.error(function(res) {
						alert(res.errMsg);
					});
				}

			})();

		});
