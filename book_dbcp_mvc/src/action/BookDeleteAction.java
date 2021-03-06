package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BookService;
import service.BookServiceImpl;

public class BookDeleteAction implements Action {
	private String path;
	
	public BookDeleteAction(String path) {
		this.path = path;
	}
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int code = Integer.parseInt(request.getParameter("code"));
		
		BookService service = new BookServiceImpl();
		boolean deleteFlag = service.deleteBook(code);
		if(!deleteFlag) {
			path = "index.jsp?tab=delete";
		}
		return new ActionForward(path,true);
	}

}
