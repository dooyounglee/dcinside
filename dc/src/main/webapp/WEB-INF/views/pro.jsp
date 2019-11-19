<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="com.kh.dc.problem.Problem"%>
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
<c:forEach var="i" begin="1" end="10">
	문제: ${p.problem }<br>
	정답: ${p.solution }<br>
	해설: ${p.solve }<br>
</c:forEach>

<textarea id="math" rows="10" cols="50"></textarea><br>
<iframe id=iframe name="math" src="preview" height="500px" width="100%">

</iframe>

<form action="preview" name="form1" target="math">
	<input id="mathinput" name="math">
</form>
<script>
	$('#math').on('input',function(){
		$('#mathinput').val($('#math').val())
		document.form1.submit()
	})
</script>

</body>
</html>