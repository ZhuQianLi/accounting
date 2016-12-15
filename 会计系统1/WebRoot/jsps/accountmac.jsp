<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<title>会计科目管理</title>
	
	<link rel="stylesheet" type="text/css" href="css/common.css">
	<link rel="stylesheet" type="text/css" href="css/account_mac.css">
</head>
<body>
	<div id="one_mac">
		
		<c:forEach items="${kindList}" var="item">
			<ul>
				
				<c:forEach items="${item}" var="it" varStatus="vs">
					<c:if test="${vs.index eq 0}">
						<div>${it}</div>
					</c:if>
					<c:if test="${vs.index ne 0}">
						<li>${it}</li>
					</c:if>
				</c:forEach>
				
			
			</ul>
		
		</c:forEach>
		
		<ul>
			<li>无</li>	
		</ul>

		

	</div>
	<main>
		
		<ul class="kind_header">
			<li>勾中删除项</li>
			<li>会计科目编号</li>
			<li>会计科目名称</li>
			<li>所属类别</li>
			<li>所属科目</li>
			<li>创建人标编号</li>
			<li>建立日期</li>
			<li>更新日期</li>
		</ul>	

		<c:forEach items="${allMacnameList}" var="item">
			<ul class="kind_body">
				<li><input type="checkbox" name="kind_check" value="2" class="kind_check"></li>
				<li>${item.acc_No}</li>
				<li>${item.acc_Nam}</li>
				<li>${item.acc_AnA}</li>
				<c:choose>
					<c:when test="${not empty item.acc_NoFName}">
						<li>${item.acc_NoFName}</li>
					</c:when>
					<c:otherwise>
						<li>无</li>
					</c:otherwise>
				</c:choose>
				<li>${item.acc_Usr}</li>
				<li>${item.acc_Date}</li>
				<li>${item.acc_Last}</li>
			</ul>
		</c:forEach>
		
		
	</main>
	<button id = "insert">新增</button>
	<button id = "del">删除</button>

	<div>*备注 ： 会计一级、二级科目编号长度为4,6</div>
	<div>*备注 ： 所属科目不填的为一级科目</div>
	<div>*备注 ： 所属科目填的为二级科目</div>
</body>
	<script src="js/ajax.js"></script>
	<script src="js/mac.js"></script>
</html>