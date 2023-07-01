package com.abhishek.dojo.misc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class FindNonRepeatingElementInArray {

	public int singleNumberUsingHashMap(int[] nums) {
		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		for (int num : nums) {
			if (map.containsKey(num)) {
				map.put(num, true);
			} else {
				map.put(num, false);
			}
		}

		for (Map.Entry<Integer, Boolean> entry : map.entrySet()) {
			if (!entry.getValue()) {
				return entry.getKey();
			}
		}

		return 0;
	}

	public static void main(String[] args) {
		//System.out.println(singleNumberUsingXOR(new int[]{2,2,3,1,3}));
		String s = "papaya";
		int count = 0;
		HashSet<String> set = new HashSet<String>();	
		for (int i = 0; i < s.length(); i++){
			for (int j = i; j <= s.length(); j++){
				String word = s.substring(i, j);
				if (set.contains(word) || isPalindrome(word)) {
					set.add(word);
					System.out.println(word);
					count++;
				}
			}    
		}  
		System.out.println("count: " + count);
	}
	
	
	
	public static boolean isPalindrome(String x){
        if (x.isEmpty()){
            return false;
        }
        if (x.length() == 1){
            return true;
        }
        char[] temp = x.toCharArray();
        int l = 0;
        int r = x.length()-1;
        while(l < r) {
        	char tmp = temp[l];
        	temp[l] = temp[r];
        	temp[r] = tmp;
        	l++;
        	r--;
        }
        return x.equals(String.valueOf(temp));
     }
	// Without using extra memory
	// Makes use of XOR
	// If a number is XORed with itself, output is zero
	// XOR of Zero and a number is that number itself
	public static int singleNumberUsingXOR(int[] nums) {
		int target = nums[0];
		for (int i = 1; i < nums.length; i++) {
			target = target ^ nums[i];
		}
		return target;
	}
}
