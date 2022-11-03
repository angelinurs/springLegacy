package com.naru.miniproject;

import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.SecureRandom;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberControl {
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		String naverClientId = "L3oXgo1YOPQuNGcHe68f";//애플리케이션 클라이언트 아이디값";
		try {
		    String redirectURI = URLEncoder.encode("http://localhost:8080/callback", "UTF-8");
		    SecureRandom random = new SecureRandom();
		    String state = new BigInteger( 130, random).toString();
		    String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code"
		         + "&client_id=" + naverClientId
		         + "&redirect_uri=" + redirectURI
		         + "&state=" + state;		
		    mv.addObject("apiURL", apiURL);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		mv.setViewName("login");
		return mv;
	}
	
	/*
	@RequestMapping( "/login" )
	public String login()	{
		return "/login";
	}
	*/
	
	
	@RequestMapping( value="/login", 
					 method=RequestMethod.POST )
	public ModelAndView login( String id, String pw ) {
		ModelAndView mv = new ModelAndView();
		
		session.setAttribute( "mvo", id );
		
		mv.setViewName( "redirect:/" );
		
		return mv;
	}
	
	@RequestMapping( "/logout" )
	public ModelAndView logout()	{
		
		session.removeAttribute( "mvo" );
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName( "redirect:/" );
		return mv;
	}
}
