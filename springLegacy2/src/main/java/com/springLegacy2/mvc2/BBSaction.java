package com.springLegacy2.mvc2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import bbs.dao.BBsDAO;
import bbs.vo.BBsVO;

@Controller
public class BBSaction {
	@Autowired
	private BBsDAO b_dao;
	
	@RequestMapping( "/list" )
	public ModelAndView getList( ) {
		BBsVO[] ar = b_dao.readAll( );
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject( "ar", ar );
		mv.setViewName( "list" );
		
		return mv;
	}
	
	@RequestMapping( "/view" )
	public ModelAndView getPost( String b_idx ) {
		BBsVO bvo = b_dao.searchById(b_idx);
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject( "bvo", bvo );
		mv.setViewName( "view" );
		
		return mv;
	}
	
	@RequestMapping( "/write" )
	public String writePost( )	{
		
		return "/write";
	}
	
	@RequestMapping( value="/write", method = RequestMethod.POST )
	public ModelAndView writePost( String title, String writer, String content, String ip )	{
		
		BBsVO bvo = new BBsVO();
		bvo.setSubject( title );
		bvo.setWriter( writer );
		bvo.setContent( content );
		bvo.setIp( ip );
		
		System.out.println( title + " " + writer + " " + content );
		
		b_dao.insertBBS( bvo );
		
		ModelAndView mv = new ModelAndView();
//		mv.setViewName( "list" );
		
		mv.setViewName( "redirect:list" );
		
		return mv;
	}
}
