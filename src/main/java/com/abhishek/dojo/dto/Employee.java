package com.abhishek.dojo.dto;

import com.abhishek.dojo.lru.Department;

public final class Employee implements Comparable{
	
	public int id;
	public String name;
	public int age;
	public Department department;
	
	public Employee() {
		
	}
	
	public Employee (String name, int age, Department dep) {
		this.name = name;
		this.age = age;
		this.department = dep;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public Department getDepartment() {
		return department;
	}
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	@Override
	public int compareTo(Object o) {
		return 0;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", department=" + department + "]";
	}
	
	
}
