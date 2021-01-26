<%@page import="book1.BookVO"%>
<%@page import="java.util.List"%>
<%@page import="book1.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
BookDAO dao = new BookDAO();
List<BookVO> list = dao.bookList();
//scope => requwst+forword,sessoin
request.setAttribute("list", list);
pageContext.forward("../select.jsp");
%>