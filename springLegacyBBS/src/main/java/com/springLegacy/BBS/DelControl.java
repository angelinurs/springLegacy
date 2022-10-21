package com.springLegacy.BBS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import mybatis.dao.BbsDAO;
import mybatis.vo.BbsVO;

@Controller
public class DelControl {
	
	@Autowired
	private BbsDAO b_dao;
	
	@RequestMapping( "/delete" )
	public String del( String b_idx, String cPage ) {
		b_dao.delBBS(b_idx);
		
		return "redirect:/list?cPage=" + cPage;
	}

}
