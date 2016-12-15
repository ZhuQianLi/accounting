<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<title>部门管理</title>

	<link rel="stylesheet" type="text/css" href="css/common.css">
	<link rel="stylesheet" type="text/css" href="css/dept.css">
</head>
<body>
	<main>
		<ul class="kind_header">
			<li>请选择</li>
			<li>部门编号</li>
			<li>部门名称</li>
			<li>创建人标号</li>
			<li>创建时间</li>
			<li>更新时间</li>
		</ul>
		
		<c:forEach items="${DepartmentList}" var="item">
			<ul class="kind_body">
				<li><input type="checkbox" name="kind_check" class="kind_check"></li>
				<li>${item.acc_DeP}</li>
				<li>${item.acc_DNa}</li>
				<li>${item.acc_Usr}</li>
				<li>${item.acc_Date}</li>
				<li>${item.acc_Last}</li>
			</ul>
		</c:forEach>
		
		
	</main>
	<button id ="insert">新增</button>
	<button id ="del">删除</button>
</body>

	<script type="text/javascript" src="js/ajax.js"></script>
	<script type="text/javascript" src="js/dept.js"></script>
</html>
