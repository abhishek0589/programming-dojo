package com.abhishek.dojo;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LambdaForFunctionalInterfaces {

	public static void main(String[] args) {

		TestInterface ti = new TestInterface() {
			@Override
			public void m1() {
				System.out.println("hello world");
			}
		};
		
		ti.m1();

		TestInterface ti1 = () -> System.out.println("Hello Lamda");
		ti1.m1();

		Comparator<Integer> comparator = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		};

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(10, (x, y) -> (x - y));

	}
}
