package com.abhishek.dojo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class StreamAPI {
	public static void main(String[] args) {
		Employee e1 = new Employee("A", 30, new Project(1, "GE"));
		Employee e2 = new Employee("B", 31, new Project(1, "GE"));
		Employee e3 = new Employee("C", 35, new Project(2, "Current"));
		Employee e4 = new Employee("D", 40, new Project(2, "Current"));
		Employee e5 = new Employee("E", 22, new Project(3, "Dejavu"));
		Employee e6 = new Employee("F", 45, new Project(3, "Dejavu"));
		Employee e7 = new Employee("G", 55, new Project(4, "Simon"));
		Employee e8 = new Employee("G", 55, new Project(4, "Simon"));
		
		Comparator<Integer> ascSort = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		};
		
		Comparator<Integer> descSort = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return -o1.compareTo(o2);
			}
		};
		
		Comparator<Integer> ascSort8 = (o1, o2) -> o1.compareTo(o2);
		Comparator<Integer> descSort8 = (o1, o2) -> -o1.compareTo(o2);
		
		
		List<Employee> emps = Arrays.asList(e1, e2, e3, e4, e5, e6, e7, e8);
		System.out.println(emps.size());
		System.out.println("=========");
		
		emps.stream().forEach(System.out::println);
		System.out.println("=========");
		// sort- sort in ascending order
		emps.stream().sorted((emp1, emp2) -> (emp1.getAge() - emp2.getAge())).forEach(System.out::println);
		System.out.println("=========");
		// sort- sort in descending order
		emps.stream().sorted((emp1, emp2) -> -(emp1.getAge() - emp2.getAge())).forEach(System.out::println);
		System.out.println("=========");
		// count- all employees with age more than 40;
		System.out.println(emps.stream().filter(e -> e.getAge() >= 40).count());
		System.out.println("=========");
		// find employee with lowest age
		System.out.println(emps.stream().max((emp1, emp2) -> (emp1.getAge() - emp2.getAge())).get().getAge());
		System.out.println("=========");
		// find employee with highest age
		System.out.println(emps.stream().min((emp1, emp2) -> (emp1.getAge() - emp2.getAge())).get().getAge());
		System.out.println("=========");
		
		// predicate
		Predicate<Employee> ageGreaterThan40 = new Predicate<Employee>() {
			@Override
			public boolean test(Employee t) {
				return t.getAge() > 40;
			}
		};
		emps.stream().filter(ageGreaterThan40).collect(Collectors.toList());
		emps.stream().filter(t->t.getAge()>40).collect(Collectors.toList());

		// function
		Function<Employee, Project> getProjectsForEmployees = new Function<Employee, Project>() {
			@Override
			public Project apply(Employee t) {
				return t.getProject();
			}
		};
		List<Project> mappedProjects = emps.stream().map(getProjectsForEmployees).collect(Collectors.toList());

		// find departments of employees with age less than 35
		List<Project> projects = emps.stream().filter(emp -> emp.getAge() < 35).map(e -> e.getProject())
				.collect(Collectors.toList());

		// long hand
		HashMap<String, Integer> map = new HashMap<>();
		Consumer<Employee> buildNameVsAge = new Consumer<Employee>() {
			@Override
			public void accept(Employee employee) {
				map.put(employee.getName(), employee.getAge());
			}
		};
		emps.stream().forEach(buildNameVsAge);
		
		// short hand
		emps.stream().forEach(employee -> map.put(employee.getName(), employee.getAge()));
		
		Supplier<Employee> supplier = new Supplier<Employee>() {
			@Override
			public Employee get() {
				return new Employee("H", 65, new Project(5, "Apple"));
			}
		};

		Employee e = supplier.get();
		
		// Multiple benefits of using optional
		
		// findfirst (in example below) could have returned null without optional and that might have
		// resulted in lot of null pointer exceptions in subsequent chains

		// with options, you dont need to test whether outcome is null or not
		// orElse method takes care of what needs to be done in case no value was found matching the predicate
		// there are three variations of orElse- orElse, orElseGet, orElseThrow

		// orElse- returns the value if present else returns the default value
		// Data data = opt.orElse(DEFAULT_DATA);

		//orElseGet- returns the value as received from supplier
		// Data data = opt.orElseGet(Data::new)
		
		//orElseThrow- returns the exception from the supplier
		// Data data = opt.orElseGet(IllegalStateException::new)
		
		
		// find employee with age 55
		// long hand
		Optional<Employee> opt = emps.stream()
				.filter(emp -> emp.getAge() == 79) // returns a stream
				.findFirst(); // returns an optional

		String name = opt.isPresent() ? opt.get().getName() : "UNKNOWNN";

		//short hand
		name = emps.stream()
				.filter(emp -> emp.getAge() == 79) // returns a stream
				.findFirst() // returns an optional
				.map(Employee::getName) // map method on optional performs internal ifPresent check. If found returns the result else returns an empty optional
				.orElse("UNKNOWN");
		
		List<Integer> lst = Arrays.asList(1,3,4,5,6,7);
		BinaryOperator<Integer> accumulator = new BinaryOperator<Integer>() {
			@Override
			public Integer apply(Integer t, Integer u) {
				return t + u;
			}
		}; 
		Optional<Integer> reduce = lst.stream().reduce(accumulator);
		System.out.println("reduced");

		System.out.println(reduce.get().toString());
		
		
		List<String> strs = Arrays.asList("Abhishek", "Naresh", "Chaudhary");
		System.out.println(strs.stream().reduce((a,b) -> (a + " " + b)).get());
		
		
		
	}
}

class Employee {
	private final String name;
	private final int age;
	private final Project project;

	public Employee(String name, int age, Project project) {
		this.name = name;
		this.age = age;
		this.project = project;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public Project getProject() {
		return project;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", project=" + project + "]";
	}
}

class Project {
	private int id;
	private String name;

	public Project(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + "]";
	}
}