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
		<link type="text/css" rel="stylesheet" href="../resources/css/common.css"/>
		<link type="text/css" rel="stylesheet" href="../resources/css/sub_tab.css"/>
		<link type="text/css" rel="stylesheet" href="../resources/css/location.css"/>
		
		<style>
			
		</style>
	</head>
	<body>		
		<div id="wrap">			
			<!-- 상단영역 -->
			<%@ include file="../nav.jsp" %>
			<!-- -------- -->
			<!-- 전기차 충전소 검색 영역  -->
			<div id="contents_sub">
				<section>
					<article class="selectZone">
						<div name="selectBox">
				            <label for="city">전기차 충전소 지역 선택 : </label>
				        </div>
				        <div class="selectBTN">
				            &nbsp;<button type="button" onclick="javascript:searchStation();"> 검색 </button>
				        </div>
					</article>
				</section>
				<header><div>&ltcir; ${fn:split(ar[0].addr, ' ')[0] } 충전소 현황 &nbsp;</div></header>
				<section class="status">					 
					 <article class='estation_map'>
						<%--
							kakao map area
						 --%>
						<div id="map" style="width:500px;height:400px;"></div>
					 </article>
					 <article class='estation_table' style="height: inherit;">
						<%--
							table area
						 --%>
						<ul style="height: 400px;">
							<c:forEach var="vo" items="${ar }">
							<li>
								<div>
									<table style="width: 100%;">
										<tbody>
											<tr> <th>&nbsp; 위치</th> </tr>
											<tr>
												<td>&#187; ${fn:split( vo.statNm, '(')[0] }</th>
											</tr>
											<tr> <th>&nbsp; 주소</th> </tr>
											<tr>
												<td>&#187; ${vo.addr }</th>
											</tr>
										</tbody>
									</table>
								</div>
							</li>
							</c:forEach>
						</ul>
					 </article>
				</section>
			</div>			
			<!-- -------- -->
			 
		<!-- 하단영역 -->
		<%@ include file="../footer.jsp" %>
		<!-- -------- -->
		</div>
		
		

		
		<!-- services와 clusterer, drawing 라이브러리 불러오기 -->
		<script type="text/javascript" 
				src="//dapi.kakao.com/v2/maps/sdk.js?appkey=${mapKey }"></script>
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
		<script>
			let locals = [
	            ["11" , "서울특별시"],
	            ["26" , "부산광역시"],
	            ["27" , "대구광역시"],
	            ["28" , "인천광역시"],
	            ["29" , "광주광역시"],
	            ["30" , "대전광역시"],
	            ["31" , "울산광역시"],
	            ["36" , "세종특별자치시"],
	            ["41" , "경기도"],
	            ["42" , "강원도"],
	            ["43" , "충청북도"],
	            ["44" , "충청남도"],
	            ["45" , "전라북도"],
	            ["46" , "전라남도"],
	            ["47" , "경상북도"],
	            ["48" , "경상남도"],
	            ["50" , "제주특별자치도"],
	        ];
			$(function() {
				
				var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
				var options = { //지도를 생성할 때 필요한 기본 옵션
					// center: new kakao.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
					center: new kakao.maps.LatLng( ${lat}, ${lng }), //지도의 중심좌표.
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
				    
				    //console.log( positions[i].title );
				    
				    // 마커를 생성합니다
				    var marker = new kakao.maps.Marker({
				        map: map, // 마커를 표시할 지도
				        position: positions[i].latlng, // 마커를 표시할 위치
				        title : positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
				        image : markerImage // 마커 이미지 
				    });
				    
				    // 마커 이벤트 등록
					// 마커를 클릭했을 때 마커 위에 표시할 인포윈도우를 생성합니다
				    var iwContent = '<div style="padding:5px;">'+ positions[i].title +'</div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
				        iwRemoveable = true; // removeable 속성을 ture 로 설정하면 인포윈도우를 닫을 수 있는 x버튼이 표시됩니다

				    // 인포윈도우를 생성합니다
				    var infowindow = new kakao.maps.InfoWindow({
				        content : iwContent,
				        removable : iwRemoveable
				    });

				 	// 마커에 mouseover 이벤트와 mouseout 이벤트를 등록합니다
				    // 이벤트 리스너로는 클로저를 만들어 등록합니다 
				    // for문에서 클로저를 만들어 주지 않으면 마지막 마커에만 이벤트가 등록됩니다
				    kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
				    kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));
				    kakao.maps.event.addListener(marker, 'dblclick', makeDownListener(infowindow));
				}
				
				// 인포윈도우를 표시하는 클로저를 만드는 함수입니다 
				function makeOverListener(map, marker, infowindow) {
				    return function() {
				        infowindow.open(map, marker);
				    };
				}

				// 인포윈도우를 닫는 클로저를 만드는 함수입니다 
				function makeOutListener(infowindow) {
				    return function() {
				        infowindow.close();
				    };
				}
				
				// 마커를 클릭하는 이벤트를 만드는 함수입니다 
				function makeDownListener(map, marker, infowindow) {
				    return function() {
				    	 infowindow.open(map, marker);  
				    };
				}

			});
			
			// create select, option elements
			$( function() {
	            
	            $('div[name=selectBox]').append( $select = $( '<select></select>') );
	            $select.prop({
	                id: "city",
	                name: 'city'
	            });
	            
	            for( var idx = 0; idx < locals.length; idx++ ) {
	                $select.append( $option = $( '<option></option>') );
	                $option.prop({
	                    value : locals[idx][0],
	                });
	                $option.text( locals[idx][1] );
	            }
	            
	            $('div[name=selectBox] option[value=${zcode}]').prop('selected', 'selected').change();

				$("#city").change(function(){
				    var value =  $(this).val();
				    
					location.replace( "/location/estation?zcode=" + value );
				});
				
	        });
			
		</script>
		
	</body>
</html>