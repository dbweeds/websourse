package service;

import java.sql.Connection;

import domain.MemberVO;
import persistence.MemberDAO;

import static persistence.JDBCUtil.*;

public class MemberServiceImpl implements MemberService {
	private Connection con;
	private MemberDAO dao;
	
	public MemberServiceImpl() {
		con=getConnection();
		dao = new MemberDAO(con);
	}
	
	@Override
	public boolean join(String userid, String password, String name, String gender, String email) {
		int result = dao.join(userid, password, name, gender, email);
		boolean flag = false;
		if(result>0) {
			flag = true;
			commit(con);
		}else {
			rollback(con);
		}
		return flag;
	}

	@Override
	public boolean modifyPw(String userid, String current_password, String new_password) {
		int result = dao.modifyPw(userid, current_password, new_password);
		boolean flag = false;
		if(result>0) {
			flag = true;
			commit(con);
		}else {
			rollback(con);
		}
		return flag;
	}

	@Override
	public boolean leave(String userid, String current_password) {
		int result = dao.leave(userid, current_password);
		boolean flag = false;
		if(result>0) {
			flag = true;
			commit(con);
		}else {
			rollback(con);
		}
		return flag;
	}

	@Override
	public MemberVO login(String userid, String password) {
		MemberVO member = dao.isLogin(userid, password);
		close(con);
		return member;
	}

	@Override
	public boolean checkIdMember(String userid) {
		boolean checkid = dao.checkId(userid);
		close(con);
		return checkid;
	}

}
