package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import domain.ProductVO;

import static persistence.JDBCUtil.*;
public class ProductDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public ProductDAO(Connection con) {
		this.con = con;
	}
	
	public List<ProductVO> getProdList(){
		List<ProductVO> list = new ArrayList<ProductVO>();
		try {
			String sql = "select * from productTBL order by num";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductVO vo = new ProductVO();
				vo.setNum(rs.getInt("num"));
				vo.setCategory(rs.getString("category"));
				vo.setName(rs.getString("name"));
				vo.setPrice(rs.getInt("price"));
				vo.setAmount(rs.getInt("amount"));
				vo.setRegdate(rs.getDate("regdate"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return list;
	}
	
	public int insertProd(ProductVO vo) {
		int result = 0;
		try {
			String sql = "insert into productTBL values(prod_seq.nextval,?,?,?,?,?,?,?,sysdate)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getCategory());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getContent());
			pstmt.setString(4, vo.getPsize());
			pstmt.setString(5, vo.getColor());
			pstmt.setInt(6, vo.getAmount());
			pstmt.setInt(7, vo.getPrice());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
}
