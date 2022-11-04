<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<div id="header">
		<a href="/"><h1>Spring Legacy Project by. Alex</h1></a>
		<ul class="gnb">
			<li><a href=""><span class="menu m01">기브유</span></a></li>
			<li><a href=""><span class="menu m02">위드유</span></a></li>
			<li><a href=""><span class="menu m03">스마트 전통시장</span></a></li>
			<li><a href="/bravo/sub1"><span class="menu m04">BRAVO!</span></a></li>
			<li><a href="/location/estation"><span class="menu m05">전기차 충전소</span></a></li>
			<c:if test="${mvo eq null }">
			<li><a href="/login"><span class="menu m06">LOGIN</span></a></li>
			</c:if>
			<c:if test="${mvo ne null }">
			<li><a href="/logout"><span class="menu m06">LOGOUT</span></a></li>
			</c:if>
		</ul>
	</div>
	