package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BookService;
import service.BookServiceImpl;

public class BookModifyAction implements Action {
	private String path;
	
	public BookModifyAction(String path) {
		this.path = path;
	}
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int code = Integer.parseInt(request.getParameter("code"));
		int price = Integer.parseInt(request.getParameter("price"));
		
		BookService service = new BookServiceImpl();
		boolean updateFlag = service.updateBook(code, price);
		if(!updateFlag) {
			path = "index.jsp?tab=modify";
		}
		return new ActionForward(path,true);
	}

}
