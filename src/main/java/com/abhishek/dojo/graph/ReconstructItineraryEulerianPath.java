package com.abhishek.dojo.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
// EulerianPath- an Eulerian trail (or Eulerian path) is a trail in a finite graph that visits every edge exactly once
public class ReconstructItineraryEulerianPath {

	public static void main(String[] args) {
		ReconstructItineraryEulerianPath r = new ReconstructItineraryEulerianPath();
		List<String> itinerary = r.findItinerary(new String[][]{{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}});
		itinerary.forEach( x-> System.out.println(x));
	}

	Map<String, PriorityQueue<String>> targets = new HashMap<>();
	List<String> route = new LinkedList<>();

	public List<String> findItinerary(String[][] tickets) {
		for (String[] ticket : tickets) {
			targets.compute(ticket[0], (k,v) -> v == null ? new PriorityQueue<>() : v).add(ticket[1]);
		}
		visit("JFK");
		return route;
	}

	void visit(String airport) {
		while(targets.containsKey(airport) && !targets.get(airport).isEmpty())
			visit(targets.get(airport).poll());
		route.add(0, airport);
	}

}