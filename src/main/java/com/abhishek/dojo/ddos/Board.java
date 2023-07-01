package com.abhishek.dojo.ddos;

public class Board {

	private int x;
	private int y;
	
    public int xsize = 7;
    public int ysize = 6;
    
    private int[][] board;
    public int cellsLeft;
    public int max = 4;

    public Board() {
        xsize = 7;
        ysize = 6;

        board = new int[xsize][ysize];
        for (int i = 0; i < xsize; i++) {
            for (int j = 0; j < ysize; j++) {
                board[i][j] = 0;
                setCellsLeft(cellsLeft + 1);
            }
        }
        System.out.println(cellsLeft);
    }
    
    //methods to gain access to internal private data
    public int getCellsLeft() {
        return cellsLeft;
    }

    public int[][] getBoard() {
        return board;
    }

    public boolean matrix_equals(int a, int b, int c) {
        return board [a][b] == c;
    }

    public void setBoard(int a, int b, int temp_player) {
        board[a][b] = temp_player;
    }

    public int get_xsize() {//returns the xsize
        return xsize;
    }

    public int get_ysize() {//returns the xsize
        return ysize;
    }

    public int find_y(int x) {//checks for room in column and returns free spot.
        int y = -1;
        for (int i = 0; i < ysize; i++) {
            if (board[x][i] == 0) {
                y = i;
            }
        }
        return y;
    }

    public int changeplayer(int player, int max_players) {
        player++;
        if (player > max_players) {
            return 1;
        }
        return player;
    }

	public void setCellsLeft(int cellsLeft) {
		this.cellsLeft = cellsLeft;
	}
}