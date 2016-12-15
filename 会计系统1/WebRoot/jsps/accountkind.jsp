<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<title>会计类别管理</title>
	
	<link rel="stylesheet" type="text/css" href="css/common.css">
	<link rel="stylesheet" type="text/css" href="css/account_kind.css">
</head>
<body>
	<main>
		<ul class="kind_header">
			<li>勾中删除项</li>
			<li>会计类别编号</li>
			<li>会计类别名称</li>
			<li>创建人</li>
			<li>建立日期</li>
			<li>更新日期</li>
		</ul>	
		<c:forEach items="${current_accountkind}" var="item">
			<ul class="kind_body">
			<li><input type="checkbox" name="kind_check" value="1" class="kind_check"></li>
			<li>${item.acc_Set}</li>
			<li>${item.acc_AnA}</li>
			<li>${item.name}</li>
			<li>${item.acc_Date}</li>
			<li>${item.acc_Last}</li>
		</ul>
		
		</c:forEach>
		
	</main>
	<button id = "insert">新增</button>
	<button id = "del">删除</button>
	<button id = "query">查看科目表</button>
</body>
	<script src="js/ajax.js"></script>
	<script src="js/kind.js"></script>
</html>