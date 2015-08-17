$(document).on('pagecontainershow', function(e, ui) {
	(function() {
		if (ui.toPage[0].id != "purchase-select-time-page")
			return;

		$("[data-role='date']").datepicker();
		$("#purchase-select-time-btn-next").click(function() {
			if (null == $("input[name='customer-time-radio']:checked").val() || "" == $("#purchase-select-time-datapicker").val()) {
				$("#purchase-select-time-pop-alert .pop-alert-header").text("提示");
				$("#purchase-select-time-pop-alert .pop-alert-content").text("请将信息填写完整");
				$("#purchase-select-time-pop-alert").popup("open");
			} else {
				SessionCache.set("customerDate", $("#purchase-select-time-datapicker").val());
				SessionCache.set("customerTime", $("input[name='customer-time-radio']:checked").val())
				$.mobile.changePage(_ctx + "/mobile/purchase-confirm");
			}

		});

	})();

});