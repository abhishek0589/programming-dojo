package com.abhishek.dojo.ddos;

import java.util.Scanner;

public class GamePlayer implements Player{

	public int id;
	public int state;
	private Board grid;
	private Scanner input;
	
	static class Builder{
		
		public int id;
		public Board grid;
		public Scanner scanner;
		
		public Builder(int id) {
			this.id = id;
		}
		
		public Builder setPlayerDetail(Board board) {
			this.grid = board;
			return this;
		}
		
		public Builder setInput(Scanner scanner) {
			this.scanner = scanner;
			return this;
		}
		
		public GamePlayer build() {
			return new GamePlayer(this);
		}
		
	}
	
	private GamePlayer(Builder builder) {
		this.id = builder.id;
		this.grid = builder.grid;
		this.input = builder.scanner;
	}

	
	@Override
	public void play() {
		display();// print out the grid
		int x = 0;// xposition is set to 0 before taking user input
		try {// tries to do get an int from the user
			x = input.nextInt();
			if (x <= 0 || x > grid.get_xsize()) {
				System.out.println("not a number between 1 and" + grid.get_xsize());
				input.nextLine();
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		evaluateMove(x);
	}

	@Override
	public void evaluateMove(int x) {
		// checks if user input is within range
		x--;
		int y = grid.find_y(x);// check for space in column. initially 6 then 5.
		if (y != -1) {
			if (setMoveAndVerifyStatus(x, y, id)) state =  State.WON;
			else if (grid.getCellsLeft() == 0)  state = State.DRAW;
		} else {
			System.out.println("collumn filled");
		}
	}

	public void display() {// prints out the matrix board
		System.out.println("player " + id + "'s turn");
		for (int i = -1; i < grid.ysize; i++) {
			for (int j = 0; j < grid.xsize; j++) {
				if (i < 0) {
					System.out.print(" " + (j + 1) + " ");
				} else {
					System.out.print("[");
					if (grid.matrix_equals(j, i, 0)) {
						System.out.print(" ]");
					} else {
						int[][] temp_matrix = grid.getBoard();
						System.out.print(temp_matrix[j][i] + "]");
					}
				}
			}
			System.out.println();
		}
	}

	public boolean setMoveAndVerifyStatus(int x, int y, int player) {// sets the found coordinate to current player
		setMove(x, y, player);
		return verifyStatus(x, y, player);
	}

	private boolean verifyStatus(int x, int y, int player) {
		return check_one(x, y, 0, 1, player) // syd
				|| check_one(x, y, -1, 1, player) // sydvest
				|| check_one(x, y, -1, 0, player) // vest
				|| check_one(x, y, 1, 1, player);// sydøst
	}

	private void setMove(int x, int y, int player) {
		System.out.println("x:" + x + ", y:" + y + ", player:" + player);
		grid.setBoard(x, y, player);
		grid.cellsLeft += -1;
	}

	private boolean check_one(int x, int y, int dx, int dy, int player) {
		System.out.println("x:" + x + ", y:" + y + ", dy: " + dy + ", player:" + player);
		int count = 0, tempx = x, tempy = y;
		while (count < grid.max && (tempx >= 0 && tempx < grid.xsize && tempy >= 0 && tempy < grid.ysize)) {
			if (!grid.matrix_equals(tempx, tempy, player)) break;
			tempx += dx;
			tempy += dy;
			count++;
		}
		tempx = x - dx;
		tempy = y - dy;
		while (count < grid.max && (tempx >= 0 && tempx < grid.xsize && tempy >= 0 && tempy < grid.ysize)) {
			if (!grid.matrix_equals(tempx, tempy, player)) break;
			tempx -= dx;
			tempy -= dy;
			count++;
		}
		return count == grid.max;
	}

	@Override
	public boolean hasWon() {
		return this.state == 1;
	}
}
