<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html> 
<head>
<meta charset="UTF-8">
<title>공지 글쓰기</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style_hyem.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function(){
		$('#write_form').submit(function(){
			if($('#noti_title').val().trim() == ''){
				alert('제목을 입력하세요');
				$('#noti_title').val('').focus();
				
				return false;
			}
			
			if($('#noti_content').val().trim() == ''){
				alert('내용을 입력하세요');
				$('#noti_content').val('').focus();
				
				return false;
			}
		});
	});
</script>
</head>
<body>
<div class="page-main">
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
	<div class="content-main">
		<h2>공지 글쓰기</h2>
		<form action="noticeWrite.do" method="post" id="write_form" enctype="multipart/form-data">
			<ul>
				<li>
					<label for="noti_title">제목</label>
					<input type="text" name="noti_title" id="noti_title" maxlength="20">
				</li>
				<li>
					<label for="noti_content">내용</label>
					<textarea rows="5" cols="30" name="noti_content" id="noti_content"></textarea>
				</li>
				<li>
					<label for="noti_file">파일</label>
					<input type="file" name="noti_file" id="noti_file" accept="image/gif, image/png, image/jpeg">
				</li>
			</ul>
			<div class="align-center">
				<input type="submit" value="등록">
				<input type="button" value="목록" onclick="location.href='noticeList.do'">
			</div>
		</form>
	</div>
</div>
</body>
</html>