<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<title>会计审核页面</title>

	<link rel="stylesheet" type="text/css" href="css/common.css">
	<link rel="stylesheet" type="text/css" href="css/account_review.css">
</head>
<body>
	<form>
		<select>
			<option>凭证号</option>
			<option>姓名</option>
			<option>部门</option>
			<option>状态</option>
		</select>
		<input type="text" placeholder="请输入搜索关键字">

		<input type="submit" value="搜索">
		<a href="#">显示全部</a>
	</form>
	<div>
		<ul class="kind_header">
			<li>凭证号</li>
			<li>姓名</li>
			<li>部门</li>
			<li>时间</li>
			<li>金额</li>
			<li>状态</li>
			<li>操作</li>
		</ul>
		<c:forEach items="${adlist}" var="item">
			<ul class="kind_body">
				<li>${item[0]}</li>
				<li>${item[1]}</li>
				<li>${item[2]}</li>
				<li>${item[3]}</li>
				<li>${item[4]}</li>
				<li>${item[5]}</li>
				<li><a href="detail?method=index&OD_No=${item[0]}">查看明细</a></li>
	
			</ul>
		
		</c:forEach>
		
		
	</div>

</body>
</html>