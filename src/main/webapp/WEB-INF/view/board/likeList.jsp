<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<%@ include file="../common/heading.jsp" %>
    <style>
        th, td { text-align: center; }
    </style>
    <script>
    	function search() {
    		const field = document.getElementById("field").value;
    		const query = document.getElementById("query").value;
    		const state = document.getElementById("state").value;
    		const category = document.getElementById("category").value;
    		console.log("search()", field, query, state, category);
    		location.href = "/board/list?p=${currentBoardPage}&f=" + field + "&q=" + query + "&state=" + state + "&category=" + category;
    	}
    </script>
</head>

<body>
   	<%@ include file="../common/top.jsp" %>
    <div class="container" style="margin-top: 80px;">
        <div class="row">
            <%@ include file="../common/aside.jsp" %>
            <div class="col-sm-9">
                <table class="table table-sm table-borderless">
	                <tr class="d-flex">
	                    <td class="col-6" style="text-align: left;">
	                        <h3><strong>찜한 상품</strong></h3>
	                    </td>
	                </tr>
                </table>
                <hr>
                <table class="table mt-2">
                    <tr class="table-secondary ">
                        <th class="col-1">카테고리</th>
                        <th class="col-1">판매/구매</th>
                        <th class="col-3">제목</th>
                        <th class="col-1">가격</th>
                        <th class="col-2">글쓴이</th>
                        <th class="col-2">날짜/시간</th>
                        <th class="col-1">조회수</th>
                        <th class="col-1">찜 삭제</th>
                    </tr>
                    <c:forEach var="board" items="${boardList}">
                    <tr>
                        <td>${board.category}</td>
                        <td>${board.state}</td>
                        <td><a href="/board/detail?bid=${board.bid}&uid=${board.uid}">${board.title}
                        	<c:if test="${board.replyCount ge 1}">
                        		<span class="text-danger">[${board.replyCount}]</span>
                        	</c:if>
                            </a>
                        </td>
                        <td>${board.price}원</td>
                        <td>${board.uname}</td>
                        <td>
                        <c:if test="${today eq fn:substring(board.modTime, 0, 10)}">
                        	${fn:substring(board.modTime,11,19)}
                        </c:if>
                        <c:if test="${today ne fn:substring(board.modTime, 0, 10)}">
                        	${fn:substring(board.modTime,0,10)}
                        </c:if>
                        </td>
                        <td>${board.viewCount}</td>
                        <td><button onclick="location.href='/board/likeCount?bid=${board.bid}&uid=${board.uid}&love=-1&pre=likeLIst'" class="badge bg-secondary">
                        	<i class="fa-regular fa-heart"></i>찜삭제${board.likeCount}
                        </button></td>
                    </tr>
                    </c:forEach>         
                </table>
                <ul class="pagination justify-content-center mt-4">
                <c:if test="${currentBoardPage gt 10}">
                    <li class="page-item"><a class="page-link" href="/board/list?p=${startPage-1}&f=${field}&q=${query}">&laquo;</a></li>
                </c:if>
                <c:if test="${currentBoardPage le 10}">
                    <li class="page-item"><a class="page-link" href="#">&laquo;</a></li>
                </c:if>
                    <c:forEach var="page" items="${pageList}" varStatus="loop">
			        	<li class="page-item ${(currentBoardPage eq page) ? 'active' : ''}">
			        		<a class="page-link" href="/board/list?p=${page}&f=${field}&q=${query}">${page}</a>
			       		</li>
		           </c:forEach>
		        <c:if test="${totalPages gt endPage}">
                    <li class="page-item"><a class="page-link" href="/board/list?p=${endPage-1}&f=${field}&q=${query}">&raquo;</a></li>
                </c:if>
                <c:if test="${totalPages le endPage}">
                    <li class="page-item"><a class="page-link" href="#">&raquo;</a></li>
                </c:if>
                </ul>
            </div>
        </div>
    </div>
    <%@ include file="../common/bottom.jsp" %> 
</body>
</html>