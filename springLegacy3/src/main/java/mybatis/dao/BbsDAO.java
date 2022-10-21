package mybatis.dao;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mybatis.vo.BbsVO;
import mybatis.vo.CommentVO;

@Component
public class BbsDAO {
	
	@Autowired
	private SqlSessionTemplate ss;
	
	public  int getTotalCount() {
		int count = 0;
		
		count = ss.selectOne( "Bbs.total_count");
		
		return count;
	}
	
	public  BbsVO[] readAll() {
		
		BbsVO[] voList = null;

		List<BbsVO> list =  ss.selectList( "Bbs.list" );
		
		if( list != null && !list.isEmpty() ) {
			voList = new BbsVO[ list.size() ];
			list.toArray( voList );
		}
		
		return voList;
	}
	
	public  boolean insertBbs( BbsVO vo ) {
		
		int result =  ss.insert( "Bbs.insert", vo );
				
		return ( result > 0 )? true: false;
	}
	
	public  BbsVO searchById( String idx ) {
		
		BbsVO vo =  ss.selectOne( "Bbs.searchById", idx );
		
		return vo;
	}
	
	public  int updateHitCount( String idx, String count ) {
		// idx -> 게시물 번호
		// count 조회수
		int rval = 0;
		
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put( "no", idx );
		map.put( "count", count );
		
		rval = ss.update( "Bbs.updateHitCount", map );
		
		return rval;
	}
	
	public  boolean insertComment( CommentVO vo ) {
		boolean value = false;
		
		
		int count = ss.insert( "comment.insert", vo );
		
		value = ( count > 0 );
		
		return value;
	}
	
	public  boolean editBbs( String title,  String content, String fname, String oname, String ipAddress, String b_idx ) {
		boolean rval = false;
		
		Map<String, String> map = new HashMap<String, String>();
		if( title != null ) map.put( "subject", title );
		if( content != null ) map.put( "content", content );
		if( fname != null ) map.put( "fname", fname );
		if( oname != null ) map.put( "fname", fname );
		if( ipAddress != null ) map.put( "ip", ipAddress );
		if( b_idx != null ) map.put( "b_idx", b_idx );
		
		int result = ss.update( "Bbs.updateBbs", map );
				
		rval = ( result > 0 );
		
		return rval;
	}
	
	public  boolean deleteBbs( String idx ) {
		boolean rval = false;
		
		int result = ss.update( "Bbs.deleteBbs", idx );
		
		rval = ( result > 0 );
		
		return rval;
	}
	
}