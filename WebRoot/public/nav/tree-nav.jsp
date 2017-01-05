<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- 侧边导航	start -->
<div class="container-left" >  <!-- style="float: left;" -->
	<ul class="layui-nav layui-nav-tree ">
		<li class="layui-nav-item layui-nav-itemed"><a
			href="javascript:;">学生信息管理</a>
			<dl class="layui-nav-child">
				<dd>
					<a href="<%=path %>/admin/view.php">查看学生信息</a>
				</dd>
				<dd>
					<a href="<%=path %>/admin/add.php">添加学生信息</a>
				</dd>
			</dl>
		</li>
		 <li class="layui-nav-item"><a href="<%=path %>/admin/statistic.php">学生信息统计</a></li>
	</ul>
</div>
<!-- 侧边导航	end -->