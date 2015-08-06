$(document).on('pagecontainershow', function(e, ui) {
	(function() {

		if (ui.toPage[0].id != "home-page")
			return;
		$("#home-header").text("米兰美甲艺社");

		$('#home-slider').sliderPro({
			width : "100%",
			aspectRatio : 2,
			arrows : true,
			buttons : false,
			fullScreen : false,
			shuffle : true,
		});

		$("#home-btn-meijia").attr("href", _ctx + "/mobile/list?groupId=" + GROUP_ID_MEIJIA_JIANYUE);
		$("#home-btn-meizu").attr("href", _ctx + "/mobile/list?groupId=" + GROUP_ID_MEIZU_JIANYUE);
		$("#home-btn-meijie").attr("href", _ctx + "/mobile/list?groupId=" + GROUP_ID_MEIJIE);
		$("#home-btn-huazhuang").attr("href", _ctx + "/mobile/list?groupId=" + GROUP_ID_HUAZHUANG_XINNIANG);
		$("#home-btn-huli").attr("href", _ctx + "/mobile/list?groupId=" + GROUP_ID_HULI_SHOUBU);
		$("#home-btn-new").attr("href", _ctx + "/mobile/list?orderBy=" + PRODUCT_LIST_ORDERBY_PRICE + "&sort=" + PRODUCT_LIST_SORT_ASC);
	})();

});