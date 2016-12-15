<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="zh_CN">
<head>
	<meta charset="UTF-8">
	<title>${globalUser.acc_DNa}&nbsp;${globalUser.NAME}</title>
	
	<link rel="stylesheet" type="text/css" href="css/common.css"/>
	<link rel="stylesheet" type="text/css" href="css/admin.css"/>
	
</head>
<body>
	<header>

	</header>
	<!-- 侧栏 -->
	<aside>

		<div class="side_menu">
			<div>基本信息管理</div>
			<ul>
				<c:if test="${fn:contains(menuList,'会计类别维护')}">
					<a href="accountkind?method=index" target="mainFrame"><li>会计类别维护</li></a>
				</c:if>
				<c:if test="${fn:contains(menuList,'部门建档维护')}">
					<a href="dept?method=index" target="mainFrame"><li>部门建档维护</li></a>
				</c:if>
				<c:if test="${fn:contains(menuList,'人员信息维护')}">
					<a href="user?method=index" target="mainFrame"><li>人员信息维护</li></a>
				</c:if>
				<c:if test="${fn:contains(menuList,'常用词汇维护')}">
					<a href="initial?method=index" target="mainFrame"><li>常用词汇维护</li></a>
				</c:if>
				<c:if test="${fn:contains(menuList,'会计科目维护管理')}">
					<a href="accountmac?method=index" target="mainFrame"><li>会计科目维护管理</li></a>
				</c:if><c:if test="${fn:contains(menuList,'会计科目查询统计分析')}">
					<a href="initial?method=index" target="mainFrame"><li>会计科目查询统计分析</li></a>
				</c:if><c:if test="${fn:contains(menuList,'特殊科目建档管理')}">
					<a href="initial?method=index" target="mainFrame"><li>特殊科目建档管理</li></a>
				</c:if>
			</ul>
		</div>

		<div class="side_menu">
			<div>会计凭证管理</div>
			<ul>
				<c:if test="${fn:contains(menuList,'会计凭证提交')}">
					<a href="accountdocument?method=index" target="mainFrame"><li>原始凭证提交</li></a>
				</c:if>
				<c:if test="${fn:contains(menuList,'会计凭证查询审核')}">
					<a href="accountreview?method=index" target="mainFrame"><li>原始凭证查询/审核</li></a>
				</c:if>
				<c:if test="${fn:contains(menuList,'会计凭证记账')}">
					<a href="AccountTypeIn?method=index" target="mainFrame"><li>记账凭证编制</li></a>
				</c:if>
				
				
			</ul>
		</div>
		
		<div class="side_menu">
			<div>会计报表管理</div>
			<ul>
				<c:if test="${fn:contains(menuList,'资产负债表')}">
					<a href="ChartLiabilities?method=index" target="mainFrame"><li>资产负债表</li></a>
				</c:if>
				<c:if test="${fn:contains(menuList,'利润表')}">
					<a href="ChartProfit?method=index" target="mainFrame"><li>利润表</li></a>
				</c:if>
				<c:if test="${fn:contains(menuList,'现金流量表')}">
					<a href="ChartCashFlow?method=index" target="mainFrame"><li>现金流量表</li></a>
				</c:if>
			
				
				
			</ul>
		</div>
		
		<div class="side_menu">
			<div>固定资产管理</div>
			<ul>
				<a href="html/采购申请表.html" target="mainFrame"><li>采购申请表</li></a>
				<a href="html/资产清单.html" target="mainFrame"><li>资产清单</li></a>
			</ul>
		</div>
		
		
		
	</aside>

	<!-- 主要部分 -->
	<main>
		<iframe src="initial?method=index" frameborder="0" name="mainFrame" height="1000" width="1100" scrolling="no">
			
		</iframe>

	</main>
</body>
	<script src="js/common.js"></script>
	<script src="js/side_menu.js"></script>
</html>

