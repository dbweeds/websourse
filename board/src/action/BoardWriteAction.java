package action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.BoardVO;
import service.BoardService;
import service.BoardServiceImpl;
import util.FileUploadUtil;

public class BoardWriteAction implements Action {
	private String path;
	
	public BoardWriteAction(String path) {
		this.path = path;
	}
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		FileUploadUtil utils = new FileUploadUtil();
		Map<String, String> map=utils.uploadFile(request);
		
		//map 에 들어있는 폼 요소들을 vO에 옮겨주기
		BoardVO vo = new BoardVO();
		vo.setName(map.get("name"));
		vo.setPassword(map.get("password"));
		vo.setTitle(map.get("title"));
		vo.setContent(map.get("content"));
		
		if(map.containsKey("attach")) {
			vo.setAttach(map.get("attach"));
		}
		//서비스 호출
		BoardService service = new BoardServiceImpl();
		boolean insertFlag = service.insertArticle(vo);
		
		if(!insertFlag) {
			path = "view/qna_board_write.jsp";
		}else {
			path += "?page=1&criteria=&keyword=";
		}
		
		return new ActionForward(path, true);
	}

}
