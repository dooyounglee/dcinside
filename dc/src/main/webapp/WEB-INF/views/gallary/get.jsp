<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.4.1.js"></script>
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
			<div class="replyDetail" data-re_no="${r.re_no }">
				${r.content }
				<button class="replyDelete">삭제</button>
				<button class="replyInput">답글</button>
			</div>
		</c:forEach>
		
	</div>
	<script>
		function replyView(){
			$('#replyArea').load('/dc/gallary/${gal_name }/get?b_no=${b.b_no } #replyArea')
		}
	
		$(document).on('click','#replyInsert',function(){
			$.ajax({
				url:'write.reply',
				type:'post',
				data:{
					b_no:${b.b_no },
					nick:$('#nick').val(),
					content:$('#content').val(),
				},
				dataType:'json',
				success:function(data){
					replyView()
					$('#content').val('')
				},
			})
		})
		
		$(document).on('click','.replyDelete',function(){
			var re_no=$(this).closest('div.replyDetail').data('re_no')
			$.ajax({
				url:'delete.reply',
				type:'post',
				data:{
					re_no:re_no,
				},
				success:function(data){
					replyView()
				},
			})
		})
		
		$(document).on('click','.replyInput',function(){
			var replyDetail=$(this).closest('div.replyDetail');
			replyDetail.append("<br>ㄴ<input>")
			replyDetail.append("<button>완료</button>")
		})
		
	</script>
</body>
</html>