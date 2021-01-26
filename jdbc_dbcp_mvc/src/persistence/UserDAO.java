package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import domain.UserVO;

import static persistence.JDBCUtil.*;

public class UserDAO {

	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public UserDAO(Connection con) {
		this.con = con;
	}

	// CRUD
	// insert
	public int insert(String username, int birthyear, String addr, String mobile) {
		try {
			if (con != null) {
				String sql = "insert into userTBL values(userTBL_seq.nextval,?,?,?,?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, username);
				pstmt.setInt(2, birthyear);
				pstmt.setString(3, addr);
				pstmt.setString(4, mobile);
				return pstmt.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return 0;
	}

	// Read
	// 전체조회
	public List<UserVO> getSelect() {
		List<UserVO> List = new ArrayList<UserVO>();
		try {
			if (con != null) {
				String sql = "select * from userTBL order by no desc";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					UserVO vo = new UserVO();
					vo.setNo(rs.getInt("no"));
					vo.setUsername(rs.getString("username"));
					vo.setBirthyear(rs.getInt("birthyear"));
					vo.setAddr(rs.getString("addr"));
					vo.setMobile(rs.getString("mobile"));
					List.add(vo);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return List;
	}

	// 개별조회
	public UserVO getUser(String no) {
		UserVO vo = null;
		try {
			if (con != null) {
				String sql = "select * from userTBL where no = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, Integer.parseInt(no));
				rs = pstmt.executeQuery();
				if (rs.next()) {
					vo = new UserVO();
					vo.setNo(rs.getInt("no"));
					vo.setUsername(rs.getString("username"));
					vo.setBirthyear(rs.getInt("birthyear"));
					vo.setAddr(rs.getString("addr"));
					vo.setMobile(rs.getString("mobile"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return vo;
	}

	// 삭제
	public int deleteUser(String no) {
		int result = 0;
		try {
			if (con != null) {
				String sql = "delete from userTBL where no = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, Integer.parseInt(no));
				result = pstmt.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int updateUser(UserVO vo) {
		int result = 0;
		try {
			if (con != null) {
				String sql = "update userTBL set addr = ? ,mobile = ? where no = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, vo.getAddr());
				pstmt.setString(2, vo.getMobile());
				pstmt.setInt(3, vo.getNo());
				result = pstmt.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
}
