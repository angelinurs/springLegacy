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
			thead tr:first-child{
				background-color: #f9ebea;
				border: none;
				margin: 0;
				padding: 0;
			}
			
			thead>tr>td>div{
				line-height: 100%;
				margin-top: 10px;
				margin-left: 10px;
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
							<td colspan="9">
								<div id="searchFrom">
									<form action="" method="">
										<label for="opt">검색 방식 선택</label>
										<select id="opt" name="opt" >
											<option value="0" >입찰공고번호 </option>
											<option value="1" >등록일시</option>
											<option value="2" >변경일시 </option>
										</select>
										<span>
											<input type="text" id="bidNtceNo" name="bidNtceNo" /> 
										</span>
										<span>
											<button type="button" id="typeBTN" name="typeBTN" >검색</button> 
										</span>
									</form>
								</div>
							</td>
						</tr>
						<tr>
							<th>입찰공고<br/>번호</th>
							<th>입찰공공<br/>기관명</th>
							<th>수요기관명</th>
							<th>입찰방식명</th>
							<th>계약체결<br/>방법명</th>
							<th>공고기관<br/>담당자명</th>
							<th>공고기관<br/>담당자전화번호</th>
							<th>공고기관<br/>담당자이메일주소</th>
							<th>집행관명</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="vo" items="${p_list }">
						<tr>
							<td>${vo.bidNtceNo }</td>
							<td>${vo.ntceInsttNm }</td>
							<td>${vo.dminsttNm }</td>
							<td>${vo.bidMethdNm }</td>
							<td>${vo.cntrctCnclsMthdNm }</td>
							<td>${vo.ntceInsttOfclNm }</td>
							<td>${vo.ntceInsttOfclTelNo }</td>
							<td>${vo.ntceInsttOfclEmailAdrs }</td>
							<td>${vo.exctvNm }</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
				
			</article>
		</div>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
		<script>
			$(function(){
				$( "#opt" ).bind( 'change', function(){
					
					// 0 : 입찰공고번호
					// 1 : 등록일시
					// 2 : 변경일시
					
					let $tag = $("<input type='text'/>");
					$tag.attr( 'name', 'reg');
					console.log( $tag.attr( 'name' ) );
					switch( this.value ) {
						case '2' : console.log( '2' ); break;
						case '1' : console.log( '1' ); break;
						default : console.log( '0' ); 
					}
					
				});
				
					
						
			});
		</script>
	</body>
</html>
