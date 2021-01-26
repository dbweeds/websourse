package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.ProductVO;
import lombok.AllArgsConstructor;
import service.ProdService;
import service.ProdServiceImpl;
@AllArgsConstructor
public class ProdAddAction implements Action {
	private String path;
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ProductVO vo = new ProductVO();
		vo.setCategory(request.getParameter("goods_category"));
		vo.setName(request.getParameter("goods_name"));
		vo.setContent(request.getParameter("goods_content"));
		vo.setPsize(request.getParameter("goods_size"));
		vo.setColor(request.getParameter("goods_color"));
		vo.setAmount(Integer.parseInt(request.getParameter("goods_amount")));
		vo.setPrice(Integer.parseInt(request.getParameter("goods_price")));
		ProdService service = new ProdServiceImpl();
		if(!service.insert(vo)) {
			path="product_write.jsp";
		}
		
		
		return new ActionForward(path,true);
	}

}
