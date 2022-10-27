package co.edu.board;

public class PageVO {
	int totalCnt; // 전체건수.
	int pageNum; // 현재페이지.
	int startPage, endPage, totalPage; // 시작페이지, 마지막페이지, 전체페이지
	boolean prev, next;

	public PageVO(int totalCnt, int pageNum) {
		this.totalCnt = totalCnt;
		this.pageNum = pageNum;

		totalPage = (int) Math.ceil(totalCnt / 10.0); // Math.ceil: 올림해줌
		// startPage, endPage 계산.
		this.endPage = (int) Math.ceil(this.pageNum / 10.0) * 10;
		// 만약에 현재 3페이지면 나누기 3해서(0.3) 올림하면 1이고 거기에 10곱하면 마지막 페이지인 10이 나온다.
		this.startPage = this.endPage - 9;
		// endPage에 9빼면 첫페이지인 1이 나옴
		if (this.endPage > totalPage) {
			this.endPage = totalPage; 
		}

		prev = this.startPage > 10; // 이전페이지 있없 여부.
		next = this.endPage < totalPage; // 다음페이지 있없 여부.
	}

	public int getTotalCnt() {
		return totalCnt;
	}

	public int getPageNum() {
		return pageNum;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public boolean isNext() {
		return next;
	}

	@Override
	public String toString() {
		return "PageVO [totalCnt=" + totalCnt + ", pageNum=" + pageNum + ", startPage=" + startPage + ", endPage="
				+ endPage + ", totalPage=" + totalPage + ", prev=" + prev + ", next=" + next + "]";
	}

}
