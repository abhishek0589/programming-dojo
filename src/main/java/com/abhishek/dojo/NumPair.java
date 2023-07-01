package com.abhishek.dojo;
public class NumPair{
	private int num;
	private int count;
	
	public NumPair(int num, int count) {
		this.num = num;
		this.count = count;
	}
	public int getNum() {
		return num;
	}
	public int getCount() {
		return count;
	}
	@Override
	public String toString() {
		return "Pair [num=" + num + ", count=" + count + "]";
	}
}