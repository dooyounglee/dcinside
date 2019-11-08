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
	<%@ include file="../include/header.jsp" %>
	<h1>${gal_name }갤러리 입니다.</h1>
	글번호:${b.b_no }<br>
	제목:${b.title }<br>
	내용:${b.content }<br>
	<form action="${cp}/gallary/${gal_name }/edit">
		<input type="hidden" name="b_no" value="${b.b_no }">
		<button>수정</button>
	</form>
	
	<input type="hidden" id="b_no" value="${b.b_no }">
	닉:<input id="nick"><input id="content"><button id="replyInsert">답글</button>
	<div id="replyArea">
		<c:forEach var="r" items="${rlist }">
			${r.content }<br>
		</c:forEach>
		
	</div>
	<script>
		$(document).on('click','#replyInsert',function(){
			$.ajax({
				url:'write.reply',
				type:'post',
				data:{
					gal_name:'${gal_name }',
					b_no:$('#b_no').val(),
					nick:$('#nick').val(),
					content:$('#content').val(),
				},
				success:function(data){
					alert(data)
				},
			})
		})
	</script>
</body>
</html>