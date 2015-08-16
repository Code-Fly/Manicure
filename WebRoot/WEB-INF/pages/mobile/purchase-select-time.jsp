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
	<div data-role="page" id="purchase-select-time-page">
		<div data-role="header">
			<h2>选择时间</h2>
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
					<p style="color: black;margin: 0;">•</p>
				</div>
				<div class="ui-block-a">
					<p style="color: orange;margin-top: 5px;">选择甲师</p>
				</div>
				<div class="ui-block-b ">
					<p style="color: orange;margin-top: 5px;">填写信息</p>
				</div>
				<div class="ui-block-c ">
					<p style="color: orange;margin-top: 5px;">选择时间</p>
				</div>
				<div class="ui-block-d ">
					<p style="color: black;margin-top: 5px;">确认下单</p>
				</div>
			</div>
			<div class="ui-grid-solo">
				<input id="purchase-select-time-datapicker" type="hidden" data-role="date" data-inline="true" >
			</div>
			<div class="ui-grid-solo" id="purchase-select-time-grid">

				<div class="ui-grid-b">
					<div class="ui-block-a">
						<label for="grid-radio-1">07:00</label> <input type="radio" id="grid-radio-1" name="customer-time-radio" value="07:00" data-mini="true">
					</div>
					<div class="ui-block-b">
						<label for="grid-radio-2">08:00</label> <input type="radio" id="grid-radio-2" name="customer-time-radio" value="08:00" data-mini="true">
					</div>
					<div class="ui-block-c">
						<label for="grid-radio-3">09:00</label> <input type="radio" id="grid-radio-3" name="customer-time-radio" value="09:00" data-mini="true">
					</div>
				</div>
				<div class="ui-grid-b">
					<div class="ui-block-a">
						<label for="grid-radio-4">10:00</label> <input type="radio" id="grid-radio-4" name="customer-time-radio" value="10:00" data-mini="true">
					</div>
					<div class="ui-block-b">
						<label for="grid-radio-5">11:00</label> <input type="radio" id="grid-radio-5" name="customer-time-radio" value="11:00" data-mini="true">
					</div>
					<div class="ui-block-c">
						<label for="grid-radio-6">12:00</label> <input type="radio" id="grid-radio-6" name="customer-time-radio" value="12:00" data-mini="true">
					</div>
				</div>
				<div class="ui-grid-b">
					<div class="ui-block-a">
						<label for="grid-radio-7">13:00</label> <input type="radio" id="grid-radio-7" name="customer-time-radio" value="13:00" data-mini="true">
					</div>
					<div class="ui-block-b">
						<label for="grid-radio-8">14:00</label> <input type="radio" id="grid-radio-8" name="customer-time-radio" value="14:00" data-mini="true">
					</div>
					<div class="ui-block-c">
						<label for="grid-radio-9">15:00</label> <input type="radio" id="grid-radio-9" name="customer-time-radio" value="15:00" data-mini="true">
					</div>
				</div>
				<div class="ui-grid-b">
					<div class="ui-block-a">
						<label for="grid-radio-10">16:00</label> <input type="radio" id="grid-radio-10" name="customer-time-radio" value="16:00" data-mini="true">
					</div>
					<div class="ui-block-b">
						<label for="grid-radio-11">17:00</label> <input type="radio" id="grid-radio-11" name="customer-time-radio" value="17:00" data-mini="true">
					</div>
					<div class="ui-block-c">
						<label for="grid-radio-12">18:00</label> <input type="radio" id="grid-radio-12" name="customer-time-radio" value="18:00" data-mini="true">
					</div>
				</div>
			</div>
			<div data-role="popup" id="purchase-select-time-pop-alert" data-dismissible="false" style="max-width:400px;">
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
			<a href="#" id="purchase-select-time-btn-next" class="ui-btn ui-btn-d ui-shadow ui-corner-all" style="width: 200px;">确认订单</a>
		</div>
		<!-- /footer -->
	</div>
</body>
</html>
