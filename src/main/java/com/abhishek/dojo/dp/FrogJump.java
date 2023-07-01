package com.abhishek.dojo.dp;

public class FrogJump {

	public static void main(String[] args) {
		int[] stones = { 0, 1, 3, 5, 6, 8, 11, 14 };
		boolean result = canReachEnd(stones);
		System.out.println(result);
	}

	private static boolean canReachEnd(int[] stones) {
		// jump from 1st to 2nd stones needs to be one unit only
		if (stones[1] - stones[0] != 1) {
			return false;
		}
		int currentJumpDist = 1;
		int currentIndex = 1;
		boolean jumped = false;
		// check for sub-squent jumps
		for (int i = 1; i < stones.length - 1; i++) {
			int jumpDist = stones[i + 1] - stones[currentIndex];
			if (jumpDist == currentJumpDist) {
				jumped = true;
			}
			if (jumpDist == currentJumpDist - 1) {
				currentJumpDist -= 1;
				jumped = true;
			}

			if (jumpDist == currentJumpDist + 1) {
				currentJumpDist += 1;
				jumped = true;
			}
			if (jumped) {
				currentIndex++;
				jumped = false;
			}
		}
		return currentIndex == stones.length - 1;
	}
}