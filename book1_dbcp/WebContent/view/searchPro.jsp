<%@page import="book1.BookVO"%>
<%@page import="java.util.List"%>
<%@page import="book1.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String criteria = request.getParameter("criteria");
	String keyword = request.getParameter("keyword");
	
	BookDAO dao = new BookDAO();
	List<BookVO> list = dao.search(criteria, keyword);
	
	request.setAttribute("list", list);
	pageContext.forward("../searchAll.jsp");
%>