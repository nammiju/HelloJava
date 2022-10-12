package co.edu.board;

public class Board {
	private int boardNum;
	private String boardTitle;
	private String boardContent;
	private String boardWriter;
	private String date;
	private int cnt;

	public Board(int boardNum, String boardTitle, String boardContent, String boardWriter, String date, int cnt) {
		this.boardNum = boardNum;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardWriter = boardWriter;
		this.date = date;
		this.cnt = cnt;
	}

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public String getBoardWriter() {
		return boardWriter;
	}

	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	@Override
	public String toString() {
		return "글번호: " + boardNum + ", 글제목: " + boardTitle //
				+ ", 글내용: " + boardTitle + ", 작성자: " + boardWriter //
				+ ", 작성일: " + date + ", 방문횟수: " + cnt;
	}

}
