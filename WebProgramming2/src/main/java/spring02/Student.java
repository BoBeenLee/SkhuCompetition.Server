package spring02;

public class Student {
	String name;
	
	public Student(){
		this("noname");
	}
	
	public Student(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
