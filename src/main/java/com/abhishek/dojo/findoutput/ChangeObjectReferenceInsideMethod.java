package com.abhishek.dojo.findoutput;

public class ChangeObjectReferenceInsideMethod {

	public static void main(String[] args) {
		A a = new ChangeObjectReferenceInsideMethod().new A();
		a.setAttr(1);
		foo(a);
		System.out.println(a.attr);
	}

	public class A {
		int attr;

		public void setAttr(int a) {
			this.attr = a;
		}
	}

	public static void foo(A t) {
		t = new ChangeObjectReferenceInsideMethod().new A();
		t.setAttr(2);
		int i = 010;
	}

	// ANS- 1
	// Here even if object reference is passed to method foo ↵
	// foo is changing the reference and once foos callstack is over ↵
	// main will have original reference and not the modified reference


}
