package com.abhishek.dojo.graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

import com.abhishek.data.structure.Graph;
import com.abhishek.data.structure.Vertex;

public class BuildSystem {
	public static void main(String[] args) {
		Graph<Integer> graph = new Graph<>(true);
		graph.addEdge(1, 3);
		graph.addEdge(1, 2);
		graph.addEdge(3, 4);
		graph.addEdge(5, 6);
		graph.addEdge(6, 3);
		graph.addEdge(3, 8);
		graph.addEdge(8, 11);
		System.out.println(graph.toString());
		BuildSystem bs = new BuildSystem();
		Deque<Vertex<Integer>> results = bs.topsort(graph);
		while (!results.isEmpty()) {
			System.out.println(results.pop().toString());
		}
	}

	public Deque<Vertex<Integer>> topsort(Graph<Integer> graph) {
		Deque<Vertex<Integer>> stack = new ArrayDeque<>();
		Set<Vertex<Integer>> visited = new HashSet<>();
		for (Vertex<Integer> vertex : graph.getAllVertex()) {
			if (!visited.contains(vertex)) {
				topsortUntil(vertex, stack, visited);
			}
		}
		return stack;
	}

	private void topsortUntil(Vertex<Integer> vertex, Deque<Vertex<Integer>> stack, Set<Vertex<Integer>> visited) {
		visited.add(vertex);
		for (Vertex<Integer> childVertex : vertex.getAdjacentVertexes()) {
			if (!visited.contains(childVertex)) {
				topsortUntil(childVertex, stack, visited);
			}
		}
		stack.offerFirst(vertex);
	}
}
