<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		
		<link rel="stylesheet" href="../css/summernote-lite.css">
		<link rel="stylesheet" href="../css/table.css" />
		
	</head>
	<body>
		<div id="bbs">
			<!-- 
				enctype="multipart/form-data" 로 전송하게 되면,
				요청받는 write_ok.jsp 에서 일반적인 request.getParameter(); 로 받을 수 없다. 
			-->
			<!-- 
			<form action="write" method="post" enctype="multipart/form-data" >
			 -->
			<form action="write" method="post">
				<table summary="게시판 글쓰기">
					<caption>게시판 글쓰기</caption>
					<colgroup>
						<col width="70px" />
						<col width="*" />
					</colgroup>
					<tbody>
						<tr>
							<th>Date :</th>
							<td><p>Today's date: <%= (new java.util.Date()).toLocaleString()%></p></td>
						</tr>
						<tr>
							<th>제목:</th>
							<td><input type="text" id="subject" name="subject" size="45"/></td>
						</tr>
						<tr>
							<th>이름:</th>
							<td><input type="text" id="writer" name="writer" size="12"/></td>
						</tr>
						<tr>
							<th>내용:</th>
							<td><textarea id="content" name="content" cols="50" 
									rows="8"></textarea></td>
						</tr>
						<tr>
							<th>첨부파일:</th>
							<td><input type="file" name="file"/></td>
						</tr>
		<!--
						<tr>
							<th>비밀번호:</th>
							<td><input type="password" name="pwd" size="12"/></td>
						</tr>
		-->
						<tr>
							<td colspan="2">
								<input type="button" value="보내기"
									onclick="javascript:sendData();"/>
								<input type="button" value="다시"
									onclick="javascript:location.reload();" />
								<input type="button" value="목록" 
									onclick="javascript:backList();"/>
							</td>
						</tr>
					</tbody>
				</table>
			</form>
		</div>
		
	<script src="https://code.jquery.com/jquery-3.6.1.min.js" 
			integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" 
			crossorigin="anonymous">
	</script>
	<script src="../js/summernote-lite.js"></script>
	<script src="../js/lang/summernote-ko-KR.js"></script>

	<script type="text/javascript">
		$( function(){
			
			$( "#content" ).summernote({
				lang: 'ko-KR',
				height: 300,
				maxHeight: 400,
				callbacks:{ 
					// 이미지가 Editor 에 추가 될때 만다 수행하는 곳
					// 이미지를 첨부하면 배열로 인식된다.
					// 이것을 서버로 비동기식 통신을 수행하면
					// 서버에 업로드를 시킬수 있다.
					onImageUpload: function( files, editor ) {
						for( var idx = 0; idx < files.length; idx++ ) {
							sendImage(files[idx], editor ); // 이미지를 서버로 보낸다.
						}
						
					}
				}
			});
		});
		
		function sendImage( file, editor ) {
			// 서버로 이미지 파일을 보내기 위해 폼객체 생성
			let frm = new FormData(); // <form enctype="multipart/form-data"  <-- 이것 만드는 명령어
			
			// 보내고자 하는 파일 자원을 폼에 파라미터로 등록
			// "upload" 라는 이름으로 파일자원을 등록했다.
			frm.append( "upload", file );
			
			// 비동기식 통신
			$.ajax({
				url: "saveImage.jsp",
				data: frm,
				type: "POST",
				
				// 두개다 false 로 지정해야 일반적 데이터 전송이 아닌
				// 파일 첨부임을 명시함. 
				// 파일 첨부시 아래의 두 라인은 무조건 있어야 함.
				contentType: false,
				processData: false,
				
				dataType: "json"
			}).done( function( res ){
				// 이미지가 서버의 uoload_img 폴더에 저장 성공시
				// 이미지 경로를 "img_url" 이라는 이름으로 res 에 json 으로 바인딩되어 넘어온다.
				
				// Case 01.
				// let image = $( "<img>" ).attr( "src", res.img_url );
				// $( "#content_1" ).summernote( "insertNode", image[0] );
				
				$( "#content" ).summernote( "editor.insertImage", res.img_url );
				
			});
		}
		
		function sendData(){
			let title = $( "#subject" ).val();
			let writer = $( "#writer" ).val();
			
			if( title.trim().length < 1 ) {
				alert( "제목을 입력하세요" );
				$( "#title" ).val();
				$( "#title" ).focus();
				
				return;
			}
			
			if( writer.trim().length < 1 ) {
				alert( "글쓴이를 입력하세요" );
				$( "#writer" ).val();
				$( "#writer" ).focus();
				
				return;
			}
	
			document.forms[0].action = "write";
			document.forms[0].submit();
		}
		
		function backList()	{
			location.href = "list";
		}
	
	</script>
	
	</body>
</html>