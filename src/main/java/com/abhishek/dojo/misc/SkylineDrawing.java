package com.abhishek.dojo.misc;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

import com.abhishek.data.util.SysoutUtil;
/**
 * Given skyline of a city merge the buildings
 * Time complexity is O(nlogn), Space complexity is O(n)
 * https://leetcode.com/problems/the-skyline-problem/
 * https://leetcode.com/discuss/67091/once-for-all-explanation-with-clean-java-code-nlog-time-space
 */

// core logic- skyline is basically max point that can span across one or more buildings

 /************* build data structure ***************/
// 1. buildings with different heights- sort them in acceding order of x (o1.x - o2.x)
// 2. buildings with   same   heights- Tie situation and 3 simple tie breaker rules
// 2a.both buildings are starting    - higher building comes first (o2.height - o1.height)
// 2b. both buildings are ending     - lower building comes first (o1.height - o2.height)
// 3c. one ending and other starting - start building comes first (hence return -1 if start else 1 if end)

/************* detailed logic to keep track of highest building points **************/
// process data structure with tree-map and compute, map of height vs occurance of the height
// compute function add and increments height if building is start
// compute function decrements and deletes height if building is end
// every time previous height and last processed height in in map are different then YOU GOT A NEW MAX
// every time you get a new max, add that to result

/************* Java algos applied ***************/
// 1. prevmax and last max 
// 2. Comparators
// 3. Compute function 

public class SkylineDrawing {
	public static void main(String args[]) {
		int [][] buildings = {{1,3,4},{3,4,4},{2,6,2},{8,11,4}, {7,9,3},{10,11,2}};
		SkylineDrawing sd = new SkylineDrawing();
		List<List<Integer>> criticalPoints = sd.getSkyline(buildings);
		criticalPoints.forEach(cp -> System.out.println(cp.get(0) + " " + cp.get(1)));
	}

	public List<List<Integer>> getSkyline(int[][] buildings) {
		List<List<Integer>> result = new ArrayList<>();
		//construct building points
		BuildingPoint[] buildingPoints = BuildingPoint.getSortedBuildingPoints(buildings);
		SysoutUtil.array2d(buildingPoints);
		TreeMap<Integer, Integer> map = new TreeMap<>();
		map.put(0, 1);
		int prevMaxHeight = 0;
		for(BuildingPoint buildingPoint : buildingPoints) {
			// if start point then add and increment. Else decrement or if last value then set null (if null, key is removed from map).
			map.compute(buildingPoint.height, buildingPoint.isStart ? SkylineUtil.remap_increment : SkylineUtil.remap_decrement);
			//peek the current height after addition or removal of building x.
			int currentMaxHeight = map.lastKey();
			//if height changes from previous height then this building x becomes critical x. So add it to the result.
			if (prevMaxHeight != currentMaxHeight) {
				List<Integer> asList = Arrays.asList(buildingPoint.x, currentMaxHeight);
				result.add(asList);
				prevMaxHeight = currentMaxHeight;
			}
		}
		return result;
	}

}
