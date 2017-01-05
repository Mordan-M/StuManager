var stuArray = new Array();
var pageData = new Array();
var stuIndex;
var pageNums = 10;//每页10条数据


layui.use([ 'layer', 'element','laypage' ], function() {
	var layer = layui.layer;
	var laypage = layui.laypage;
	$.ajax({
		url : path + '/admin/stu_getAllStuInfos.php',
		method : 'POST',
		dataType : 'json',
		success : function(data) {
			getData(data.stus);
			//渲染
			var render = function(curr){
				var str = '';
				var last = curr*pageNums - 1;
				last = last >= pageData.length ? (pageData.length-1) : last;
				for(var i = (curr*pageNums - pageNums); i <= last; i++){
					str += pageData[i];
				}
				return str;
			}
			
			laypage({
			    cont: 'pagination'
			    ,pages: Math.ceil(pageData.length/pageNums) //得到总页数
			    ,jump: function(obj){
			    	$('.stu_table_tbody').html(render(obj.curr));
			    	addClickEventForBtn();
			    },
			    skip: true
			});
		},
		error : function() {
			layer.msg("出错啦，请尝试刷新！");
		}
	});
	
	
});



function getData(stus){
	for ( var i = 0; i < stus.length; i++) {
		
		var stuId = "<td>" + stus[i].stuId + "</td>";
		var stuname = "<td>" + stus[i].stuName + "</td>";
		var className = "<td>" + stus[i].className + "</td>";
		var stuSex = "<td>" + stus[i].stuSex + "</td>";
		var stuAge = "<td>" + stus[i].stuAge + "</td>";
		var stuPhone = "<td>" + stus[i].stuPhone + "</td>";
		var stuAddress = "<td>" + stus[i].stuAddress + "</td>";
		var updateBtn = "<td><button class='layui-btn info-update-btn' id='"
				+ i + "'>修改</button>";
		var deleteBtn = "<button class='layui-btn layui-btn-danger info-delete-btn' id='"
				+ stus[i].stuId+"_"+ i+ "'>删除</button></td>";
		stuArray[i] = stus[i];
		pageData[i] = "<tr id='trIndex"+ i +"'>" + stuId + stuname + className + stuSex + stuAge
				+ stuPhone + stuAddress + updateBtn + deleteBtn + "</tr>";
	}
}


/*
function tableRender(){
	$.ajax({
		url : path + '/stu/stu_getAllStuInfos.php',
		method : 'POST',
		dataType : 'json',
		success : function(data) {
			showStus(data.stus);
		},
		error : function(){
			layer.msg("出错啦，请尝试刷新！");
		}
	});
}
*/
/*
//学生信息表渲染
function showStus(stus) {
	var data = '';
	for ( var i = 0; i < stus.length; i++) {
		stuArray[i] = stus[i];
		var stuId = "<td>" + stus[i].stuId + "</td>";
		var stuname = "<td>" + stus[i].stuName + "</td>";
		var className = "<td>" + stus[i].className + "</td>";
		var stuSex = "<td>" + stus[i].stuSex + "</td>";
		var stuAge = "<td>" + stus[i].stuAge + "</td>";
		var stuPhone = "<td>" + stus[i].stuPhone + "</td>";
		var stuAddress = "<td>" + stus[i].stuAddress + "</td>";
		var updateBtn = "<td><button class='layui-btn info-update-btn' id='"
				+ i + "'>修改</button>";
		var deleteBtn = "<button class='layui-btn layui-btn-danger info-delete-btn' id='"
				+ stus[i].stuId+"_"+ i + "'>删除</button></td>";
		data += ("<tr id='trIndex"+ i +"'>" + stuId + stuname + className + stuSex + stuAge
				+ stuPhone + stuAddress + updateBtn + deleteBtn + "</tr>");
	}
	$('.stu_table_tbody').html(data);
	addClickEventForBtn();
}
*/
function addClickEventForBtn(){
	$('.info-update-btn').unbind('click');
	$('.info-delete-btn').unbind('click');
	//为更新按钮监听点击事件
	$('.info-update-btn').on('click', function() {
		stuIndex = $(this).attr("id");
		layer.open({
			type : 2,
			title : '修改学生信息',
			shadeClose : true,
			shade : 0.8,
			area : [ '400px', '52%' ],
			content : path + '/admin/update.php' //iframe的url
		});
	});
	//为删除按钮监听点击事件
	$('.info-delete-btn').on('click',function() {
		var id = $(this).attr("id").split('_');
		var trIndex = id[1];
		stuId = id[0];
		//询问框
		layer.confirm('确认删除？', {
		  btn: ['确定','取消'] //按钮
		}, function(){
			deleteByActForDeleteBtn(stuId , trIndex);
		});
		
		
		
	});
}


function deleteByActForDeleteBtn(stuId , trIndex){
	$.ajax({
		url : path + '/admin/stu_deleteStu.php',
		method : 'POST',
		data : 'stuId=' + stuId,
		dataType: 'json',
		success : function(rmsg) {
			if(rmsg.msg == true) {
				$('#trIndex'+trIndex).remove();
				layer.msg("删除成功！");
			}
			//console.log(rmsg.msg);
			//tableRender();
		},
		error : function(){
			layer.msg("删除失败啦！请重试！");
		}
	});
}





	
