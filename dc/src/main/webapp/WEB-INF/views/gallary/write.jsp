<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<!-- include libraries(jQuery, bootstrap) -->
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 

<!-- include summernote css/js -->
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.js"></script>

</head>
<body>
	<%@ include file="../include/header.jsp" %>
	<h1>${gal_name }갤러리 입니다.</h1>
	
	<c:set var="aaa" value="write"/>
	<c:set var="b_no" value="0"/>	
	<c:set var="content" value=""/>
	<c:if test="${!empty b }">
		<c:set var="aaa" value="edit"/>
		<c:set var="b_no" value="${b.b_no }"/>
		<c:set var="content" value="${b.content }"/>
	</c:if>
	
	<form action="${cp}/gallary/${gal_name }/${aaa}" method="post" autocomplete=off>
		<input type=hidden name="b_no" value="${b_no }">
		제목:<input name=title value="${b.title }"><br>
		내용:<textarea id="summernote" name="editordata">${content }</textarea>
		<input type="hidden" name="content" id="content">
		<button onclick="showw()">작성</button>
	</form>
	
<script>
	$('#summernote').summernote({
		callbacks : {
			onImageUpload : function(files) {
				var _this=this;
				    for(var i=0; i<files.length; i++){
				    	var formData = new FormData();
			        formData.append('uploadFile', files[i]);
				    $.ajax({
				        url: "${cp}/gallary/upload",
				        data: formData,
				        processData: false,
				        contentType: false,
				        type: 'POST',
				        success: function (data) {
				            $(_this).summernote('editor.insertImage', "${cp}/resources/upload/"+data);
				        }
				    });
				    }
	            alert("이미지 업로드 성공");
			}
		}
	});

	function showw() {
		var markupStr = $('#summernote').summernote('code');
		$('#content').val(markupStr)
	}
</script>
</body>
</html>