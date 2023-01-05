<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style_hyem.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
</head>
<body>
<div class="page-main">
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
	<h2>공지사항</h2>
	<div class="align-right">
		<input type="button" value="글쓰기" onclick="location.href='noticeWriteForm.do'">
	</div>
	
	<c:if test="${count == 0}">
		<div class="result-display">
			등록된 공지가 없습니다.
		</div>
	</c:if>
	
	<c:if test="${count > 0}">	
		<table>
			<tr>
				<th>글 번호</th>
				<th>제목</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
			<c:forEach var="notice" items="${list}">
				<tr>
					<td>${notice.noti_num}</td>
					<td><a href="noticeDetail.do?noti_num=${notice.noti_num}">${notice.noti_title}</a></td>
					<td>${notice.noti_reg_date}</td>
					<td>${notice.noti_hit}</td>
				</tr>
			</c:forEach>
		</table>
		<div class="align-center">
			${pagingHtml}
		</div>
	</c:if>
</div>
</body>
</html>