package action;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.BoardVO;
import domain.SearchVO;
import service.BoardService;
import service.BoardServiceImpl;

public class BoardViewAction implements Action {
	private String path;
	public BoardViewAction(String path) {
		this.path = path;
	}
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		SearchVO searchVO = new SearchVO();
		searchVO.setPage(Integer.parseInt(request.getParameter("page")));
		searchVO.setCriteria(request.getParameter("criteria"));
		searchVO.setKeyword(request.getParameter("keyword"));
		
		
		BoardService service = new BoardServiceImpl();
		BoardVO vo=service.getRow(bno);
		request.setAttribute("vo", vo);
		request.setAttribute("searchVO", searchVO);
		
		return new ActionForward(path,false);
	}

}
