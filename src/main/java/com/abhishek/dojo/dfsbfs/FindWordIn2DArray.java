package com.abhishek.dojo.dfsbfs;
/** 
 * Details-
 * 
 * 1. Data structure- 
 * 2. Logic-
 * 3. Runtime complexity-
 * 4. Space complexity-
 * 5. Leetcode URL tests-
 * 		URL- https://leetcode.com/problems/word-search/
 *   	Tests passed- 87 / 87 test cases passed.
 * 
*/	
public class FindWordIn2DArray {
	public static void main(String[] args) {
		//char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		//System.out.println(new FindWordIn2DArray().exists(board, "ABCCED"));
		// Given word = "ABCCED", return true.
		// Given word = "SEE", return true.
		// Given word = "ABCB", return false.
		char[][] board = {{'C','A','A'},{'A','A','A'},{'B','C','D'}};
		System.out.println(new FindWordIn2DArray().exists(board, "AAB"));
	}

	public boolean exists(char[][] board, String word) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == word.charAt(0)) {
					// dont do this. because in case a character comes multiple times, 
					// it may not find correct match in one shot and would return one. 
					// However we need to continue scanning for other duplicate characters
					// return checkSubsquenceWords(board, i, j, word, 0);
					//do this instead.
					if(checkSubsquenceWords(board, i, j, word, 0)) {  
						return true;
					}
				}
			}
		}
		return false;
	}

	private boolean checkSubsquenceWords(char[][] board, int i, int j, String word, int count) {
		if (count == word.length()) {
			return true;
		}
		if (i < 0 || j < 0 || i >= board.length || j >= board[i].length || board[i][j] != word.charAt(count))
			return false;
		
		char temp = board[i][j];
		board[i][j] = ' ';
		
		boolean found = checkSubsquenceWords(board, i + 1, j, word, count + 1)
				|| checkSubsquenceWords(board, i - 1, j, word, count + 1)
				|| checkSubsquenceWords(board, i, j - 1, word, count + 1)
				|| checkSubsquenceWords(board, i, j + 1, word, count + 1);
		
		board[i][j] = temp;
		return found;
	}
}
