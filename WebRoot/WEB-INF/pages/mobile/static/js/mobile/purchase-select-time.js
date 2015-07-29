$(document).on('pagecontainershow', function(e, ui) {
	(function() {
		if (ui.toPage[0].id != "purchase-select-time-page")
			return;
		
		$("[data-role='date']").datepicker();
		// alert(GetQueryString("type"));
	})();

});