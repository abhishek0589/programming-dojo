package com.abhishek.dojo.design.iterator;

/**
 * key things to remember-
 * 
 * 1. Data structure- No extra DS
 * 
 * 
 * 2. Logic- Use a constructor, hasNext and next method
 * 
 * 
 * 3. Runtime complexity- o(n)
 * 
 * 
 * 4. Space complexity- o(1)
 * 
 * 5. LC- 18 / 18 test cases passed.
 * 
 */
public class Flatten2DVector {
	
	private int[][] vector;
	private int i = 0;
	private int j = 0;

	public Flatten2DVector(int[][] vector) {
		this.vector = vector;
		caliberate(0, 0);
	}

    public boolean hasNext() {
		return i < vector.length && j < vector[i].length;
	}
	
	public int next() {
		if (hasNext()) {
			int item = vector[i][j];
			caliberate(0, 1);
			return item;
		}
		throw new IndexOutOfBoundsException();
	}
	
	public void caliberate(int incr_i, int incr_j) {
		i += incr_i; j += incr_j;
		if (i < vector.length && j < vector[i].length) return;// if within bounds, finish calibration and return
		if (i < vector.length && j == vector[i].length) 
			caliberate(1,-j); // // if not, see if i is ok and j touching bound, if so, calibrate i and j
	}
	
	public static void main(String[] args) {
		int[][] vector = new int[][] { {}, {}, { 1 }, { 2, 3 }, {}, { 4 }, {}, {}, {}, { 5 }, {}, {} }; // -> {0,1,2,3},
		Flatten2DVector f = new Flatten2DVector(vector);
		System.out.println(f.next());
		System.out.println(f.next());
		System.out.println(f.next());
		System.out.println(f.hasNext());
		System.out.println(f.hasNext());
		System.out.println(f.next());
		System.out.println(f.hasNext());
	}

}
