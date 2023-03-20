package mytest;

public class Student {
	
	// 1.constructor
	public Student() {
	// default constructor
	}
	
	public Student(String sName, String sNumber, String deptName, String deptNumber) {
	    this.name = sName;
	    this.number = sNumber;
	    this.dept = new Department(deptName, deptNumber);
	}
	
	
	// 2. field
	private String name; //학생이름
	private String number; // 학번
	private Department dept; // 학과
	public static void main(String[] args) {
		Student s = new Student("홍길동", "1234", "철학과", "010-111-222");
	}
	
	
	// 3. method
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}

}
