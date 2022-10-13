package co.edu.board;

public class Reply {
	private int repNum; //
	private int boardNum;
	private String repContent;
	private String repWriter;
	private String repDate;

	public Reply(int repNum, int boardNum, String repContent, String repWriter, String repDate) {
		this.repNum = repNum;
		this.boardNum = boardNum;
		this.repContent = repContent;
		this.repWriter = repWriter;
		this.repDate = repDate;
	}

	public int getRepNum() {
		return repNum;
	}

	public void setRepNum(int repNum) {
		this.repNum = repNum;
	}

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public String getRepContent() {
		return repContent;
	}

	public void setRepContent(String repContent) {
		this.repContent = repContent;
	}

	public String getRepWriter() {
		return repWriter;
	}

	public void setRepWriter(String repWriter) {
		this.repWriter = repWriter;
	}

	public String getRepDate() {
		return repDate;
	}

	public void setRepDate(String repDate) {
		this.repDate = repDate;
	}

	@Override
	public String toString() {
		return "댓글번호: " + repNum + ", 글번호: " + boardNum + ", 댓글작성자: " + repWriter //
				+ ", 댓글내용: " + repContent + ", 댓글작성일시: " + repDate;
	}
}
