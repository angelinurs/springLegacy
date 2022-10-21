package com.springLegacy.mvc1;

import java.sql.Date;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@Component
public class Test2Action {

	@RequestMapping("/now")
	public ModelAndView handleRequest(){
		// 현재 날짜 구하기
		
		Date now = new Date( System.currentTimeMillis() );
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject( "now", now.toString() );
		mv.setViewName( "test3" );
		
		return mv;
	}

}
