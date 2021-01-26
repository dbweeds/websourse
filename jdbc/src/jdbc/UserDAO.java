package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
//~DAO : 데이터베이스작업을 담당하는 클래스
//jdbc : 드라이버로드, 커넥션 , crud(select, update, delete, insert)
	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		// 3 커넥션
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "javadb";
			String password = "12345";
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// CRUD
	// insert
	public int insert(String username, int birthyear, String addr, String mobile) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
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
			try {
					pstmt.close();
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return 0;
	}

	// Read
	// 전체조회
	public List<UserVO> getSelect() {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
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
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return List;
	}

	// 개별조회
	public UserVO getUser(String no) {

		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
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
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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

	// 삭제
	public int deleteUser(String no) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
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
			try {
				pstmt.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return result;
	}

	public int updateUser(UserVO vo) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
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
