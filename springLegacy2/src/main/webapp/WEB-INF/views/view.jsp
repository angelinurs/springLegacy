<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		
		<link rel="stylesheet" href="../css/table.css" />
	</head>
	<body>
		<div id="bbs">
			<form method="post" >
				<table summary="게시판 글보기">
					<caption>게시판 글보기</caption>
					<tbody>
						<c:if test="${bvo != null }">
							<c:set var="vo" value="${bvo }" />
						<tr>
							<th>제목:</th>
							<td>${vo.subject }</td>
						</tr>
						<c:if test="${vo.file_name != null }">
						<tr>
							<th>첨부파일:</th>
							<td><a href="javascript:down( '${vo.file_name }' );">
								${vo.file_name }
							</a></td>
						</tr>
						</c:if>
						<tr>
							<th>이름:</th>
							<td>${vo.writer }</td>
						</tr>
						<tr>
							<th>내용:</th>
							<td>${vo.content }</td>
						</tr>
						
						<tr>
							<td colspan="2">
								<input type="button" value="수정"
									 onclick="javascript:backList( 'edit.jsp' )" />
								<input type="button" value="삭제"
									 onclick="javascript:del();" />
								<input type="button" value="목록"
									 onclick="javascript:backList( 'list.jsp' )" />
							</td>
						</tr>
						</c:if>
					</tbody>
				</table>
			</form>
			<form method="post" action="ans_write.jsp">
				이름:<input type="text" name="writer"/><br/>
				내용:<textarea rows="4" cols="55" name="content"></textarea><br/>
				비밀번호:<input type="password" name="pwd"/><br/>
				
				
				<input type="hidden" name="b_idx" value="${vo.b_idx }">
				<%--
				<input type="hidden" name="cPage" value="<%=cPage%>"/>
				 --%>
				<input type="submit" value="저장하기"/> 
			</form>
			
			댓글들<hr/>
			<c:forEach var="cvo" items="${bvo.commentList }">	
				<div>
					이름:${cvo.writer } &nbsp;&nbsp;
					날짜:${cvo.write_date }<br/>
					내용:${cvo.content }
				</div>
				<hr/>
			</c:forEach>
			
			</div>
			<%--
			<form name="frm" method="post">
				<input type="hidden" name="cPage" value="<%=cPage %>"/>
				<input type="hidden" name="idx" value="<%=idx %>"/>
				<input type="hidden" name="f_name" />
			</form>
			 --%>
	
	<script src="https://code.jquery.com/jquery-3.6.1.min.js" 
			integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" 
			crossorigin="anonymous">
	</script>
	<script>
	<%--
	function backList( page )	{
		// Case 01. get method.
		// location.href="list.jsp?cPage=<%=cPage %>";
		
		// Case 02. post method
		let frm = document.createElement("form");
		frm.setAttribute("method", "POST");
		frm.setAttribute("action", page + "?cPage=<%=cPage %>&idx=<%=vo.getB_idx() %>" );
		document.body.appendChild( frm );
		frm.submit();
	}
	--%>
	
	function down( fname ) {
		document.frm.f_name.value = fname;
		document.frm.action = "download.jsp";
		document.frm.submit();
	}
	
	function del() {
		if( confirm( "Are you sure?" ) ) {
			document.frm.action = "del.jsp";
			document.frm.submit();
			
		}
	}
	</script>
	</body>
</html>