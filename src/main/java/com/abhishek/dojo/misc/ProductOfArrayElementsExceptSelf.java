package com.abhishek.dojo.misc;

import com.abhishek.data.util.SysoutUtil;

public class ProductOfArrayElementsExceptSelf {
	
	public static void main(String[] args) {
		ProductOfArrayElementsExceptSelf p = new ProductOfArrayElementsExceptSelf();
		SysoutUtil.array(p.getProductsOfAllIntsExceptAtIndex(new int[] {3,7,9,2}));
	}
	
	  public int[] getProductsOfAllIntsExceptAtIndex(int[] intArray) {
		    if (intArray.length < 2) {
		        throw new IllegalArgumentException("Getting the product of numbers at other indices requires at least 2 numbers");
		    }
		    // we make an array with the length of the input array to
		    // hold our products
		    int[] productsOfAllIntsExceptAtIndex = new int[intArray.length];
		    // for each integer, we find the product of all the integers
		    // before it, storing the total product so far each time
		    productsOfAllIntsExceptAtIndex[0] = 1;
		    for (int i = 1; i < intArray.length; i++) {
		        productsOfAllIntsExceptAtIndex[i] = productsOfAllIntsExceptAtIndex[i-1] * intArray[i-1];
		    }
		    
		    SysoutUtil.array(productsOfAllIntsExceptAtIndex);
		    
		    // for each integer, we find the product of all the integers
		    // after it. since each index in products already has the
		    // product of all the integers before it, now we're storing
		    // the total product of all other integers
		    int productFromRight = 1;
		    for (int i = intArray.length - 2; i >= 0; i--) {
		    	productFromRight *= intArray[i+1];
		        productsOfAllIntsExceptAtIndex[i] = productsOfAllIntsExceptAtIndex[i] * productFromRight;
		    }
		    return productsOfAllIntsExceptAtIndex;
		}
}
