package action;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.BoardVO;
import lombok.AllArgsConstructor;
import service.BoardService;
import service.BoardServiceImpl;
@AllArgsConstructor
public class BoardReplyAction implements Action {
	private String path;
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardVO vo = new BoardVO();
		int bno = Integer.parseInt(request.getParameter("bno"));
		vo.setName(request.getParameter("name"));
		vo.setTitle(request.getParameter("title"));
		vo.setContent(request.getParameter("content"));
		vo.setPassword(request.getParameter("password"));		
		vo.setRe_ref(Integer.parseInt(request.getParameter("re_ref")));
		vo.setRe_lev(Integer.parseInt(request.getParameter("re_lev")));
		vo.setRe_seq(Integer.parseInt(request.getParameter("re_seq")));
		

		String page = request.getParameter("page");
		String criteria = request.getParameter("criteria");
		String keyword = URLEncoder.encode(request.getParameter("keyword"),"utf-8");
		
		BoardService service = new BoardServiceImpl();
		boolean replyFlag = service.replyArticle(vo);
		if(!replyFlag) {
			path ="qView.do?bno="+bno+"&page="+page+"&criteria="+criteria+"&keyword="+keyword; 
		}else {
			path +="?page="+page+"&criteria="+criteria+"&keyword="+keyword; 
		}
		return new ActionForward(path,true);
	}

}
