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
		// model object �� request �� ����� !
		// forward �� ��밡����
		m.addAttribute( "vo", vo );
		
		return "edit";
	}
	
	@RequestMapping( value = "/edit", 
					 method = RequestMethod.POST )
	public ModelAndView edit( BbsVO vo, String cPage ) {
		ModelAndView mv = new ModelAndView();
		
		// ��û�� ������ ÷�ε� ��û����? �׳� ����ü�� ���޵� ��û����? ����
		// multipart....?  [post]application....? [get]null
		
		String ctx = request.getContentType( );
		
		// System.out.println( "ctx" );
		
		if( ctx.startsWith( "multipart" ) ) {
			// ��û�� ������ encType ( ����÷�� ���� ) ���� Ȯ��
			// ÷�ε� ������ �ִٸ� ���� ó�� �ؾ���.
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
