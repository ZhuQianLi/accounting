

var oSubmit = document.getElementById('submit');

var oForm = document.getElementById('login');

oSubmit.onclick = function(){

	var oUsername = document.getElementById('username');
	var oPassword = document.getElementById('password');

	var ReX = new RegExp("^([0-9a-zA-Z]{6,15})$");
	if(!ReX.test(oUsername.value) || !ReX.test(oPassword.value) ){
		alert("账户或者密码输入错误");
		return false;
	}
}