$(document).on('pagecontainershow', function(e, ui) {
	(function() {
		if (ui.toPage[0].id != "space-page")
			return;
		$("#list-header").text("个人中心");
	})();

});