package com.springLegacy.Interceptor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import api_ex.VO.NaverVO;

@Controller
public class NaverControl {
	
	@Autowired
	private HttpSession session;
	
	// naver login info
	private String clientId = "L3oXgo1YOPQuNGcHe68f";//���ø����̼� Ŭ���̾�Ʈ ���̵�";
	private String clientSecret = "fmNWgZyHAI";//���ø����̼� Ŭ���̾�Ʈ ��ũ����";

	@RequestMapping( "/callback" )
	public ModelAndView login( String code, String state ) throws Exception {
		ModelAndView mv = new ModelAndView();
		
//		System.out.println( "Code : " + code );
//		System.out.println( "State : " + state );
		
		String redirectURI = URLEncoder.encode("http://localhost:8080/callback", "UTF-8");
	    String apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code"
	        + "&client_id=" + clientId
	        + "&client_secret=" + clientSecret
	        + "&redirect_uri=" + redirectURI
	        + "&code=" + code
	        + "&state=" + state;
	    
	    String accessToken = "";
	    String refresh_token = "";
		
	    try {
	        URL url = new URL(apiURL);
	        HttpURLConnection con = (HttpURLConnection)url.openConnection();
	        con.setRequestMethod("GET");
	        
	        int responseCode = con.getResponseCode();
	        
	        BufferedReader br;
	        
	        if (responseCode == HttpURLConnection.HTTP_OK ) { // ���� ȣ��
	          br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	        } else {  // ���� �߻�
	          br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
	        }
	        String inputLine = null;
	        StringBuilder res = new StringBuilder();
	        
	        while ((inputLine = br.readLine()) != null) {
	          res.append(inputLine);
	        }
	        
	        br.close();
	        
	        if (responseCode == 200) {
//	        	System.out.println( res.toString() );
	        	
	        	// ���� token ���� Json ���� parsing �Ͽ� ���� ������ ����.
	        	JSONParser pars = new JSONParser();
	        	
	        	Object obj = pars.parse( res.toString() );
	        	
	        	JSONObject json = (JSONObject) obj;
	        	
	        	accessToken = (String) json.get( "access_token" );
	        	refresh_token = (String) json.get( "refresh_token" );
	        	
//	        	System.out.println( "Acc_tok : " + accessToken );
//	        	System.out.println( "Ref_tok : " + refresh_token );
	        	

	            String header = "Bearer " + accessToken; // Bearer ������ ���� �߰�

	            apiURL = "https://openapi.naver.com/v1/nid/me";

	            Map<String, String> requestHeaders = new HashMap<String, String>();
	            requestHeaders.put("Authorization", header);
	            String responseBody = get(apiURL,requestHeaders);

	            
	            //System.out.println(responseBody);
	            // {"resultcode":"00","message":"success","response":{"id":"_nofBDhV6DxYpCxjinaaX0HyJa07b2RRtCaAfT7pzk0","nickname":"ramu","gender":"M","birthday":"09-14"}}
	        	
	            // ���� responseBody �� Json ��ü�� �ٲپ�
	            // ���ϴ� ������ ������ VO �� ����
	            // �׸��� HttpSession �� �����ϰ�
	            // DB �� ����
	            
	            Object obj2 =  pars.parse( responseBody );
	            JSONObject json2 = (JSONObject) obj2;
	            
	            JSONObject personData  = (JSONObject) json2.get( "response" );
	            
	            NaverVO vo = new NaverVO();
	            vo.setId( (String) personData.get( "id" ) );
	            vo.setNickname( (String) personData.get( "nickname" ) );
	            vo.setBirthday( (String) personData.get( "gender" ) );
	            vo.setGender( (String) personData.get( "birthday" ) );
	            
	            session.setAttribute( "mvo", vo );
	            mv.setViewName( "redirect:/" );
	     
	        }
		  } catch (Exception e) {
		    // Exception �α�
			  e.printStackTrace();
		  }
	    
		return mv;
	}
	
	 private String get(String apiUrl, Map<String, String> requestHeaders){
	        HttpURLConnection con = connect(apiUrl);
	        try {
	            con.setRequestMethod("GET");
	            for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
	                con.setRequestProperty(header.getKey(), header.getValue());
	            }


	            int responseCode = con.getResponseCode();
	            if (responseCode == HttpURLConnection.HTTP_OK) { // ���� ȣ��
	                return readBody(con.getInputStream());
	            } else { // ���� �߻�
	                return readBody(con.getErrorStream());
	            }
	        } catch (IOException e) {
	            throw new RuntimeException("API ��û�� ���� ����", e);
	        } finally {
	            con.disconnect();
	        }
	    }


	    private HttpURLConnection connect(String apiUrl){
	        try {
	            URL url = new URL(apiUrl);
	            return (HttpURLConnection)url.openConnection();
	        } catch (MalformedURLException e) {
	            throw new RuntimeException("API URL�� �߸��Ǿ����ϴ�. : " + apiUrl, e);
	        } catch (IOException e) {
	            throw new RuntimeException("������ �����߽��ϴ�. : " + apiUrl, e);
	        }
	    }


	    private String readBody(InputStream body){
	        InputStreamReader streamReader = new InputStreamReader(body);


	        try  {
	        	BufferedReader lineReader = new BufferedReader( streamReader );
	            StringBuilder responseBody = new StringBuilder();


	            String line;
	            while ((line = lineReader.readLine()) != null) {
	                responseBody.append(line);
	            }


	            return responseBody.toString();
	        } catch (IOException e) {
	            throw new RuntimeException("API ������ �дµ� �����߽��ϴ�.", e);
	        }
	    }
	
}
