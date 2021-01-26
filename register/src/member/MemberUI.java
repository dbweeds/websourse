package member;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberUI {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ch = 0;
		MemberConsoleUtil console = new MemberConsoleUtil();
		Member member = null;
		List<Member> list = new ArrayList<Member>();
		while(ch != 5) {
			System.out.println("===== 회원관리 프로그램====");
			System.out.println("1.회원등록");
			System.out.println("2.회원목록보기");
			System.out.println("3.회원정보수정");
			System.out.println("4.회원정보삭제");
			System.out.println("5.프로그램종료");
			System.out.print("메뉴번호 : ");
			ch = sc.nextInt();
			switch(ch) {
				case 1:
					member=console.getNewmember(sc);
					console.printAddSuccessMessage(member);
					list.add(member);
					break;
				case 2:
					console.printMemberList(list);
					break;
				case 3:
					member = console.getUpdateMember(sc, list);
					if(member != null) {
						console.printModifySuccessMessage(member);
						console.printMemberList(list);
					}else {
						console.printModifydFailMessage();
					}
					break;
				case 4:
					member = console.removeMember(sc, list);
					if(member ==null) {
						console.printRemoveFailMessage();
					}else {
						console.printRemoveSuccessMessage();
					}
					break;
				case 5:
					System.out.println("프로그램 종료");
					break;
				default :
					System.out.println("잘못입력하셨습니다.");
					break;
			}
			member = null;
		}
	}

}
