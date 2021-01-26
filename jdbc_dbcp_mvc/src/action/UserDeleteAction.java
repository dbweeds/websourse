package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;
import service.UserServiceImpl;

public class UserDeleteAction implements Action {

	private String path;
	
	public UserDeleteAction(String path) {
		this.path = path;
	}
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String no = request.getParameter("no");
		
		UserService service = new UserServiceImpl();
		boolean deleteFlag = service.deleteUser(no);
		
		if(!deleteFlag) {
			path = "select.jsp";
		}
		return new ActionForward(path,true);
	}

}
