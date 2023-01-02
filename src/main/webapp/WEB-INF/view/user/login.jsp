<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="../common/heading.jsp"%>
<style>
th, td {
	text-align: center;
}
</style>
	<title>로그인</title>
</head>

<body>
	<%@ include file="../common/top.jsp"%>
	<h3>
		<strong>로그인</strong> 
		<span style="font-size: 0.6em;">
		<a href="/user/register" class="ms-5">
		<i class="fas fa-user-plus"></i>회원가입</a>
		</span>
	</h3>
	<hr>
	<form action="/user/login" method="post">
		<table class="table table-borderless">
			<tr>
				<td><label for="uid" class="col-form-label">아이디</label></td>
				<td><input type="text" name="uid" id="uid"
					class="form-control" placeholder="아이디"></td>
			</tr>
			<tr>
				<td><label for="pwd" class="col-form-label">패스워드</label></td>
				<td><input type="password" name="pwd" id="pwd"
					class="form-control" placeholder="패스워드"></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: center;"><input
					class="btn btn-primary" type="submit" value="로그인"> <input
					class="btn btn-secondary" type="reset" value="취소"></td>
			</tr>
		</table>
	</form>
	<%@ include file="../common/bottom.jsp"%>	
</body>
</html>