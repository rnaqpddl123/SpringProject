<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이미지테스트</title>
</head>
<body>
	<h1>이미지테스트</h1>
	<hr>
	<form method="post" action="board/upload" enctype="multipart/form-data">
	<input type="file" name="uploadfile" multiple="multiple"/> 
	<input type="submit" value="결과 확인"/>
</form>
</body>
