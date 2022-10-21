package bbs.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bbs.vo.BBsVO;
import bbs.vo.CommentVO;

@Component
public class BBsDAO {
	
	@Autowired
	private SqlSessionTemplate ss;
	
	public  int getTotalCount() {
		int count = 0;
		
		count = ss.selectOne( "bbs.total_count");
		
		return count;
	}
	
	public  BBsVO[] readAll() {
		
		BBsVO[] voList = null;

		List<BBsVO> list =  ss.selectList( "bbs.list" );
		
		if( list != null && !list.isEmpty() ) {
			voList = new BBsVO[ list.size() ];
			list.toArray( voList );
		}
		
		return voList;
	}
	
	public  boolean insertBBS( BBsVO vo ) {
		
		int result =  ss.insert( "bbs.insert", vo );
				
		return ( result > 0 )? true: false;
	}
	
	public  BBsVO searchById( String idx ) {
		
		BBsVO vo =  ss.selectOne( "bbs.searchById", idx );
		
		return vo;
	}
	
	public  int updateHitCount( String idx, String count ) {
		// idx -> 게시물 번호
		// count 조회수
		int rval = 0;
		
		
		Map<String, String> map = new HashMap<>();
		
		map.put( "no", idx );
		map.put( "count", count );
		
		rval = ss.update( "bbs.updateHitCount", map );
		
		return rval;
	}
	
	public  boolean insertComment( CommentVO vo ) {
		boolean value = false;
		
		
		int count = ss.insert( "comment.insert", vo );
		
		value = ( count > 0 );
		
		return value;
	}
	
	public  boolean editBBS( String title,  String content, String fname, String oname, String ipAddress, String b_idx ) {
		boolean rval = false;
		
		Map<String, String> map = new HashMap<>();
		if( title != null ) map.put( "subject", title );
		if( content != null ) map.put( "content", content );
		if( fname != null ) map.put( "fname", fname );
		if( oname != null ) map.put( "fname", fname );
		if( ipAddress != null ) map.put( "ip", ipAddress );
		if( b_idx != null ) map.put( "b_idx", b_idx );
		
		int result = ss.update( "bbs.updateBBS", map );
				
		rval = ( result > 0 );
		
		return rval;
	}
	
	public  boolean deleteBBS( String idx ) {
		boolean rval = false;
		
		int result = ss.update( "bbs.deleteBBS", idx );
		
		rval = ( result > 0 );
		
		return rval;
	}
	
}