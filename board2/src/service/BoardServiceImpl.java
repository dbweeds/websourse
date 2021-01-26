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
		boolean flag = dao.insert(vo);
		if(flag) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		
		return flag;
	}

	@Override
	public boolean updateArticle(BoardVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteArticle(int bno, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<BoardVO> searchAll() {
		List<BoardVO> list = dao.list();
		close(con);
		return list;
	}

	@Override
	public BoardVO getRow(int bno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hitUpdate(int bno) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean replyArticle(BoardVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getRows(String criteria, String keyword) {
		// TODO Auto-generated method stub
		return 0;
	}

}
