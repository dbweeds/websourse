package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.ProductVO;
import lombok.AllArgsConstructor;
import service.ProdService;
import service.ProdServiceImpl;
@AllArgsConstructor
public class ProdListAction implements Action {
	private String path;
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ProdService service = new ProdServiceImpl();
		List<ProductVO> list = service.list();
		
		request.setAttribute("list", list);
		return new ActionForward(path,false);
	}

}
