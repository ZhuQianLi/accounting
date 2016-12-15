<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<title>登陆界面</title>
</head>
<body>
	<form id="login" action=<c:url value="login?method=userlogin"/> method="post">
		<div>
			<div>用户名：<input type="text" name="username" id="username" placeholder="账户6-15位字母或数字"></div>
			<div>密码 ：<input type="text" name="password" id="password"  placeholder="密码6-15位字母或数字"></div>
			<div><input type="submit" value="登陆" id="submit"></div>
		</div>
	</form>
	<c:if test="${not empty message}">
		${message}
		<c:remove var="message"/>
	</c:if>
	
</body>

	<script type="text/javascript" src="js/login.js"></script>
</html>
