package exam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ELServlet
 */
@WebServlet("*.do")
public class ELServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		session.setAttribute("age", 25);
		
		List<LoginDTO> list = new ArrayList<LoginDTO>();
		list.add(new LoginDTO("king123","king123@"));
		list.add(new LoginDTO("king124","king124@"));
		list.add(new LoginDTO("king125","king125@"));
		list.add(new LoginDTO("king126","king126@"));
		request.setAttribute("list", list);
		
		
		
		
		LoginDTO login = new LoginDTO("hong123","hong1234@");
		request.setAttribute("login", login);
		
		
		request.setAttribute("name", request.getParameter("name"));
		RequestDispatcher rd = request.getRequestDispatcher("EL/test2.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
