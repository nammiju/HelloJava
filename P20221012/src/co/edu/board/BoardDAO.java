package co.edu.board;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//CRUD 기능 구현
public class BoardDAO extends DAO {
//	1. 글등록 - 글번호, 글제목, 글내용, 작성자, 작성일시, 읽은횟수(게시글 읽으면 자동증가) 
	public void create(Board bd) {
		String sql = "insert into board (board_num, board_title, board_content, board_writer)\r\n" //
				+ "values(" + bd.getBoardNum()//
				+ ", '" + bd.getBoardTitle()//
				+ ", '" + bd.getBoardContent()//
				+ ", '" + bd.getBoardWriter() + "')";
		conn = getConnect();
		try {
			stmt = conn.createStatement();
			int r = stmt.executeUpdate(sql);
			System.out.println(bd.getBoardNum() + "번 글 " + r + "건이 등록되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

//	2. 글수정 - 글번호 넣으면 글내용 - 작성일시 자동 변경
	public void update(Board bd) {
		String sql = "update board \r\n"//
				+ "set board_content = ? "//
				+ "creation_date = sysdate"//
				+ "where board_num = ?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, bd.getBoardContent());
			psmt.setInt(2, bd.getBoardNum());

			int r = psmt.executeUpdate();
			System.out.println(bd.getBoardNum() + "번 글 " + r + "건이 수정되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

//	3. 글삭제 - 글번호
	public void delete(int boardNum) {
		String sql = "delete from board \r\n"//
				+ "where board_num = ?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, boardNum);
			psmt.executeUpdate();
			System.out.println(boardNum + "번 글이 삭제되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

//	4. 글목록보기 - 글번호, 글제목, 작성자, 작성일시
	public List<Board> search() {
		conn = getConnect();
		List<Board> list = new ArrayList<>(); // 반환하기 위한 값의 형태.
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from board");
			while (rs.next()) {
				list.add(new Board(rs.getInt("board_num") //
						, rs.getString("board_title") //
						, rs.getString("board_content") //
						, rs.getString("board_writer")//
						, rs.getString("date")//
						, rs.getInt(0)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

//	5. 상세조회 - 글번호, 글제목, 글내용, 작성자, 작성일시, 읽은횟수
	public Board getbd(int boardNum) {
		conn = getConnect();
		Board bd = null;
		String sql = "select * from board where board_num = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, boardNum);

			rs = psmt.executeQuery();
			if (rs.next()) {
				bd = new Board(rs.getInt("board_num")//
						, rs.getString("board_title") //
						, rs.getString("board_content") //
						, rs.getString("board_writer") //
						, rs.getString("date")//
						, rs.getInt("cnt")//
				);
			}
			System.out.println(boardNum + "번 글이 조회되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return bd;
	}

}
