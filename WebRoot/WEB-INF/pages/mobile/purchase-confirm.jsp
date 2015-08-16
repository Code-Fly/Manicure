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
					<p style="color: orange;margin-top: 5px;">选择甲师</p>
				</div>
				<div class="ui-block-b ">
					<p style="color: orange;margin-top: 5px;">填写信息</p>
				</div>
				<div class="ui-block-c ">
					<p style="color: orange;margin-top: 5px;">选择时间</p>
				</div>
				<div class="ui-block-d ">
					<p style="color: orange;margin-top: 5px;">确认下单</p>
				</div>
			</div>
			<div class="ui-grid-solo ui-content">
				<label>请确认订单：</label>
				<form>
					<ul data-role="listview" data-inset="true" id="page-confirm-detail-list">
						<li class="ui-field-contain"><img id="confirm-product-img">
							<h2 id="confirm-product-name"></h2>
							<p id="confirm-product-description"></p></li>
						<li class="ui-field-contain"><label>甲师：</label>
							<p>
								<span id="confirm-shop-name"></span> &nbsp; <span id="confirm-technician-name"></span>
							</p></li>
						<li class="ui-field-contain"><label>预约时间：</label>
							<p>
								<span id="confirm-date"></span> &nbsp; <span id="confirm-time"></span>
							</p></li>
						<li class="ui-field-contain"><label>服务方式：</label>
							<p>
								<span id="confirm-type"></span>
							</p></li>
						<li class="ui-field-contain" id="confirm-list-my-info" style="display: none;"><label>我的信息:</label>
							<p>
								<span>姓名：</span> <span id="confirm-my-name"></span>
							</p>
							<p>
								<span>电话号码：</span> <span id="confirm-my-tel"></span>
							</p>
							<p>
								<span>居住地址：</span> <span id="confirm-my-address"></span>
							</p>
							<p>
								<span>所在商圈：</span> <span id="confirm-my-business"></span>
							</p></li>
					</ul>
				</form>
			</div>
			<div class="ui-grid-solo"></div>
			<div data-role="popup" id="purchase-confirm-pop-alert" data-dismissible="false" style="max-width:400px;">
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

		<!-- footer -->
		<div data-role="footer" data-position="fixed" style="text-align: center;">
			<a href="#" id="purchase-select-confirm-btn-next" data-ajax="false" class="ui-btn ui-btn-d ui-shadow ui-corner-all" style="width: 200px;">付款</a>
		</div>
	</div>
</body>
</html>
