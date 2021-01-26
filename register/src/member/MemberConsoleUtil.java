package member;

import java.util.List;
import java.util.Scanner;

public class MemberConsoleUtil {
	public MemberConsoleUtil() {
		
	}
	public Member getNewmember(Scanner sc) {
		Member user = new Member();
		System.out.println("등록할 회원 정보를 입력하세요");
		System.out.print("아이디 : ");
		user.setId(sc.nextInt());
		System.out.print("이름 : ");
		user.setName(sc.next());
		System.out.print("주소 : ");
		sc.nextLine();
		user.setAddr(sc.nextLine());
		System.out.print("이메일 : ");
		user.setEmail(sc.next());
		System.out.print("국가 : ");
		user.setNation(sc.next());
		System.out.print("나이 : ");
		user.setAge(sc.nextInt());
		return user;
		
	}
	public void printAddSuccessMessage(Member user) {
		System.out.println(user.getName()+" 회원 정보 추가 성공");
	}
	public void printModifySuccessMessage(Member user) {
		System.out.println(user.getName()+" 회원 정보 수정 성공");
	}
	public void printModifydFailMessage() {
		System.out.println("회원 아이디를 확인해 주세요.");
	}
	public void printRemoveFailMessage() {
		System.out.println("회원 삭제에 실패하셨습니다.");
	}
	public void printRemoveSuccessMessage() {
		System.out.println("회원 삭제에 성공하셨습니다.");
	}
	public void printMemberList(List<Member> list) {
		System.out.println("회원아이디  이름\t주소\t이메일\t\t국가\t나이");
		for(Member m:list) {
			System.out.printf("%5d%7s%8s%18s%6s%8d\n",m.getId(),m.getName(),m.getAddr(),m.getEmail(),m.getNation(),m.getAge());
		}
	}
	public Member getUpdateMember(Scanner sc,List<Member> list) {
		Member user = null;
		System.out.print("수정할 회원의 아이디를 입력하세요 : ");
		int userid = sc.nextInt();
		for(Member m:list) {
			if(m.getId() == userid) {
				System.out.print("수정할 주소를 입력하세요 : ");
				sc.nextLine();
				m.setAddr(sc.nextLine());
				System.out.println("수정할 이메일을 입력하세요 : ");
				m.setEmail(sc.next());
				user = m;
			}
		}
		return user;
	}
	public Member removeMember(Scanner sc,List<Member> list) {
		Member user = null;
		System.out.print("삭제할 회원의 아이디를 입력하세요 : ");
		int userid = sc.nextInt();
		for(int i = 0; i < list.size(); i++) {
			user = list.get(i);
			if(user.getId()==userid) {
				System.out.print("정말로 삭제하시겠습니까? 예(1) 아니요(2) : ");
				if(sc.next().equals("1")) {
					list.remove(i);
				}
		}
	}
		return user;
	}
}
