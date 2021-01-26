

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JoinForm
 */
@WebServlet("/JoinForm")
public class JoinForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("utf-8");
	
	String id = request.getParameter("id");
    String password = request.getParameter("password");
    String passwordcheck = request.getParameter("passwordcheck");
    String name = request.getParameter("name");
    String gender = request.getParameter("gender");
    String email = request.getParameter("email");
    
	response.setContentType("text/html;charset=utf-8");
	PrintWriter out = response.getWriter();
	out.print("<html><head><title>유저정보</title></head>");
	out.print("<body><h2>가입하신 유저의 정보</h2>");
	out.print("<ul><li>아이디 : "+id+"</li>");
	out.print("<li>비밀번호 : "+password+"</li>");
	out.print("<li>비밀번호확인 : "+passwordcheck+"</li>");
	out.print("<li>이름 : "+name+"</li>");
	out.print("<li>성별 : "+gender+"</li>");
	out.print("<li>이메일 : "+email+"</li></ul></body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
