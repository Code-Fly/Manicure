$(document).on('pagecontainershow', function(e, ui) {
	(function() {
		if (ui.toPage[0].id != "purchase-select-employee-page")
			return;
		$(".purchase-select-employee-btn-next").click(function() {
			$.mobile.changePage(_ctx + "/mobile/purchase-select-time?pid=" + GetQueryString("pid"));
		});
	})();

});