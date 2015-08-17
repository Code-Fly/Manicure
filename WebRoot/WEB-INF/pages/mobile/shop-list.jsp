<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="meta/config.jsp"%>
<!DOCTYPE html>
<html>
<head>

<%@ include file="meta/meta.jsp"%>
</head>
<body>
	<div data-role="page" id="shop-list-page">
		<div data-role="header">
			<a href="${ctx}/mobile/index" data-ajax="false" class="ui-btn ui-btn-left ui-alt-icon ui-nodisc-icon ui-corner-all ui-btn-icon-notext ui-icon-home">首页</a>
			<h2>门店列表</h2>
		</div>
		<!-- /header -->
		<div role="main">
			<div class="ui-grid-solo ui-content">
				<label>门店：</label>
				<ul data-role="listview" data-inset="true" id="shop-list-list">
					<%-- <li><a class="purchase-select-shop-btn-next" href="#"> <img src="${ctx}/mobile/static/_assets/img/blackberry_10.png">
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
