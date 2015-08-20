$(document).on('pagecontainershow', function(e, ui) {
	(function() {
		if (ui.toPage[0].id != "purchase-select-time-page")
			return;

		$("[data-role='date']").datepicker();

		var oType = SessionCache.get("customerServiceType");
		var tid = SessionCache.get("customerTecId");
		var avail = 0;

		if ("上门服务" == oType) {
			$("#grid-radio-3").checkboxradio("disable");
			$("#grid-radio-4").checkboxradio("disable");
		}
		$("#purchase-select-time-btn-next").click(function() {
			if (null == $("input[name='customer-time-radio']:checked").val() || "" == $("#purchase-select-time-datapicker").val()) {
				$("#purchase-select-time-pop-alert .pop-alert-header").text("提示");
				$("#purchase-select-time-pop-alert .pop-alert-content").text("请将信息填写完整");
				$("#purchase-select-time-pop-alert").popup("open");
			} else {

				var selectDate = $("#purchase-select-time-datapicker").val();
				var selectTime = $("input[name='customer-time-radio']:checked").val();

				queryTime(selectDate, selectTime);
				
				if (1 == avail) {
					$("#purchase-select-time-pop-alert .pop-alert-header").text("提示");
					$("#purchase-select-time-pop-alert .pop-alert-content").text("该时间技师已被预订，请选择其他时间。");
					$("#purchase-select-time-pop-alert").popup("open");
				} else {
					SessionCache.set("customerDate", selectDate);
					SessionCache.set("customerTime", selectTime)
					$.mobile.changePage(_ctx + "/mobile/purchase-confirm");
				}
			}

		});

		function queryTime(selectDate, selectTime) {

			var json = $.ajax({
				type : "GET",
				url : _ctx + "/api/technician/" + tid + "/orderstime/",
				async : false
			}).responseText;

			if (null == json) {
				return;
			}
			verityTime(eval("(" + json + ")"), selectDate, selectTime);
		}

		function verityTime(json, selectDate, selectTime) {
			
			var jList = json;
			avail = 0;
			for (var i = 0; i < jList.length; i++) {
				if (jList[i].replace(/-/g,"/") == (selectDate + " " + selectTime)) {
					avail = 1;
				}
			}
		}

	})();

});