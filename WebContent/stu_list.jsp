<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生列表</title>
</head>
<body>
	<h1>这是学生信息界面</h1>
	<table border="1" width="200">
		<tr>
			<td>编号</td>
			<td>姓名</td>
			<td>年龄</td>
			<td>性别</td>
			<td>住址</td>
		</tr>
		
		<c:forEach items="${list }" var="stu">
			<tr>
				<td>${stu.id }</td>
				<td>${stu.name }</td>
				<td>${stu.age }</td>
				<td>${stu.gender }</td>
				<td>${stu.address }</td>
			</tr>
		</c:forEach>
		
	</table>
</body>
</html>