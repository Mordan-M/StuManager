function logout(){
	$.ajax({
		url: path + '/user/user_logout.php',
		method: 'POST',
		dataType: 'json',
		success : function(rmsg){
			layer.msg("注销成功！");
			window.location.href = path;
		}
	});
	
}