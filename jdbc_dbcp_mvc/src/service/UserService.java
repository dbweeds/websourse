package service;

import java.util.List;

import domain.UserVO;

public interface UserService {
	public boolean insertUser(String username, int birthyear, String addr, String mobile);
	public boolean updateUser(UserVO vo);
	public boolean deleteUser(String no);

	public UserVO getUser(String no);
	public List<UserVO> getUserList();
	
	
}
