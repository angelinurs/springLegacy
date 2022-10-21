package com.springLegacy.Interceptor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class KakaoControl {
	@Autowired
	private HttpSession session;

	@RequestMapping( "/kakao/login" )
	public ModelAndView kakaoLogin( String code )	{
		
		String REST_API_KEY = "798a60e3e91cbf6ef0d0e9093b43ffa3";
		String REDIRECT_URI = "http://localhost:8080/kakao/login";
		
		// 카카오 서버에서 인증코드 받기
		// token 이라는 변수로 받음.
		ModelAndView mv = new ModelAndView();
		
//		 System.out.println( "DECO : " + code );
		
		
		/*
		 * 출처.
		 * https://developers.kakao.com/docs/latest/ko/kakaologin/rest-api
		 * curl -v -X POST "https://kauth.kakao.com/oauth/token" \
		 * -H "Content-Type: application/x-www-form-urlencoded" \
		 * -d "grant_type=authorization_code" \
		 * -d "client_id=${REST_API_KEY}" \
		 * --data-urlencode "redirect_uri=${REDIRECT_URI}" \
		 * -d "code=${AUTHORIZE_CODE}"
		 */
		// 받은 코드를 가지고 2번째 요청인 토큰을 요청하여 받기 위한 작업
		String access_Token = "";
		String refresh_Token = "";
		String requestURL = "https://kauth.kakao.com/oauth/token";

		
		try {
			// 웹상의 경로를 연결하기 위해 객체화 시킨다.
			URL url = new URL( requestURL );
			
			// 웹상의 경로와 연결한다.
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			// POST 방식으로 요청하기 위해 setOutput 을 true 로 지정해야 한다.
			conn.setRequestMethod( "POST" );
			conn.setRequestProperty( "Content-Type", 
									 "application/x-www-form-urlencoded" );
			conn.setDoOutput( true );
			
			// 파라미터를 전달하기 위해 OutputStream 을 준비한다.
			BufferedWriter bw = new BufferedWriter( 
									new OutputStreamWriter( conn.getOutputStream() )
								);
			
			// 4개의 파라미터들을 만들어서 bw 를 통해 카카오 서버로 보낸다.
			StringBuffer sb = new StringBuffer();
			sb.append( "grant_type=authorization_code" ).append( "&" )
			  .append( "client_id=" ).append( REST_API_KEY ).append( "&" )
			  .append( "redirect_uri=" ).append( REDIRECT_URI ).append( "&" )
			  .append( "code=" ).append( code );
			
			bw.write( sb.toString() );
			bw.flush();
			
			int res_code = conn.getResponseCode();
//			System.out.println( "RES_ CODE : " + res_code );
			
			if( res_code == 200 ) {
				// 요청을 통해 얻은 JSON 타입의 결과 메세지를 읽어온다
				BufferedReader br = new BufferedReader( 
						new InputStreamReader( conn.getInputStream() ) );
				// conn 이 주는 stream 은 input stream 이다.
				// 우리가 필요한 sream 은 BufferdReader 이다.
				// BufferedReader 의 생성자는 InputStream 을 받지 않기 때문에 
				// 중간에 InputStream 을 Reader로 변경해주는 InputStreamReader 를 사용했다.
				
				
				StringBuffer result = new StringBuffer();
				String line = null;
				
				// 한줄 단위로 읽어서 StringBuffer Object 에 accumulation 한다.
				
				while( ( line = br.readLine()) != null ) {
					result.append( line );
				}
				
//				System.out.println( result.toString() );
				
				// response 된 json 형식의 String 을 Json 으로 convert
				JSONParser pars = new JSONParser();
				
				Object obj = pars.parse( result.toString() );
				
				JSONObject json = (JSONObject) obj;
				
				// Json object 로 parsing 된 object 에서 
				// "access_token", "refresh+token" 값을 가져온다.
				access_Token = (String) json.get( "access_token" );
				refresh_Token = (String) json.get( "refresh_token" );
				
//				System.out.println( "access_Token : " + access_Token );
//				System.out.println( "refresh_Token : " + refresh_Token );
				
				// 사용자 정보 요청
				 String header = "Bearer " + access_Token;
				 String apiURL = "https://kapi.kakao.com/v2/user/me";
				 
				 URL url2 = new URL( apiURL );
				 
				 HttpURLConnection conn2 = (HttpURLConnection) url2.openConnection();
				 conn2.setRequestMethod( "POST" );
				 conn2.setDoOutput( true );
				 
				 conn2.setRequestProperty( "Authorization", header );
				 
				 res_code = conn2.getResponseCode();
				 
				 System.out.println( "RES_ CODE : " + res_code );
				 System.out.println( " / " + HttpURLConnection.HTTP_OK );
				 
				 if( res_code == HttpURLConnection.HTTP_OK ) {
					 // 요청에 성공한 경우!!
					 
					 // 카카오 서버쪽에서 사용자 정보를 보내준다.
					 // 이것을 읽어와서 필요한 정보들을 선별해야 한다.
					 // db 에 저장할 정보 저장후 
					 // login 을 위해서 session 처리
					 
					 BufferedReader brdm = new BufferedReader(
							 	new InputStreamReader( conn2.getInputStream() )
							 );
					 
					 String str = null;
					 StringBuffer res = new StringBuffer();
					 
					 while( ( str = brdm.readLine() ) != null  ) {
						 res.append( str );
						 // 카카오에서 전달해주는 사용자 정보가 모두 res 에 누적된다.
					 }
					 
					 System.out.println( res.toString() );
					 
					 // 받은 값을 Json 객체로 반환한다.
					 obj = pars.parse( res.toString() );
					 json = (JSONObject) obj;
					 
					 // System.out.println( (String)json.get( "kakao_account" ) );
					 // 변환된 Json 객체 안에서 다시 Json 객체로 얻어내야 하는 것이 
					 // 바로 "properties" 라는 키의 값이다.
					 JSONObject props = (JSONObject) json.get( "kakao_account" );
					 
					 String gender = (String) props.get( "gender" );
					 
					 System.out.println( "Gender : " + gender );
					 
					 // 1. mvo 구조로 저장
					 // 2. db 에 저장
					 // 3. session 에 저장
					 
					 session.setAttribute( "mvo", gender );
					 
					 
				 }
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			mv.setViewName( "redirect:/" );
		}
		
		
		return mv;
	}
}
