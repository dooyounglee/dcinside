<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>problemList</h1>
	<a href="make.pro">문제 만들기</a><br>
	<c:forEach var="p" items="${plist }">
		<a href="get.pro?p_no=${p.p_no }">${p }</a><br>
	</c:forEach>
</body>
</html>