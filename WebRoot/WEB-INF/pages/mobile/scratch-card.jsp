<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="meta/config.jsp"%>
<!DOCTYPE html>
<html>
<head>

<%@ include file="meta/meta.jsp"%>
<link rel="stylesheet" href="${ctx}/mobile/static/css/scratch-card.css" />

</head>

<body data-role="page" class="scratch-card activity-scratch-card-winning" id="scratch-card-page" style="margin: 0;padding: 0;">
	<div class="main">
		<div class="cover">
			<img src="${ctx}/mobile/static/images/scratchCard/activity-scratch-card-bannerbg.png">
			<div id="prize"></div>
			<div id="scratchpad">
				<div style="position: absolute; width: 150px; height: 40px; cursor: default;">
					<canvas width="150" height="40" style="cursor: default;"></canvas>
				</div>
			</div>
		</div>
		<div class="content">

			<div id="winprize" style="display:none" class="boxcontent boxwhite">
				<div class="box">
					<div class="title-red">
						<span>恭喜你中奖了</span>
					</div>
					<div class="Detail">
						<p>
							您中了 <span class="red" id="prizelevel"></span>
						</p>
						<p>
							奖品为 <span class="red" id="prizename"></span>
						</p>
					</div>
				</div>
			</div>

			<div class="boxcontent boxwhite">
				<div class="box">
					<div class="title-brown">活动说明：</div>
					<div class="Detail">
						<p>活动时间：即日起</p>
						<p>
							奖品设置：<font color="red">代金券</font>&nbsp;一张
						</p>
						<p>参与方式</p>
						<p>第一步：关注微信公众账号</p>
						<p>第二步：刮掉涂层查看中奖结果</p>
						<p>第三步：等待系统发放奖品</p>
					</div>
				</div>
			</div>

		</div>
		<div style="clear:both;"></div>
	</div>
	<div style="height:60px;"></div>
</body>
</html>
