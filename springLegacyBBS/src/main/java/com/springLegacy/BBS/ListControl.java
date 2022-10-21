package com.springLegacy.BBS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mybatis.dao.BbsDAO;
import mybatis.vo.BbsVO;
import spring.util.Paging;

@Controller
public class ListControl {

	@Autowired
	private BbsDAO b_dao;
	
	private int nowPage;
	private int totalCount;
	private int numPerPage = 10;
	private int pagePerBlock = 5;
	
	@RequestMapping( "/list" )
	public ModelAndView list( String cPage, String bname ) {
		ModelAndView mv = new ModelAndView();
		
		if( bname == null ) bname = "BBS";
		if( cPage == null )	{
			nowPage = 1;
		} else {
			nowPage = Integer.parseInt( cPage );
		}
		
		totalCount = b_dao.getTotalCount(bname);
		
		Paging page = new Paging(nowPage, numPerPage, totalCount, pagePerBlock);
		
		int begin = page.getBegin();
		int end = page.getEnd();
		
		BbsVO[] ar = b_dao.getList(begin, end, bname);
		
		mv.addObject( "ar", ar );
		mv.addObject( "pageCode", page.getSb().toString() );
		mv.addObject( "nowPage", nowPage );
		mv.addObject( "numPerPage", numPerPage );
		mv.addObject( "totalCount", totalCount );
		mv.addObject( "pagePerBlock", pagePerBlock );
		
		mv.setViewName( "list" );
		
		return mv;
	}
}
