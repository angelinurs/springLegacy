<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		
		<link rel="stylesheet" href="../css/table.css" /> 
		<link rel="stylesheet" href="../css/paging.css" /> 
	</head>
	<body>
		
		<div id="bbs">
			<table summary="게시판 목록">
				<caption>게시판 목록</caption>
				<thead>
					<tr class="title">
						<th class="no">번호</th>
						<th class="subject">제목</th>
						<th class="writer">글쓴이</th>
						<th class="reg">날짜</th>
						<th class="hit">조회수</th>
					</tr>
				</thead>

				<tbody>
				<c:if test="${ar != null }">
					<c:forEach var="vo" items="${ar }">
					<tr>
						<td>${vo.b_idx }</td>
						<td style="text-align: left">
							<a href="view?b_idx=${vo.b_idx }">
							${vo.subject }
							<%--
								out.print( ( vo.getCommentList() != null && vo.getCommentList().size() > 0 )? "(" + vo.getCommentList().size() + ")": "(0)" ); 
							--%>
							</a>
						</td>
						<td>${vo.writer }</td>
						<td>${vo.write_date }</td>
						<td>${vo.hit }</td>
					</tr>
					</c:forEach>
				</c:if>
				<c:if test="${ar == null }">
					<tr>
						<td colspan="5">검색 결과 없음</td>
					</tr>
				</c:if>

				</tbody>
				
				<tfoot>
                      <tr>
                          <td colspan="4">
                              
                          </td>
                          
						  <td>
							<input type="button" value="글쓰기" 
								onclick="javascript:location.href='write'"/>
						  </td>
                      </tr>
				</tfoot>
				
			</table>
			
		</div>
	
	</body>
</html>