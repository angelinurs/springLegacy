package spring.util;

public class Paging {

	int nowPage = 1; //현재 페이지

	int numPerPage = 10;// 한 페이지당 보여질 게시물 수
	int totalCount = 0;// 총 게시물의 수
	
	//한 블럭당 보여질 페이지 수(페이지 묶음)
	int pagePerBlock = 5;
	
	int totalPage = 0;// 전체 페이지 수
	
	int begin, end, startPage, endPage;
	
	boolean isPrePage; // 이전 기능 가능여부 ( true 일때 이전기능 활성화 ) 
	boolean isNextPage; // 다음 기능 가능여부 ( true 일때 다음기능 활성화 ) 
	
	// list.jsp 에서 표현할 페이징 HTML 코드를 저장 할 곳
	private StringBuffer sb;
	
	public Paging() {} // 기본생성자
	public Paging(int numPerPage, int pagePerBlock) {
		this.numPerPage = numPerPage;// 한 페이지당 보여질 게시물 수를 변경
		this.pagePerBlock = pagePerBlock;//한 블럭당 보여질 페이지 수를 변경
	}

	public Paging(int nowPage, int numPerPage, int totalCount, int pagePerBlock) {
		this.nowPage = nowPage; // 현재 페이지 값
		this.numPerPage = numPerPage; // 한 페이지당 보여질 게시물 수
		this.totalCount = totalCount; // 총 게시물 수
		this.pagePerBlock = pagePerBlock; // 한 블럭당 보여질 페이지 수
		
		isPrePage = false;
		isNextPage = false;
		
		// 입력된 전체 게시물의 수를 통해 전체 페이지 값을 구한다.
		totalPage = (int)Math.ceil( totalCount / numPerPage );
		
		// 현재 페이지의 값이 전체 페이지의 값보다 크다면
		// 전체페이지 값으로 지정한다.
		if( nowPage > totalPage ) nowPage = totalPage;
		
		// 현재 블럭의 시작 페이지 값과 마지막 페이지 값을 구하자
		startPage = (int)( (nowPage-1)/pagePerBlock  )*pagePerBlock+1;
		endPage = startPage + pagePerBlock -1;
		
		// 마지막 페이지 값이 전체 페이지 값을 넘어갈 경우
		if( endPage > totalPage ) endPage = totalPage;
		
		// 현재 페이지 값에 의해 시작 게시물에 의해 
		// 시작 게시물의 행번호와 마지막 게시물의 행번호를 지정하여
		// 현재 페이지에 보여질 게시물 목록을 얻을 준비를 하자!
		begin = ( nowPage -1 ) * numPerPage + 1;
		end = nowPage*numPerPage;
		
		// 이전 기능 가능여부 확인
		if( startPage > 1 ) isPrePage = true;
		// 다음 기능 가능여부 확인
		if( endPage < totalPage ) isNextPage = true;
		
		// 페이징 기법에 사용할 html 코드를 StringBuffer 저장
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

	public void setNowPage(int nowPage) { //현재 페이지 값 변경
		this.nowPage = nowPage;			// begin, end, startPage, endPage값들 변경해야 함
		
		// 현재 페이지 값이 변경될 때 표현할 게시물들이 변경되어야 한다.
		// 즉, begin과 end값이 변경되어야 한다.
		
		//현재페이지(nowPage) 값이 총 페이지 값(totalPage)을
		// 넘지 못하게 하자!
		if(nowPage > totalPage)
			nowPage = totalPage;
		
		// 각 페이지의 시작과 끝(begin, end)지정한다.
		//   현재페이지가 1: begin:1, end: 10
		//   현재페이지가 2: begin:11, end: 20
		//   현재페이지가 3: begin:21, end: 30
		//   현재페이지가 4: begin:31, end: 40
		//   현재페이지가 5: begin:41, end: 50

		begin = (nowPage-1)*numPerPage+1;
		end = nowPage*numPerPage;
		
		//현재페이지 값에 의해 블럭의 시작페이지 값 구하기
		startPage = ((nowPage-1)/pagePerBlock)*pagePerBlock+1;
		
		//블록의 마지막 페이지 값 구하기
		endPage = startPage + pagePerBlock - 1;
		
		// endPage가 총 페이지 수보다 더 크다면
		// 총 페이지 수보다 더 큰 페이지 값이 표현 되는것은 맞지 않다.
		// 즉, endPage가 totalPage보다 크면 totalPage값으로 변경하자!
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

	public void setTotalCount(int totalCount) { // 총 게시물 수가 변경될 때
		this.totalCount = totalCount;
		
		//총 게시물 수가 변경되면 총 페이지 수도 변경되어야 한다.
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
