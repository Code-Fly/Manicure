<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="meta/config.jsp"%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<%@ include file="meta/meta.jsp"%>

</head>
<body>
	<div data-role="page" id="technician-page">
		<div data-role="header">
			<a href="${ctx}/mobile/index" data-ajax="false" class="ui-btn ui-btn-left ui-alt-icon ui-nodisc-icon ui-corner-all ui-btn-icon-notext ui-icon-home">首页</a>
			<h2 id="technician-header"></h2>
		</div>
		<!-- /header -->
		<div role="main">

			<div id="technician-grid-1" class="ui-grid-a ui-bar ui-bar-i" style="text-align: center;">
				<div class="ui-block-a" style="text-align: center;padding: 0.2em;">

					<img style="width: 100%;" id="technician-headerPic">

				</div>
				<div class="ui-block-b" style="text-align: left;padding: 0.2em;vertical-align: middle;">
					<p>
						<span id="technician-name"></span> <span style="color: blue;font-size: 0.6em;" id="technician-jobTitle"></span>
					</p>
					<p style="color: orange;" id="technician-stars"></p>
					<p style="font-size: 0.8em;">
						<span id="technician-avg">均价：¥130</span>&nbsp;&nbsp;<span id="technician-orderCount"></span>
					</p>
				</div>
			</div>
			<div class="ui-grid-b ui-bar" style="font-size: 0.8em;text-align: center;">
				<div class="ui-block-a">
					<p>
						<span>专业：</span> <span style="color:blue;" id="technician-profnalScore"></span>
					</p>
				</div>
				<div class="ui-block-b">
					<p>
						<span>感动：</span> <span style="color:green;" id="technician-moveScore"></span>
					</p>
				</div>
				<div class="ui-block-c">
					<p>
						<span>守时：</span> <span style="color:red;" id="technician-punctualScore"></span>
					</p>
				</div>

			</div>
			<div class="ui-grid-solo ">
				<ul data-role="listview">
					<li><a href="#">顾客评价</a></li>
				</ul>
			</div>
			<div class="ui-grid-solo ui-bar">
				<p>个人信息</p>
				<p class="ui-body ui-body-a ui-corner-all" id="technician-selfDesc"></p>
			</div>

			<div class="ui-grid-solo ui-bar">
				<p>服务商圈</p>
				<p class="ui-body ui-body-a ui-corner-all" id="technician-business"></p>
			</div>
			<div class="ui-grid-solo ui-bar">
				<p>个人作品</p>

				<ul data-role="listview" data-inset="true" id="page-list-list-service">

					<li><a href="#"> <img src="${ctx}/mobile/static/_assets/img/apple.png" class="ui-li-thumb">
							<h2>无商品</h2>
							<p>没有商品</p>
							<p class="ui-li-aside">¥0</p>
					</a></li>

				</ul>

			</div>
			<div data-role="footer" data-position="fixed" style="text-align: center;">
				<a href="#" id="technicion-back" data-rel="back" class="ui-btn ui-btn-d ui-shadow ui-corner-all" style="width: 200px;">返回</a>
			</div>
		</div>
		<!-- /footer -->
	</div>
</body>
</html>
