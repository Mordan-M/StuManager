<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path  = request.getContextPath();
%>

<!DOCTYPE HTML">
<html>
<head>
<title>学生信息管理系统</title>

<link rel="stylesheet" type="text/css"
	href="<%=path%>/plugins/layui/css/layui.css">
<link rel="stylesheet"
	href="<%=path%>/plugins/Font-Awesome/css/font-awesome.css">

</head>

<body>
    <div class="main-box">
		<!-- 水平导航start -->
		<div class="lat-nav">
			<ul class="layui-nav">
				<li class="layui-nav-item"><a href="#">学生信息管理系统</a>
				</li>
			</ul>
		</div>
		<!-- 水平导航end -->
		<div class="container" style=" width: 520px;  margin: 50px auto;">
		<fieldset class="layui-elem-field">
			<legend>请登入</legend>
				<div class="layui-field-box">
					<div class="layui-tab layui-tab-card">
						<ul class="layui-tab-title">
							<li class="layui-this">登入</li>
							<li>学生注册</li>
						</ul>
						<div class="layui-tab-content" >
							<!-- 登入 -->
							<div class="layui-tab-item layui-show">
								<form class="layui-form">
									<div class="layui-form-item">
											<label class="layui-form-label">用&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;户</label>
												<div class="layui-input-block">
													<select name="userType" lay-verify="required" >
														<!-- <option value=""></option> -->
														<option value="2">管理员</option>
														<option value="1">学生</option>
													</select>
												</div>
									</div>
									
									<div class="layui-form-item">
										<label class="layui-form-label">用 户 名</label>
										<div class="layui-input-block">
											<input type="text" name="username" required lay-verify="number"
												placeholder="请输入用户名" autocomplete="off" class="layui-input">
										</div>
										
									</div>
									
									<div class="layui-form-item">
										<label class="layui-form-label">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码</label>
										<div class="layui-input-inline">
											<input type="password" name="password" required
												lay-verify="required" placeholder="请输入密码" autocomplete="off"
												class="layui-input">
										</div>
									</div>
					
									<div class="layui-form-item">
										<div class="layui-input-block" id="login-btn">
											<button class="layui-btn" lay-submit lay-filter="loginForm">登入</button>
										</div>
									</div>
								</form>
							
							
							</div>
							<!-- 注册 -->
							<div class="layui-tab-item">
								<form class="layui-form">
								
									<div class="layui-form-item">
										<label class="layui-form-label">学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号</label>
										<div class="layui-input-block">
											<input type="text" id="stuId" name="stuId" required
												lay-verify="account" placeholder="请输入学号" autocomplete="off"
												class="layui-input" >
										</div>
									</div>
									
									<div class="layui-form-item">
										<label class="layui-form-label">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码</label>
										<div class="layui-input-inline">
											<input type="password" name="stuPsw" required
												lay-verify="pass" placeholder="请输入密码" autocomplete="off"
												class="layui-input">
										</div>
									</div>
									
									

									<div class="layui-form-item">
										<label class="layui-form-label">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名</label>
										<div class="layui-input-block">
											<input type="text" id="stuName" name="stuName" required
												lay-verify="required" placeholder="请输入姓名" autocomplete="off"
												class="layui-input">
										</div>
									</div>

									<div class="layui-form-item">
										<label class="layui-form-label">班&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;级</label>
										<div class="layui-input-block">
											<input type="text" id="className" name="className" required
												lay-verify="required" placeholder="请输入班级" autocomplete="off"
												class="layui-input">
										</div>
									</div>



									<div class="layui-form-item">
										<label class="layui-form-label">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别</label>
										<div class="layui-input-block">
											<input type="radio" name="stuSex" id="stuSex_男" value="男"
												title="男" checked> <input type="radio" name="stuSex"
												id="stuSex_女" value="女" title="女">
										</div>
									</div>

									<div class="layui-form-item">
										<label class="layui-form-label">年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄</label>
										<div class="layui-input-block">
											<input type="text" id="stuAge" name="stuAge" required
												lay-verify="age" placeholder="请输入年龄" autocomplete="off"
												class="layui-input">
										</div>
									</div>

									<div class="layui-form-item">
										<label class="layui-form-label">电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话</label>
										<div class="layui-input-block">
											<input type="text" id="stuPhone" name="stuPhone" required
												lay-verify="phone" placeholder="请输入电话" autocomplete="off"
												class="layui-input">
										</div>
									</div>

									<div class="layui-form-item">
										<label class="layui-form-label">地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址</label>
										<div class="layui-input-block">
											<input type="text" id="stuAddress" name="stuAddress" required
												lay-verify="required" placeholder="请输入地址" autocomplete="off"
												class="layui-input">
										</div>
									</div>

									<div class="layui-form-item">
										<div class="layui-input-block">
											<button class="layui-btn" lay-submit lay-filter="registerForm">立即注册</button>
											<!-- <button type="reset" class="layui-btn layui-btn-primary">重置</button> -->
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
					
				</div>
			</fieldset>
		</div>
	
		
	</div>

	<%@include file="/public/footer.jsp" %>
	<script type="text/javascript" src="<%=path %>/public/js/index.js"></script>
</body>
</html>
