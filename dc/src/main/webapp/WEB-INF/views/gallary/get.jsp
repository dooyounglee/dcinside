<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="../include/header.jsp" %>
	<h1>${gal_name }갤러리 입니다.</h1>
	글번호:${b.b_no }<br>
	제목:${b.title }<br>
	내용:${b.content }<br>
	<form action="${cp}/gallary/${gal_name }/edit">
		<input type="hidden" name="b_no" value="${b.b_no }">
		<button>수정</button>
	</form>
</body>
</html>