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
								$.mobile.changePage(_ctx + "/mobile/purchase-select-time");
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
								// $("#test").text(JSON.stringify(rs));

							});
						}
					}, "全国");
				}

			})();

		});