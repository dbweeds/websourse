package book1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BookDAO {
	public Connection getConnection() {
		// 3 커넥션
		Connection con = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle");
			con = ds.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	public int insert(int code,String title,String writer,int price) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		try {
			if(con != null) {
				String sql = "insert into bookTBL values(?,?,?,?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, code);
				pstmt.setString(2, title);
				pstmt.setString(3, writer);
				pstmt.setInt(4, price);
				return pstmt.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	public List<BookVO> search(String criteria,String keyword){
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
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
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	public List<BookVO> bookList(){
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
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
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public int delete(int code) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql = "delete from bookTBL where code=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, code);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	public int update(int code,int price) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
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
			try {
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
