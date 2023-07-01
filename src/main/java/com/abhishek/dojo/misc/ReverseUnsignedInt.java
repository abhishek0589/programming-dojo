package com.abhishek.dojo.misc;

public class ReverseUnsignedInt {
    public int reverse(long x) {
        boolean isSigned = (x + "").startsWith("-")? true : false;
        String target = x + "";
        target = isSigned ? target.substring(1, target.length()): target;
        int left = 0;
        int right = target.length() - 1;
        char[] targetArr = target.toCharArray();
        while (left < right){
            char temp;
            temp = targetArr[left];
            targetArr[left] = targetArr[right];
            targetArr[right] = temp;
            left++;
            right--;            
        }
        target = new String(targetArr);
        target = isSigned ? "-" + target : target;
        return Integer.parseInt(target);
    }
    
    public static void main(String[] args) {
    	ReverseUnsignedInt r = new ReverseUnsignedInt();
    	System.out.println(r.reverse(9646324351L));
	}
}