package com.springLegacy.mvc1;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import mybatis.dao.EmpDAO;
import mybatis.vo.EmpVO;

@Controller
public class EmpActionWithJackson {
	@Autowired
	private EmpDAO e_dao;
	
	@RequestMapping( "/view_ajax" )
	public String view1() {
		return "ajax/view";
	}
	
	@RequestMapping( "/frm_ajax" )
	public ModelAndView view2( String type, String value ) {
		
//		System.out.println( type + "/" + value );
		
		EmpVO[] ar = e_dao.search( type, value );
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject( "ar", ar );
		mv.setViewName( "emp/view2" );
		
		return mv;
	}
	
	
	@RequestMapping( value="/view_ajax2", 
					 method=RequestMethod.POST )
	@ResponseBody
	public Map<String, Object> test( String type, String value  )	{
		EmpVO[] ar = e_dao.search(type, value);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put( "totalSize", ar.length );
		map.put( "ar", ar );
		
		return map;
	}
}
