package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FourServlet
 */
@WebServlet("/FourServlet")
public class FourServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num1=Integer.parseInt(request.getParameter("num1"));
		int num2=Integer.parseInt(request.getParameter("num2"));
		String op = request.getParameter("op");
		int value = 0;
		switch (op) {
		case "+":
			value = num1+num2;
			break;
		case "-":
			value = num1-num2;
			break;
		case "*":
			value = num1*num2;
			break;
		case "/":
			value = num1/num2;
			break;
		default:
			break;
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html><head><title>계산프로그램</title></head>");
		out.print("<body><h2>계산결과</h2>");
		out.print("<h3>"+num1+" "+ op +" "+num2+" = "+value+"</h3>");
		out.print("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
