package spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override public boolean preHandle( HttpServletRequest request, 
									    HttpServletResponse response, 
									    Object handler ) throws Exception {
		
		HttpSession session = request.getSession( true );
		
		Object obj = session.getAttribute( "mvo" );
		
		if( obj == null ) {
			// 로그인이 안되있을 경우
			response.sendRedirect( "../login" );
			return false;
		}
		
		System.out.println( request.getRequestURI() );
		
		return true;
	}
	
}
