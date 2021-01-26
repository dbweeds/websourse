package student;

import java.util.List;
import java.util.Scanner;

public class StudentConsolUtil {
	
	public Student addStudent(Scanner sc) {
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
		Student stu = new Student(no, name, classLevel, addr, birthday);
		return stu;
	}
	
	public void printAddSuccessMessage(Student stu) {
		System.out.println(stu.getName()+" 학생 정보가 입력되었습니다.");
	}
	public void printStudentList(List<Student> list) {
		System.out.println("---- 학생 정보 보기 -----");
		System.out.println("학 번     이 름    학 년   ");
		System.out.println("---------------------");
		for(Student stu:list) {
			System.out.printf("%d\t%s\t%d\n",stu.getNo(),stu.getName(),stu.getClassLevel());
		}
		
	}
	public void printSelectStudent(Student stu) {
		System.out.println("---- 학생 개별 정보 보기 -----");
		System.out.println("이릅 : "+stu.getName());
		System.out.println("학년 : "+stu.getClassLevel());
		System.out.println("주소 : "+stu.getAddr());
		System.out.println("생일 : "+stu.getBirthday());
	}
	
	public void selectStudent(Scanner sc,List<Student> list) {
		System.out.print("검색하고자 하는 학생의 학번을 입력하세요 : ");
		int no = sc.nextInt();
		for(Student stu:list) {
			if(stu.getNo() == no) {
				printSelectStudent(stu);
			}
		}
	}
}
