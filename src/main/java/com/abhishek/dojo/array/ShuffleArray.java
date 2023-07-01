package com.abhishek.dojo.array;

import java.util.Random;

public class ShuffleArray {
	
	public static void main(String[] args) {
		ShuffleArray sa = new ShuffleArray(new int[] {6,3,9});
		int[] shuffle = sa.shuffle();
		for (int i = 0; i < shuffle.length; i++) {
			System.out.println(shuffle[i]);
		}
	}

    private int[] array;
    private int[] original;

    Random rand = new Random();

    private int randRange(int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    private void swapAt(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public ShuffleArray(int[] nums) {
        array = nums;
        original = nums.clone();
    }
    
    public int[] reset() {
        array = original;
        original = original.clone();
        return original;
    }
    
    public int[] shuffle() {
        for (int i = 0; i < array.length; i++) {
            swapAt(i, randRange(i, array.length));
        }
        return array;
    }
}