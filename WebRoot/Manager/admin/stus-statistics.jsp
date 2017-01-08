<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <%@include file="/public/head.jsp"%>
  
  <body>
 
	<div class="main-box ">
		<%@include file="/public/nav/lateral-nav.jsp"%>
		<div class="container">
				<%@include file="/public/nav/tree-nav.jsp"%>
				<div class="container-right">
					<fieldset class="layui-elem-field layui-field-title ">
						<legend>学生信息统计</legend>
						<div class="layui-field-box">
							 <!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
	    					<div id="class_cnt_echart"   style="width: 700px;height:432px; display:inline-block; " ></div>  <!-- display: inline" -->
							<div id="age_cnt_echart"   style="width: 700px;height:432px; display:inline-block;" ></div> <!-- style="width: 800px;height:494px; display: inline" -->
							<div id="sex_cnt_echart" style="width: 1200px;height:500px; display:inline-block;"></div> <!-- style="width: 1200px;height:741px;" -->
						</div>
					</fieldset>
				</div>
		</div>
	</div>
	
	<%@include file="/public/footer.jsp" %>
	<script type="text/javascript" src="<%=path%>/plugins/echarts/echarts.js"></script>
	<script type="text/javascript" src="<%=path %>/public/js/admin/statistics.js"></script>
	<script type="text/javascript" src="<%=path %>/public/js/logout.js"></script>

</body>

</html>


