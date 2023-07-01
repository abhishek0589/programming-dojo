package com.abhishek.dojo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import com.abhishek.dojo.dto.Employee;
import com.abhishek.dojo.lru.Department;

public class FilterMapFunctions {
	
	public static void main(String[] args) {
		HashMap<String, String> test = new HashMap<String, String>();
		int hashCode = "test".hashCode();
		System.out.println(hashCode);
		test.put("AaAa", "Ankit");
		test.put("BBBB", "Ankit1");
		test.put("test2", "Ankit2");
		test.put("test3", "Ankit3");
		
		Department d1 =  new Department(1,"A");
		Department d2 =  new Department(2, "B");

		Employee e1 = new Employee("Abhishek1", 30, d1);
		Employee e2 = new Employee("Abhishek2", 31, d2);
		Employee e3 = new Employee("Abhishek3", 32, d1);
		Employee e4 = new Employee("Abhishek4", 33, d2);
		Employee e5 = new Employee("Abhishek5", 34, d2);
		Employee e6 = new Employee("Abhishek6", 35, d2);
		Employee e7 = new Employee("Abhishek7", 36, d1);
		Employee e8 = new Employee("Abhishek8", 37, d1);
		
		Comparator<Employee> comp = (x1, x2) -> x1.age - x2.age;
		List<Employee> emp = new ArrayList<Employee>();
		emp.add(e1);
		emp.add(e2);
		emp.add(e3);
		emp.add(e4);
		emp.add(e5);
		emp.add(e6);
		emp.add(e7);
		emp.add(e8);
		//get department for employees with age more than 35
		List<Department> collect = emp.stream().filter(e -> e.age > 35).map(e->e.getDepartment()).collect(Collectors.toList());
		System.out.println(collect.size());

	}
}
