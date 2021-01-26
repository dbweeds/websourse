package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InfoServlet
 */
@WebServlet("/InfoServlet")
public class InfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("utf-8");
	
	String name = request.getParameter("name");
	String id= request.getParameter("id");
	String password= request.getParameter("password");
	String gender= request.getParameter("gender");
	String job= request.getParameter("job");
	
	response.setContentType("text/html;charset=utf-8");
	PrintWriter out=response.getWriter();
	out.print("<html>\r\n"
			+ "  <head>\r\n"
			+ "    <title>내 정보</title>\r\n"
			+ "    <style>\r\n"
			+ "      .contaner {\r\n"
			+ "        background-color: rgb(218, 195, 240);\r\n"
			+ "        font-family: border;\r\n"
			+ "        margin: 0 auto;\r\n"
			+ "        border: 4px solid;\r\n"
			+ "      }\r\n"
			+ "      ul{\r\n"
			+ "          list-style-type: none;\r\n"
			+ "          border: 1px solid;\r\n"
			+ "          background-color: rgb(99, 89, 77);\r\n"
			+ "          margin: 10px;\r\n"
			+ "      }\r\n"
			+"li{color: white;}"
			+ "    </style>\r\n"
			+ "  </head>\r\n"
			+ "  <body>\r\n"
			+ "    <div class=\"contaner\">\r\n"
			+ "      <h3>내 정보</h3>\r\n"
			+ "      <ul>");
	out.print("<li>이름 : "+name+"</li>");
	out.print("<li>아이디 : "+id+"</li>");
	out.print("<li>비밀번호 : "+password+"</li>");
	out.print("<li>성별 : "+gender+"</li>");
	out.print("<li>직업 : "+job+"</li>");
	out.print("</ul>\r\n"
			+ "			    </div>\r\n"
			+ "			  </body>\r\n"
			+ "			</html>");
	
	
	
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
