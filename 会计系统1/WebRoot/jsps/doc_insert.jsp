<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<title>凭证处理</title>
	
	<link rel="stylesheet" type="text/css" href="css/doc_insert.css"/>
</head>
<body>

	<main>
		<!-- 填写凭证 -->
		<div class="doc_header">
			<div>
				<div>所属类别：</div>
				<select>
					<option>1</option>
					<option>2</option>
					<option>3</option>
				</select>
			</div>

			

			<div>
				<div>借方科目名：</div>
				<select>
					<option>1</option>
					<option>2</option>
					<option>3</option>
				</select>
			</div>

			<div>
				<div>贷方科目名：</div>
				<select>
					<option>1</option>
					<option>2</option>
					<option>3</option>
				</select>
			</div>

			<div>
				<div>单位的名称:</div>
				<input type="text" name="">
			</div>

			<div>
				<div>金额：</div>
				<input type="text" name="">
			</div>

			<div>
				<div>摘要：</div>
				<input type="text" name="">
			</div>

			<div>
				<div>日期：</div>
				<input type="text" name="">
			</div>
		</div>


		<div class="doc_option">
			<button>添加</button>
			<button disabled="disabled">编辑</button>
			<button disabled="disabled">删除</button>
		</div>

		<button>提交</button>
	</main>

</body>
</html>