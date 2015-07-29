$(document).on('pagecontainershow', function(e, ui) {
	(function() {
		if (ui.toPage[0].id != "purchase-input-address-page")
			return;
		$("#purchase-input-address-btn-next").click(function() {
			$.mobile.changePage(_ctx + "/mobile/purchase-select-employee?pid=" + GetQueryString("pid"));
		});
	})();

});