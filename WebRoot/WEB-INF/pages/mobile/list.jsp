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
			<div class="ui-grid-b" style="font-size: 0.8em;text-align: center;">
				<div class="ui-block-a typebtn">
					<a id="list-btn-meijia" href="#" data-ajax="false" data-theme="b" data-role="button">美甲</a>
				</div>
				<div class="ui-block-b typebtn">
					<a id="list-btn-meizu" href="#" data-ajax="false" data-theme="c" data-role="button">美足</a>
				</div>
				<div class="ui-block-c typebtn">
					<a id="list-btn-meijie" href="#" data-ajax="false" data-theme="d" data-role="button">美睫</a>
				</div>
			</div>
			<div class="ui-grid-a" style="font-size: 0.8em;text-align: center;">
				<div class="ui-block-a typebtn">
					<a id="list-btn-huazhuang" data-theme="e" data-role="button">化妆</a>
				</div>
				<div class="ui-block-b typebtn">
					<a id="list-btn-huli" data-theme="f" data-role="button">护理</a>
				</div>
			</div>
			<div class="ui-bar " style="padding: 0px;">
				<div class="ui-grid-b">
					<div class="ui-block-a">
						<select name="select-native-1" id="select-native-1" data-mini="true" data-theme="a">
							<option>-综合-</option>
							<option value="1">升序</option>
							<option value="2">降序</option>
						</select>
					</div>
					<div class="ui-block-b">
						<select name="select-native-2" id="select-native-2" data-mini="true" data-theme="a">
							<option>-价格-</option>
							<option value="1">价格优先</option>
							<option value="2">销量优先</option>
						</select>
					</div>
					<div class="ui-block-c">
						<select name="select-native-3" id="select-native-3" data-mini="true" data-theme="a">
							<option>-筛选-</option>
							<option value="1">0-100</option>
							<option value="2">101-200</option>
							<option value="3">201-400</option>
							<option value="4">401-1000</option>
							<option value="4">1000+</option>
						</select>
					</div>
				</div>
			</div>
			<form style="text-align: center;">
				<fieldset data-role="controlgroup" data-type="horizontal" id="list-radio-group-meijia" style="display: none;">
					<input type="radio" name="list-radio-group-meijia" id="list-radio-meijia-jianyue" value="on" checked="checked"> 
					<label for="list-radio-meijia-jianyue">简约</label> 
					<input type="radio" name="list-radio-group-meijia" id="list-radio-meijia-caihui" value="off"> 
					<label for="list-radio-meijia-caihui">彩绘</label> 
					<input type="radio" name="list-radio-group-meijia" id="list-radio-meijia-fashi" value="other"> 
					<label for="list-radio-meijia-fashi">法式</label> 
					<input type="radio" name="list-radio-group-meijia" id="list-radio-meijia-rihan" value="other"> 
					<label for="list-radio-meijia-rihan">日韩</label>
				</fieldset>
				<fieldset data-role="controlgroup" data-type="horizontal" id="list-radio-group-meizu" style="display: none;">
					<input type="radio" name="list-radio-group-meizu" id="list-radio-meizu-jianyue" value="on" checked="checked"> 
					<label for="list-radio-meizu-jianyue">简约</label> 
					<input type="radio" name="list-radio-group-meizu" id="list-radio-meizu-caihui" value="off"> 
					<label for="list-radio-meizu-caihui">彩绘</label> 
				</fieldset>
				<fieldset data-role="controlgroup" data-type="horizontal" id="list-radio-group-huazhuang" style="display: none;">
					<input type="radio" name="list-radio-group-huazhuang" id="list-radio-huazhuang-xinniang" value="on" checked="checked"> 
					<label for="list-radio-huazhuang-xinniang">新娘妆</label> 
					<input type="radio" name="list-radio-group-huazhuang" id="list-radio-huazhuang-wutai" value="off"> 
					<label for="list-radio-huazhuang-wutai">舞台妆</label>
				</fieldset>
				<fieldset data-role="controlgroup" data-type="horizontal" id="list-radio-group-huli" style="display: none;">
					<input type="radio" name="list-radio-group-huli" id="list-radio-huli-shoubu" value="on" checked="checked"> 
					<label for="list-radio-huli-shoubu">手部</label> 
					<input type="radio" name="list-radio-group-huli" id="list-radio-huli-zubu" value="off"> 
					<label for="list-radio-huli-zubu">足部</label> 
					<input type="radio" name="list-radio-group-huli" id="list-radio-huli-pifu" value="other"> 
					<label for="list-radio-huli-pifu">皮肤</label>
				</fieldset>
			</form>


			<div class="ui-grid-solo">
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