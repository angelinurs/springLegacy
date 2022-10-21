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
								<form action="frm1" method="post">
									<select id="type" name="type">
										<option value="0">사번</option>
										<option value="1">이름</option>
										<option value="2">입사일</option>
									</select>
									<input type="text" id="value" name="value" />
									<button type="button" onclick="javascript:searchData( this.form );">검색</button>
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
		
		<script>
			function searchData( frm ) {
				frm.submit();
			}
		</script>
	</body>
</html>