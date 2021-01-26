package service;

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
	@Override
	public boolean insert(ProductVO vo) {
		boolean flag = false;
		
		if(dao.insertProd(vo)>0) {
			flag = true;
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		return flag;
	}

	@Override
	public List<ProductVO> list() {
		List<ProductVO> list = dao.getProdList();
		close(con);
		return list;
	}

}
