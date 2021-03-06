<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="meta/config.jsp"%>
<!DOCTYPE html>
<html>
<head>

<title>Home</title>
<%@ include file="meta/meta.jsp"%>

</head>
<body>
	<div data-role="page" id="order-page" data-title="订单">
		<div data-role="header">
			<h2 id="order-header">我的米宝</h2>
		</div>
		<div role="main">
			<div data-role="navbar">
				<ul>
					<li><a href="#" id="page-order-btn-list-all" class="ui-btn-active">全部</a></li>
					<li><a href="#" id="page-order-btn-list-processing">进行中</a></li>
					<li><a href="#" id="page-order-btn-list-not-evaluated">待评价</a></li>
				</ul>
			</div>
			<div class="ui-grid-solo">
				<ul data-role="listview" id="page-order-list-orders">
					<%-- 
					<li><a href="#"> <img src="${ctx}/_assets/img/blackberry_10.png" class="ui-li-thumb">
							<h2>优雅裸色</h2>
							<p>简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介</p>
							<p class="ui-li-aside" style="color:orange;">待评价</p>
					</a></li> 
					--%>

				</ul>
			</div>
			<div data-role="popup" id="order-pop-alert" data-dismissible="false" style="max-width:400px;">
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

		<%@ include file="meta/footer.jsp"%>
		<!-- /footer -->
	</div>
</body>
</html>