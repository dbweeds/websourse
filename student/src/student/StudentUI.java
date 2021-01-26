package student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentUI {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StudentConsolUtil util = new StudentConsolUtil();
		List<Student> list = new ArrayList<Student>();
		boolean isStop = false;
		while(!isStop) {
			System.out.println("--------- <학생 정보 관리 프로그램> ---------");
			System.out.println("          1. 학생정보 입력                ");
			System.out.println("          2. 학생정보 전체 조회            ");
			System.out.println("          3. 학생정보 개별 조회            ");
			System.out.println("          4. 프로그램 종료                ");
			System.out.print("    선택 : ");
			switch(sc.next()) {
				case "1" :
					Student stu = util.addStudent(sc);
					list.add(stu);
					list.get(0);
					util.printAddSuccessMessage(stu);
					break;
				case "2" :
					util.printStudentList(list);
					break;
				case "3" :
					util.selectStudent(sc, list);
					break;
				case "4" :
					System.out.println("프로그램 종료");
					isStop = true;
					break;
				default :
					System.out.println("잘못 입력하셨습니다.");
					break;
			}
		}

	}

}
