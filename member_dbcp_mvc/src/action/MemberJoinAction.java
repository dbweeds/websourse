package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberService;
import service.MemberServiceImpl;

public class MemberJoinAction implements Action {
	private String path;
	
	public MemberJoinAction(String path) {
		this.path = path;
	}
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		System.out.println(gender);
		MemberService service = new MemberServiceImpl();
		boolean flag = service.join(userid, password, name, gender, email);
		if(!flag) {
			path = "index.jsp";
		}
		System.out.println("MemberJoinAction");
		return new ActionForward(path,true);
	}

}
