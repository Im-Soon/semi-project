<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html> 
<html>
<head>
<meta charset="UTF-8">
<title>공지 글 상세</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style_hyem.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
</head>
<body>
<div class="page-main">
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
	<div class="content-main">
		<h2>${notice.noti_title}</h2>
		<h4>조회 : ${notice.noti_hit}</h4>
		<hr size="1" noshade="noshade" width="100%">
		<c:if test="${!empty notice.noti_file}">
			<div class="align-center">
				<img src="${pageContext.request.contextPath}/upload/${notice.noti_file}" class="detail-img">
			</div>
		</c:if>
		<p>
			${notice.noti_content}
		</p>
		<hr size="1" noshade="noshade" width="100%">
	</div>
	<div class="align-right">
		<input type="button" value="수정" onclick="location.href='noticeUpdateForm.do?noti_num=${notice.noti_num}'">
		<input type="button" value="삭제" onclick="location.href='noticeDelete.do?noti_num=${notice.noti_num}'">
		<input type="button" value="목록" onclick="location.href='noticeList.do'">
	</div>
</div>
</body>
</html>