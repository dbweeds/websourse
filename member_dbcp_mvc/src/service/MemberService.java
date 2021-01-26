package service;

import domain.MemberVO;

public interface MemberService {
	public boolean join(String userid,String password,String name,String gender,String email);
	public boolean modifyPw(String userid,String current_password,String new_password);
	public boolean leave(String userid,String current_password);
	
	public MemberVO login(String userid,String password);
	
	public boolean checkIdMember(String userid);
	
}
