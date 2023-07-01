package com.abhishek.dojo.lru;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class Department {
	
	public int id;
	public String name;
	
	public Department() {
	}
	
	public Department(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public static void main(String[] args) {
		Department d = new Department();
		List<List<Integer>> test = new ArrayList<List<Integer>>();
		ArrayList<Integer> e = new ArrayList<Integer>();
		e.add(1);
		e.add(2);
		test.add(e);
		ArrayList<Integer> e1 = new ArrayList<Integer>();
		e1.add(3);
		e1.add(4);
		test.add(e1);

		d.ClosestXdestinations(2, test, 1);
	}
	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	public  List<List<Integer>> ClosestXdestinations(int numDestinations, 
			List<List<Integer>> allLocations,
			int numDeliveries)
	{
		// WRITE YOUR CODE HERE
		Map<List<Integer>, Double> locationsVsDistance = new HashMap<List<Integer>, Double>();
		List<List<Integer>> shortedDeliveries = new ArrayList<List<Integer>>();
		TreeSet<Double> sortedDistance = new TreeSet<Double>();

		for (int location = 0; location < numDestinations; location++){
			Double distance = getSquareRoot(allLocations.get(location));
			sortedDistance.add(distance);
			locationsVsDistance.put(allLocations.get(location), distance);
		}

		for (Iterator<Double> iterator = sortedDistance.iterator(); iterator.hasNext() && numDeliveries > 0;){
			double dist =  iterator.next();
			shortedDeliveries.add(getLocationFromDistance(locationsVsDistance, dist));
			numDeliveries--;
		}
		System.out.println(shortedDeliveries);
		return shortedDeliveries;
	}

	private List<Integer> getLocationAtIndex(List<List<Integer>> allLocations, int index){
		return allLocations.get(index);
	}

	private double getSquareRoot(List<Integer> location){
		int x = location.get(0);
		int y = location.get(1);
		x *= x;
		y *= y;
		double distance = Math.sqrt(x + y);
		return distance;
	}

	private List<Integer> getLocationFromDistance(Map<List<Integer>, Double> locationsVsDistance, Double distance){
		for (List<Integer> key : locationsVsDistance.keySet()){
			Double double1 = locationsVsDistance.get(key);
			if (distance.compareTo(double1) == 0) {
				return key;
			}
		}
		return null;
	}


	List<List<Integer>> optimalUtilization(int maxTravelDist, 
			List<List<Integer>> forwardRouteList,
			List<List<Integer>> returnRouteList)
	{
		// logic- for every element in first array 
		// this logic can be optimized further by memoization
		List<List<Integer>> bestDistance = new ArrayList<List<Integer>>();
		for (int i = 0 ; i < forwardRouteList.size(); i++){
			List<Integer> froute = forwardRouteList.get(i);
			int felement = froute.get(1);
			for (int j = 0 ; j < returnRouteList.size(); i++){
				List<Integer> rroute = forwardRouteList.get(i);
				int relement = froute.get(1);
				// found best match
				if (felement + relement == maxTravelDist){
					bestDistance.add(froute);
					bestDistance.add(rroute);
				}
				// find closest match
				else{

				}
			}
		}
		return bestDistance;

	}

}
