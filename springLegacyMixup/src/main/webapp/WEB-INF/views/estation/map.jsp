<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		
		<!-- 외부 CSS파일 연결! -->
		<link type="text/css" rel="stylesheet" href="../resources/css/common.css"/>
		<link type="text/css" rel="stylesheet" href="../resources/css/sub_tab.css"/>
	</head>
	<body>		
		<div id="wrap">			
			<!-- 상단영역 -->
			<%@ include file="../nav.jsp" %>
			<!-- -------- -->
			<div id="contents_sub">
				<header>
					<h1>충전소 목록</h1>
				</header>
				<%--
				<article>
					<label for="city">시/도</label>
					<select id="city" name="city" >
					<!-- 
						<option value="2" >등록일시</option>
					 -->
					</select>
				</article>
				<article>
					<table>
						<colgroup>
							<col width="*" />
							<col width="*" />
							<col width="*"/>
							<col width="*" />
							<col width="100px" />
							<col width="100px" />
							<col width="*" />
						</colgroup>
						<thead>
							<tr>
								<th>충전소명</th>
								<th>전화번호</th>
								<th>충전타입</th>
								<th>주소</th>
								<th>위도</th>
								<th>경도</th>
								<th>이용시간</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach var="vo" items="${ar }">
							<tr>
								<td>${vo.statNm }</td>
								<td>${vo.busiCall }</td>
								<td style="text-align: center;">${vo.chgerType }</td>
								<td>${vo.addr }</td>
								<td>${vo.lat }</td>
								<td>${vo.lng }</td>
								<td>${vo.useTime }</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
					
				</article>
				 --%>
				 <article class='estation_map'>
					<%--
						kakao map area
					 --%>
					<div id="map" style="width:500px;height:400px;"></div>
				 </article>
			</div>
			 
		<!-- 하단영역 -->
		<%@ include file="../footer.jsp" %>
		<!-- -------- -->
		</div>
		
		

		
		<!-- services와 clusterer, drawing 라이브러리 불러오기 -->
		<script type="text/javascript" 
				src="//dapi.kakao.com/v2/maps/sdk.js?appkey=${mapKey }"></script>
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
		<script>
			
			$(function() {
				
				var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
				var options = { //지도를 생성할 때 필요한 기본 옵션
					// center: new kakao.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
					center: new kakao.maps.LatLng(37.511340, 127.0289991), //지도의 중심좌표.
					level: 10 //지도의 레벨(확대, 축소 정도)
				};
				
				var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
				
				var positions = [
						<c:forEach var="vo" items="${ar }">
						{
							title: '${vo.statNm }',
							latlng: new kakao.maps.LatLng( ${vo.lat }, ${vo.lng } )
						
						},
						</c:forEach>
				];
				
				var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";
				
				for (var i = 0; i < positions.length; i ++) {
				    
				    // 마커 이미지의 이미지 크기 입니다
				    var imageSize = new kakao.maps.Size(24, 35); 
				    
				    // 마커 이미지를 생성합니다    
				    var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
				    
				    console.log( positions[i].title );
				    
				    // 마커를 생성합니다
				    var marker = new kakao.maps.Marker({
				        map: map, // 마커를 표시할 지도
				        position: positions[i].latlng, // 마커를 표시할 위치
				        title : positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
				        image : markerImage // 마커 이미지 
				    });
				}
			});
		</script>
		
	</body>
</html>