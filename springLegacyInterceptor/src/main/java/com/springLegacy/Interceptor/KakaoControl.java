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
		
		// īī�� �������� �����ڵ� �ޱ�
		// token �̶�� ������ ����.
		ModelAndView mv = new ModelAndView();
		
//		 System.out.println( "DECO : " + code );
		
		
		/*
		 * ��ó.
		 * https://developers.kakao.com/docs/latest/ko/kakaologin/rest-api
		 * curl -v -X POST "https://kauth.kakao.com/oauth/token" \
		 * -H "Content-Type: application/x-www-form-urlencoded" \
		 * -d "grant_type=authorization_code" \
		 * -d "client_id=${REST_API_KEY}" \
		 * --data-urlencode "redirect_uri=${REDIRECT_URI}" \
		 * -d "code=${AUTHORIZE_CODE}"
		 */
		// ���� �ڵ带 ������ 2��° ��û�� ��ū�� ��û�Ͽ� �ޱ� ���� �۾�
		String access_Token = "";
		String refresh_Token = "";
		String requestURL = "https://kauth.kakao.com/oauth/token";

		
		try {
			// ������ ��θ� �����ϱ� ���� ��üȭ ��Ų��.
			URL url = new URL( requestURL );
			
			// ������ ��ο� �����Ѵ�.
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			// POST ������� ��û�ϱ� ���� setOutput �� true �� �����ؾ� �Ѵ�.
			conn.setRequestMethod( "POST" );
			conn.setRequestProperty( "Content-Type", 
									 "application/x-www-form-urlencoded" );
			conn.setDoOutput( true );
			
			// �Ķ���͸� �����ϱ� ���� OutputStream �� �غ��Ѵ�.
			BufferedWriter bw = new BufferedWriter( 
									new OutputStreamWriter( conn.getOutputStream() )
								);
			
			// 4���� �Ķ���͵��� ���� bw �� ���� īī�� ������ ������.
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
				// ��û�� ���� ���� JSON Ÿ���� ��� �޼����� �о�´�
				BufferedReader br = new BufferedReader( 
						new InputStreamReader( conn.getInputStream() ) );
				// conn �� �ִ� stream �� input stream �̴�.
				// �츮�� �ʿ��� sream �� BufferdReader �̴�.
				// BufferedReader �� �����ڴ� InputStream �� ���� �ʱ� ������ 
				// �߰��� InputStream �� Reader�� �������ִ� InputStreamReader �� ����ߴ�.
				
				
				StringBuffer result = new StringBuffer();
				String line = null;
				
				// ���� ������ �о StringBuffer Object �� accumulation �Ѵ�.
				
				while( ( line = br.readLine()) != null ) {
					result.append( line );
				}
				
//				System.out.println( result.toString() );
				
				// response �� json ������ String �� Json ���� convert
				JSONParser pars = new JSONParser();
				
				Object obj = pars.parse( result.toString() );
				
				JSONObject json = (JSONObject) obj;
				
				// Json object �� parsing �� object ���� 
				// "access_token", "refresh+token" ���� �����´�.
				access_Token = (String) json.get( "access_token" );
				refresh_Token = (String) json.get( "refresh_token" );
				
//				System.out.println( "access_Token : " + access_Token );
//				System.out.println( "refresh_Token : " + refresh_Token );
				
				// ����� ���� ��û
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
					 // ��û�� ������ ���!!
					 
					 // īī�� �����ʿ��� ����� ������ �����ش�.
					 // �̰��� �о�ͼ� �ʿ��� �������� �����ؾ� �Ѵ�.
					 // db �� ������ ���� ������ 
					 // login �� ���ؼ� session ó��
					 
					 BufferedReader brdm = new BufferedReader(
							 	new InputStreamReader( conn2.getInputStream() )
							 );
					 
					 String str = null;
					 StringBuffer res = new StringBuffer();
					 
					 while( ( str = brdm.readLine() ) != null  ) {
						 res.append( str );
						 // īī������ �������ִ� ����� ������ ��� res �� �����ȴ�.
					 }
					 
					 System.out.println( res.toString() );
					 
					 // ���� ���� Json ��ü�� ��ȯ�Ѵ�.
					 obj = pars.parse( res.toString() );
					 json = (JSONObject) obj;
					 
					 // System.out.println( (String)json.get( "kakao_account" ) );
					 // ��ȯ�� Json ��ü �ȿ��� �ٽ� Json ��ü�� ���� �ϴ� ���� 
					 // �ٷ� "properties" ��� Ű�� ���̴�.
					 JSONObject props = (JSONObject) json.get( "kakao_account" );
					 
					 String gender = (String) props.get( "gender" );
					 
					 System.out.println( "Gender : " + gender );
					 
					 // 1. mvo ������ ����
					 // 2. db �� ����
					 // 3. session �� ����
					 
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
