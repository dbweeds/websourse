package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JDBCUtil {
	public static Connection getConnection() {
		// 3 커넥션
		Connection con = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle");
			con = ds.getConnection();
			con.setAutoCommit(false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public static void commit(Connection con) {
		try {
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void rollback(Connection con) {
		try {
			con.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void close(Connection con) {
		try {
			con.close();
		} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();}
		}
	public static void close(PreparedStatement pstmt) {
		try {
			pstmt.close();			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
	}
	
	public static void close(ResultSet rs) {
		try {
			rs.close();			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
	}
}

