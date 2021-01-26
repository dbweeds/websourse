package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import domain.BoardVO;
import static persistence.JDBCUtil.*;
public class BoardDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public BoardDAO(Connection con) {
		this.con = con;
	}
	
	public boolean insert(BoardVO vo) {
		int result = 0;
		try {
			String sql = "insert into board values(board_seq.nextval,?,?,?,?,?,board_seq.currval,0,0)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getTitle());
			pstmt.setString(4, vo.getContent());
			pstmt.setString(5, vo.getAttach());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result>0?true:false;
	}
	public List<BoardVO> list(){
		List<BoardVO> list = new ArrayList<>();
		try {
			String sql = "select * from board";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setBno(rs.getInt("bno"));
				vo.setTitle(rs.getString("title"));
				vo.setRegdate(rs.getDate("regdate"));
				vo.setName(rs.getString("name"));
				vo.setReadcnt(rs.getInt("readcont"));
				vo.setRe_lev(rs.getInt("re_lev"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	
}
