<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/summernote-lite.css"/>
<style type="text/css">
	#bbs table {
	    width:700px;
	    margin-left:10px;
	    border:1px solid black;
	    border-collapse:collapse;
	    font-size:14px;
	    
	}
	
	#bbs table caption {
	    font-size:20px;
	    font-weight:bold;
	    margin-bottom:10px;
	}
	
	#bbs table th {
	    text-align:center;
	    border:1px solid black;
	    padding:4px 10px;
	}
	
	#bbs table td {
	    text-align:left;
	    border:1px solid black;
	    padding:4px 10px;
	}
	
	.no {width:15%}
	.subject {width:30%}
	.writer {width:20%}
	.reg {width:20%}
	.hit {width:15%}
	.title{background:lightsteelblue}
	
	.odd {background:silver}
	
	.note-editor .note-editable {
	    line-height: 100%;  /*개행 간격을 알맞게 설정*/
	}	
</style>
<script type="text/javascript">
	function sendData(){
		let subject = document.forms[0].subject.value;
		let writer = document.forms[0].writer.value;
		
		if(subject.trim().length < 1){
			alert("제목을 입력하세요");
			document.forms[0].subject.value = "";
			document.forms[0].subject.focus();
			return;
		}
		
		if(writer.trim().length < 1){
			alert("글쓴이를 입력하세요");
			document.forms[0].writer.value = "";
			document.forms[0].writer.focus();
			return;
		}

		document.forms[0].submit();
	}
</script>
</head>
<body>
	<div id="bbs">
	<form action="write" method="post" 
	encType="multipart/form-data">
		<table summary="게시판 글쓰기">
			<caption>게시판 글쓰기</caption>
			<tbody>
				<tr>
					<th>제목:</th>
					<td><input type="text" name="subject" size="45"/></td>
				</tr>
				<tr>
					<th>이름:</th>
					<td><input type="text" name="writer" size="12"/></td>
				</tr>
				<tr>
					<th>내용:</th>
					<td><textarea id="content" name="content"  cols="50" 
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
						onclick="sendData()"/>
						<input type="button" value="다시"/>
						<input type="button" value="목록" onclick="backList()"/>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
	</div>
	<script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
	<script src="resources/js/summernote-lite.js"></script>
	<script src="resources/js/lang/summernote-ko-KR.js"></script>
	<script>
		$(function(){
			
			$("#content").summernote({
				height: 200,
				lang: "ko-KR",
				focus: true,/* 커서를 미리 가져다 놓는다. */
				callbacks:{
					onImageUpload: function(files, editor){
						// 이미지가 에디터에 추가될 때마다 수행하는 곳!
						// ( 추가되는 이미지들은 배열로 인식함! )
						for(let i=0; i<files.length; i++)
							sendImage(files[i], editor);// 서버로 비동기식 통신으로
									// 이미지를 서버로 업로드 시킨다. -- editor_img폴더 저장!
					}
				}
			});
			
			$("#content").summernote("lineHeight", 0.4);
			
		});
		
		function sendImage(file, editor){
			// 에디터에 이미지가 들어왔을 때 수행하는 곳이다.
			// 이미지도 파일이므로 Multipart/form-data형식을 따라야 한다.
			let frm = new FormData();
			
			// 보내고자 하는 파일을 위해 만든 FormData에 파라미터를 넣어주자
			frm.append("s_file", file);
			
			//비동기식 통신
			$.ajax({
				url: "saveImage",
				data: frm,
				type: "post",
				contentType: false,
				processData: false,
				cache: false,
				dataType: "json",//서버로부터 받을 데이터 형식
			}).done(function(data){
				let url = data.path + "/" + data.fname;
				$("#content").summernote("editor.insertImage", url );
			});
		}
		
		function backList(){
			location.href="#";
		}
	</script>
	
	
</body>
</html>




