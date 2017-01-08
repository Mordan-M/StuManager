<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
<%@include file="/public/head.jsp"%>

<body>
	<div class="main-box">
		<%@include file="/public/nav/lateral-nav.jsp"%>
		<div class="container">
			<!-- 侧边导航	start -->
			<div class="container-left" style="float: left;">
				<ul class="layui-nav layui-nav-tree">
					<li class="layui-nav-item layui-nav-itemed"><a
						href="javascript:;">个人信息管理</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="<%=path %>/student/view.php">查看个人信息</a>
							</dd>
							<dd>
								<a href="<%=path %>/student/changePsw.php">修改密码</a>
							</dd>
						</dl></li>
				</ul>
			</div>
			<!-- 侧边导航	end -->
			<div class="container-right">
				<fieldset class="layui-elem-field layui-field-title">
					<legend>请输入新密码</legend>
						<form class="layui-form" style=" margin-right: 20%;">
						
							<div class="layui-form-item">
								<label class="layui-form-label">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码</label>
								<div class="layui-input-inline">
									<input type="password" id="psw1" name="stuPsw" required
										lay-verify="pass" placeholder="请输入密码" autocomplete="off"
										class="layui-input">
								</div>
							</div>
							
							<div class="layui-form-item">
								<label class="layui-form-label">确认密码</label>
								<div class="layui-input-inline">
									<input type="password"id="psw2" name="repeatStuPsw" required
										lay-verify="pass" placeholder="请再次输入密码" autocomplete="off"
										class="layui-input">
								</div>
							</div>
				
							<div class="layui-form-item">
								<div class="layui-input-block">
									<button class="layui-btn" lay-submit lay-filter="updatePsw">确认修改</button>
									<!-- <button type="reset" class="layui-btn layui-btn-primary">重置</button> -->
								</div>
							</div>
							
						</form>
					</fieldset>
				</div>
		</div>
	</div>
	<%@include file="/public/footer.jsp" %>
	<script type="text/javascript" src="<%=path %>/public/js/student/changePsw.js"></script>
	<script type="text/javascript" src="<%=path %>/public/js/logout.js"></script>
</body>

</html>


