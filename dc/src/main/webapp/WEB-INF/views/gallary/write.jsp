<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../include/header.jsp" %>
<h1>${gal_name }갤러리 입니다.</h1>
<form action="${cp}/gallary/${gal_name }/write" method="post" autocomplete=off>
	<input type=hidden name="${gal_name }">
	제목:<input name=title><br>
	내용:<input name=content><br>
	<button>작성</button>
</form>
</body>
</html>