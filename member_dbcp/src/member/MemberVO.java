package member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data//set,equals,default constructor, hashCode, 
@AllArgsConstructor
@NoArgsConstructor
public class MemberVO {
	private String userid;
	private String password;
	private String name;
	private String gender;
	private String email;

}
