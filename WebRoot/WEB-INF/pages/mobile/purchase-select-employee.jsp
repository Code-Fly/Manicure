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
			<p style="font-size: 0.6em;">&nbsp;选择店面</p>
			<div class="ui-grid-solo" style="padding:10px;">
				<select name="select-native-17" id="select-native-17">
					<option value="1" selected="selected">南京 淘淘巷</option>
				</select>
			</div>
			<p style="font-size: 0.6em;">&nbsp;选择甲师</p>
			<div class="ui-grid-solo" style="padding-bottom: 10px;">
				<ul data-role="listview">
					<li><a class="purchase-select-employee-btn-next" href="#"> <img src="${ctx}/mobile/static/_assets/img/blackberry_10.png">
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
					</a></li>
					<li><a href="#" class="purchase-select-employee-btn-next"> <img src="${ctx}/mobile/static/_assets/img/blackberry_10.png">
							<h2>张君苗</h2>
							<p>
								专业:
								<n style="color:blue;">3.5</n>
								感动:
								<n style="color:green;">4.4</n>
								守时:
								<n style="color:red;">5.0</n>
							</p>
							<p class="ui-li-aside" style="color:orange;">服务46次</p>
					</a></li>
					<li><a href="#" class="purchase-select-employee-btn-next"> <img src="${ctx}/mobile/static/_assets/img/blackberry_10.png">
							<h2>黄雅莉</h2>
							<p>
								专业:
								<n style="color:blue;">2.5</n>
								感动:
								<n style="color:green;">4.0</n>
								守时:
								<n style="color:red;">4.0</n>
							</p>
							<p class="ui-li-aside" style="color:orange;">服务25次</p>
					</a></li>
				</ul>
			</div>
		</div>

		<!-- /footer -->
	</div>
</body>
</html>
