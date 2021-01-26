package student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentUI2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StudentConsolUtil util = new StudentConsolUtil();
		List<Student> list = new ArrayList<Student>();
		Student stu = null;
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
					System.out.println("---- 새로운 학생 정보 입력 -----");
					System.out.print("학 번 : ");
					int no = sc.nextInt();
					System.out.print("이 름 : ");
					String name = sc.next();
					System.out.print("학 년 : ");
					int classLevel  = sc.nextInt();
					System.out.print("주 소 : ");
					sc.nextLine();
					String addr = sc.nextLine();
					System.out.print("생 일(예시 : 05/11) : ");
					String birthday = sc.next();
					stu = new Student(no, name, classLevel, addr, birthday);
					list.add(stu);
					System.out.println(stu.getName()+" 학생 정보가 입력되었습니다.");
					break;
				case "2" :
					System.out.println("---- 학생 정보 보기 -----");
					System.out.println("학 번     이 름    학 년   ");
					System.out.println("---------------------");
					for(Student vo:list) {
						System.out.printf("%d\t%s\t%d\n",vo.getNo(),vo.getName(),vo.getClassLevel());
					}
					break;
				case "3" :
					System.out.print("검색하고자 하는 학생의 학번을 입력하세요 : ");
					int ch = sc.nextInt();
					for(Student vo:list) {
						if(vo.getNo() == ch) {
							System.out.println("---- 학생 개별 정보 보기 -----");
							System.out.println("이릅 : "+vo.getName());
							System.out.println("학년 : "+vo.getClassLevel());
							System.out.println("주소 : "+vo.getAddr());
							System.out.println("생일 : "+vo.getBirthday());
						}
					}
					break;
				case "4" :
					System.out.println("프로그램 종료");
					isStop = true;
					break;
				default :
					System.out.println("잘못 입력하셨습니다.");
					break;
			}
			stu = null;
		}

	}

}
