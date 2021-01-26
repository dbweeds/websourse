package domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BoardVO {
	private int bno;//글번호
	private String name;//작성자
	private String password;//비밀번호
	private String title;//글제목
	private String content;//내용
	private String attach;//파일첨부
	private int re_ref;//답젼글 작성시 참조되는 글번호
	private int re_lev;//답변글의 레벨
	private int re_seq;//답변글의 순서
	private int readcnt;//조회수
	private Date regdate;//작성날짜
	
}
