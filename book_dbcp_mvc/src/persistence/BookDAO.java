package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import domain.BookVO;

import static persistence.JDBCUtil.*;

public class BookDAO {

	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public BookDAO(Connection con) {
		this.con = con;
	}
	
	public int insert(int code,String title,String writer,int price) {
		int result = 0;
		try {
			if(con != null) {
				String sql = "insert into bookTBL values(?,?,?,?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, code);
				pstmt.setString(2, title);
				pstmt.setString(3, writer);
				pstmt.setInt(4, price);
				result = pstmt.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	public List<BookVO> search(String criteria,String keyword){
		List<BookVO> list = new ArrayList<BookVO>();
		BookVO vo = null;
		try {
			String sql="select * from bookTBL where " + criteria + " = ?";
			pstmt = con.prepareStatement(sql);
			if(criteria.equals("code")) {
				pstmt.setInt(1, Integer.parseInt(keyword));
			}else {
				pstmt.setString(1, keyword);
			}
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo = new BookVO();
				vo.setCode(rs.getInt("code"));
				vo.setTitle(rs.getString("title"));
				vo.setWriter(rs.getString("writer"));
				vo.setPrice(rs.getInt("price"));
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
	public List<BookVO> bookList(){
		List<BookVO> list = new ArrayList<BookVO>();
		BookVO vo = null;
		try {
			String sql = "select * from bookTBL order by code desc";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo = new BookVO();
				vo.setCode(rs.getInt("code"));
				vo.setTitle(rs.getString("title"));
				vo.setWriter(rs.getString("writer"));
				vo.setPrice(rs.getInt("price"));
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
	
	public int delete(int code) {
		int result = 0;
		try {
			String sql = "delete from bookTBL where code=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, code);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	public int update(int code,int price) {
		int result = 0;
		try {
			String sql = "update bookTBL set price = ? where code = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, price);
			pstmt.setInt(2, code);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
}
