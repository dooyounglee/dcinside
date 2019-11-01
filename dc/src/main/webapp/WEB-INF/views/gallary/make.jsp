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
	<form action="${cp }/gallary/make.gal" method="post">
		갤이름:<input name="gal_name">
		<button>맹글기</button>
	</form>
</body>
</html>