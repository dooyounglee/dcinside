<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/x-mathjax-config">
      MathJax.Hub.Config({
        tex2jax: {inlineMath: [['$','$'], ['\\(','\\)']]}
      });
    </script>
<script src="http://code.jquery.com/jquery-3.4.1.js"></script>
<script src="https://polyfill.io/v3/polyfill.min.js?features=es6"></script>
<script id="MathJax-script" async src="https://cdn.jsdelivr.net/npm/mathjax@3/es5/tex-mml-chtml.js"></script>
</head>
<body>
	<h1>문제 상세보기</h1>
	문제: ${p.problem }<br>
	정답: ${p.solution }<br>
	해설: ${p.solve }<br>
	<br>
	
	<c:if test="${empty v }">
	
	</c:if>
	<c:if test="${!empty v }">
		문제: ${ranp.problem }<br>
		정답: ${ranp.solution }<br>
		해설: ${ranp.solve }<br>
	</c:if>

	<a href="edit.pro?p_no=${p.p_no }">수정</a>
</body>
</html>