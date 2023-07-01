package com.abhishek.dojo.lru;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import com.abhishek.dojo.dto.Employee;

public class ExternalRunner {
	
	public static void main(String[] args) {
		
		HashMap<String, String> test = new HashMap<String, String>();
		int hashCode = "test".hashCode();
		System.out.println(hashCode);
		test.put("AaAa", "Ankit");
		test.put("BBBB", "Ankit1");
		test.put("test2", "Ankit2");
		test.put("test3", "Ankit3");
		
		Department d1 =  new Department();
		
		Employee e1 = new Employee("Abhishek1", 30, d1);
		Employee e2 = new Employee("Abhishek2", 30, d1);
		Employee e3 = new Employee("Abhishek3", 30, d1);
		Employee e4 = new Employee("Abhishek4", 30, d1);
		Employee e5 = new Employee("Abhishek5", 30, d1);
		Employee e6 = new Employee("Abhishek6", 30, d1);
		Employee e7 = new Employee("Abhishek7", 30, d1);
		Employee e8 = new Employee("Abhishek8", 30, d1);
		
		LRUCache<Employee, Department> cache = LRUCache.getInstance(3);
		
		cache.put(e1, d1);
		cache.put(e2, d1);
		cache.put(e3, d1);
		cache.put(e4, d1);
		cache.put(e5, d1);
		cache.put(e6, d1);
		cache.get(e5);
		cache.put(e7, d1);
		cache.put(e8, d1);

		
		System.out.println(cache.size());
		
		Set<Entry<Employee, Department>> entrySet = cache.entrySet();
		
		for (Iterator<Entry<Employee, Department>> iterator = entrySet.iterator(); iterator.hasNext();) {
			Entry<Employee, Department> entry = iterator.next();
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
		
	}

}
