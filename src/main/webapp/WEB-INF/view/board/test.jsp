<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" encType = "multipart/form-data" action="writeAction.jsp?boardID=#{bid}&keyValue=multipart">
	<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
		<thead>
			<tr>
				<th style="background-color: #eeeee; text-align: center;">게시판 글쓰기 양식</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><input type="text" class="form-control" placeholder="글 제목" name="bbsTitle" maxlength="50"></td>
			</tr>
				<c:if test="#{bid eq 1}">
			<tr>
				<td><input type="text" class="form-control" placeholder="주소" name="map" maxlength="50"></td>
			</tr>
				</c:if>
			<tr>
				<td><textarea class="form-control" placeholder="글 내용" name="bbsContent" maxlength="2048" style="height:350px;"></textarea></td>
			</tr>
			<tr>
				<td><input type="file" name="fileName"></td>
			</tr>
		</tbody>
		</table>
			<input type="submit" class="btn-primary pull-right" value="글쓰기">
</form>
</body>
</html>