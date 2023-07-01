package com.abhishek.data.util;

public class CompilerPad {

	
	
	public static void main(String[] args) {
		System.out.println(getMax());
	}

	private static int getMax() {
		int [][] costs = {
				{5,8,6}, //5-0. 5
				{19,14,13},//13-2. 13
				{7,5,12},//5-1. 7
				{14,15,17},//14-0. 15
				{3,20,10}};//10-2. 3
		
		/*
		
		{5,8,6}, 
		{19,14,13},// 19+6 14+5 13+5 -> 20 19 18  
		{7,5,12},//5-1. //
		{14,15,17},//14-0. 15
		{3,20,10}};//10-2. 3
		
		*/
		
		for (int i = 1; i < costs.length; i++) {
			costs[i][0] += Math.min(costs[i-1][1],costs[i-1][2]);
			costs[i][1] += Math.min(costs[i-1][0],costs[i-1][2]);
			costs[i][2] += Math.min(costs[i-1][0],costs[i-1][1]);
		}
		int l = costs.length-1;
		return Math.min(costs[l][0], Math.min(costs[l][1], costs[l][2]));
	}


}
