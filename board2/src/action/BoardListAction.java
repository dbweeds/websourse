package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.BoardVO;
import lombok.AllArgsConstructor;
import service.BoardService;
import service.BoardServiceImpl;
@AllArgsConstructor
public class BoardListAction implements Action {
	private String path;
	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardService service = new BoardServiceImpl();
		
		List<BoardVO> list = service.searchAll();
		
		request.setAttribute("list", list);
		
		return new ActionForward(path, false);
	}

}
