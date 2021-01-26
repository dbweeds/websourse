package persistence;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	
	public int insertProd(ProductVO vo) {
		int result = 0;
		
		String sql = "insert into productTBL(num, category, name, content, psize, color, amount, price, uploadDate) values(prod_seq.nextval, ?, ?, ?, ?, ?, ?, ?, sysdate)";
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, vo.getCategory());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getContent());
			pstmt.setString(4, vo.getPsize());
			pstmt.setString(5, vo.getColor());
			pstmt.setInt(6, vo.getAmount());
			pstmt.setInt(7, vo.getPrice());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public List<ProductVO> getList(){
		List<ProductVO> list = new ArrayList<>();
		
		try {
			if (con != null) {
				String sql = "select num, category, name, price, amount, uploadDate from productTBL orderby num asc";

				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					ProductVO vo = new ProductVO();
					vo.setCategory(rs.getString("category"));
					vo.setName(rs.getString("name"));
					vo.setPrice(rs.getInt("price"));
					vo.setAmount(rs.getInt("amount"));
					vo.setUploadDate(rs.getDate("uploadDate"));
					
					list.add(vo);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
}
