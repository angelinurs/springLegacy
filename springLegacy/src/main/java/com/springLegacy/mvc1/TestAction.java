package com.springLegacy.mvc1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestAction {

		@RequestMapping("/ex1")
		public String execute()	{
			// �ƹ��͵� ���ϰ� �ٷ� jsp�� ��θ� ��ȯ
			return "test1";
		}
		
		@RequestMapping("/ex2")
		public ModelAndView test2()	{
			// jsp mvc ���� �ߴ� ��ó�� request �� �����͸� �����ؼ� �����Ϸ���
			// ModelAndView Object �� �ʿ��ϴ�.
			ModelAndView mv = new ModelAndView();
			
			mv.addObject( "msg", "����" );
			
			mv.setViewName( "test2" );
			
			return mv;
		}
}
