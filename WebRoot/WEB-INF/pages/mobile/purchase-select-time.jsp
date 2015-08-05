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
			<h2>填写订单</h2>
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
					<p style="color: orange;margin-top: 5px;">填写信息</p>
				</div>
				<div class="ui-block-b ">
					<p style="color: orange;margin-top: 5px;">选择甲师</p>
				</div>
				<div class="ui-block-c ">
					<p style="color: orange;margin-top: 5px;">选择时间</p>
				</div>
				<div class="ui-block-d ">
					<p style="color: black;margin-top: 5px;">确认下单</p>
				</div>
			</div>
			<div class="ui-grid-solo">
				<input id="purchase-select-time-datapicker" type="hidden" data-role="date" data-inline="true">
			</div>
			<div class="ui-grid-solo" id="purchase-select-time-grid">
			
				<div class="ui-grid-b">
					<div class="ui-block-a">
						<label for="grid-radio-1">07:00</label> <input type="radio" id="grid-radio-1" name="grid-radio-2" data-mini="true">
					</div>
					<div class="ui-block-b">
						<label for="grid-radio-2">08:00</label> <input type="radio" id="grid-radio-2" name="grid-radio-2" data-mini="true">
					</div>
					<div class="ui-block-c">
						<label for="grid-radio-3">09:00</label> <input type="radio" id="grid-radio-3" name="grid-radio-2" data-mini="true">
					</div>
				</div>
				<div class="ui-grid-b">
					<div class="ui-block-a">
						<label for="grid-radio-4">10:00</label> <input type="radio" id="grid-radio-4" name="grid-radio-2" data-mini="true">
					</div>
					<div class="ui-block-b">
						<label for="grid-radio-5">11:00</label> <input type="radio" id="grid-radio-5" name="grid-radio-2" data-mini="true">
					</div>
					<div class="ui-block-c">
						<label for="grid-radio-6">12:00</label> <input type="radio" id="grid-radio-6" name="grid-radio-2" data-mini="true">
					</div>
				</div>
				<div class="ui-grid-b">
					<div class="ui-block-a">
						<label for="grid-radio-7">13:00</label> <input type="radio" id="grid-radio-7" name="grid-radio-2" data-mini="true">
					</div>
					<div class="ui-block-b">
						<label for="grid-radio-8">14:00</label> <input type="radio" id="grid-radio-8" name="grid-radio-2" data-mini="true">
					</div>
					<div class="ui-block-c">
						<label for="grid-radio-9">15:00</label> <input type="radio" id="grid-radio-9" name="grid-radio-2" data-mini="true">
					</div>
				</div>
				<div class="ui-grid-b">
					<div class="ui-block-a">
						<label for="grid-radio-10">16:00</label> <input type="radio" id="grid-radio-10" name="grid-radio-2" data-mini="true">
					</div>
					<div class="ui-block-b">
						<label for="grid-radio-11">17:00</label> <input type="radio" id="grid-radio-11" name="grid-radio-2" data-mini="true">
					</div>
					<div class="ui-block-c">
						<label for="grid-radio-12">18:00</label> <input type="radio" id="grid-radio-12" name="grid-radio-2" data-mini="true">
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
