package com.abhishek.dojo.dp.botup.topdown;

/*

TOP DOWN without optimization
TOP DOWN with optimization
BOTTOM UP- row represents capacity. col represents weight. value is profit thats obtained through below formula-
dp[i][j] = Max (profits till previous weight at same capacity , 
				profit at current weight + profit till previous weight excluding currently picked up weight); 

dp[i][j] = Max (dp[i-1][j], profit[i] + dp[i-1][j-weight[i])

Given the weights and profits of ‘N’ items, we are asked to put these items in a knapsack which has a capacity ‘C’. 
The goal is to get the maximum profit from the items in the knapsack. 
Each item can only be , as we don’t have multiple quantities of any item.

Let’s take the example of Merry, who wants to carry some fruits in the knapsack to get maximum profit. 
Here are the weights and profits of the fruits:

Items: { Apple, Orange, Banana, Melon }
Weights: { 2, 3, 1, 4 }
Profits: { 4, 5, 3, 7 }
Knapsack capacity: 5

Let’s try to put different combinations of fruits in the knapsack, such that their total weight is not more than 5:

Apple + Orange (total weight 5) => 9 profit
Apple + Banana (total weight 3) => 7 profit
Orange + Banana (total weight 4) => 8 profit
Banana + Melon (total weight 5) => 10 profit

This shows that Banana + Melon is the best combination, as it gives us the maximum profit 
and the total weight does not exceed the capacity.

 */
public class Knapsack01 {

	public static void main(String[] args) {
		Knapsack01 ks = new Knapsack01();

		int[] profits = {1,5,6,8};
		int[] weights = {2,3,5,7};
		int maxProfit = ks.solveKnapsack(profits, weights, 7);
		System.out.println("Total knapsack profit ---> " + maxProfit);
		maxProfit = ks.solveKnapsack(profits, weights, 6);
		System.out.println("Total knapsack profit ---> " + maxProfit);

	}

	public int solveKnapsack(int[] profits, int[] weights, int capacity) {

		int dp[][] = new int[weights.length][capacity+1];

		// at 0th capacity nothing can be picked and hence profit is always zero
		for (int i = 0; i < weights.length; i++) {
			dp[i][0] = 0;
		}

		// capacity at with only one weight (At index 0) is always going to be smallest weight option
		for (int currentCapacity = 0; currentCapacity < capacity + 1; currentCapacity++) {
			if(weights[0] <= currentCapacity)
				dp[0][currentCapacity] = profits[0];
		}

		for (int i = 1; i < weights.length; i++) {
			for (int currentCapacity = 1; currentCapacity < capacity + 1; currentCapacity++) {
				dp[i][currentCapacity] = Math.max(dp[i - 1][currentCapacity], weights[i] <= currentCapacity ? profits[i] + dp[i - 1][currentCapacity - weights[i]] : 0);
			}
		}
		return dp[weights.length-1][capacity];
	}

}
