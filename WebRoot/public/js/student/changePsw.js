layui.use([ 'form', 'layer', 'element' ], function() {
	
	var form = layui.form();
	//监听提交
	form.on('submit(updatePsw)', function(form_elm) {
		//console.log(form_elm.field);
		
		$.ajax({
			url: path + '/student/stu_changePsw.php',
			method: 'POST',
			data: form_elm.field,
			dataType: 'json',
			success : function(rmsg){
				if(rmsg.msg == true){
					layer.msg("修改成功！");
					$('#psw1').val('');
					$('#psw2').val('');
				}else if(rmsg.msg == false){
					layer.msg("修改失败！请检查数据的合法性！");
				}else{
					layer.msg("请输入合法数据，密码和确认密码要一致！");
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
		pass: [/^[\S]{6,12}$/,'密码必须6到12位，且不能出现空格']
	});
	
});

function clear(){
	$('#psw1').val('');
	$('#psw2').val('');
}

