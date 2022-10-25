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
		String sql = "insert board_seq.nexval from dual";
		String sql2 = "insert into tbl_board (board_no, title, content, writer)\r\n"//
				+ "values(?, ?, ?, ?)";
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
			} else {
				return false;
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
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}
}
