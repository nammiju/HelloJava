package co.edu.board;
// 내용만 담는 클래스 
public class Board {
	private int boardNo; // 필드만 정의해주면 자동으로 매서드 생성할 수 있음.
	private String title;
	private String content;
	
	public Board() {} // 매개변수가 없는 기본 생성자.

	public Board(int boardNo, String title, String content) {
		super(); // 상속
		this.boardNo = boardNo;
		this.title = title;
		this.content = content;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() { 
		return "Board [boardNo=" + boardNo + ", title=" + title + ", content=" + content + "]";
	} 
	
	
}
