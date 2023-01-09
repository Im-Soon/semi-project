<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style_hoon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">

</script>
</head>
<body>
	<div class="wrap" id="wrap">
		<div class="container" id="container">
			<div>
				<div class="wrap_inn">
					<div class="wrap_main_info">
						<div class="section_visual section_visual_main">
							<div class="group_visual">
								<div class="container_visual">
									<ul class="visual_img">
										<li class="item">
										 	<img src="../images/hoon/studyroom1.jpg" class="img_thumb" width="490px;" height="490px;">
										</li>
									</ul>
								</div><!-- end of container_visual -->
							</div><!-- end of group_visual -->
						</div><!-- end of section_visual section_visual_main -->
						<div class="section_contents">
						 	<div class="contents_txt">
						 		<h2 class="contents_txt_tit">
						 			<span>스터디역삼</span>
						 		</h2>
						 		<p>예약신청 후 확정/취소여부를 반드시 확인해주세요.</p>
						 	</div><!-- end of contents_txt -->
						 	<div class="contents_store_details _site_desc_con">
						 		<div class="store_details view_more">
							 		<p class="dsc">
								 	*전화예약불가합니다. 네이버예약 부탁드립니다.(당일예약만 전화 혹은 현장에서 가능합니다)
								 	<br>
								 	*1인실은 전액선입금받고있으며 일주일전18시까지 환불가능합니다.
								 	<br>
								 	*1월은 1일, 21~24일 휴무입니다.
								 	<br>
								 	*예약은 최소 2시간 이상, 정시단위로 가능합니다.
								 	<br> 
								 	(30분씩 예약은 불가합니다.)
								 	<br>
								 	*방 형태는 상이하며 예약 상황에 따라 공간이 변경될 수 있습니다(반드시 선호하시는 룸이 있다면 사전요청 부탁드립니다)
								 	<br>
								 	<br>
								 	*예약 확정/취소여부를 신청 후 반드시 확인하고 와주세요.
								 	<br>
								 	*외부음료 및 음식반입 금지되어 있습니다.
								 	<br>
								 	*취소는 전날저녁6시까지만 가능하며 6시이후~당일취소(및 변경)시 위약금발생됩니다(룸별상이 하단참조)
								 	<br>
								 	*코로나로인한 노쇼 및 당일취소 및 변경도 위약금 동일하게 발생됩니다.
								 	<br>
								 	*전날18시이후 취소시 위약금
								 	<br>
								 	*2~3시간/4~6시간/7~12시간*:
								 	<br>
								 	최소1인실 10,000원/12,000원/18,000원
								 	<br>
								 	최소4,5인실: 14,400원/16,000원, 24,000원
								 	<br>
								 	최소6인실 16,000원/24,000원/36,000원
								 	<br>
								 	최소12인실:36,000원/40,000원/60,000원
								 	<br>
									</p>
								 	<ul class="store_features">
								 	</ul>
								</div><!-- end of store_details view_more -->
							</div><!-- end of contents_store_details _site_desc_con -->
							<li>
								<input class="btn_srch on" type="submit" value="예약날짜로 검색하기" onclick="location.href='${pageContext.request.contextPath}/room/roomlst.do'">
							</li>
						</div><!-- end of section_contents -->
					</div><!-- end of wrap_main_info -->
					<div class="wrap_item_lst">
						<div class="section_item_lst">
							<h3 class="out_tit">
								<span class="txt">전체</span>
								<span class="count_num">3/3</span>
							</h3>
							<div class="wrap_lst_item_box">
								<ul class="lst_item_box">
									<li class="item" onclick="location.href='${pageContext.request.contextPath}/room/roomlst.do'">
										<a href="#" class="lnk_item_book">
											<div class="item_preview" >
												<img src="../images/hoon/room1.jpg" class="img_thumb">
											</div>
										</a>
										<a href="../room1.jsp" class="lnk_item_info">
											<div class="item_txt">
												<div class="txt_wrap">
													<h4 class="tit">
														<span class="item_txt_tit_inn">
															<span class="item_txt_tit">4~8인실</span>
														</span>
													</h4>
													<p class="dsc">
														4~8인실 스터디 룸
														<br>
														(4인 이상 이용, 1~3명이어도
														<br>
														4인 비용지불시 이용 가능)
														<br>
													</p>
												</div>
											</div><!-- item_txt -->
										</a>
									</li><!-- end of item -->
									<li class="item" onclick="location.href=''">
										<a href="#" class="lnk_item_book">
											<div class="item_preview" >
												<img src="../images/hoon/room2.jpg" class="img_thumb">
											</div>
										</a>
										<a href="#" class="lnk_item_info">
											<div class="item_txt">
												<div class="txt_wrap">
													<h4 class="tit">
														<span class="item_txt_tit_inn">
															<span class="item_txt_tit">6~13인실</span>
														</span>
													</h4>
													<p class="dsc">
														6~13인실 스터디 룸
														<br>
														(6인 이상 이용)
														<br>
														-[시작시간]을 먼저 선택 후,..
														<br>
													</p>
												</div>
											</div><!-- item_txt -->
										</a>
									</li><!-- end of item -->
									<li class="item" onclick="location.href=''">
										<a href="#" class="lnk_item_book">
											<div class="item_preview" >
												<img src="../images/hoon/room3.jpg" class="img_thumb">
											</div>
										</a>
										<a href="#" class="lnk_item_info">
											<div class="item_txt">
												<div class="txt_wrap">
													<h4 class="tit">
														<span class="item_txt_tit_inn">
															<span class="item_txt_tit">5~10인실</span>
														</span>
													</h4>
													<p class="dsc">
														5~10인실 스터디 룸
														<br>
														(5인 이상 이용)룸은 랜덤배정됩니다.(회의형, 교실형 2가지 있...
														<br>
													</p>
												</div>
											</div><!-- item_txt -->
										</a>
									</li><!-- end of item -->
								</ul><!-- end of 1st_item_box -->
							</div><!-- end of wrap_1st_item_box -->
						</div><!-- end of section_item_1st -->
					</div><!-- end of wrap_item_1st -->
				</div><!-- end of wrap_inn -->
			</div>
		</div><!-- end of container -->
	</div><!-- end of wrap -->
</body>
</html>