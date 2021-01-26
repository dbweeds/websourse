package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
//	static {
//		try {
//			Class.forName("oracle.jdbc.OracleDriver");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
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

	public boolean checkId(String userid) {
		boolean result = false;
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select userid from member where userid=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = true;
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
		return result;
	}
	
	public MemberVO isLogin(String userid,String password) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVO vo = null;
		try {
			String sql = "select userid, name from member where userid = ? and password = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo = new MemberVO();
				vo.setUserid(rs.getString("userid"));
				vo.setName(rs.getString("name"));
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
		return vo;
	}
	public int join(String userid,String password,String name,String gender,String email) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql = "insert into member values(?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, password);
			pstmt.setString(3, name);
			pstmt.setString(4, gender);
			pstmt.setString(5, email);
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
	public int modifyPw(String userid,String current_password,String new_password) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql = "update member set password = ? where userid = ? and password = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, new_password);
			pstmt.setString(2, userid);
			pstmt.setString(3, current_password);
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
	public int leave(String userid,String current_password) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql = "delete from member where userid = ? and password = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, current_password);
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
}
