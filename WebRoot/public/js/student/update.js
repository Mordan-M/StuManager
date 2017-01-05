layui.use([ 'form', 'layer', 'element' ], function() {
	$.ajax({
		url: path + '/student/stu_getInfo.php',
		method: 'POST',
		dataType: 'json',
		success : function(rmsg){
			showStuInfo(rmsg.stu);
		},
		error : function(){
			layer.msg("服务器繁忙，稍后请重试！");
		}
	});
	
	var form = layui.form();
	//监听提交
	form.on('submit(updateInfo)', function(form_elm) {
		//console.log(form_elm.field);
		
		$.ajax({
			url: path + '/student/stu_update.php',
			method: 'POST',
			data: form_elm.field,
			dataType: 'json',
			success : function(rmsg){
				if(rmsg.msg == true){
					showStuInfo(form_elm.field);
					layer.msg("修改成功！");
				}else if(rmsg.msg == false){
					layer.msg("修改失败！请检查数据的合法性！");
				}else{
					layer.msg(rmsg.msg);
				}
				
			},
			error : function(){
				layer.msg("服务器繁忙，稍后请重试！");
			}
		});
		
		return false;//阻止表单跳转
	});
	//添加表单验证规则
	form.verify({
		account : [ /^\d{9}$/, '请输入9位数字学号' ],
		age : [ /^\d{1,3}$/, '请输入正确的年龄' ]
	});
	
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


