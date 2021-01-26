package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.AllArgsConstructor;
import service.MemberService;
import service.MemberServiceImpl;

@AllArgsConstructor
public class DeleteAction implements Action{
	private String path;
	

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name = request.getParameter("name");
		System.out.println("delete_action : "+name);
		
		MemberService service = new MemberServiceImpl();
		service.deleteMember(name);
		
		//어디로갈것인지?(~~.jsp or ~~.do) / 어떤 방식으로 갈 것인지(forward / sendRedirect)
		//ActionForward
		return new ActionForward(path,true);
	}
}
