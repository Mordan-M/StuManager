
layui.use([ 'form', 'layer', 'element' ], function() {
	/* 	var element = layui.element();
		//一些事件监听
		element.on('tab(demo)', function(data) {
			console.log(data);
		}); */
	var form = layui.form();
	var index = parent.layer.getFrameIndex(window.name);
	var stuIndex =  parent.stuIndex;
	var stu = parent.stuArray[stuIndex];
	var path = parent.path;
	showStuInfo(stu);
	//重新渲染
	form.render();
	
	//监听提交
	form.on('submit(updateInfo)', function(form_elm) {
		//console.log(form_elm.field);
		
		$.ajax({
			url: path + '/admin/stu_updateStuByStuId.php',
			method: 'POST',
			data: form_elm.field,
			dataType: 'json',
			success : function(rmsg){
				if(rmsg.msg == true){
//					parent.tableRender();
					updateData(form_elm.field);
					parent.addClickEventForBtn();
					parent.layer.msg("修改成功！");
					parent.layer.close(index);
				}else{
					parent.layer.msg("修改失败！，请检查数据的合法性！");
				}
			},
			error : function(){
				layer.msg("服务器繁忙，稍后请重试！");
			}
		});
		
		return false;//阻止表单跳转
	});
	
	
	function showStuInfo(stu) {
		$('#stuId').val(stu.stuId);
		$('#stuName').val(stu.stuName);
		$('#className').val(stu.className);
		$('#stuAge').val(stu.stuAge);
		$('#stuPhone').val(stu.stuPhone);
		$('#stuAddress').val(stu.stuAddress);
		$('#stuSex_' + stu.stuSex).prop('checked','checked');
	}
	
	
	function updateData(stu){
		var str;
		var stuId = "<td>" + stu.stuId + "</td>";
		var stuname = "<td>" + stu.stuName + "</td>";
		var className = "<td>" + stu.className + "</td>";
		var stuSex = "<td>" + stu.stuSex + "</td>";
		var stuAge = "<td>" + stu.stuAge + "</td>";
		var stuPhone = "<td>" + stu.stuPhone + "</td>";
		var stuAddress = "<td>" + stu.stuAddress + "</td>";
		var updateBtn = "<td><button class='layui-btn info-update-btn' id='"
				+ stuIndex + "'>修改</button>";
		var deleteBtn = "<button class='layui-btn layui-btn-danger info-delete-btn' id='"
				+ stu.stuId + "'>删除</button></td>";
		str = stuId + stuname + className + stuSex + stuAge
		+ stuPhone + stuAddress + updateBtn + deleteBtn;
		parent.$('#trIndex' + stuIndex).html(str);
	}
	
	//添加表单验证规则
	form.verify({
		account : [ /^\d{9}$/, '请输入9位数字学号' ],
		age : [ /^\d{1,3}$/, '请输入正确的年龄' ]
	});
	

});


