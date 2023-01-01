<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="../common/heading.jsp" %>
	<meta charset="UTF-8">
	<title>관리자 페이지</title>
</head>
<body>
   	<%@ include file="../common/top.jsp" %>
	<h3>회원리스트 (관리자 전용)</h3>
	<a href="/user/login">사용자 등록</a>
	<a href="/user/logout">로그아웃</a>
	<hr>
	${sessionUname}님 환영합니다.
	<table border="1">
		<tr>
			<th>UID</th><th>패스워드</th><th>이름</th>
			<th>email</th><th>주소</th><th>전화번호</th>
			<th>등록일</th><th>탈퇴여부</th>
			<th>탈퇴신청날짜</th>
		</tr>
		<c:forEach var="user" items="${adminList}">
		<tr>
			<td>${user.uid}</td>
			<td>${user.pwd}</td>
			<td>${user.uname}</td>
			<td>${user.email}</td>
			<td>${user.addr}</td>
			<td>${user.phoneNum}</td>
			<td>${user.regDate}</td>
			<td>${user.isDeleted}</td>	
			<td>${user.delDate}</td>

		</c:forEach>
		 <button onclick="location.href='/user/delList'">탈퇴회원 보기</button>
	</table>
	<%@ include file="../common/bottom.jsp" %>
</body>
</html>