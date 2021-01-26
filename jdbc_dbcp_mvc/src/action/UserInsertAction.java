package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;
import service.UserServiceImpl;

public class UserInsertAction implements Action {

	private String path;
	
	public UserInsertAction(String path) {
		this.path = path;
	}
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String username = request.getParameter("username");
		int birthyear= Integer.parseInt(request.getParameter("birthyear"));
		String addr = request.getParameter("addr");
		String mobile = request.getParameter("mobile");
		
		
		//service에게 일시키기
		UserService service = new UserServiceImpl();
		boolean insertFlag = service.insertUser(username, birthyear, addr, mobile);
		
		if(!insertFlag) {
			path = "add.jsp";
		}
		
		
		//작업결과에 따라 페이지 이동방식 결정 - sendRedirect(true)
		return new ActionForward(path,true);
	}

}
