<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="meta/config.jsp"%>
<!DOCTYPE html>
<html>
<head>

<%@ include file="meta/meta.jsp"%>
<style type="text/css">
</style>
</head>
<body>
	<div data-role="page" id="purchase-confirm-page">
		<div data-role="header">
			<h2>确认订单</h2>
		</div>
		<!-- /header -->
		<div role="main">

			<div class="ui-grid-c ui-bar ui-bar-b" style="font-size: 0.8em;text-align: center;">
				<div class="ui-block-a">
					<p style="color: orange;margin: 0;">•</p>
				</div>
				<div class="ui-block-b">
					<p style="color: orange;margin: 0;">•</p>
				</div>
				<div class="ui-block-c">
					<p style="color: orange;margin: 0;">•</p>
				</div>
				<div class="ui-block-d">
					<p style="color: orange;margin: 0;">•</p>
				</div>
				<div class="ui-block-a">
					<p style="color: orange;margin-top: 5px;">填写信息</p>
				</div>
				<div class="ui-block-b ">
					<p style="color: orange;margin-top: 5px;">选择甲师</p>
				</div>
				<div class="ui-block-c ">
					<p style="color: orange;margin-top: 5px;">选择时间</p>
				</div>
				<div class="ui-block-d ">
					<p style="color: orange;margin-top: 5px;">确认下单</p>
				</div>
			</div>
			<div class="ui-grid-solo"></div>
			<div class="ui-grid-solo"></div>
			<div data-role="footer" data-position="fixed" style="text-align: center;">
				<a href="#" id="purchase-select-confirm-btn-next" data-ajax="false" class="ui-btn ui-btn-d ui-shadow ui-corner-all" style="width: 200px;">付款</a>
			</div>
		</div>
		<!-- /footer -->
	</div>
</body>
</html>
