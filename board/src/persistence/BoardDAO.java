package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.BoardVO;
import domain.SearchVO;

import static persistence.JDBCUtil.*;

public class BoardDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public BoardDAO(Connection con) {
		this.con = con;
	}
	
	public int insert(BoardVO vo) {
		int result = 0;
		try {
			String sql = "insert into board(bno,name,password,title,content,attach,re_ref,re_lev,re_seq) values(board_seq.nextval,?,?,?,?,?,board_seq.currval,0,0)";
			pstmt=con.prepareStatement(sql);
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
		return result;
	}
//	
//	public List<BoardVO> List(){
//		List<BoardVO> list = new ArrayList<BoardVO>();
//		try {
//			String sql = "select bno,title,name,regdate,readcont,re_lev from board order by re_ref desc,re_seq asc";
//			pstmt = con.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//			while(rs.next()) {
//				BoardVO vo = new BoardVO();
//				vo.setBno(rs.getInt("bno"));
//				vo.setTitle(rs.getString("title"));
//				vo.setRegdate(rs.getDate("regdate"));
//				vo.setName(rs.getString("name"));
//				vo.setReadcnt(rs.getInt("readcont"));
//				vo.setRe_lev(rs.getInt("re_lev"));
//				list.add(vo);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			close(pstmt);
//		}
//		return list;
//	}
	//전체 행 수 가져오기
	public int totalRows(String criteria,String keyword) {
		String sql="";
		//전체 게시물
		int totalRow=0;
		try {
			if (!criteria.isEmpty()) {
				//검색조건에 맞는 행 수 구하기
				sql="select count(*) from board where "+criteria+" like ?";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, "%"+keyword+"%");
			}else {
				sql = "select count(*) from board";
				pstmt=con.prepareStatement(sql);
			}
			rs=pstmt.executeQuery();
			if(rs.next()) {
				totalRow=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return totalRow;
	}
	
	
	
	
	public List<BoardVO> searchAll(SearchVO searchVO){
		
//		select bno,title,name,regdate,readcont,re_lev
//		from(select rownum rnum,bno,title,name,regdate,readcont,re_lev
//		     from(select bno,title,name,regdate,readcont,re_lev from board where bno>0 order by re_ref desc,re_seq asc)
//		     where rownum<=20)
//		where rnum > 10;
		
		//문자열 => String
		//StringBuffer,StringBuilder=>append()
		int start = searchVO.getPage()* searchVO.getAmount();
		int limit = (searchVO.getPage()-1)* searchVO.getAmount();
		
		StringBuilder builder = new StringBuilder();
		List<BoardVO> list = new ArrayList<BoardVO>();
		try {
			if(!searchVO.getCriteria().isEmpty()) {
				//sql = "select bno,title,name,regdate,readcont,re_lev from board where "+searchVO.getCriteria()+" like ? order by re_ref desc,re_seq asc";
				builder.append("select bno,title,name,regdate,readcont,re_lev ");
				builder.append("from(select rownum rnum,bno,title,name,regdate,readcont,re_lev ");
				builder.append("from(select bno,title,name,regdate,readcont,re_lev from board where bno>0 and "+searchVO.getCriteria()+" like ? ");
				builder.append("order by re_ref desc,re_seq asc) ");
				builder.append("where rownum <= ?) ");
				builder.append("where rnum > ?");
				pstmt = con.prepareStatement(builder.toString());
				pstmt.setString(1,"%"+searchVO.getKeyword()+"%");
				pstmt.setInt(2, start);
				pstmt.setInt(3, limit);
			}else {
				//sql = "select bno,title,name,regdate,readcont,re_lev from board order by re_ref desc,re_seq asc";
				builder.append("select bno,title,name,regdate,readcont,re_lev ");
				builder.append("from(select rownum rnum,bno,title,name,regdate,readcont,re_lev ");
				builder.append("from(select bno,title,name,regdate,readcont,re_lev from board where bno>0 order by re_ref desc,re_seq asc) ");
				builder.append("where rownum <= ?) ");
				builder.append("where rnum > ?");
				pstmt = con.prepareStatement(builder.toString());
				pstmt.setInt(1, start);
				pstmt.setInt(2, limit);
			}
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
	public BoardVO view(int bno) {
		BoardVO vo = null;
		try {
			String sql = "select bno,name,title,content,attach,re_ref,re_lev,re_seq from board where bno = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,bno);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo = new BoardVO();
				vo.setBno(rs.getInt("bno"));
				vo.setName(rs.getString("name"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setAttach(rs.getString("attach"));
				vo.setRe_ref(rs.getInt("re_ref"));
				vo.setRe_lev(rs.getInt("re_lev"));
				vo.setRe_seq(rs.getInt("re_seq"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return vo;
	}
	public int readCountUpdate(int bno){
		
		int result = 0;
		try {
			String sql = "update board set readcont = readcont+1 where bno=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,bno);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	public int modify(BoardVO vo) {
		int result = 0;
		String sql = "";
		try {
			if(vo.getAttach()!=null) {
				sql = "update board set title = ? ,content = ?, attach = ? where bno = ? and password = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, vo.getTitle());
				pstmt.setString(2, vo.getContent());
				pstmt.setString(3, vo.getAttach());
				pstmt.setInt(4, vo.getBno());
				pstmt.setString(5, vo.getPassword());				
			}else {
				sql = "update board set title = ? ,content = ? where bno = ? and password = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, vo.getTitle());
				pstmt.setString(2, vo.getContent());
				pstmt.setInt(3, vo.getBno());
				pstmt.setString(4, vo.getPassword());	
			}
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	public int remove(int bno,String password) {
		int result = 0;
		try {
			String sql="delete from board where bno = ? and password = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bno);
			pstmt.setString(2, password);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int reply(BoardVO vo) {
		int result =0;
		try {
			int re_ref = vo.getRe_ref();
			int re_seq = vo.getRe_seq();
			int re_lev = vo.getRe_lev();
			String sql = "update board set re_seq = re_seq+1 where re_ref=? and re_seq > ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, re_ref);
			pstmt.setInt(2, re_seq);
			int updateCount = pstmt.executeUpdate();
			if(updateCount>0) {
				commit(con);
			}
			close(pstmt);
			
			sql="insert into board(bno,name,password,title,content,attach,re_ref,re_lev,re_seq)"
					+ "values(board_seq.nextval,?,?,?,?,null,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getTitle());
			pstmt.setString(4, vo.getContent());
			pstmt.setInt(5, re_ref);
			pstmt.setInt(6, re_lev+1);
			pstmt.setInt(7, re_seq+1);
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
}
