package com.yedam.collection;

import java.util.Date;
import java.util.Objects;

// empNo, empName, hireDate, salary.
public class Employee {
	private int empNo;
	private String empName;
	private Date hireDate;
	private int salary;
	
	public Employee(int empNo, String empName, Date hireDate, int salary) {
		super(); //부모 생성자 호출. Employee 클래스의 부모 : Object 클래스.
		// 이 super(); 는 있어도, 없어도 된다.
		this.empNo = empNo;
		this.empName = empName;
		this.hireDate = hireDate;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", empName=" + empName + ", hireDate=" + hireDate + ", salary=" + salary
				+ "]";
	}
	
	Date getHireDate() {
		return hireDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(empName, empNo, hireDate, salary);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(empName, other.empName) && empNo == other.empNo
				&& Objects.equals(hireDate, other.hireDate) && salary == other.salary;
	}
	
	
	
	
	
	
	
}
