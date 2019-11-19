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
	<h1>문제만들기</h1>
	
	<c:set var="aaa" value="make"/>
	<c:if test="${!empty p }">
		<c:set var="aaa" value="edit"/>
	</c:if>
	
	<form action="${aaa }.pro" method="post" autocomplete=off>
		<input type="hidden" name="p_no" value="${p.p_no }">
		문제:<input name="problem" value="${p.problem }"><br>
		정답:<input name="solution" value="${p.solution }"><br>
		해설:<input name="solve" value="${p.solve }"><br>
		key값:<input name="keyval" value="${p.keyval }"><br>

		<button>만들기</button>
	</form>

	<button id="addBtn">추가</button>
	<div id="variablesArea">
		<c:forEach var="v" items="${vlist }">
			<input name="val" value="${v.val }"><button onclick="editBtn(this,${v.v_no })">수정</button><button onclick="delBtn(this,${v.v_no })">삭제</button><br>
		</c:forEach>
	</div>
	<script>
		$('#addBtn').click(function(){
			$('#variablesArea').append('<input name="val"><button onclick="okBtn(this)">확인</button><button id="cancleBtn">취소</button><br>')
		})
		
		$(document).on('click','#cancleBtn',function(){
			$(this).next().remove()
			$(this).prev().remove()
			$(this).prev().remove()
			$(this).remove()
		})
		
		function okBtn(this_){
			$.ajax({
				url:'ok.val',
				type:'post',
				data:{
					p_no:${p.p_no },
					val:$(this_).prev().val(),
				},
				success:function(data){
					//$(this_).text('수정')
					$('#variablesArea').load('edit.pro?p_no=${p.p_no } #variablesArea')
				},
			})
		}
		
		function delBtn(this_,v_no){
			$.ajax({
				url:'del.val',
				type:'post',
				data:{
					v_no:v_no,
				},
				success:function(data){
/* 					$(this_).next().remove()
					$(this_).prev().remove()
					$(this_).prev().remove()
					$(this_).remove() */
					$('#variablesArea').load('edit.pro?p_no=${p.p_no } #variablesArea')
				},
			})
		}
		
		function editBtn(this_,v_no){
			$.ajax({
				url:'edit.val',
				type:'post',
				data:{
					v_no:v_no,
					val:$(this_).prev().val(),
				},
				success:function(data){
					$('#variablesArea').load('edit.pro?p_no=${p.p_no } #variablesArea')
				},
			})
		}
	</script>
	
	
	<textarea id="math" rows="10" cols="50"></textarea><br>
	<iframe id=iframe name="math" src="preview" height="500px" width="100%">
	
	</iframe>
	
	<form action="preview" name="form1" target="math">
		<input type="hidden" id="mathinput" name="math">
	</form>
	<script>
		$('#math').on('input',function(){
			$('#mathinput').val($('#math').val())
			document.form1.submit()
		})
	</script>
</body>
</html>