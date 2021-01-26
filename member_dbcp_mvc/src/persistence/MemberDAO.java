package persistence;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import domain.MemberVO;
import static persistence.JDBCUtil.*;

public class MemberDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public MemberDAO(Connection con) {
		this.con = con;
	}
	

	public MemberVO isLogin(String userid,String password) {
		MemberVO vo = null;
		try {
			String sql = "select * from member where userid = ? and password = ?";
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
				close(rs);
				close(pstmt);
			}
			return vo;
	}
	
	public boolean checkId(String userid) {
		boolean result = false;
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
			close(rs);
			close(pstmt);
		}
		return result;
	}
	public int join(String userid,String password,String name,String gender,String email) {
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
			close(pstmt);
		}
		return result;
	}
	public int modifyPw(String userid,String current_password,String new_password) {
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
			close(pstmt);
		}
		return result;
	}
	public int leave(String userid,String current_password) {
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
			close(pstmt);
		}
		return result;
	}
}
