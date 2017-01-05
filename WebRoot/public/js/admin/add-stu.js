layui.use([ 'form', 'layer', 'element' ], function() {
	var form = layui.form();
	var layer = layui.layer;
	//监听提交
	form.on('submit(addInfo)', function(form_elm) {
		//layer.msg(JSON.stringify(form_elm.field));
		$.ajax({
			url: path + '/admin/stu_addStu.php',
			method: 'POST',
			data: form_elm.field,
			dataType: 'json',
			success : function(rmsg){
				//console.log(rmsg.msg == true);
				if(rmsg.msg == true){
					layer.msg("添加成功！");
					clearForm();
				}else{
					parent.layer.msg("添加失败！，请检查数据的合法性！");
				}
				
			}, 
			error : function(){
				layer.msg("服务器繁忙，稍后请重试！");
			}
			
		});
		
		return false;
	});

	//添加表单验证规则
	form.verify({
		account : [ /^\d{9}$/, '请输入9位数字学号' ],
		age : [ /^\d{1,3}$/, '请输入正确的年龄' ],
		pass: [/^[\S]{6,12}$/,'密码必须6到12位，且不能出现空格']
	});
		
	
	function clearForm(){
		$('#stuId').val('');
		$('#stuName').val('');
		$('#className').val('');
		$('#stuAge').val('');
		$('#stuPhone').val('');
		$('#stuAddress').val('');
		$('#stuSex_' + '男').prop('checked','checked');
	}
});