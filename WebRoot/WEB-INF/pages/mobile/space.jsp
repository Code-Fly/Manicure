<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="meta/config.jsp"%>
<!DOCTYPE html>
<html>
<head>

<title>Home</title>
<%@ include file="meta/meta.jsp"%>
</head>
<body>
	<div data-role="page" id="space-page" data-title="我的">
		<div data-role="header">
			<h2 id="space-header">个人中心</h2>
		</div>
		<div role="main">
			<div class="ui-grid-a ui-bar ui-bar-b">
				<div class="ui-block-a" style="text-align: center;">
					<img id="space-user-headimgurl" height="100px" width="100px" src="">
				</div>
				<div class="ui-block-b">
					<p id="space-user-nickname"></p>
					<p style="font-size: 0.8em;font-weight: normal;">
						<span id="space-user-country"></span>&nbsp;<span id="space-user-province"></span>&nbsp;<span id="space-user-city"></span>
					</p>
				</div>
			</div>
			<ul data-role="listview" style="margin-top: 10px;">
				<li><a href="#">我的收藏<span class="ui-li-count">0</span></a></li>
				<li><a href="#">刮刮卡</a></li>
				<li><a href="#">门店地址</a></li>
			</ul>
		</div>
		<%@ include file="meta/footer.jsp"%>
		<!-- /footer -->
	</div>
</body>
</html>