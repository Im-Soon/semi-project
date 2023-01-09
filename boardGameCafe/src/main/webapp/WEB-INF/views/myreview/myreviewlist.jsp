<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내가 쓴 댓글</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style_ddk.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
</head>
<body>
	<div class="page-main">
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>

	<c:if test="${count == 0}">
		<div class="result-display-x">
			댓글이 없습니다.
		</div>
	</c:if>
	<c:if test="${count > 0}">
	<table class="tablestyle">
		<tr>
			<th class="revtable-1">게임이름</th>
			<th>리뷰내용</th>
			<th class="revtable-3">작성일</th>
		</tr>
		<c:forEach var="myreview" items="${list}">
		<tr>
			<td>${myreview.pro_name}</td>
			<td><a href="${pageContext.request.contextPath}/board/detail.do?pro_num=${myreview.pro_num}">${myreview.rev_content}</a></td>
			<td>${myreview.rev_date}</td>
		</tr>
		</c:forEach>
	</table>
	<div class="pageup"></div>
	<div class="align-center">${page}</div>
	<div class="pagebottom"></div>
	</c:if>
	</div>
</body>
</html>