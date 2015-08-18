$(document).on('pagecontainershow', function(e, ui) {
	(function() {
		if (ui.toPage[0].id != "scratch-card-page")
			return;

		var display = false;
		var num = 0;
		var win = false;
		$(function() {
			$("#scratchpad").wScratchPad({
				width : 150,
				height : 40,
				color : "#a9a9a7",
				scratchMove : function(e, percent) {
					num++;
					// 80%时自动清除
					if (percent > 80) {
						this.clear();
					}
					// 开始时请求中奖结果
					if (num == 1) {
						if (Math.floor(Math.random() * (100 + 1)) < 50) {
							// 需要通过ajax请求判断openid以前是否中过奖
							$getPrizeBefor = false;
							if (!$getPrizeBefor) {
								win = true;
							}
						}
					}

					// 移动至少10次后，显示结果
					if (num > 10) {
						// 只显示一次
						if (!display) {
							// 根据概率显示
							if (win) {
								if (null != _user) {
									$("#prize").text("代金券");
									//$("#prizelevel").text("代金券");
									//$("#prizename").text("12元代金券");
									//$("#winprize").slideToggle(500);
									var sendCoupon = $.ajax({
										type : "POST",
										url : _ctx + "/api/keystone/customerservice/coupon/send",
										data : {
											"touser" : _user.openid,
											"cardId" : "pxgY4xHYfja32gNydRjZ7OzcUInc"
										},
										async : false
									}).responseText;
								} else {
									$("#prize").text("用户未登录");
								}
							} else {
								if (null != _user) {
									$("#prize").text("谢谢参与");
								}else{
									$("#prize").text("用户未登录");
								}
							}
						}
						display = true;
					}
				}
			});
		});

	})();

});