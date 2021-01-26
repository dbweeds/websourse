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
public class BoardModifyAction implements Action {
	private String path;
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		FileUploadUtil utils = new FileUploadUtil();
		Map<String, String> map=utils.uploadFile(request);
		BoardVO vo = new BoardVO();
		vo.setBno(Integer.parseInt(map.get("bno")));
		vo.setTitle(map.get("title"));
		vo.setContent(map.get("content"));
		vo.setPassword(map.get("password"));
		
		if(map.containsKey("attach")) {
			vo.setAttach(map.get("attach"));
		}
		
		String page = map.get("page");
		String criteria = map.get("criteria");
		String keyword = map.get("keyword");
		
		BoardService service = new BoardServiceImpl();
		boolean modifyFlag = service.updateArticle(vo);
		
		if(!modifyFlag) {
			path = "qUpdate.do?bno="+map.get("bno")+"&page="+page+"&criteria="+criteria+"&keyword="+keyword;
		}else {
			path += "?bno="+map.get("bno")+"&page="+page+"&criteria="+criteria+"&keyword="+keyword;
		}
		
		return new ActionForward(path,true);
	}

}
