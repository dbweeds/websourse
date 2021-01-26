package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Action.Action;
import Action.ActionForward;

@WebServlet("*.do")
public class ProdFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String reqURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String CMD = reqURI.substring(contextPath.length());
		
		ProdActionFactory PAFactory = ProdActionFactory.getInstance();
		Action action = PAFactory.action(CMD);
		
		ActionForward AF = null;
		try {
			AF = action.excute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (AF.isRedirect()) {
			response.sendRedirect(AF.getPath());
		
		} else {
			RequestDispatcher RD = request.getRequestDispatcher(AF.getPath());
			RD.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
