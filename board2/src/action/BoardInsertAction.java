package action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.BoardVO;
import lombok.AllArgsConstructor;
import service.BoardService;
import service.BoardServiceImpl;
import util.FileUploadUtil;
@AllArgsConstructor
public class BoardInsertAction implements Action {
	private String path;
	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		FileUploadUtil utils = new FileUploadUtil();
		Map<String, String> map = utils.uploadFile(request);
		
		BoardVO vo = new BoardVO();
		vo.setName(map.get("name"));
		vo.setPassword(map.get("password"));
		vo.setTitle(map.get("title"));
		vo.setContent(map.get("content"));
		
		if(map.containsKey("attach")) {
			vo.setAttach(map.get("attach"));
		}
		
		BoardService service = new BoardServiceImpl();
		if(!service.insertArticle(vo)) {
			path = "view/qna_board_write.jsp";
		}
		
		return new ActionForward(path,true);
	}

}
