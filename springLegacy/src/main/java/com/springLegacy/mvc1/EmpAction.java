package com.springLegacy.mvc1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mybatis.dao.EmpDAO;
import mybatis.vo.EmpVO;

@Controller
public class EmpAction {
	@Autowired
	private EmpDAO e_dao;
	
	@RequestMapping( "/view1" )
	public String view1() {
		return "emp/view1";
	}
	
	@RequestMapping( "/frm1" )
	public ModelAndView view2( String type, String value ) {
		
//		System.out.println( type + "/" + value );
		
		EmpVO[] ar = e_dao.search( type, value );
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject( "ar", ar );
		mv.setViewName( "emp/view2" );
		
		return mv;
	}
}
