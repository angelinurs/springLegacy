package spring.util;

public class Paging {

	int nowPage = 1; //���� ������

	int numPerPage = 10;// �� �������� ������ �Խù� ��
	int totalCount = 0;// �� �Խù��� ��
	
	//�� ���� ������ ������ ��(������ ����)
	int pagePerBlock = 5;
	
	int totalPage = 0;// ��ü ������ ��
	
	int begin, end, startPage, endPage;
	
	boolean isPrePage; // ���� ��� ���ɿ��� ( true �϶� ������� Ȱ��ȭ ) 
	boolean isNextPage; // ���� ��� ���ɿ��� ( true �϶� ������� Ȱ��ȭ ) 
	
	// list.jsp ���� ǥ���� ����¡ HTML �ڵ带 ���� �� ��
	private StringBuffer sb;
	
	public Paging() {} // �⺻������
	public Paging(int numPerPage, int pagePerBlock) {
		this.numPerPage = numPerPage;// �� �������� ������ �Խù� ���� ����
		this.pagePerBlock = pagePerBlock;//�� ���� ������ ������ ���� ����
	}

	public Paging(int nowPage, int numPerPage, int totalCount, int pagePerBlock) {
		this.nowPage = nowPage; // ���� ������ ��
		this.numPerPage = numPerPage; // �� �������� ������ �Խù� ��
		this.totalCount = totalCount; // �� �Խù� ��
		this.pagePerBlock = pagePerBlock; // �� ���� ������ ������ ��
		
		isPrePage = false;
		isNextPage = false;
		
		// �Էµ� ��ü �Խù��� ���� ���� ��ü ������ ���� ���Ѵ�.
		totalPage = (int)Math.ceil( totalCount / numPerPage );
		
		// ���� �������� ���� ��ü �������� ������ ũ�ٸ�
		// ��ü������ ������ �����Ѵ�.
		if( nowPage > totalPage ) nowPage = totalPage;
		
		// ���� ���� ���� ������ ���� ������ ������ ���� ������
		startPage = (int)( (nowPage-1)/pagePerBlock  )*pagePerBlock+1;
		endPage = startPage + pagePerBlock -1;
		
		// ������ ������ ���� ��ü ������ ���� �Ѿ ���
		if( endPage > totalPage ) endPage = totalPage;
		
		// ���� ������ ���� ���� ���� �Խù��� ���� 
		// ���� �Խù��� ���ȣ�� ������ �Խù��� ���ȣ�� �����Ͽ�
		// ���� �������� ������ �Խù� ����� ���� �غ� ����!
		begin = ( nowPage -1 ) * numPerPage + 1;
		end = nowPage*numPerPage;
		
		// ���� ��� ���ɿ��� Ȯ��
		if( startPage > 1 ) isPrePage = true;
		// ���� ��� ���ɿ��� Ȯ��
		if( endPage < totalPage ) isNextPage = true;
		
		// ����¡ ����� ����� html �ڵ带 StringBuffer ����
		sb = new StringBuffer();
		sb.append("<ol class='paging'>");
		
		if( isPrePage ) {
			sb.append( "<li><a href='list?cPage=" )
			  .append( nowPage - pagePerBlock )
			  .append( "'>&lt;</a></li>" );
		} else {
			sb.append( "<li class='disable'> &lt; </li>");
		}
		
		for( int idx = startPage; idx <= endPage; idx++ ) {
			if( idx == nowPage ) {
				sb.append( "<li class='now'>" )
				  .append(idx)
				  .append( "</li>" );
			} else {

				sb.append( "<li><a href='list?cPage=" )
				  .append( idx )
				  .append( "'>" )
				  .append( idx )
				  .append( "</a></li>" );
			}
		}
		
		if( isNextPage ) {
			sb.append( "<li><a href='list?cPage=" )
			  .append( nowPage + pagePerBlock )
			  .append( "'>&gt;</a></li>" );
		} else {
			sb.append( "<li class='disable'> &gt; </li>");
		}
		
		sb.append( "</ol>" );
	}
	
	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) { //���� ������ �� ����
		this.nowPage = nowPage;			// begin, end, startPage, endPage���� �����ؾ� ��
		
		// ���� ������ ���� ����� �� ǥ���� �Խù����� ����Ǿ�� �Ѵ�.
		// ��, begin�� end���� ����Ǿ�� �Ѵ�.
		
		//����������(nowPage) ���� �� ������ ��(totalPage)��
		// ���� ���ϰ� ����!
		if(nowPage > totalPage)
			nowPage = totalPage;
		
		// �� �������� ���۰� ��(begin, end)�����Ѵ�.
		//   ������������ 1: begin:1, end: 10
		//   ������������ 2: begin:11, end: 20
		//   ������������ 3: begin:21, end: 30
		//   ������������ 4: begin:31, end: 40
		//   ������������ 5: begin:41, end: 50

		begin = (nowPage-1)*numPerPage+1;
		end = nowPage*numPerPage;
		
		//���������� ���� ���� ���� ���������� �� ���ϱ�
		startPage = ((nowPage-1)/pagePerBlock)*pagePerBlock+1;
		
		//����� ������ ������ �� ���ϱ�
		endPage = startPage + pagePerBlock - 1;
		
		// endPage�� �� ������ ������ �� ũ�ٸ�
		// �� ������ ������ �� ū ������ ���� ǥ�� �Ǵ°��� ���� �ʴ�.
		// ��, endPage�� totalPage���� ũ�� totalPage������ ��������!
		if(endPage > totalPage)
			endPage = totalPage;
	}

	public int getNumPerPage() {
		return numPerPage;
	}

	public void setNumPerPage(int numPerPage) {
		this.numPerPage = numPerPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) { // �� �Խù� ���� ����� ��
		this.totalCount = totalCount;
		
		//�� �Խù� ���� ����Ǹ� �� ������ ���� ����Ǿ�� �Ѵ�.
		totalPage = (int)Math.ceil((double)totalCount/numPerPage);
	}

	public int getPagePerBlock() {
		return pagePerBlock;
	}

	public void setPagePerBlock(int pagePerBlock) {
		this.pagePerBlock = pagePerBlock;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getBegin() {
		return begin;
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	
	public StringBuffer getSb() {
		return sb;
	}
	
}
