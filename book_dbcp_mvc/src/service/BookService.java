package service;

import java.util.List;

import domain.BookVO;

public interface BookService {
	public boolean insertBook(int code,String title,String writer,int price);
	public boolean deleteBook(int code);
	public boolean updateBook(int code,int price);
	
	public List<BookVO> searchBook(String criteria,String keyword);
	public List<BookVO> listBook();
}
