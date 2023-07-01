package com.abhishek.dojo.string;

public class ReverseString {
	
	public static void main(String[] args) {
		System.out.println(reverse("helloh"));
	}
	
	public static String reverse(String s){
        char result[] = s.toCharArray();
        int left = 0;
        int right = result.length -1;
        while (left < right){
            char temp = result[left];
            result[left] = result[right];
            result[right] = temp;
            left++;
            right--;
        }     
        return new String(result);
    }
}
