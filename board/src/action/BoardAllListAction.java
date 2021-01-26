package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.BoardVO;
import domain.PageVO;
import domain.SearchVO;
import lombok.AllArgsConstructor;
import service.BoardService;
import service.BoardServiceImpl;
@AllArgsConstructor
public class BoardAllListAction implements Action {
	private String path;
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//검색기능 추가
		String criteria = request.getParameter("criteria");
		String keyword = request.getParameter("keyword");
		//페이지 나누기 추가
		int page=1;
		if(request.getParameter("page")!=null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		int amount = 10;//한 페이지당 보여줄 게시물 수
		SearchVO vo = new SearchVO(criteria, keyword, page, amount);
		
		//페이지 번호에 맞는 리스트 가져오기
		BoardService service = new BoardServiceImpl();
		List<BoardVO> list=service.searchAll(vo);
		
		//전체 행 수 가져오기
		service = new BoardServiceImpl();
		int totalRow = service.getRows(criteria,keyword);
		
		PageVO info = new PageVO(totalRow,vo);
		
		
		//검색어/검색기준
		request.setAttribute("info", info);
		//검색결과
		request.setAttribute("list", list);
				
		return new ActionForward(path,false);
	}

}
