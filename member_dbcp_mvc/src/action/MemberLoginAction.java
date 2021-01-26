package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.MemberVO;
import lombok.AllArgsConstructor;
import service.MemberService;
import service.MemberServiceImpl;
@AllArgsConstructor
public class MemberLoginAction implements Action {
	private String path;
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userid=request.getParameter("userid");
		String password=request.getParameter("current_password");
		
		MemberService service = new MemberServiceImpl();
		MemberVO member = service.login(userid, password);
		HttpSession session = request.getSession();
		session.setAttribute("login", member);
		System.out.println(session.getAttribute("login"));
		return new ActionForward(path, true);
	}

}
