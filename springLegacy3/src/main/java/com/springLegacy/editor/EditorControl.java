package com.springLegacy.editor;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import editor.vo.ImgVO;
import mybatis.dao.BbsDAO;
import mybatis.vo.BbsVO;
import spring.util.FileRenameUtil;

@Controller
public class EditorControl {
	
	@Autowired
	private BbsDAO b_dao;
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private ServletContext application;
	
	private String img_path = "/resources/editor_img";
	private String bbs_path = "/resources/bbs_upload";
	
	
	@RequestMapping( "/write" )
	public String write()	{
		return "write";
	}
	
	@RequestMapping( value="/saveImage", 
					 method=RequestMethod.POST )
	@ResponseBody
	public Map<String, String> saveImage( ImgVO vo )	{
		
		MultipartFile mf = vo.getS_file();
		Map<String, String> map = new HashMap<String, String>();
		
		String fname = null;
		
		if( mf != null && mf.getSize() > 0 ) {
			// image 파일이 넘어온 경우
			// get server absolute path
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
	public ModelAndView write( BbsVO vo ) throws Exception, IOException {
		ModelAndView mv = new ModelAndView();
		
		vo.setIp( request.getRemoteAddr() );
		
		// get a attached file from vo
		
		MultipartFile mf = vo.getFile();
		
		if( mf != null && mf.getSize() > 0 ) {
			String realPath = application.getRealPath(bbs_path);
			
			String fname = mf.getOriginalFilename();
			vo.setOri_name( fname );
			
			fname = FileRenameUtil.checkSameFileName(fname, realPath);
			vo.setFile_name(fname);
			
			mf.transferTo( new File( realPath, fname) );
			
		}
		
		// store to db with dao
		b_dao.insertBbs(vo);
		
		System.out.println( vo.getSubject() );
		mv.setViewName( "redirect:/list" );
		
		return mv;
	}
	
	@RequestMapping( "/list" )
	public ModelAndView listAll() {
		ModelAndView mv = new ModelAndView();
		
		BbsVO[] ar =  b_dao.readAll();
		
		mv.addObject( "ar", ar);
		mv.setViewName( "list" );
		
		return mv;
	}
}
