package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.AllArgsConstructor;
import service.MemberService;
import service.MemberServiceImpl;

@AllArgsConstructor
public class insertAction implements Action{
	private String path;
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name = request.getParameter("name");
		System.out.println("insert_action : "+name);
		MemberService service = new MemberServiceImpl();
		service.insertMember(name);
		
		//session,            request
		//sendRedirect(true), forward(false)
		return new ActionForward(path,true);
	}
}
