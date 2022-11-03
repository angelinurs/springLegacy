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
				<h1>입찰공고목록 정보조회</h1>
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
										<label for="inqryDiv">검색 방식 :&nbsp;</label>
										<select id="inqryDiv" name="opt" >
											<option value="1" >입찰공고번호 </option>
											<option value="2" >등록일시</option>
											<option value="3" >변경일시 </option>
										</select>
										<span>
											
											<label for="inqryBgnDt">등록일시 :&nbsp;</label>
											<input type="date" id="inqryBgnDt" name="inqryBgnDt" /> 
											<input type="time" id="inqryBgnDt" name="inqryBgnDt" />
											<label for="inqryEndDt">변경일시 :&nbsp;</label>
											<input type="datetime-local" id="inqryEndDt" name="inqryEndDt" /> 
											<label for="bidNtceNo">입찰공고번호 :&nbsp;</label>
											<input type="text" id="bidNtceNo" name="bidNtceNo" /> 
											<input type="hidden" id="type" name="type" /> 
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
				$( "#inqryDiv" ).bind( 'change', function(){
					// 1 : 입찰공고번호
					// 2 : 등록일시
					// 3 : 변경일시
					switch( this.value ) {
						case '2' :
							console.log( '2' );
                            $( '#bidNtceNo').attr( 'disabled', 'disabled' );
                            $( '#inqryBgnDt').removeAttr( 'disabled' );
                            $( '#inqryEndDt').attr( 'disabled', 'disabled' );
                            break;
						case '3' :
							console.log( '3' ); 
                            $( '#bidNtceNo').attr( 'disabled', 'disabled' );
                            $( '#inqryBgnDt').attr( 'disabled', 'disabled' );
                            $( '#inqryEndDt').removeAttr( 'disabled' );
                            break;
						default :
							console.log( '1' );
                            $( '#bidNtceNo').removeAttr( 'disabled' );
                            $( '#inqryBgnDt').attr( 'disabled', 'disabled' );
                            $( '#inqryEndDt').attr( 'disabled', 'disabled' );
					}
				});
				
					
						
			});
		</script>
	</body>
</html>
