<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<title>填写凭证</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/acc_doc.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/doc_new.js"></script>
</head>

<body>
	<!-- <a href="initial?method=index" target="mainFrame"><li>现金流量表</li></a> -->
	<div style="float: left;height: 20%">
	原始凭证种类：
	<button id="button1">选择</button>
	</div>
	<div id="div1" style="float: right; width: 70% ;height: 30px">费用报销单</div>
	<iframe src="html/yuanshipingzheng1.html" frameborder="0" style="float:left" id="yspzFrame" height=800px width=100% scrolling="no">
			
	</iframe>
	
	
</body>
	
	
</html>