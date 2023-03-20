package com.uni;

public class Student extends Human {
	
	// 1.constructor
	public Student() {
		
	}
 
    public Student(String name, int age, int height, int weight, String number, String major) {
		super(name, age, height, weight);
		this.number = number;
		this.major = major;

	}



	// 2.field
    private String number;
    private String major;
  

    
    // 3. method
    
	@Override
	public String printInformation() {
		//학생의 정보를 출력하는거다.
		// Human의 정보 + 학생 특유의 정보
		return super.printInformation() + " " + number + " " + major;
   	}
		
	public String getNumber() {
		return number;
	}

    public void setNumber(String number) {
		this.number = number;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
}
