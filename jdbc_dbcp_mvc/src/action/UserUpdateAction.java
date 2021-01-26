package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.UserVO;
import service.UserService;
import service.UserServiceImpl;

public class UserUpdateAction implements Action {
	
	private String path;
	
	public UserUpdateAction(String path) {
		this.path = path;
	}
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String no = request.getParameter("no");
		
		UserService service =new UserServiceImpl();
		UserVO user = service.getUser(no);
		
		request.setAttribute("user", user);
		return new ActionForward(path,false);
	}

}
