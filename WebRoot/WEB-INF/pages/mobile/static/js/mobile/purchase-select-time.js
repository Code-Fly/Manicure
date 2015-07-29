$(document).on('pagecontainershow', function(e, ui) {
	(function() {
		if (ui.toPage[0].id != "purchase-select-time-page")
			return;

		$("[data-role='date']").datepicker();
		$("#purchase-select-time-btn-next").click(function() {
			$.mobile.changePage(_ctx + "/mobile/purchase-confirm?pid=" + GetQueryString("pid"));
		});

	})();

});