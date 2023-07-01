package com.abhishek.dojo.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.abhishek.data.util.SysoutUtil;

// https://leetcode.com/problems/prison-cells-after-n-days/solution/
// note- this solution would timeout in leetcode as cell state would re-occur after certain days
// you should be able to create the logic to idenfity cycle and not 'recompute' but 'reuse' logic

public class PrisonCellAfterNDays {

	public static void main(String[] args) {
		PrisonCellAfterNDays t = new PrisonCellAfterNDays();
		SysoutUtil.array(t.prisonAfterNDays(new int[] {1,0,0,1,0,0,1,0}, 20));
	}

	public int[] prisonAfterNDays(int[] cells, int N) {
		List<String> states = new ArrayList<>();
		int cycle = 0;
		if (cells == null || cells.length == 0 || N <= 0) return cells;
		for (int i = 0; i < N && cycle == 0; i++) { // note && condition in for loop
			cells = nextDay(cells);
			String state = Arrays.toString(cells).replaceAll("[\\[., +\\]]", "");
			cycle = !states.contains(state) && states.add(state) ? 0 : i;
		}
		if (cycle != 0) {
			String[] temp = states.get((N-1) % cycle).split("");
			cells = new int[temp.length];
			for (int i = 0; i < N && cycle == 0; i++) {
				cells[i] = Integer.parseInt(temp[i]);
			}
		}
		return cells;
	}

	private int[] nextDay(int[] cells) {
		int[] tmp = new int[cells.length];// deep copy needed
		for (int i = 1; i < cells.length - 1; i++) { 
			tmp[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
		}
		return tmp;
	}
}