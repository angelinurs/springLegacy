package mybatis.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mybatis.vo.EmpVO;

@Component
public class EmpDAO {
	@Autowired
	private SqlSessionTemplate ss;
	
	public EmpVO[] search( String searchType, String searchValue ) {
		EmpVO[] ar = null;
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put( "searchType", searchType );
		map.put( "searchValue", searchValue );
		
		List<EmpVO> list =  ss.selectList( "emp.search", map );
		
		if( list != null && !list.isEmpty() ) {
			ar = new EmpVO[ list.size() ];
			list.toArray( ar );
		}
		
		return ar;
	}
}
