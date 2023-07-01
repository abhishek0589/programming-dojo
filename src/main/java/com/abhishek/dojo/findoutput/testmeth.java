package com.abhishek.dojo.findoutput;

public class testmeth
{
	static int i = 1;
	public static void main(String args[])
	{
		System.out.println(i+ ",");
		m(i);
		System.out.println(i);
	}
	public static void m(int i)
	{
		i += 2;
	}
}