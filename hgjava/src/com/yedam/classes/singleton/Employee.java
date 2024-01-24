package com.yedam.classes.singleton;
//클래스 명 바꾸고 싶을때, 우측 뷰에서 해당 클래스 좌클릭하고 F2누르면 됨. 혹은 우클릭 누르고 rename
public class Employee {
	private int employeeId; // 사번
	private String name; //이름
	private int departmentId; // 부서번호(10:인사 20:개발 30:영업)
	private String departmentName; //부서명.
	private int salary; //급여
	//기본 생성자 - 필드의 값을 초기화
	public Employee() {
		
	}
	//추가로 작성하는 생성자
	public Employee(int employeeId, String name, int salary, int departmentId) {
		this.employeeId = employeeId;
		this.name = name;
		this.salary = salary;
		this.departmentId = departmentId;
		// 인스턴스가 만들어지면, 그 인스턴스를 해당 -> this.
		if(departmentId == 10) {
			departmentName = "인사";
		}else if(departmentId == 20) {
			departmentName = "개발";
		}else {
			departmentName = "영업";
		}
	}
	
	public Employee(int employeeId, String name, int salary) {
		this(employeeId, name, salary, 30); //자기자신의 생성자 호출
	
		// getter / setter.
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	

}
