<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<!-- 외부 CSS파일 연결! -->
		<link type="text/css" rel="stylesheet" href="resources/css/common.css"/>
		<link type="text/css" rel="stylesheet" href="resources/css/login.css"/>
		
		<style>
		
			#kakao{
				position: relative;
				text-align: left;
			}
		</style>
	</head>
<body>
<div id="wrap">
	<!-- 상단영역 -->
	<%@ include file="nav.jsp" %>
	<!-- -------- -->
	<!-- 콘텐츠영역 -->
	<div id="contents_sub">
		<h1 class="sub_title tit02">회원 로그인</h1>
		<div class="login_area">
			<!-- 일반개인회원 -->
			<div class="person_login">
				<h2 class="sub_title title01">일반 개인회원</h2>
				<div class="login">
					<form action="login" method="post" name="frm1" >
						<div class="input_area">
							<p>
								<label for="s_id">아이디</label>
								<input type="text" name="id" id="s_id"/>
							</p>
							<p>
								<label for="s_pw">비밀번호</label>
								<input type="password" name="pw" id="s_pw"/>
							</p>
						</div>
						<div class="btnArea_right">
							<span class="btn b_login">
								<a href="javascript:login()">로그인</a>
							</span>
						</div>
						<div class="fclear"></div>
						<p class="login_search">
							<input type="checkbox" name="chk" id="ch01"/>
							<label for="ch01">아이디저장</label>
							<span class="btn b_search">
								<a href="">아이디/비밀번호찾기</a>
							</span>
						</p>
					</form>
				</div>
			</div>
			<!-- ------------ -->
			<!-- 기관단체회원 -->
			<div class="group_login">
				<h2 class="sub_title title02">기관 단체회원</h2>
				<div class="login">
					<form action="" method="post">
						<div class="input_area">
							<p>
								<label for="s_id">아이디</label>
								<input type="text" name="id" id="s_id"/>
							</p>
							<p>
								<label for="s_pw">비밀번호</label>
								<input type="password" name="pw" id="s_pw"/>
							</p>
						</div>
						<div class="btnArea_right">
							<span class="btn b_login">
								<a href="">로그인</a>
							</span>
						</div>
						<div class="fclear"></div>
						<p class="login_search">
							<input type="checkbox" name="chk" id="ch01"/>
							<label for="ch01">아이디저장</label>
							<span class="btn b_search">
								<a href="">아이디/비밀번호찾기</a>
							</span>
						</p>
					</form>
				</div>
				<div id="kakao">
					<c:set var="REST_API_KEY" value="798a60e3e91cbf6ef0d0e9093b43ffa3" />
					<c:set var="REDIRECT_URI" value="http://localhost:8080/kakao/login" />
					<a href="https://kauth.kakao.com/oauth/authorize?client_id=${REST_API_KEY}&redirect_uri=${REDIRECT_URI}&response_type=code">
						<img src="resources/img/kakao_login.png">
					</a>
				</div>
				<div id="naver">
					<c:set var="client_id" value="798a60e3e91cbf6ef0d0e9093b43ffa3" />
					<c:set var="redirectURI" value="http://localhost:8080/kakao/login" />
					<a href="${apiURL }">
						<img src="resources/img/naver_login.png" width="50%" height="50%" >
						<img height="50" src="http://static.nid.naver.com/oauth/small_g_in.PNG"/>
					</a>
				</div>
			</div>
			<!-- ------------ -->
		</div>
	</div>
	<!-- ---------- -->
	<!-- 하단영역 -->
	<%@ include file="footer.jsp" %>
	<!-- -------- -->
</div>

<script>
	function login() {
		document.frm1.submit();
	}
</script>
</body>
</html>