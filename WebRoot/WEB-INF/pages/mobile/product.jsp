<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="meta/config.jsp"%>
<!DOCTYPE html>
<html>
<head>

<title>Home</title>
<%@ include file="meta/meta.jsp"%>
<SCRIPT type="text/javascript">
	var __pid = "${pid}";
</SCRIPT>
</head>
<body>
	<div data-role="page" id="product-page">
		<div data-role="header">
			<a href="${ctx}/mobile/index" data-ajax="false" class="ui-btn ui-btn-left ui-alt-icon ui-nodisc-icon ui-corner-all ui-btn-icon-notext ui-icon-home">首页</a>
			<h2 id="product-header"></h2>
		</div>
		<div role="main">
			<div class="ui-grid-solo">
				<div id="product-slider" class="slider-pro">
					<div class="sp-slides">
						<div class="sp-slide">
							<img id="product-main-img" class="sp-image" data-src="${ctx}/mobile/images/slides/bridge.jpg" />

						</div>
					</div>
					<%-- <img id="product-main-img" src="${ctx}/mobile/images/slides/bridge.jpg" style="width: 100%;height: 200px;"> --%>
				</div>
				<div class="ui-content">
					<div class="ui-grid-a">
						<div class="ui-block-a" style="text-align: left;">
							<h2 style="color:#ff7070;margin-top:5px; margin-bottom: 5px" id="product-price">¥0</h2>
							<p style="font-size: 0.6em;">
								店面价：
								<del id="product-ori-price">¥0</del>
							</p>
						</div>
						<div class="ui-block-b" style="text-align: right;">
							<p style="color:orange;">
								<n id="product-sales">0</n>
								人做过
							</p>
						</div>
					</div>
					<div class="ui-grid-solo">
						<p style="font-size: 0.8em;" id="product-description">商品可能已下架</p>
					</div>
					<hr />
					<div class="ui-grid-a" style="text-align: left;">
						<div class="ui-block-a">
							<p style="font-size: 0.8em;">
								耗时：<em id="product-cost">0分钟</em>
							</p>
						</div>
						<div class="ui-block-b">
							<p style="font-size: 0.8em;">
								保持：<em id="product-last">0天</em>
							</p>
						</div>
					</div>
				</div>
				<div class="ui-grid-solo ui-content">
					<ul data-role="listview" data-inset="true" id="page-product-list-technician">
						<%-- 
						<li><a href="#"> <img src="${ctx}/mobile/static/_assets/img/blackberry_10.png">
								<h2>叶海燕</h2>
								<p>
									<span>1</span>
									<n style="color:blue;">4.5</n>
									感动:
									<n style="color:green;">4.0</n>
									守时:
									<n style="color:red;">5.0</n>
								</p>
								<p class="ui-li-aside" style="color:orange;">服务32次</p>
						</a></li>
						 --%>
					</ul>
				</div>

			</div>
			<div data-role="footer" data-position="fixed" style="text-align: center;">
				<div class="ui-grid-a">
					<div class="ui-block-a">
						<a id="product-btn-to-door-service" href="#" class="ui-btn ui-btn-d ui-shadow ui-corner-all" style="width: 60%;">上门服务</a>
					</div>
					<div class="ui-block-b">
						<a id="product-btn-to-shop-service" href="#" class="ui-btn ui-btn-d ui-shadow ui-corner-all" style="width: 60%;">到店服务</a>
					</div>

				</div>
			</div>
			<!-- /footer -->
		</div>
	</div>
</body>
</html>