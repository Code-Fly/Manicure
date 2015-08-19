<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="meta/config.jsp"%>
<!DOCTYPE html>
<html>
<head>

<%@ include file="meta/meta.jsp"%>

</head>
<body>
	<div data-role="page" id="technician-comment-list-page">
		<div data-role="header">
			<a href="${ctx}/mobile/index" data-ajax="false" class="ui-btn ui-btn-left ui-alt-icon ui-nodisc-icon ui-corner-all ui-btn-icon-notext ui-icon-home">首页</a>
			<h2></h2>
		</div>
		<!-- /header -->
		<div role="main">

			<div class="ui-grid-solo ui-bar">
				<p>所有评价</p>

				<ul data-role="listview" data-inset="true" id="technician-comment-list" >

					<!-- <li>
						<h2>无商品</h2>
						<p style="white-space: normal;">没有商品没有商品没有商品没有商品没有商品没有商品没有商品没有商品没有商品没有商品没有商品没有商品没有商品没有商品没有商品</p>
						<p class="ui-li-aside"></p>
					</li> -->

				</ul>
				<!-- <ul data-role="listview" data-inset="true"  >

					<li>
						<h2>无商品</h2>
						<p style="white-space: normal;">没有商品没有商品没有商品没有商品没有商品没有商品没有商品没有商品没有商品没有商品没有商品没有商品没有商品没有商品没有商品</p>
						<p class="ui-li-aside"></p>
						<p></p>
						
					</li>

				</ul> -->
			</div>

		</div>

		<!-- /footer -->
		<div data-role="footer" data-position="fixed" style="text-align: center;">
			<a href="#" id="technicion-back" data-rel="back" class="ui-btn ui-btn-d ui-shadow ui-corner-all" style="width: 200px;">返回</a>
		</div>
	</div>
</body>
</html>
