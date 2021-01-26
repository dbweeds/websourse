package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lombok.AllArgsConstructor;
import service.MemberService;
import service.MemberServiceImpl;
@AllArgsConstructor
public class MemberLeaveAction implements Action {
	private String path;
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userid = request.getParameter("userid");
		String current_password = request.getParameter("current_password");
		
		MemberService service = new MemberServiceImpl();
		boolean flag = service.leave(userid, current_password);
		if(!flag) {
			path = "view/leave.jsp";
		}else {
			HttpSession session = request.getSession();
			session.removeAttribute("login");
		}
		return new ActionForward(path,true);
	}

}
