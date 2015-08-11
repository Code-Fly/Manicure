$(document).on('pagecontainershow', function(e, ui) {
	(function() {
		if (ui.toPage[0].id != "purchase-select-time-page")
			return;

		$("[data-role='date']").datepicker();
		$("#purchase-select-time-btn-next").click(function() {
			SessionCache.set("customerDate", $("#purchase-select-time-datapicker").val());
			SessionCache.set("customerTime", $("input[name='customer-time-radio']:checked").val())
			$.mobile.changePage(_ctx + "/mobile/purchase-confirm");
		});
		
		
	})();

});