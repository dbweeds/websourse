package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.MemberVO;
import lombok.AllArgsConstructor;
import service.MemberService;
import service.MemberServiceImpl;
@AllArgsConstructor
public class MemberModifyAction implements Action {
	String path;
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String current_password = request.getParameter("current_password");
		String new_password = request.getParameter("new_password");
		System.out.println("3");
		HttpSession session = request.getSession();
		System.out.println(session.getAttribute("login"));
		MemberVO vo=(MemberVO)session.getAttribute("login");
		MemberService service = new MemberServiceImpl();

		boolean flag = service.modifyPw(vo.getUserid(), current_password, new_password);
		if(!flag) {
			path = "view/modifyForm.jsp";
		}else {
			session.removeAttribute("login");
		}
		
		return new ActionForward(path,true);
	}

}
