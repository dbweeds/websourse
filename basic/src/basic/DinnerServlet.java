package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DinnerServlet
 */
@WebServlet("/DinnerServlet")
public class DinnerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String[] dinner = request.getParameterValues("dinner");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html>"
				+ "  <head>"
				+ "    <title>오늘의 저녁</title>"
				+ "    <style>"
				+ "      .contaner {"
				+ "        background-color: blueviolet;"
				+ "        font-family: border;"
				+ "        margin: 0 auto;"
				+ "        height: 170px;"
				+ "      }"
				+ "      ul{"
				+ "          list-style-type: none;"
				+ "          background-color: burlywood;"
				+ "          margin: 10px;"
				+ "      }"
				+ "      li{  margin: 0 auto;}"
				+ "    </style>"
				+ "  </head>"
				+ "  <body>"
				+ "    <div class=\"contaner\">"
				+ "      <h3>오늘 먹을 저녁</h3>"
				+ "      <ul>");
		for(String s:dinner) {
			out.print("<li>"+s+"</li>");
		}
	
	out.print("</ul>"
			+ "				    </div>"
			+ "				  </body>"
			+ "				</html>");
	
	}
	
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
