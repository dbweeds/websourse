package Service;

import java.util.List;

import domain.ProductVO;

public interface ProdService {

	public boolean ProdUp(ProductVO vo);
	
	public List<ProductVO> getList();
	
}
