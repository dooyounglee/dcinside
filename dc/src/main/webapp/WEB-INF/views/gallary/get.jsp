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
			<c:if test="${r.rere eq 0 }">
				<div class="replyDetail" data-re_no="${r.re_no }">
					<c:if test="${r.status eq 'Y'}">
						${r.content }
						<button class="replyDelete">삭제</button>
						<button class="replyInput">답글</button><br>
					</c:if>
					<c:if test="${r.status eq 'N'}">
						삭제된 댓글입니다.
					</c:if>
					<div class="rereplyInputArea"></div>
				</div>
			</c:if>
			<c:if test="${r.rere eq 1 }">
				ㄴ${r.content }
				<button class="rereplyDelete" data-re_no="${r.re_no }">삭제</button><br>
			</c:if>
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
			$('.rereplyInputArea').html('')
			if($(this).text()=='취소'){
				$(this).text('답글')
				return
			}
			$('.replyInput').text('답글')
			$(this).text('취소')
			var replyDetail=$(this).closest('div.replyDetail');
			var rereplyInputArea=replyDetail.children('div.rereplyInputArea')
			var str='ㄴ<input id="rereplyInput"><button id="rereplyInsert">완료</button>'
			rereplyInputArea.append(str)
		})

		$(document).on('click','#rereplyInsert',function(){
			var content=$('#rereplyInput').val();
			if(content=='')return;
			var re_no2=$(this).closest('div.replyDetail').data('re_no');
			$.ajax({
				url:'write.rereply',
				type:'post',
				data:{
					b_no:${b.b_no },
					re_no2:re_no2,
					content:content,
				},
				success:function(data){
					replyView()
				},
			})
		})
		
		$(document).on('click','.rereplyDelete',function(){
			var re_no=$(this).data('re_no')
			$.ajax({
				url:'delete.rereply',
				type:'post',
				data:{
					re_no:re_no,
				},
				success:function(data){
					replyView()
				},
			})
		})
		
	</script>
</body>
</html>