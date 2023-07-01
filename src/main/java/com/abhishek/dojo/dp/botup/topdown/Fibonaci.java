package com.abhishek.dojo.dp.botup.topdown;

import java.util.HashMap;
import java.util.Map;
/*

                       	fib(5)
                     /             \
               fib(4)                fib(3)*
             /      \                /     \
         fib(3)*      fib(2)*         fib(2)*    fib(1)
        /     \        /    \       /    \
  fib(2)   fib(1)  fib(1) fib(0) fib(1) fib(0)
  /    \
fib(1) fib(0)

 */

// How to identify- ?
// top down- recursion
// bottoms up- for loop from 1 to N

public class Fibonaci {

	public static void main(String[] args) {
		Fibonaci f = new Fibonaci();
		System.out.println(f.topDown(5));
		System.out.println(f.topDownMem(5, new HashMap<Integer, Integer>()));
		System.out.println("saved compute: " + f.savedCompute);
		System.out.println(f.bottomUp(5));
	}

	// Recursion — Big O(N^2) XXXXXXX- Needs to be optimized
	public int topDown(int n) {
		if (n <= 1) {
			return n;
		} 
		return topDown(n-1) + topDown(n-2);
	}

	// Memoization — O(N) — time, O(N) — space
	// in top down- compute can be saved with memoization
	int savedCompute = 0;
	public int topDownMem(int n, Map<Integer, Integer> map) {
		if (n <= 1) {
			return n;
		}
		if (map.containsKey(n)) {
			savedCompute++;
			return map.get(n);
		}
		int sum = topDownMem(n-1, map) + topDownMem(n-2, map);
		map.put(n, sum);
		return map.get(n);
	}

	// Bottoms Up — O(N) — time, O(1) — space
	public int bottomUp(int n) {
		int f[] = new int[n+1]; 
		f[0] = 0; f[1] = 1;
		for (int i = 2; i <= n; i++) {
			f[i] = f[i-1] + f [i-2];
		}
		return f[n];
	}

	// for negative numbers as well
	public static int getFibBottomUp(int num) {
		if(num == 0) return 0;
		if(num ==1 ) return 1;
		// negative case to be handled after fibo of math.abs(num) is calculated
		// dont handle negative case right away, compute fib of Math.abs of given number
		int ori = num;
		num = Math.abs(ori);
		int result[] = new int[num+1]; 
		result[0] = 0; 
		result[1] = 1;
		for (int i = 2; i <= num; i++) {
			result[i] = result[i-1] + result [i-2];
		}
		return (ori < 0 ? ori % 2 == 0 ? -1 : 1 : 1) * result[num];
	}
}
