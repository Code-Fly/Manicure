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
	<div data-role="page" id="shop-detail-page">
		<div data-role="header">
			<a href="${ctx}/mobile/index" data-ajax="false" class="ui-btn ui-btn-left ui-alt-icon ui-nodisc-icon ui-corner-all ui-btn-icon-notext ui-icon-home">首页</a>
			<h2 id="shop-name"></h2>
		</div>
		<!-- /header -->
		<div role="main">
			<div class="ui-grid-solo">
				<div id="shop-slider" class="slider-pro">
					<div class="sp-slides">
						<div class="sp-slide">
							<img id="shop-main-img" class="sp-image" data-src="${ctx}/mobile/images/slides/bridge.jpg" />

						</div>
					</div>
				</div>

			</div>

			<div class="ui-grid-solo">
				<ul data-role="listview" data-theme="g">
					<li data-role="list-divider">详细地址</li>
					<li>
						<div class="ui-grid-a">
							<div class="ui-block-a" style="width: 20%;color: grey;">位置</div>
							<div class="ui-block-b" style="width: 80%" id="shop-location"></div>
						</div>
					</li>
					<li class="ui-field-contain">
						<div class="ui-grid-a">
							<div class="ui-block-a" style="width: 20%;color: grey;">电话</div>
							<div class="ui-block-b" style="width: 80%" id="shop-tel"></div>
						</div>
					</li>
					<li data-role="list-divider">商店概况</li>
					<li class="ui-field-contain">
						<div class="ui-grid-a">
							<div class="ui-block-a" style="width: 20%;color: grey;">营业</div>
							<div class="ui-block-b" style="width: 80%" id="shop-opentime"></div>
						</div>
					</li>
					<li class="ui-field-contain">
						<div class="ui-grid-a">
							<div class="ui-block-a" style="width: 20%;color: grey;">推荐</div>
							<div class="ui-block-b" style="width: 80%;" id="shop-recommend"></div>
						</div>
					</li>
					<li class="ui-field-contain">
						<div class="ui-grid-a">
							<div class="ui-block-a" style="width: 20%;color: grey;">特色</div>
							<div class="ui-block-b" style="width: 80%" id="shop-special"></div>
						</div>

					</li>
				</ul>
			</div>


		</div>

		<!-- /footer -->
		<div data-role="footer" data-position="fixed" style="text-align: center;">
			<a href="#" id="shop-detail-back" data-rel="back" class="ui-btn ui-btn-d ui-shadow ui-corner-all" style="width: 200px;">返回</a>
		</div>
	</div>
</body>
</html>
