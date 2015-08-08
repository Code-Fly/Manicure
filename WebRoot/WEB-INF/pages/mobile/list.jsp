<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="meta/config.jsp"%>
<!DOCTYPE html>
<html>
<head>

<title>Home</title>
<%@ include file="meta/meta.jsp"%>

</head>
<body>
	<div data-role="page" id="list-page">
		<div data-role="header">
			<h2 id="list-header">米宝服务</h2>
		</div>
		<div role="main">
			<div class="ui-grid-b" style="font-size: 1em;text-align: center;">
				<div class="ui-block-a ">
					<a id="list-btn-meijia" href="#" data-ajax="false" data-theme="b" data-role="button">美甲</a>
				</div>
				<div class="ui-block-b ">
					<a id="list-btn-meizu" href="#" data-ajax="false" data-theme="c" data-role="button">美足</a>
				</div>
				<div class="ui-block-c ">
					<a id="list-btn-meijie" href="#" data-ajax="false" data-theme="d" data-role="button">美睫</a>
				</div>
			</div>
			<div class="ui-grid-a" style="font-size: 1em;text-align: center;">
				<div class="ui-block-a ">
					<a id="list-btn-huazhuang" data-ajax="false" data-theme="e" data-role="button">化妆</a>
				</div>
				<div class="ui-block-b ">
					<a id="list-btn-huli" data-ajax="false" data-theme="f" data-role="button">护理</a>
				</div>
			</div>

			<div class="ui-grid-c ui-body-a ui-corner-all" id="list-btn-group-meijia" style="font-size: 0.8em;text-align: center;display: none;margin: 5px;">
				<div class="ui-block-a">
					<a href="#" id="list-btn-meijia-jianyue" class="ui-btn ui-mini ui-shadow ui-corner-all" data-ajax="false">简约</a>
				</div>
				<div class="ui-block-b">
					<a href="#" id="list-btn-meijia-caizhuang" class="ui-btn ui-mini ui-shadow ui-corner-all" data-ajax="false">彩妆</a>
				</div>
				<div class="ui-block-c">
					<a href="#" id="list-btn-meijia-fashi" class="ui-btn ui-mini ui-shadow ui-corner-all" data-ajax="false">法式</a>
				</div>
				<div class="ui-block-d">
					<a href="#" id="list-btn-meijia-rihan" class="ui-btn ui-mini ui-shadow ui-corner-all" data-ajax="false">日韩</a>
				</div>
			</div>
			<div class="ui-grid-a  ui-body-a ui-corner-all" id="list-btn-group-meizu" style="font-size: 0.8em;text-align: center;display: none;margin: 5px;">
				<div class="ui-block-a">
					<a href="#" id="list-btn-meizu-jianyue" class="ui-btn ui-mini ui-shadow ui-corner-all" data-ajax="false">简约</a>
				</div>
				<div class="ui-block-b">
					<a href="#" id="list-btn-meizu-caihui" class="ui-btn ui-mini ui-shadow ui-corner-all" data-ajax="false">彩绘</a>
				</div>
			</div>

			<div class="ui-grid-a  ui-body-a ui-corner-all" id="list-btn-group-huazhuang" style="font-size: 0.8em;text-align: center;display: none;margin: 5px;">
				<div class="ui-block-a">
					<a href="#" id="list-btn-huazhuang-xinniang" class="ui-btn ui-mini ui-shadow ui-corner-all" data-ajax="false">新娘妆</a>
				</div>
				<div class="ui-block-b">
					<a href="#" id="list-btn-huazhuang-wutai" class="ui-btn ui-mini ui-shadow ui-corner-all" data-ajax="false">舞台妆</a>
				</div>
			</div>
			<div class="ui-grid-b ui-body-a ui-corner-all" id="list-btn-group-huli" style="font-size: 0.8em;text-align: center;display: none;margin: 5px;">
				<div class="ui-block-a">
					<a href="#" id="list-btn-huli-shoubu" class="ui-btn ui-mini ui-shadow ui-corner-all" data-ajax="false">手部</a>
				</div>
				<div class="ui-block-b">
					<a href="#" id="list-btn-huli-zubu" class="ui-btn ui-mini ui-shadow ui-corner-all" data-ajax="false">足部</a>
				</div>
				<div class="ui-block-c">
					<a href="#" id="list-btn-huli-pifu" class="ui-btn ui-mini ui-shadow ui-corner-all" data-ajax="false">皮肤</a>
				</div>
			</div>



			<div class="ui-bar " style="padding: 0px;">
				<div class="ui-grid-b">
					<div class="ui-block-a">
						<select name="select-native-1" id="list-select-sort" data-mini="true" data-theme="a">
							<option value="null">-综合-</option>
							<option value="asc">升序</option>
							<option value="desc">降序</option>
						</select>
					</div>
					<div class="ui-block-b">
						<select name="select-native-2" id="list-select-orderBy" data-mini="true" data-theme="a">
							<option value="null">-价格-</option>
							<option value="price">价格优先</option>
							<option value="sales">销量优先</option>
						</select>
					</div>
					<div class="ui-block-c">
						<select name="select-native-3" id="list-select-price" data-mini="true" data-theme="a">
							<option value="null">-筛选-</option>
							<option value="0-100">0-100</option>
							<option value="101-200">101-200</option>
							<option value="201-400">201-400</option>
							<option value="401-1000">401-1000</option>
							<option value="1000-?">1000+</option>
						</select>
					</div>
				</div>
			</div>

			<div class="ui-grid-solo product-square-list">
				<ul data-role="listview" data-inset="true" id="page-list-list-service">
					<%-- 
					<li><a href="#"> <img src="${ctx}/mobile/_assets/img/apple.png" class="ui-li-thumb">
							<h2>无商品</h2>
							<p>没有商品</p>
							<p class="ui-li-aside">¥0</p>
					</a></li>
 					--%>
				</ul>

			</div>

		</div>
		<%@ include file="meta/footer.jsp"%>
		<!-- /footer -->
	</div>
</body>
</html>