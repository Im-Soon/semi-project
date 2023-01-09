<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style_ddk.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function(){
		//회원탈퇴 체크
		$('#delete_form').submit(function(){
			if($('#passwd').val().trim()==''){
				alert('비밀번호를 입력하세요!');
				$('#passwd').val('').focus();
				return false;
			}
			if($('#cpasswd').val().trim()==''){
				alert('비밀번호 확인을 입력하세요!');
				$('#cpasswd').val('').focus();
				return false;
			}
			if($('#passwd').val()!=$('#cpasswd').val()){
				alert('비밀번호와 비밀번호 확인이 불일치합니다.');
				$('#passwd').val('').focus();
				$('#cpasswd').val('');
				return false;
			}
		});//end of submit
	});
</script>
</head>
<body>
<div class="page-main">
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
	<div class="content-main">
		<h2>회원탈퇴</h2>
		<!-- 프로필 사진 시작 -->
		<div class="photo-box-delete">
			<c:if test="${empty member.mem_photo}">
				<img src="${pageContext.request.contextPath}/images/face.png"
					width="200" height="200" class="my-photo">
			</c:if>
			<c:if test="${!empty member.mem_photo}">
				<img
					src="${pageContext.request.contextPath}/upload/${member.mem_photo}"
					width="200" height="200" class="my-photo">
			</c:if>
		</div>
		<!--프로필 사진 끝  -->
		<!-- 탈퇴 폼 시작 -->
		<form id="delete_form" action="deleteUser.do"
		                                   method="post">
			<ul>
				<li>
					<label for="passwd">비밀번호</label>
					<input type="password" name="passwd" 
					            id="passwd" maxlength="12">
				</li>
				<li>
					<label for="cpasswd">비밀번호 확인</label>
					<input type="password" name="cpasswd" 
					            id="cpasswd" maxlength="12">
				</li>
			</ul>
			<div class="align-center">
				<input class="redbtn-delete" type="submit" value="탈퇴하기">
			</div> 
			<div class="helpbox">
			<a href="${pageContext.request.contextPath}/mymember/modifyPasswordForm.do"><ins>도움말(경로설정아직X)</ins></a>
			</div>
			<div class="float-end"></div>                                  
		</form>
		<!-- 탈퇴 폼 시작 -->
	</div>
</div>
</body>
</html>






