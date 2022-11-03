<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 외부 CSS파일 연결! -->
<link type="text/css" rel="stylesheet" href="resources/css/common.css"/>
<link type="text/css" rel="stylesheet" href="resources/css/index.css"/>
</head>
<body>
<div id="wrap">
	<!-- 상단영역 -->
	<%@ include file="nav.jsp" %>
	<!-- -------- -->
	<!-- 콘텐츠영역 -->
	<div id="contents_sub">
		<div class="main_img">
		<!-- img태그에서 title은 설명을 보여주는 역활, alt는
		 스크린리더기에서 읽혀지고 또는 이미지 손실시 대신 출력되는 문장! -->
			<a href="">
				<img src="resources/img/@img00.png" title="서울안전체험 한마당봉사" 
					alt="서울안전체험 한마당봉사"/>
			</a>
		</div>
		<div class="main_news">
			<div class="news_type01 fl">
				<p class="title">기브유 후원참여</p>
				<p class="news_src">
					<a href="" class="thum_img">
						<img src="resources/img/@img01.png" alt="기사사진"/>
					</a>
					<span class="ellip subject">
						난청이지만 피아니스트가 되고픈 한별이의 이야기입니다.
					</span>
					<span class="writer">by ttogether</span>
					<span class="more_view">자세히보기</span>
					<span class="fclear"></span>
				</p>
			</div>
			<!-- ----------------------------------------------------- -->
			<div class="news_type01 cen">
				<p class="title">기브유 후원금 쓰임현황</p>
				<p class="news_src">
					<a href="" class="thum_img">
						<img src="resources/img/@img02.png" alt="기사사진"/>
					</a>
					<span class="ellip subject">
						레티하씨 가정에 희망의 집 선물
					</span>
					<span class="writer">by 한국해비타트</span>
					<span class="more_view">자세히보기</span>
					<span class="fclear"></span>
				</p>
			</div>
			<!-- ----------------------------------------------------- -->
			<div class="news_type01 fr">
				<p class="title">기브유 나눔영상</p>
				<p class="news_src">
					<span class="thum_img">
						<img src="resources/img/@img03.png" alt="기사사진"/>
						<span class="btn_play" title="동영상 재생">
							<a href=""></a>
						</span>							
					</span>
					<span class="ellip subject">
						1리터의 생명을 선물해주세요.
					</span>
					<span class="writer">by hungersaver</span>
					<span class="more_view">자세히보기</span>
					<span class="fclear"></span>
				</p>
			</div>
		</div>
		<div class="main_board">
			<!-- 공지사항 -->
			<div class="board_type01 fl">
				<p class="title">공지사항</p>
				<span class="more_view"><a href="">더보기</a></span>
				<ul class="notice">
				
				<%--
					# 공지사항
				 --%>
				 <c:forEach var="nvo" items="${n_list }" >
				 	<li>
						<a href="">${nvo.subject }</a>
						<span class="date">${fn:replace( nvo.write_date, "-", "." ) }</span>
					</li>
				 </c:forEach>					
				<%-- ---------- --%>
				</ul>
			</div>
			<!-- 공지사항 끝 -->
			
			<!-- together트위터 -->
			<div class="board_type01 cen">
				<p class="title">T-Together트위터</p>
				<span class="more_view"><a href="/bbs/list?bname=TWIT">더보기</a></span>
				
				<%--
					# 트위터 top 1
				 --%>
				 <%--
				<c:set var="twit" value="${t_list }" />
				  --%>
				<c:forEach var="twit" items="${t_list }">
				<a href="" class="article">
					<span class="thum_img">
						<img height="60" src="resources/bbs_upload/${twit.file_name }" alt="캠페인이미지"/>
					</span>
					<span class="src">
						${twit.subject }
					</span>
					<span class="fclear"></span>
				</a>
				 </c:forEach>
				<%-- --------- --%>
			</div>
			<!-- together트위터 끝 -->
			
			<!-- 배너 -->
			<div class="board_type01 fr">
				<span class="banner b01">
					<a href="">
						T-Together와 함께할 기관/단체를 모십니다.
					</a>
				</span>
				<span class="banner b02">
					<a href="">
						T-Together  이젠 모바일로 함께해요.
					</a>
				</span>
			</div>
			<!-- 배너 끝 -->
		</div>
	</div>
	<!-- ---------- -->
	<!-- 하단영역 -->
	<%@ include file="footer.jsp" %>
	<!-- -------- -->
</div>
</body>
</html>