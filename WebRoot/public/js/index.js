layui.use([ 'form', 'layer', 'element' ], function() {
	var form = layui.form();
	var layer = layui.layer;
	//监听登入表单提交
	form.on('submit(loginForm)', function(form_elm) {
		//layer.msg(JSON.stringify(form_elm.field));
		$('#login-btn').html("<i class='icon-spinner icon-spin icon-2x pull-left btnmsg' style='margin-left:20px'></i>");
		$.ajax({
			url: path + '/user/user_login.php',
			method: 'POST',
			data: form_elm.field,
			dataType: 'json',
			success : function(rmsg){
				//console.log(rmsg.msg == true);
				if(rmsg.msg == true){
					layer.msg("登入成功！");
					if(rmsg.userType==2){
						window.location.href = path + '/admin/view.php'
					}else if(rmsg.userType==1){
						window.location.href = path + '/student/view.php'
					}
				}else{
					layer.msg("用户名或密码错误！");
					$('#login-btn').html("<button class='layui-btn' lay-submit lay-filter='loginForm'>登入</button>");
				}
			},
			error : function(){
				layer.msg("服务器繁忙，稍后请重试！");
				$('#login-btn').html("<button class='layui-btn' lay-submit lay-filter='loginForm'>登入</button>");
			}
			
		});
		return false;
	});
	
	//监听注册表单提交
	form.on('submit(registerForm)', function(form_elm) {
		//layer.msg(JSON.stringify(form_elm.field));
		$.ajax({
			url: path + '/user/user_register.php',
			method: 'POST',
			data: form_elm.field,
			dataType: 'json',
			success : function(rmsg){
				//console.log(rmsg.msg == true);
				if(rmsg.msg == true){
					layer.msg("注册成功！");
					windows.location.href = path;
				}else{
					layer.msg("对不起，请输入合法数据！");
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
			
});