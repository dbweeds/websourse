package Action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.ProdService;
import Service.ProdServiceImpl;
import domain.ProductVO;

public class ProdListAction implements Action {
	private String path;
	
	public ProdListAction(String path) {
		super();
		this.path = path;
	}


	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ProdService serv = new ProdServiceImpl();
		List<ProductVO> list = serv.getList();
		
		request.setAttribute("list", list);
		
		return new ActionForward(path, false);
	}

}
