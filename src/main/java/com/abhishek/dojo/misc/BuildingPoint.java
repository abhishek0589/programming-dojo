package com.abhishek.dojo.misc;

import java.util.Arrays;

//Represents either start or end of building
public class BuildingPoint implements Comparable<BuildingPoint> {
	int x;
	boolean isStart;
	int height;

	// comparator logic- if a-b is negative then a comes before b
	// if you want comparator to put some item always before some item return negative value
	@Override
	public int compareTo(BuildingPoint o) {
		//first compare by x.
		if (this.x != o.x) {
			return this.x - o.x;
		} else {
			// both buildings are start points- consider building with higher height first hence reverse sort
			if (this.isStart && o.isStart) {
				return o.height - this.height; 
			}
			// both buildings are end points- lower height building should be picked first
			else if (!this.isStart && ! o.isStart) {
				return this.height - o.height;
			}
			//if one start and end is compared then start should appear before end
			else {
				return this.isStart ? -1 : 1; 
			}
		}
	}

	public static BuildingPoint[] getSortedBuildingPoints(int[][] buildings) {
		BuildingPoint[] buildingPoints = new BuildingPoint[buildings.length*2];
		int index = 0;
		for(int building[] : buildings) {
			buildingPoints[index] = new BuildingPoint();
			buildingPoints[index].x = building[0];
			buildingPoints[index].isStart = true;
			buildingPoints[index].height = building[2];

			buildingPoints[index + 1] = new BuildingPoint();
			buildingPoints[index + 1].x = building[1];
			buildingPoints[index + 1].isStart = false;
			buildingPoints[index + 1].height = building[2];
			index += 2;
		}
		Arrays.sort(buildingPoints);
		return buildingPoints;
	}

	@Override
	public String toString() {
		return "BuildingPoint [x=" + x + ", isStart=" + isStart + ", height=" + height + "]";
	}
}