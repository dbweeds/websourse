package service;

import java.util.List;

import domain.ProductVO;

public interface ProdService {
	public boolean insert(ProductVO vo);
	public List<ProductVO> list();
}
