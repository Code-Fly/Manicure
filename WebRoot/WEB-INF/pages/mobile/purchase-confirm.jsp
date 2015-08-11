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
			<div class="ui-grid-solo ui-content">
				<label>请确认订单：</label>
				<form>
					<ul data-role="listview" data-inset="true" id="page-confirm-detail-list">
						<li class="ui-field-contain"><img id="confirm-product-img">
							<h2 id="confirm-product-name">服务名</h2>
							<p id="confirm-product-description">简介</p></li>
						<li class="ui-field-contain">
							<label>甲师：</label>
							<p>
								<span id="confirm-shop-name">店面。。</span>
								&nbsp;
								<span id="confirm-technician-name">甲师。。</span>
							</p>
						</li>
						<li class="ui-field-contain">
							<label>预约时间：</label>
							<p>
								<span id="confirm-date">日期。。</span>
								&nbsp;
								<span id="confirm-time">时间。。</span>
							</p>
						</li>
						<li class="ui-field-contain">
							<label>预约方式：</label>
							<p>
								<span id="confirm-type"></span>
							</p>
						</li>
						<li class="ui-field-contain" id="confirm-list-my-info" style="display: none;">
							<label>我的信息:</label>
							<p>
								<span>姓名：</span>
								<span id="confirm-my-name">xx</span>
							</p>
							<p>
								<span>电话号码：</span>
								<span id="confirm-my-tel">xx</span>
							</p>
							<p>
								<span>居住地址：</span>
								<span id="confirm-my-address">xx</span>
							</p>
							<p>
								<span>所在商圈：</span>
								<span id="confirm-my-business">xx</span>
							</p>						
						</li>
					</ul>
				</form>
			</div>
			<div class="ui-grid-solo"></div>
			<div data-role="footer" data-position="fixed" style="text-align: center;">
				<a href="#" id="purchase-select-confirm-btn-next" data-ajax="false" class="ui-btn ui-btn-d ui-shadow ui-corner-all" style="width: 200px;">付款</a>
			</div>
		</div>
		<!-- /footer -->
	</div>
</body>
</html>
