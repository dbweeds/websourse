package student;

public class Student {
	private int no;
	private String name;
	private int classLevel;
	private String addr;
	private String birthday;
	
	public Student(int no, String name, int classLevel, String addr, String birthday) {
		super();
		this.no = no;
		this.name = name;
		this.classLevel = classLevel;
		this.addr = addr;
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "Student [no=" + no + ", name=" + name + ", classLevel=" + classLevel + ", addr=" + addr + ", birthday="
				+ birthday + "]";
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getClassLevel() {
		return classLevel;
	}
	public void setClassLevel(int classLevel) {
		this.classLevel = classLevel;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	
}