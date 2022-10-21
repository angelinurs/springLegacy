package com.springLegacy.BBS;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import mybatis.dao.BbsDAO;
import mybatis.vo.BbsVO;
import spring.util.FileRenameUtil;

@Controller
public class Editcontrol {

	@Autowired
	private ServletContext application;
	
	@Autowired
	private ServletRequest request;
	
	@Autowired
	private BbsDAO b_dao;
	
	
	private String editor_img = "/resource/editor_img";
	private String bbs_upload = "/resource/bbs_upload";
	
	@RequestMapping( "/edit" )
	public String edit( String b_idx, Model m ) {
		
		BbsVO vo = b_dao.getBbs(b_idx);
		// model object 는 request 에 저장됨 !
		// forward 시 사용가능함
		m.addAttribute( "vo", vo );
		
		return "edit";
	}
	
	@RequestMapping( value = "/edit", 
					 method = RequestMethod.POST )
	public ModelAndView edit( BbsVO vo, String cPage ) {
		ModelAndView mv = new ModelAndView();
		
		// 요청시 파일이 첨부된 요청인지? 그냥 폼객체로 전달된 요청인지? 구별
		// multipart....?  [post]application....? [get]null
		
		String ctx = request.getContentType( );
		
		// System.out.println( "ctx" );
		
		if( ctx.startsWith( "multipart" ) ) {
			// 요청시 형식이 encType ( 파일첨부 가능 ) 인지 확인
			// 첨부된 파일이 있다면 파일 처리 해야함.
			MultipartFile mf = vo.getFile();
			
			if( mf != null && mf.getSize() > 0 ) {
				String realPath = application.getRealPath( bbs_upload );
				String fname = mf.getOriginalFilename();
				fname = FileRenameUtil.checkSameFileName(fname, realPath);
				
				try {
					mf.transferTo( new File( realPath, fname ) );
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				vo.setFile_name(fname);
			}
			
		}
		vo.setIp( request.getRemoteAddr() );
		b_dao.edit(vo);
		
//		mv.setViewName( "redirect:/list" );
		mv.setViewName( "redirect:/view"+vo.getB_idx()+"&cPage="+cPage );
		
		return mv;
		
	}
}
