package mybatis.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mybatis.vo.BbsVO;

@Component
public class BbsDAO {

	@Autowired
	private SqlSessionTemplate ss;
	
	//�� �Խù��� ���� ��ȯ
	public int getTotalCount( String bname ) {
		
		return ss.selectOne("bbs.total_count", bname);	
		
	}
	
	//��ü �Խù� - ListControl���� ȣ��
	public BbsVO[] getTotal() {
		BbsVO[] ar = null;
		
		List<BbsVO> list = ss.selectList("bbs.total");
		if(list != null && list.size() > 0) {
			ar = new BbsVO[list.size()];
			list.toArray(ar);
		}
		
		return ar;
	}
	
	//�� �������� ������ �Խù��� ��ȯ
	public BbsVO[] getList(int begin, int end, String bname) {
		BbsVO[] ar = null;
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("begin", String.valueOf( begin ));
		map.put("end", String.valueOf( end ) );
		map.put("bname", bname);
		
		List<BbsVO> list = ss.selectList("bbs.list", map);
		if(list != null && list.size() > 0) {
			ar = new BbsVO[list.size()];
			list.toArray(ar);
		}
		
		return ar;
	}
	
	//�Խñ� ����
	public int add( BbsVO vo ) {
		
		int cnt = ss.insert("bbs.add", vo );
				
		return cnt;
	}
	
	//�Խñ��� �⺻Ű�� �޾Ƽ� �ش� �Խñ� ��ȯ
	public BbsVO getBbs(String b_idx ) {
				
		return ss.selectOne("bbs.get_bbs", b_idx);
	}
	
	public int edit( BbsVO vo ) {
		return ss.update( "bbs.edit", vo );
	}
	
	public boolean updateHit( String b_idx ) {
		boolean value= false;
		int cnt = ss.update( "bbs.hit", b_idx );
		
		if( cnt > 0 ) 
			value = true;
		
		return value;
	}
	
	public int delBBS( String b_idx ) {
		return ss.update( "bbs.del", b_idx );
	}
}




