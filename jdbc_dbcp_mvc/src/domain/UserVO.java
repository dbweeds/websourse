package domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {
	private int no;
	private String username;
	private int birthyear;
	private String addr;
	private String mobile;
	
}
