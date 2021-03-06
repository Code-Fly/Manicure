<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="meta/config.jsp"%>
<!DOCTYPE html>
<html>
<head>

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
				<div class="ui-block-a" style="text-align: center;padding: 0.2em;width: 30%;">

					<img style="width: 100%;" id="technician-headerPic">

				</div>
				<div class="ui-block-b" style="text-align: left;padding-left: 1em;">
					<p>
						<span id="technician-name"></span> <span style="color: blue;font-size: 0.6em;" id="technician-jobTitle"></span>
					</p>
					<p style="color: orange;" id="technician-stars"></p>
					<!-- <p style="font-size: 0.8em;">
						<span id="technician-orderCount"></span>
					</p> -->
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
				<div data-role="tabs" id="technician-tabs" style="padding: 0;">
					<div data-role="navbar">
						<ul>
							<li><a href="#one" data-ajax="false" class="ui-btn-active">个人简介</a></li>
							<li><a href="#two" data-ajax="false">服务商圈</a></li>
						</ul>
					</div>
					<div id="one" class="ui-body  ui-content">
						<p id="technician-selfDesc"></p>
					</div>
					<div id="two" class="ui-body  ui-content">
						<p id="technician-business"></p>
					</div>
				</div>
			</div>
			<div class="ui-grid-solo ">
				<ul data-role="listview">
					<li><a href="#" id="technician-comment-list-btn">顾客评价<span class="ui-li-count" id="technician-comment-count">0</span></a></li>
				</ul>
			</div>

			<div class="ui-grid-solo ui-bar product-square-list">
				<p>个人作品</p>

				<ul data-role="listview" data-inset="true" id="page-technician-list-product">

					<%-- <li><a href="#"> <img src="${ctx}/mobile/static/_assets/img/apple.png" class="ui-li-thumb">
							<h2>无商品</h2>
							<p>没有商品</p>
							<p class="ui-li-aside">¥0</p>
					</a></li> --%>

				</ul>

			</div>

		</div>

		<!-- /footer -->
		<div data-role="footer" data-position="fixed" style="text-align: center;">
			<a href="#" id="technicion-back" data-rel="back" class="ui-btn ui-btn-d ui-shadow ui-corner-all" style="width: 200px;">返回</a>
		</div>
	</div>
</body>
</html>
