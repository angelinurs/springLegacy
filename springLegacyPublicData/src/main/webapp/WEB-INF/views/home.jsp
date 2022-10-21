<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
	<head>
		<title>Home</title>
		<style>
			table {
				border-collapse: collapse;
			}
			tr {
				border-bottom: 1px solid black;
			}
			thead tr{
				background-color: #f6ddcc;
			}
			tbody tr:nth-child( even ) {
				background-color: #ebf5fb;
			}
			th {
				border-left: 2px dotted black;
			}
			td {
				border-left: 2px solid black;
			}
		
		</style>
	</head>
	<body>
		<div id="wrap">
			<header>
				<h1>충전소 목록</h1>
			</header>
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
		</div>
	</body>
</html>
