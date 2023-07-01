package com.abhishek.concepts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class  Person {

	private String name;
	private Integer age;
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	

}

