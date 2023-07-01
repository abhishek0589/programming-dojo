package com.abhishek.dojo;

@FunctionalInterface
public interface TestInterface {
	public void m1();

	default void m2() {

	}

	public static void m3() {
		
	}
}
