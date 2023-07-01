package com.abhishek.dojo.dp;

public class CoinChange {

	public static void main(String[] args) {
		CoinChange c = new CoinChange();
		System.out.println(c.coinChange(new int[] {2,3,4,5}, 16));
	}
	
	
	
	public int coinChange(int[] coins, int amount) {        
        if (amount < 1) return 0;
        return coinChange(coins, amount, new int[amount], 0);
    }

    private int coinChange(int[] coins, int rem, int[] count, int times) {
        System.out.println("times: " + times);
        if (rem < 0) 
        	return -1;
        if (rem == 0) 
        	return 0;
        if (count[rem - 1] != 0) 
        	return count[rem - 1];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
        	System.out.println("evaluating coin: " + coin + " for amount : " + rem);
            int res = coinChange(coins, rem - coin, count, ++times);
            System.out.println("result for : " + coin + " is: " + res);
            if (res >= 0 && res < min)
                min = 1 + res;
        }
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
    }
	
	
//	public int coinChange(int[] coins, int amount) {
//		// System.out.println("Start ...");
//        int minCoins = 0; int ori = amount;
//        Arrays.sort(coins);
//        for (int i = coins.length - 1; i >= 0; i--){
//            int coin = coins[i];
//            if (amount % coin == 0) {
//                return minCoins + amount / coin;
//            } else {
//                minCoins = minCoins + amount / coin;
//                amount = amount % coin;
//            }
//        }
//        return amount != 0 || minCoins == 0? coins.length > 0 ? coinChange(Arrays.copyOfRange(coins, 0, coins.length-1), ori) : -1 : minCoins;
//    }
	
}
