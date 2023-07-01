package com.abhishek.dojo.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// build 3 integer arrays-
// an array of parent of every node
// an array of discovery number of each node while doing DFS
// an array of lowest node number for each node via a backedge

// 1. build a DFS spanning tree
// 2. build arrays
// 3. check few conditions for root and non root node
public class CriticalConnectionsArticulationPoint {

	public static void main(String args[])  { 
		System.out.println("Articulation points in first graph "); 
		List<List<Integer>> connections = new ArrayList<List<Integer>>();
		List<Integer> connection = new ArrayList<Integer>();
		connection.add(1); connection.add(3); connections.add(connection); connection = new ArrayList<>();
		connection.add(0); connection.add(1); connections.add(connection); connection = new ArrayList<>();
		connection.add(0); connection.add(2); connections.add(connection); connection = new ArrayList<>(); 
		connection.add(2); connection.add(3); connections.add(connection); connection = new ArrayList<>();
		connection.add(2); connection.add(5); connections.add(connection); connection = new ArrayList<>();
		connection.add(5); connection.add(6); connections.add(connection); connection = new ArrayList<>();
		connection.add(3); connection.add(4); connections.add(connection);
		getCriticalNodes(connections, 7, 7).forEach(x -> System.out.print(x + "|"));
	}

	private static List<Integer> getCriticalNodes(List<List<Integer>> links, int numLinks, int numRouters) {
		Graph g = new CriticalConnectionsArticulationPoint().new Graph(numRouters);
		for (List<Integer> connection : links) g.addEdge(connection.get(0), connection.get(1));
		return g.findArticulationPoint(); 
	}

	class Graph {
		int time;
		int len; // No. of vertices
		LinkedList<Integer> edge[];// Array of lists for Adjacency List Representation
		
		Graph(int total_vertices) {
			this.time = 0;
			this.len = total_vertices;
			edge = new LinkedList[this.len];
			// Arrays.fill(adj, new LinkedList<>());
			for (int i = 0; i < this.len; ++i) edge[i] = new LinkedList<>();
		}

		// Function to add an edge into the graph
		void addEdge(int edge_point1, int edge_point2) {
			edge[edge_point1].add(edge_point2); // add edge_point1 to edge_point2's list.
			edge[edge_point2].add(edge_point1); // add edge_point2 to edge_point1's list
		}

		// A recursive function that find articulation points. vertex_next --> The vertex to be visited next. parent[] --> Stores parent vertices in DFS tree
		void dfs(int parent_vertex, boolean vertex_visited[], int vertex_discovery_time[], int distance_low[], int parent[], boolean ap[]) {
			int children = 0; // count of children in DFS Tree
			vertex_visited[parent_vertex] = true; // Mark the current node as visited
			vertex_discovery_time[parent_vertex] = distance_low[parent_vertex] = ++time; // Initialize discovery time and low value

			LinkedList<Integer> edgesFromVertex = edge[parent_vertex];
			for (int childVertex: edgesFromVertex) { // v is current adjacent of vertex_next
				if (!vertex_visited[childVertex]) {
					children++;
					// If v is not visited yet, then make it a child of vertex_next in DFS tree and recur for it
					parent[childVertex] = parent_vertex;
					dfs(childVertex, vertex_visited, vertex_discovery_time, distance_low, parent, ap);
					// Check if the subtree rooted with childVertex has a connection to one of the ancestors of parentVertex
					distance_low[parent_vertex] = Math.min(distance_low[parent_vertex], distance_low[childVertex]);
					updateAP(parent_vertex, vertex_discovery_time, distance_low, parent, ap, children, childVertex);
				} else if (childVertex != parent[parent_vertex]) // Update low value of u for parent function calls.
					distance_low[parent_vertex] = Math.min(distance_low[parent_vertex], vertex_discovery_time[childVertex]);
			}
		}

		private void updateAP(int vertex_next, int[] vertex_discovery_time, int[] distance_low, int[] parent,
				boolean[] ap, int children, int vertex) {
			// vertex_next is an articulation point in following cases (1) u is root of DFS tree and has two or more children.
			if (parent[vertex_next] == -1 && children > 1)
				ap[vertex_next] = true;
			// (2) If vertex_next is not root and low value of one of its child is more than discovery value of vertex_next.
			if (parent[vertex_next] != -1 &&  vertex_discovery_time[vertex_next] <= distance_low[vertex])
				ap[vertex_next] = true;
		}

		List<Integer> findArticulationPoint() {
			List<Integer> result = new ArrayList<>();
			
			boolean visited[] = new boolean[len]; // Mark all the vertices as not visited
			boolean ap[] = new boolean[len]; // To store articulation points
			
			int parent[] = new int[len];
			int vertex_discovery_time[] = new int[len];
			int low[] = new int[len];
			
			Arrays.fill(parent, -1); // Initialize parent and visited, and ap(articulation point) arrays
			
			for (int i = 0; i < len; i++) // DFS to find ap in DFS tree rooted with vertex 'i'
				if (visited[i] == false)
					dfs(i, visited, vertex_discovery_time, low, parent, ap);

			for (int i = 0; i < len; i++) if (ap[i]) result.add(i);

			return result;
		}
	}
}
