package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BookService;
import service.BookServiceImpl;

public class BookInsertAction implements Action {
	private String path;
	
	public BookInsertAction(String path) {
		this.path = path;
	}
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int code = Integer.parseInt(request.getParameter("code"));
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		int price = Integer.parseInt(request.getParameter("price"));
		
		BookService service = new BookServiceImpl();
		boolean insertFlag = service.insertBook(code, title, writer, price);
		
		if(!insertFlag) {
			path = "index.jsp";
		}
		return new ActionForward(path,true);
	}

}
