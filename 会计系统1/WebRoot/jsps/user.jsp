<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<title>人员信息表</title>

	<link rel="stylesheet" type="text/css" href="css/common.css">
	<link rel="stylesheet" type="text/css" href="css/user.css">
</head>
<body>

	
	<main>
		
		<ul class="kind_header">
			<li>姓名</li>
			<li>所属部门</li>
			
			<li>用户名</li>
			<li>密码</li>
			<li>权限等级</li>
			<li>操作</li>
		</ul>
		
		<!-- 模型 -->
		<ul class="kind_modul">
			
			<li><input type="text" value=""></li>
			<li>
				<select>
					<option>理学院</option>
					<option>经管学院</option>
					<option>信息学院</option>
				</select>
			</li>
			<li><input type="text" value="" disabled="true"></li>
			<li><input type="text" value=""></li>
			<li>
				<select>
					<option>操作员</option>
					<option>审核员</option>
					<option>管理员</option>
				</select>
			</li>
			<li>
				<button class="del">删除</button>
				<button class="ok">确认</button>
			</li>
		</ul>

		<c:forEach items="${userList}" var="item">
			<ul class="kind_body">
				<li>${item.username}</li>
				<li>${item.acc_DNa}</li>
				<li>${item.acc_Usr}</li>
				<li>${item.password}</li>
				<li>${item.rolename}</li>
				<li>
					<button class="del">删除</button>
					<button class="edit">编辑</button>
				</li>
			</ul>
		</c:forEach>

		

	</main>
	
	<button id="insert">新增用户</button>
</body>
	
	<script type="text/javascript" src="js/ajax.js"></script>
	<script type="text/javascript" src="js/user.js"></script>
</html>