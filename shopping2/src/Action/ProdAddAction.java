package Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.ProdService;
import Service.ProdServiceImpl;
import domain.ProductVO;

public class ProdAddAction implements Action {

	private String path;
		
	public ProdAddAction(String path) {
		this.path = path;
	}

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ProductVO product = new ProductVO();
		System.out.println(product.toString());
		
		product.setCategory(request.getParameter("goods_category"));
		product.setName(request.getParameter("goods_name"));
		product.setContent(request.getParameter("goods_content"));
		product.setPsize(request.getParameter("goods_size"));
		product.setColor(request.getParameter("goods_color"));
		product.setAmount(Integer.parseInt(request.getParameter("goods_amount")));
		product.setPrice(Integer.parseInt(request.getParameter("goods_price")));
		ProdService serv = new ProdServiceImpl();
		boolean flag = serv.ProdUp(product);
		if (!flag) {
			path = "product_write.jsp";
		}
		return new ActionForward(path, true);
	}

}
