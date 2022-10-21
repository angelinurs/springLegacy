package com.springLegacy.mvc1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestAction {

		@RequestMapping("/ex1")
		public String execute()	{
			// 아무것도 안하고 바로 jsp의 경로만 반환
			return "test1";
		}
		
		@RequestMapping("/ex2")
		public ModelAndView test2()	{
			// jsp mvc 에서 했던 것처럼 request 에 데이터를 저장해서 전달하려면
			// ModelAndView Object 가 필요하다.
			ModelAndView mv = new ModelAndView();
			
			mv.addObject( "msg", "연습" );
			
			mv.setViewName( "test2" );
			
			return mv;
		}
}
