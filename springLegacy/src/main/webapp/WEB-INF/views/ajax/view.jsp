<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		
		<style>
			#table {
				width: 400px;
				border-collapse: collapse;
			}
			#table th, #table td {
				border: 1px solid black; 
			}
			#table th {
				padding: 4px;
				background-color: #cdcdcd;
			}
			caption {
				height: 0px;
				text-indent: -9999px;
			}
		</style>
	</head>
	<body>
		<div id="wrap">
			<header>
				<h1>사원 목록</h1>
			</header>
			<article>
				<table id="table">
					<caption>사원 테이블</caption>
					<colgroup>
						<col width="100px" />
						<col width="100px" />
						<col width="*" />
					</colgroup>
					<thead>
						<tr>
							<td colspan="3">
								<form action="view_ajax2" method="post">
									<select id="type" name="type">
										<option value="0">사번</option>
										<option value="1">이름</option>
										<option value="2">입사일</option>
									</select>
									<input type="text" id="value" name="value" />
									<!-- 
									<button type="button" onclick="javascript:searchData( this.form );">검색</button>
									 -->
									<button type="button" id="btn" name="btn">검색</button>
								</form>
							</td>
						</tr>
						<tr>
							<th>사번 </th>
							<th>이름 </th>
							<th>입사일 </th>
						</tr>
					</thead>
					<tbody></tbody>
				</table>
			</article>
		</div>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
		<script>
			$( function(){
				
				$( "#btn" ).bind( "click", function(){
					let type = $( "#type" ).val();
					let value = $( "#value" ).val();
					
					if( value.trim().length < 1 )	{
						alert( "검색할 내용을 입력해주세요." );
						$( "#value" ).focus();
						return;
					}
					
					$.ajax({
						url: "view_ajax2",
						data: {
								"type" : type,
								"value" : value
							  },
						type: "POST",
						dataType: "json"
						
					}).done( function( res ){
						let str = "";
						for( var idx=0; idx < res.totalSize; idx++ ) {
							str += "<tr><td>";
							str += res.ar[idx].emp_no;
							str += "</td><td>";
							str += res.ar[idx].first_name;
							str += "</td><td>";
							str += res.ar[idx].hire_date;
							str += "</td></tr>";
						}
						
						$( "#table tbody" ).html( str );
					});	
				});
			});
			/* 
			function searchData( frm ) {
				frm.submit();
			}
			 */
		</script>
	</body>
</html>