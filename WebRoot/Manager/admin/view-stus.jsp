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
			<%@include file="/public/nav/tree-nav.jsp"%>

			<div class="container-right">
				<!-- 所有学生信息 -->
				<table class="layui-table" lay-skin="line" >
					<colgroup>
						<col>
						<col>
						<col>
						<col>
						<col>
						<col>
						<col>
						<col width="200px">
					</colgroup>
					<thead>
						<tr>
							<th>学号</th>
							<th>姓名</th>
							<th>班级</th>
							<th>性别</th>
							<th>年龄</th>
							<th>电话</th>
							<th>地址</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody class="stu_table_tbody">
						<!-- <tr>
							<td>140920033</td>
							<td>张三</td>
							<td>软件1809</td>
							<td>男</td>
							<td>25</td>
							<td>12345678911</td>
							<td>天马山</td>
							<td><button class="layui-btn info-update">修改</button><button class="layui-btn layui-btn-danger">删除</button></td>
						</tr>
						<tr>
							<td>140920033</td>
							<td>张三</td>
							<td>软件1809</td>
							<td>男</td>
							<td>25</td>
							<td>12345678911</td>
							<td>天马山</td>
							<td><button class="layui-btn info-update">修改</button><button class="layui-btn layui-btn-danger">删除</button></td>
						</tr> -->
						
					</tbody>
				</table>
				<div id="pagination"></div>
			</div>
		</div>
	</div>

	<%@include file="/public/footer.jsp" %>
	<script type="text/javascript" src="<%=path %>/public/js/admin/view_stus.js"></script>
	<script type="text/javascript" src="<%=path %>/public/js/logout.js"></script>
</body>

</html>


