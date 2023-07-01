package com.abhishek.dojo;

import com.abhishek.dojo.dto.Employee;

class PassByValORRef {

	public static void main(String[] args) {
		Employee e1 = new Employee();
		e1.id = 1;
		Employee e2 = new Employee();
		e2.id = 2;
		System.out.println("1st employee: " + e1.id);
		System.out.println("2nd employee: " + e2.id);
		swapEmployees(e1, e2);
		System.out.println("1st employee: " + e1.id);
		System.out.println("2nd employee: " + e2.id);
	}

	static void swapEmployees(Employee e1, Employee e2) {
		Employee temp = null;
		temp = e1;
		e1 = e2;
		e2 = temp;
	}
}
