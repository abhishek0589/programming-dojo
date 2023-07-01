package com.abhishek.dojo;

public class MyRunnableRunner {
	
	public static void main(String[] args) {
		
		// approach 1
		MyRunnable mr = new MyRunnable();
		Thread t = new Thread(mr);
		t.start();
		
		// approach 2
		Runnable anonymous = new Runnable() {
			@Override
			public void run() {
				System.out.println("hello world");
			}
		};
		t = new Thread(anonymous);
		t.start();
		
		//approach 3
		Runnable inline = () -> System.out.println("helllo world");
		new Thread(inline).start();
		
		//approach 4
		new Thread(() -> System.out.println("helllo world")).start();
	}
}
