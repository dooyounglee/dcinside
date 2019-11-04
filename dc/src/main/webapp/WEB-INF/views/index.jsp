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
	<%@ include file="include/header.jsp" %>
	<a href="${cp }/gallary/make.gal">맹글기</a>
	
	<table border=1>
		<tr>
			<th>gal_no</th>
			<th>gal_name</th>
		</tr>
		<c:forEach var="g" items="${list }">
		<tr>
			<td>${g.gal_no }</td>
			<td><a href="${cp }/gallary/${g.gal_name }/list">${g.gal_name }갤러리</a></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>