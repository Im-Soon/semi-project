<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방예약1</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style_hoon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	window.onload=function(){ //window.onload 메소드를 안쓸거면 div태그 밑에 넣어야됨
		let num=1; 
		let gallery = document.getElementById('gallery');
		//이벤트 연결
		//이전 버튼을 눌렀을 때
		document.getElementById('prev').onclick=function(){
			num--
			if(num<1) num=3;
			gallery.src='../images/room'+num+'.jpg';
		};
		//다음 버튼을 눌렀을 때
		document.getElementById('next').onclick=function(){
			num++;
			if(num>3) num=1;
			gallery.src='../images/room'+num+'.jpg';
		};
	};
</script>
</head>
<body>
	<div class="wrap" id="wrap">
		<div class="container">
			<div class="breadcrumbs">
				<ul class="lst_breadcrumbs">
					<li class="item">
						<a href="${pageContext.request.contextPath}/reserve/reserve.do">
							<span>스터디룸인</span>
						</a>
					</li>
					<li class="item">
						<span>&nbsp;>&nbsp;</span>
						<a href="" class="lnk_page active">
							<span>예약하기</span>
						</a>
					</li>
				</ul>
			</div><!-- end of breadcrumbs -->
			<div class="wrap_inn">
				<div class="wrap_left">
					<div class="group_visual group_visual_s">
						<div class="container_visual">
							<ul class="visual_img _slide_con">
								<li class="item">
									<img src="../images/room1.jpg" class="img_thumb" id="gallery">
								</li>
							
							</ul><!-- end of visual_img _slide_con -->
						</div><!-- end of container_visual -->
						<div class="arrow">
								<img src="../images/left_btn.png" alt="이전 그림 보기" id="prev" class="prev">
								<img src="../images/right_btn.png" alt="다음 그림 보기" id="next" class="next">
						</div>
					</div><!-- end of group_visual group_visual_s -->
				</div><!-- end of wrap_left -->
			</div><!-- end of wrap_inn -->
		</div><!-- end of container -->
	</div><!-- end of wrap -->
</body>
</html>