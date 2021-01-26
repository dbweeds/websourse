package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.UserVO;
import service.UserService;
import service.UserServiceImpl;

public class UserModifyAction implements Action {

	private String path;
	
	public UserModifyAction(String path) {
		this.path = path;
	}
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		UserVO vo = new UserVO();
		vo.setNo(Integer.parseInt(request.getParameter("no")));
		vo.setAddr(request.getParameter("addr"));
		vo.setMobile(request.getParameter("mobile"));
		
		UserService service = new UserServiceImpl();
		boolean updateFlag = service.updateUser(vo);
		
		if(!updateFlag) {
			path = "update.do";
		}
		return new ActionForward(path,true);
	}

}
