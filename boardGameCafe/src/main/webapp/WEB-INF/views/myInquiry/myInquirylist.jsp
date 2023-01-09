<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내가 쓴 문의</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style_ddk.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
</head>
<body>
	<div class="page-main">
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
	<h1>내가 작성한 문의</h1>
	<c:if test="${count == 0}">
		<div class="result-display-x">
			문의한 글이 없습니다.
		</div>
	</c:if>
	<c:if test="${count > 0}">
	<table class="tablestyle">
		<tr>
			<th class="inqutable-1">문의 제목</th>
			<th>문의 내용</th>
			<th class="inqutable-3">작성일</th>
		</tr>
		<c:forEach var="myinqu" items="${list}">
		<tr>
			<td>${myinqu.inqu_title}</td>
			<td><a href="${pageContext.request.contextPath}/board/detail.do?board_num=${myinqu.inqu_num}">${myinqu.inqu_content}</a></td>
			<td>${myinqu.inqu_reg_date}</td>
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