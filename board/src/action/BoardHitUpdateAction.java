package action;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.PageVO;
import lombok.AllArgsConstructor;
import service.BoardService;
import service.BoardServiceImpl;
@AllArgsConstructor
public class BoardHitUpdateAction implements Action {
	private String path;
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		String page = request.getParameter("page");
		String criteria = request.getParameter("criteria");
		String keyword = URLEncoder.encode(request.getParameter("keyword"),"utf-8");
		
		BoardService service = new BoardServiceImpl();
		service.hitUpdate(bno);
		
		path += "?bno="+bno+"&page="+page+"&criteria="+criteria+"&keyword="+keyword;
		
		return new ActionForward(path,true);
	}

}
