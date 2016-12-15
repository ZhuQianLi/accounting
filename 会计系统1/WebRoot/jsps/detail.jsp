<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<title>凭证明细页面</title>
	
	<link rel="stylesheet" type="text/css" href="css/common.css">
	<link rel="stylesheet" type="text/css" href="css/detail.css">
</head>
<body>
	<div class="detail">
		<div>凭证号:${array[0]}</div>
		<div>姓名:${array[1]}</div>
		<div>部门:${array[2]}</div>
		<div>用途:${array[3]}</div>
		<div>转账方式:${array[4]}</div>
		<div>申请时间:${array[5]}</div>
		<div>账目明细:
			<ul class="kind_header">
				<li><input type="checkbox" name="all_check">全选</li>
				<li>名称</li>
				<li>单价</li>
				<li>数量</li>
			</ul>
			
			<c:forEach items="${detailList}" var="item">
				<ul class="kind_body">
				<li><input type="checkbox" name="check"></li>
				<li>${item[0]}</li>
				<li>${item[1]}</li>
				<li>${item[2]}</li>
			</ul>
			</c:forEach>
			

			
		</div>
		<div>申报金额&yen;:${array[6]}</div>
		
		<div>
			摘要:${array[7]}
		</div>

		<div class="state">状态:${array[8]}</div>
		<div>
			<form action="detail?method=update&OD_No=${array[0]}" method="post">
				<div>审核金额:<input type="text" name="OD_Exam" value="0.00" id="review"></div>
				<input type="submit" value="提交审核">
			</form>
		</div>
	</div>
		
</body>

<script type="text/javascript" src="js/detail.js"></script>
</html>
