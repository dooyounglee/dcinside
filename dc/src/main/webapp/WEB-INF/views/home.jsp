<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
dev
doo

<script src="http://code.jquery.com/jquery-3.4.1.js"></script>
<div id="co" style="position:fixed;top:0px;left:300px;width:100px;height:100px;"></div>
<img id=scream src="사진" style="max-width:300;max-height:150;">
<script>
  var ctx;
  window.onload=function(){
	  var img = $('#scream');
	  var w=img.width()
	  var h=img.height()

	  var c=$('<canvas/>')[0]
	  $(c).css({
		  width:w,
		  height:h,
	  })
	  ctx = c.getContext('2d');
	  ctx.drawImage(img.get(0), 0, 0, w, h);
  }
  
  $('#scream').mousemove(function(e){
	  var imgData = ctx.getImageData(e.offsetX, e.offsetY, 1, 1);
	  var arr=imgData.data
	  var col='rgba('+arr[0]+','+arr[1]+','+arr[2]+','+arr[3]+')';
	  $('#co').css('background',col)
  })
</script>
</body>
</html>
