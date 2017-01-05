<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
<%@include file="/public/head.jsp"%>

<body>
		<div class="container" style= " margin-right: 75px;" >
			<form class="layui-form">
				<div class="layui-form-item">
					<label class="layui-form-label" >学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号</label>
					<div class="layui-input-block">
						<input type="text" id="stuId" name="stuId" required lay-verify="account"
							placeholder="请输入学号" autocomplete="off" class="layui-input" readonly="readonly">
					</div>
				</div>

				<div class="layui-form-item">
					<label class="layui-form-label">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名</label>
					<div class="layui-input-block">
						<input type="text" id="stuName" name="stuName" required lay-verify="required"
							placeholder="请输入姓名" autocomplete="off" class="layui-input">
					</div>
				</div>

				<div class="layui-form-item">
					<label class="layui-form-label">班&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;级</label>
					<div class="layui-input-block">
						<input type="text" id="className" name="className" required lay-verify="required"
							placeholder="请输入班级" autocomplete="off" class="layui-input">
					</div>
				</div>



				<div class="layui-form-item">
					<label class="layui-form-label">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别</label>
					<div class="layui-input-block">
						<input type="radio" name="stuSex" id="stuSex_男" value="男" title="男" checked> <input
							type="radio" name="stuSex" id="stuSex_女" value="女" title="女" >
					</div>
				</div>

				<div class="layui-form-item">
					<label class="layui-form-label">年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄</label>
					<div class="layui-input-block">
						<input type="text" id="stuAge" name="stuAge" required lay-verify="age"
							placeholder="请输入年龄" autocomplete="off" class="layui-input">
					</div>
				</div>

				<div class="layui-form-item">
					<label class="layui-form-label">电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话</label>
					<div class="layui-input-block">
						<input type="text" id="stuPhone" name="stuPhone" required lay-verify="phone"
							placeholder="请输入电话" autocomplete="off" class="layui-input">
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
						<button class="layui-btn" lay-submit lay-filter="updateInfo">提交修改</button>
						<!-- <button type="reset" class="layui-btn layui-btn-primary">重置</button> -->
					</div>
				</div>
			</form>
		</div>
	<%@include file="/public/footer.jsp" %>
	<script type="text/javascript" src="<%=path %>/public/js/admin/update_stu.js"></script>
</body>

</html>


