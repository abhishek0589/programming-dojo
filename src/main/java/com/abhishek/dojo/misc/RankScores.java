package com.abhishek.dojo.misc;

/*
	You created a game that is more popular than Angry Birds.
	
	Each round, players receive a score between 0 and 100, 
	which you use to rank them from highest to lowest. 
	So far you're using an algorithm that sorts in O(n\lg{n})O(nlgn) time, 
	but players are complaining that their rankings aren't updated fast enough. 
	You need a faster sorting algorithm.

 */
public class RankScores {
	
	public static int[] sortScores(int[] unorderedScores, int highestPossibleScore) {
	    // array of 0s at indices 0..highestPossibleScore
	    int[] scoreCounts = new int[highestPossibleScore + 1];
	    // populate scoreCounts
	    for (int score : unorderedScores) {
	        scoreCounts[score]++;
	    }
	    // populate the final sorted array
	    int[] sortedScores = new int[unorderedScores.length];
	    int currentSortedIndex = 0;
	    // for each item in scoreCounts
	    for (int score = highestPossibleScore; score >= 0; score--) {
	        int count = scoreCounts[score];
	        // for the number of times the item occurs
	        for (int occurrence = 0; occurrence < count; occurrence++) {
	            // add it to the sorted array
	            sortedScores[currentSortedIndex] = score;
	            currentSortedIndex++;
	        }
	    }
	    return sortedScores;
	}

}
