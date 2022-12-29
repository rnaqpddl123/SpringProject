<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="../common/heading.jsp" %>
	<meta charset="UTF-8">
	<title>User List</title>
</head>
<body>
   	<%@ include file="../common/top.jsp" %>
	<h3>사용자 리스트</h3>
	<a href="/user/login">사용자 등록</a>
	<a href="/user/logout">로그아웃</a>
	<hr>
	${sessionUname}님 환영합니다.
	<table border="1">
		<tr>
			<th>UID</th><th>패스워드</th><th>이름</th>
			<th>email</th><th>주소</th><th>전화번호</th>
			<th>등록일</th><th>탈퇴여부</th>
			<th>탈퇴신청날짜</th><th colspan="2">액션</th>
		</tr>
		<c:forEach var="user" items="${userList}">
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
			<td>
				<button onclick="location.href='/user/update/${user.uid}'">수정</button>
				<button onclick="location.href='/user/delete/${user.uid}'">삭제</button>
			</td>				
		</tr>
		</c:forEach>
	</table>
	<%@ include file="../common/bottom.jsp" %>
</body>
</html>