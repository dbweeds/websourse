package service;

import java.sql.Connection;
import java.util.List;

import domain.BookVO;
import persistence.BookDAO;

import static persistence.JDBCUtil.*;

public class BookServiceImpl implements BookService {
	
	private Connection con;
	private BookDAO dao;
	
	public BookServiceImpl() {
		con = getConnection();
		dao = new BookDAO(con);
	}
	
	@Override
	public boolean insertBook(int code, String title, String writer, int price) {
		int result = dao.insert(code, title, writer, price);
		
		boolean insertFlag = false;
		if(result>0) {
			insertFlag = true;
			commit(con);
		}else {
			rollback(con);
		}
		return insertFlag;
	}

	@Override
	public boolean deleteBook(int code) {
		int result = dao.delete(code);
		
		boolean deleteFlag = false;
		if(result>0) {
			deleteFlag = true;
			commit(con);
		}else {
			rollback(con);
		}
		return deleteFlag;
	}

	@Override
	public boolean updateBook(int code, int price) {
		int result = dao.update(code, price);
		
		boolean updateFlag = false;
		if(result>0) {
			updateFlag = true;
			commit(con);
		}else {
			rollback(con);
		}
		return updateFlag;
	}

	@Override
	public List<BookVO> searchBook(String criteria, String keyword) {
		List<BookVO> search =dao.search(criteria, keyword);
		close(con);
		return search;
	}

	@Override
	public List<BookVO> listBook() {
		List<BookVO> list = dao.bookList();
		close(con);
		
		return list;
	}

}
