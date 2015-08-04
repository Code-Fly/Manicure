$(document).on('pagecontainershow', function(e, ui) {
	(function() {
		if (ui.toPage[0].id != "technician-page")
			return;
		var tid = GetQueryString("tid");
		$.getJSON(_ctx + "/api/technician/query/" + tid, function(json) {
			if (null == json) {
				alert("null");
				return;
			}
			loadTechnician(json);

		});

		function loadTechnician(json) {
			$("#technician-headerPic").attr("src", json.headerPic);
			$("#technician-name").text(json.name);
			$("#technician-jobTitle").text(json.jobTitle);
			var stars = "";
			for (var i = 0; i < json.stars; i++) {
				stars += "★";
			}

			$("#technician-stars").text(stars);

			$("#technician-orderCount").text("接单数：" + json.orderCount);
			$("#technician-moveScore").text(json.moveScore);
			$("#technician-profnalScore").text(json.profnalScore);
			$("#technician-punctualScore").text(json.punctualScore);

			$("#technician-selfDesc").text(json.selfDesc);
			$("#technician-business").text(json.business);
		}
	})();

});