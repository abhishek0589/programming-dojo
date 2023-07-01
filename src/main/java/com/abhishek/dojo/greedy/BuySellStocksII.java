package com.abhishek.dojo.greedy;

//LC- 201 / 201 test cases passed.
public class BuySellStocksII {

	public static void main(String[] args) {
		BuySellStocksII b2 = new BuySellStocksII();
		int[] data = {3,3,5,0,0,3,1,4};
		b2.maxProfit(data);
	}

	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0 ){
			return 0;
		}
		int profit = 0;
		for (int i = 0; i < prices.length - 1 ; i++){
			if (prices[i+1] > prices[i]){
				// every-time price at next index is lesser than previous index, sell
				profit = profit + prices[i+1] - prices [i];
			}
		}
		return profit;
	}

}
