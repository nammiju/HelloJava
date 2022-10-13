package co.edu.board;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//CRUD 기능 구현
public class BoardDAO extends DAO {
//	1. 글등록 - 글번호, 글제목, 글내용, 작성자, 작성일시, 읽은횟수(게시글 읽으면 자동증가) 
	public void create(Board bd) {
		String sql = "insert into board (board_num, board_title, board_content, board_writer)\r\n" //
				+ "values ( " + bd.getBoardNum()//
				+ ", '" + bd.getBoardTitle()//
				+ "', '" + bd.getBoardContent()//
				+ "', '" + bd.getBoardWriter() + "')";
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
				+ "set board_content = ?, "//
				+ "creation_date = sysdate "//
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
						, rs.getString("creation_date")//
						, rs.getInt("cnt")));
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
		Board getBoard = null;
		String sql = "select * from board where board_num = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, boardNum);

			rs = psmt.executeQuery();
			if (rs.next()) {
				getBoard = new Board(rs.getInt("board_num")//
						, rs.getString("board_title") //
						, rs.getString("board_content") //
						, rs.getString("board_writer") //
						, rs.getString("creation_date")//
						, rs.getInt("cnt")//
				);
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return getBoard;
	}

	// 방문횟수
	public void cnt(int bNum) {
		String sql = "update board set cnt=cnt+1 where  board_num = ?";//
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, bNum);
			psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}

	// 로그인
	public int login(String id, String pwd) {
		String sql = "select * from users where id = ?";//
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if (rs == null) {
				return -1; // 아이디가 없을때
			} else if (rs.next() && rs.getString("passwd").equals(pwd)) {
//				System.out.println("로그인 성공");
				return 0; // 아이디 비밀번호 다 일치할떄
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return -2; // 아이디는 맞고 비번은 틀릴때
	}

	// 댓글작성
	public void reply(Reply re) {
		conn = getConnect();
		String sql = "insert into reply (rep_seq, board_num, rep_content, rep_writer)\r\n"
				+ " values(reply_seq.nextval, ?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, re.getBoardNum());
			psmt.setString(2, re.getRepContent());
			psmt.setString(3, re.getRepWriter());
			int r = psmt.executeUpdate();

			System.out.println(re.getBoardNum() + "번 글에 댓글 " + r + "건이 등록되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}

	// 댓글조회
	public List<Reply> searchReply(int boardNum) {
		conn = getConnect();
		List<Reply> reply = new ArrayList<Reply>();
		String sql = "select * from reply where board_num = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, boardNum);

			rs = psmt.executeQuery();
			while (rs.next()) {
				reply.add(new Reply(rs.getInt("rep_seq")//
						, rs.getInt("board_num") //
						, rs.getString("rep_content") //
						, rs.getString("rep_writer") //
						, rs.getString("creation_date")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return reply;
	}
}
