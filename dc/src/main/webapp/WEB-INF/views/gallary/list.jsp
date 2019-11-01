<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="../include/header.jsp" %>
<h1>${gal_name }갤러리 입니다.</h1>
<a href="${cp}/gallary/${gal_name }/write">글쓰기</a>
<table border=1>
	<tr>
		<th>번호</th>
		<th>제목</th>
	</tr>
	<c:forEach var="b" items="${list }">
	<tr>
		<td>${b.b_no}</td>
		<td>${b.title}</td>
	</tr>
	</c:forEach>
	
</table>
</body>
</html>