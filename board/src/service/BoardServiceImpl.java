package service;

import java.sql.Connection;
import java.util.List;

import domain.BoardVO;
import domain.SearchVO;
import persistence.BoardDAO;
import static persistence.JDBCUtil.*;
public class BoardServiceImpl implements BoardService {
	
	private BoardDAO dao;
	private Connection con;
	
	public BoardServiceImpl() {
		con = getConnection();
		dao = new BoardDAO(con);
	}
	
	@Override
	public boolean insertArticle(BoardVO vo) {
		boolean insertFlag = false;
		
		int result = dao.insert(vo);
		if(result>0) {
			commit(con);
			insertFlag = true;
		}else {
			rollback(con);
		}
		
		close(con);
		return insertFlag;
	}

	@Override
	public boolean updateArticle(BoardVO vo) {
		boolean modifyFlag = false;
		int result = dao.modify(vo);
		if(result>0) {
			commit(con);
			modifyFlag = true;
		}else {
			rollback(con);
		}
		close(con);
		return modifyFlag;
	}

	@Override
	public boolean deleteArticle(int bno,String password) {
		int result = dao.remove(bno, password);
		boolean removeFlag = false;
		if(result>0) {
			commit(con);
			removeFlag = true;
		}else {
			rollback(con);
		}
		close(con);
		return removeFlag;
	}


	@Override
	public BoardVO getRow(int bno) {
		BoardVO vo=dao.view(bno);
		close(con);
		return vo;
	}

	@Override
	public boolean hitUpdate(int bno) {
		boolean updateFlag = false;
		
		int result = dao.readCountUpdate(bno);
		
		if(result>0) {
			commit(con);
			updateFlag = true;
		}else {
			rollback(con);
		}
		close(con);
		return updateFlag;
	}

	@Override
	public boolean replyArticle(BoardVO vo) {
		boolean replyFlag = false;
		int result = dao.reply(vo);
		if(result>0) {
			commit(con);
			replyFlag = true;
		}else {
			rollback(con);
		}
		close(con);
		return replyFlag;
	}

	@Override
	public List<BoardVO> searchAll(SearchVO search) {
		List<BoardVO> list = dao.searchAll(search);
		close(con);
		return list;
	}

	@Override
	public int getRows(String criteria,String keyword) {
		int totalRow = dao.totalRows(criteria,keyword);
		close(con);
		return totalRow;
	}
	

}
