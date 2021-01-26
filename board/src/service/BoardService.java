package service;

import java.util.List;

import domain.BoardVO;
import domain.SearchVO;

public interface BoardService {
	public boolean insertArticle(BoardVO vo);
	public boolean updateArticle(BoardVO vo);
	public boolean deleteArticle(int bno,String password);
	public List<BoardVO> searchAll(SearchVO search);
	public BoardVO getRow(int bno);
	
	public boolean hitUpdate(int bno);
	public boolean replyArticle(BoardVO vo);
	
	//게시글 전체 행 수
	public int getRows(String criteria,String keyword);
}
