package com.abhishek.dojo.collections;


public class Student implements Comparable<Student>, Cloneable{

	private int id;
	private String name;
	private Adress adress;

	public Student(final int i, final String n) {
		id = i;
		name = n;
	}

	public Student(final int i, final String n, final Adress adres) {
		id = i;
		name = n;
		this.adress = adres;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		if (this.id == ((Student)obj).getId() && this.name == ((Student)obj).getName())
			return true;
		else
			return false;
	}

	@Override
	public int compareTo(Student o) {
		int _thisInt = this.id;
		int _incomingInt = o.id;
		
		//Acsending sort
		//return ((Integer)_thisInt).compareTo((Integer)_incomingInt);
		
		//Desc sort
		return ((Integer)_incomingInt).compareTo(_thisInt);
		
//		if (this.equals(o))
//			return 0;
//		else if (this.id < o.getId())
//			return 1;
//		else
//			return -1;
	}


	@Override
	public String toString() {
		return "-----HASHCODE----------" + this.hashCode() + "-------ID--------" + this.id + "---------NAME-------------" + this.name;
	}

	public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
