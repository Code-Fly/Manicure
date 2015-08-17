$(document).on('pagecontainershow', function(e, ui) {
	(function() {
		if (ui.toPage[0].id != "space-page")
			return;
		$("#list-header").text("个人中心");
		if (null != _user) {
			$("#space-user-headimgurl").attr("src", _user.headimgurl);
			$("#space-user-nickname").text(_user.nickname);
			$("#space-user-country").text(_user.country);
			$("#space-user-province").text(_user.province);
			$("#space-user-city").text(_user.city);
		}else{
			$("#space-user-headimgurl").attr("src", _ctx+"/mobile/static/images/mobile/defaultheadimg.png");
			$("#space-user-nickname").text("你好！");
			$("#space-user-country").text("请先关注我们的公众号");
		}
	})();

});