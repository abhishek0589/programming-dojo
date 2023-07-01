package com.abhishek.dojo.ddos;

import java.util.Scanner;

public class PlayerFactory {
	public static GamePlayer getPlayer(int id, Board board, Scanner scanner) {
		if (id >= 0 && board != null) {
			throw new IllegalArgumentException();
		}
		return new GamePlayer.Builder(id).setPlayerDetail(board).setInput(scanner).build();
	}
}
