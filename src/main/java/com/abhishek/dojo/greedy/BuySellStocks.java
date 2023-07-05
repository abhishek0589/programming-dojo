package com.abhishek.dojo.greedy;

//LC-  200 / 200 test cases passed.
public class BuySellStocks {

	// How are you ensuring that buy first and sell later happens? 
	// we traverse in forward direction and get buy price first and then get maxProfit. 
	
	public int maxProfit1(int[] prices) {
		if (prices.length < 2){
			return 0;
		}
		// to handle case of decreasing stock price. else we could have initialized buy price to some maximum value Integer.MAX_VALUE;
		int intial_buy_price = prices[0];
		//calculate initial profit
		int profit = prices[1]-prices[0];  
		for (int i = 1; i < prices.length; i++){
			int current_price = prices[i];
			// notice the sequence of below lines
			// evaluate profit and then update buy price
			profit = Math.max(current_price - intial_buy_price, profit);
			intial_buy_price = Math.min(intial_buy_price, current_price);
		}
		// no transactions if price keeps on descreasing
		return profit < 0 ? 0 : profit;
	}
	
	// buy at min price and see if you are able to maximize profit by selling at current price
	public int maxProfit(int[] prices) {
		if (prices.length < 2) return 0;
        int buy = Integer.MAX_VALUE;
        int profit = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++){
            buy = Math.min(buy, prices[i]);
            profit = Math.max(profit, prices[i] - buy);
        }
        return profit;
	}
	
	public static void main(String[] args) {
		BuySellStocks bss = new BuySellStocks();
		bss.maxProfit(new int[] { 10, 20, 30, 40, 50 }); // stock price always increasing (ans- 40)
		bss.maxProfit(new int[] { 10, 20, 30, 5, 6 }); //case 2- stock price fluctuating (ans 20)
		bss.maxProfit(new int[] { 100, 20, 30, 5, 15, 100, 120, 110 });	 // case 3- stock price fluctuating (ans-115)
		bss.maxProfit(new int[] { 100, 90, 80, 70, 60 }); // case 3- stock price decreasing all day (ans - negative 10)
	}

}
