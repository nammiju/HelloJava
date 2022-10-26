package co.edu.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.board.BoardVO;
import co.edu.common.DAO;

public class BoardDAO extends DAO {
	// 입력, 조회, 수정, 삭제...

	// 입력
	public BoardVO insertBoard(BoardVO vo) {
		// 입력처리중에 에러가 발생하면.. null;
		getConnect();
		String sql = "select board_seq.nextval from dual";
		String sql2 = "insert into tbl_board (board_no, title, content, writer, image)\r\n"//
				+ "values(?, ?, ?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			int nextSeq = 0;
			if (rs.next()) {
				nextSeq = rs.getInt(1);
			}
			psmt = conn.prepareStatement(sql2);
			psmt.setInt(1, nextSeq);
			psmt.setString(2, vo.getTitle());
			psmt.setString(3, vo.getContent());
			psmt.setString(4, vo.getWriter());
			psmt.setString(5, vo.getImage());
			int r = psmt.executeUpdate();
			if (r > 0) {
				vo.setBoardNo(nextSeq);
				return vo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null; // 실패할 경우 null을 반환.

	}

	// 한건조회
	public BoardVO searchBoard(int BoardNo) { 
		getConnect();
		String sql = "select * from tbl_board where board_no = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, BoardNo);
			rs = psmt.executeQuery();
			
			while (rs.next()) {
			BoardVO board = new BoardVO();
			board.setBoardNo(rs.getInt("board_no"));
			board.setTitle(rs.getString("title"));
			board.setContent(rs.getString("content"));
			board.setWriter(rs.getString("writer"));
			board.setWriteDate(rs.getString("write_date"));
			board.setClickCnt(rs.getInt("click_cnt"));
			board.setImage(rs.getString("image"));
			
			return board;
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;

	}

	// 목록조회
	public List<BoardVO> boardList(BoardVO vo) {
		List<BoardVO> list = new ArrayList<>();
		getConnect();
		String sql = "select * from tbl_board where 1 = 1"//
				+ "and title like '%'||?||'%' "//
				+ "and content like '%'||?||'%' "//
				+ "and writer like '%'||?||'%' ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getTitle());
			psmt.setString(2, vo.getContent());
			psmt.setString(3, vo.getWriter());

			rs = psmt.executeQuery();
			while (rs.next()) {
				BoardVO board = new BoardVO();
				board.setBoardNo(rs.getInt("board_no"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setWriter(rs.getString("writer"));
				board.setWriteDate(rs.getString("write_date"));
				board.setClickCnt(rs.getInt("click_cnt"));
				board.setImage(rs.getString("image"));

				list.add(board);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 업데이트
	public boolean updateBoard(BoardVO vo) {
		// 처리건수가 1개 이상이면 true, 에러나거나 0이면(없으면) false
		getConnect();
		String sql = "update tbl_board set content = ? where board_no = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getContent());
			psmt.setInt(2, vo.getBoardNo());
			int r = psmt.executeUpdate();

			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}

	// 삭제
	public boolean deleteBoard(int BoardNo) {
		// 처리건수가 1개 이상이면 true, 에러나거나 0이면(없으면) false
		getConnect();
		String sql = "delete from tbl_board where board_no = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, BoardNo);

			int r = psmt.executeUpdate();
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}

	// 페이징. 1)전체건수를 기준으로 10개씩 1페이지 구성
	public int totalCnt() {
		getConnect();
		String sql = "select count(1) from tbl_board"; // 전체 컬럼수를 가져옴
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			if (rs.next()) {
				int cnt = rs.getInt(1); // 첫번째 값을 가져옴
				return cnt;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return 0;

	}

	// 2)검색결과 건수를 기준으로 10개씩
	public List<BoardVO> pageList(int page) {
		getConnect();
		List<BoardVO> list = new ArrayList<>();
		String sql = "select b.* "//
				+ "from ( select rownum rn, a.* "//
				+ "       from ( select * "//
				+ "              from tbl_board "//
				+ "              order by board_no desc) a "//
				+ "       where rownum <= ?) b "//
				+ "where b.rn >= ? ";
		int from = (page - 1) * 10 + 1; // ex) 1페이지는 1부터 / 2페이지는 11부터
		int to = (page * 10); // ex) 10까지 보여줌 / 20까지 보여줌
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, to);
			psmt.setInt(2, from);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				BoardVO board = new BoardVO();
				board.setBoardNo(rs.getInt("board_no"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setWriter(rs.getString("writer"));
				board.setWriteDate(rs.getString("write_date"));
				board.setClickCnt(rs.getInt("click_cnt"));
				board.setImage(rs.getString("image"));

				list.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return list;
	}
}
