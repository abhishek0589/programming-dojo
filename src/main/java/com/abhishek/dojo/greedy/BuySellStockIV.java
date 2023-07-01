package com.abhishek.dojo.greedy;

public class BuySellStockIV {

	// approach 1- slow
	public int maxProfit(int k, int[] prices) {
		if (prices.length == 0) {
			return 0;
		}
		int[][] T = new int[k + 1][prices.length];
		for (int i = 1; i < T.length; i++) {
			for (int j = 1; j < T[i].length; j++) {
				int maxWithTransactionAtJ = 0;
				for (int m = 0; m < j; m++) {
					maxWithTransactionAtJ = Math.max(maxWithTransactionAtJ, (prices[j] - prices[m] + T[i - 1][m]));
				}
				T[i][j] = Math.max(maxWithTransactionAtJ, T[i][j - 1]);
			}
		}
		return T[k][prices.length - 1];
	}

	//approach 2- fast
	public int maxProfit1(int k, int[] prices) {
		if (prices.length == 0) {
			return 0;
		}
		int[][] T = new int[k + 1][prices.length];
		for (int i = 1; i < T.length; i++) {
			int maxDiff = -prices[0];
			for (int j = 1; j < T[i].length; j++) {
				T[i][j] = Math.max(T[i][j-1], prices[j] + maxDiff);
				maxDiff = Math.max(maxDiff, T[i-1][j]-prices[j]);
			}
		}
		return T[k][prices.length - 1];
	}

}
