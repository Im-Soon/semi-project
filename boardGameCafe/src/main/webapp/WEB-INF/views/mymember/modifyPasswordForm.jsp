<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 수정</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style_ddk.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function(){
		//비밀번호 수정 체크
		$('#password_form').submit(function(){
			if($('#origin_passwd').val().trim()==''){
				alert('현재 비밀번호를 입력하세요!');
				$('#origin_passwd').val('').focus();
				return false;
			}
			if($('#passwd').val().trim()==''){
				alert('새비밀번호를 입력하세요!');
				$('#passwd').val('').focus();
				return false;
			}
			if($('#cpasswd').val().trim()==''){
				alert('새비밀번호 확인을 입력하세요!');
				$('#cpasswd').val('').focus();
				return false;
			}
			if($('#passwd').val()!=$('#cpasswd').val()){
				alert('새비밀번호와 새비밀번호 확인이 불일치합니다.');
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
		<h2>비밀번호 수정</h2>
		<form id="password_form" action="modifyPassword.do" method="post">
			<ul>
				<li>
					<label for="origin_passwd">현재 비밀번호</label>
					<input type="password" name="origin_passwd" 
					            id="origin_passwd" maxlength="12">
				</li>
				<li>
					<label for="passwd">새비밀번호</label>
					<input type="password" name="passwd" 
					            id="passwd" maxlength="12">
				</li>
				<li>
					<label for="cpasswd">새비밀번호 확인</label>
					<input type="password" name="cpasswd" 
					            id="cpasswd" maxlength="12">
				</li>
			</ul>
			<div class="align-center">
				<input type="submit" value="비밀번호 수정">
				<input type="button" value="My페이지"
				  onclick="location.href='myPage.do'">
			</div>                                   
		</form>
	</div>
</div>
</body>
</html>






