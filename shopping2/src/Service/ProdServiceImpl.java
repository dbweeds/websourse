package Service;

import static persistence.JDBCUtil.getConnection;

import java.sql.Connection;
import java.util.List;
import domain.ProductVO;
import persistence.ProductDAO;
import static persistence.JDBCUtil.*;

public class ProdServiceImpl implements ProdService {
	
	private Connection con;
	private ProductDAO dao;
	
		public ProdServiceImpl() {
			con = getConnection();
			dao = new ProductDAO(con);
		}

	// insert
	@Override
	public boolean ProdUp(ProductVO vo) {
		boolean UpFlag = false;
		int result = dao.insertProd(vo);

		if (result > 0) {
			commit(con);
			UpFlag = true;
		} else {
			rollback(con);
		}
		return UpFlag;
	}

	// get List 
	@Override
	public List<ProductVO> getList() {
		List<ProductVO> list = dao.getList();
		close(con);
		
		return list;
	}

}
