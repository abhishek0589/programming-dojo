package com.abhishek.dojo.ddos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Connect4 {

	/*public static void main(String[] args) {
		Game game = new Game();
		int state = 0;
		while (state != -1) {//checks if program is in quitting stage
			switch (state) {
			case 0:
				game.play();
				if (game.hasWon()) state = 1;
				if (game.isDraw()) state = 2;
				break;
			case 1://prints end game with winner
				game.showWinner();
				if (game.hasQuit())  state = -1;
				if (game.getNewGame()) game = new Game();
				break;
			case 2://prints end game with draw game
				game.showDraw();
				if (game.hasQuit()) state = -1;
				if (game.getNewGame()) game = new Game();
				break;
			}
		}
	}*/
	
	
	public static void main(String[] args) {
		List<Player> players = new ArrayList<>();
		Board board = new Board();
		Scanner input = new Scanner(System.in);
		
		players.add(PlayerFactory.getPlayer(1, board, input));
		players.add(PlayerFactory.getPlayer(2, board, input));
		players.add(PlayerFactory.getPlayer(3, board, input));
		
		boolean gameOver = false;
		while (true) {
			for (int i = 0; i < players.size(); i++) {
				players.get(i).play();
				/*if (players.get(i).state == State.WON) {
					System.out.println("Player " + players.get(i).id + " won");
					gameOver = true;
					break;
				}*/
			}
			if (gameOver) break;
		}
	}
}
