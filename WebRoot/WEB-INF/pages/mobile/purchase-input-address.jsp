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
	<div data-role="page" id="purchase-input-address-page">
		<div data-role="header">
			<h2>填写信息</h2>
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
					<p style="color: black;margin: 0;">•</p>
				</div>
				<div class="ui-block-d">
					<p style="color: black;margin: 0;">•</p>
				</div>
				<div class="ui-block-a">
					<p style="color: orange;margin-top: 5px;">选择甲师</p>
				</div>
				<div class="ui-block-b ">
					<p style="color: orange;margin-top: 5px;">填写信息</p>
				</div>
				<div class="ui-block-c ">
					<p style="color: black;margin-top: 5px;">选择时间</p>
				</div>
				<div class="ui-block-d ">
					<p style="color: black;margin-top: 5px;">确认下单</p>
				</div>
			</div>
			<div class="ui-grid-solo ui-content">
				<label for="purchase-input-address-tel">电话号码：</label> <input type="text" data-clear-btn="true" name="purchase-input-address-tel" id="purchase-input-address-tel" value="" placeholder="请填写您的手机号">
			</div>
			<div class="ui-grid-solo ui-content">
				<label for="purchase-input-address-addr">居住地址：</label>
				<textarea cols="40" rows="8" name="purchase-input-address-addr" id="purchase-input-address-addr" placeholder="请填写并选择地址"></textarea>
			</div>
			<div class="ui-grid-solo ui-content">
				<label for="purchase-input-address-biz">所在商圈：</label>
				<p id="purchase-input-address-biz"></p>
			</div>
			<div class="ui-grid-solo">
				<input type="hidden" id="purchase-hid-address-point-lng"> <input type="hidden" id="purchase-hid-address-point-lat">
			</div>
			<div data-role="popup" id="purchase-input-address-pop-alert" data-dismissible="false" style="max-width:400px;">
				<div data-role="header">
					<h1 class="pop-alert-header"></h1>
				</div>
				<div role="main" class="ui-content">
					<p class="pop-alert-content"></p>
					<div class="ui-grid-solo" style="text-align: center;">
						<a href="#" class="ui-btn ui-corner-all ui-shadow ui-btn-inline ui-mini " data-rel="back">确定</a>
					</div>
				</div>
			</div>
		</div>
		<div data-role="footer" data-position="fixed" style="text-align: center;">
			<a href="#" id="purchase-input-address-btn-next" class="ui-btn ui-btn-d ui-shadow ui-corner-all" style="width:200px;">选择时间</a>
		</div>
		<!-- /footer -->
	</div>
</body>
</html>
