package co.edu.memo;

import java.io.Serializable;

public class Memo implements Serializable {

	private int no; // 메모번호.
	private String date; // 메모작성날짜.
	private String content; // 메모내용.

	public Memo(int no, String date, String content) {
		this.no = no;
		this.date = date;
		this.content = content;
	}

	// getter, setter

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "번호: " + no + ", 작성날짜: " + date + ", 내용: " + content;
	}
}
