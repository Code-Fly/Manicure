$(document).on('pagecontainershow', function(e, ui) {
	(function() {
		if (ui.toPage[0].id != "purchase-input-address-page")
			return;
		$("#purchase-input-address-btn-next").click(function() {
			SessionCache.setItem("customerAddr",$("#test").text());
			SessionCache.setItem("customerTel",$("#purchase-input-address-tel").val());
			$.mobile.changePage(_ctx + "/mobile/purchase-select-employee?pid=" + GetQueryString("pid"));
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
						
						$("#test").text(JSON.stringify(rs));
						
					});
				}
			}, "全国");
		}

	})();

});