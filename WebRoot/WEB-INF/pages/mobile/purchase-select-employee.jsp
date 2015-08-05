<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="meta/config.jsp"%>
<!DOCTYPE html>
<html>
<head>

<%@ include file="meta/meta.jsp"%>
</head>
<body>
	<div data-role="page" id="purchase-select-employee-page">
		<div data-role="header">
			<h2>选择甲师</h2>
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
					<p style="color: orange;margin-top: 5px;">填写信息</p>
				</div>
				<div class="ui-block-b ">
					<p style="color: orange;margin-top: 5px;">选择甲师</p>
				</div>
				<div class="ui-block-c ">
					<p style="color: black;margin-top: 5px;">选择时间</p>
				</div>
				<div class="ui-block-d ">
					<p style="color:black;margin-top: 5px;">确认下单</p>
				</div>
			</div>

			<div class="ui-grid-solo ui-content">
				<label for="purchase-input-address-addr">选择甲师：</label>
				<ul data-role="listview" data-inset="true" id="page-purchase-select-employee-list">
					<%-- <li><a class="purchase-select-employee-btn-next" href="#"> <img src="${ctx}/mobile/static/_assets/img/blackberry_10.png">
							<h2>叶海燕</h2>
							<p>
								专业:
								<n style="color:blue;">4.5</n>
								感动:
								<n style="color:green;">4.0</n>
								守时:
								<n style="color:red;">5.0</n>
							</p>
							<p class="ui-li-aside" style="color:orange;">服务32次</p>
					</a></li> --%>

				</ul>
			</div>
		</div>

		<!-- /footer -->
	</div>
</body>
</html>
