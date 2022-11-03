<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>

<h2> 지도 test</h2>
<%--
	kakao map area
 --%>
<div id="map" style="width:500px;height:400px;"></div>

<hr />
<h2> 공공데이터 충전소 test</h2>


<!-- services와 clusterer, drawing 라이브러리 불러오기 -->
<script type="text/javascript" 
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=45370cb3ddc7ad495a13fcfd6952c6e3&libraries=services,clusterer,drawing"></script>

<script>
	var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
	var options = { //지도를 생성할 때 필요한 기본 옵션
		center: new kakao.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
		level: 3 //지도의 레벨(확대, 축소 정도)
	};
	
	var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
</script>

</body>
</html>
