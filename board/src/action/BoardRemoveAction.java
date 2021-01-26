package action;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.AllArgsConstructor;
import service.BoardService;
import service.BoardServiceImpl;
@AllArgsConstructor
public class BoardRemoveAction implements Action {
	private String path;
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int bno = Integer.parseInt(request.getParameter("bno"));
		String password = request.getParameter("password");
		
		String page = request.getParameter("page");
		String criteria = request.getParameter("criteria");
		String keyword =URLEncoder.encode(request.getParameter("keyword"),"utf-8");
		
		BoardService service = new BoardServiceImpl();
		boolean removeFlag = service.deleteArticle(bno, password);
		if(!removeFlag) {
			path = "view/qna_board_pwdCheck.jsp"+"?page="+page+"&criteria="+criteria+"&keyword="+keyword;
		}else {
			path += "?page="+page+"&criteria="+criteria+"&keyword="+keyword;
		}
		return new ActionForward(path,true);
	}

}
