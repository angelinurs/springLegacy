package com.springLegacy.BBS;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.map.type.MapLikeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import mybatis.dao.BbsDAO;
import mybatis.vo.BbsVO;
import mybatis.vo.ImgVO;
import spring.util.FileRenameUtil;

@Controller
public class WriteControl {

	@Autowired
	private BbsDAO b_dao;
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private ServletContext application;
	
	private String img_path = "/resources/editor_img";
	private String bbs_path = "/resources/bbs_upload";
	
	@RequestMapping( "write" )
	public ModelAndView write( String cPage, String bname ) {
		ModelAndView mv = new ModelAndView();
		
		mv.addObject( "cPage", cPage );
		mv.addObject( "bname", bname );
		mv.setViewName( "write" );
		
		return mv;
	}
	
	@RequestMapping( value="saveImage",
					 method=RequestMethod.POST )
	@ResponseBody
	public Map<String, String> saveImage( ImgVO vo ) {
		
		Map<String, String> map = new HashMap<String, String>();
		
		MultipartFile mf = vo.getS_file();
		
		String fname = null;
		
		System.out.println( fname );
		System.out.println( mf );
		System.out.println( mf.getSize() );
		
		if( mf != null && mf.getSize() > 0 ) {
			String realPath = application.getRealPath( img_path );
			
			fname = mf.getOriginalFilename();
			
			fname = FileRenameUtil.checkSameFileName( fname, realPath );
			
			try {
				mf.transferTo( new File( realPath, fname ) );
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		String path = request.getContextPath();
		
		map.put( "path", path + img_path );
		map.put( "fname", fname );
		
		return map;
	}
	
	@RequestMapping( value="/write",
					 method=RequestMethod.POST )
	public ModelAndView write( BbsVO vo ) throws IllegalStateException, IOException {
		ModelAndView mv = new ModelAndView();
		
		vo.setIp( request.getRemoteAddr() );
		
		MultipartFile mf = vo.getFile();
		
		if( mf != null && mf.getSize() > 0 ) {
			String realPath = application.getRealPath( bbs_path );
			
			String fname = mf.getOriginalFilename();
			fname = FileRenameUtil.checkSameFileName(fname, realPath);
			
			vo.setFile_name( fname );
			
			mf.transferTo( new File( realPath, fname ));
			
		}
		
		b_dao.add(vo);
		
		mv.setViewName( "redirect:/list" );
		
		return mv;
	}
}
