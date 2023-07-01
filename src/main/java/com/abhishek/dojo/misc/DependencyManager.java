package com.abhishek.dojo.misc;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DependencyManager {
	public static void main(String[] args) {
		List<String> ins = new ArrayList<>();
		ins.add("DEPEND TELNET TCPIP NETCARD");
		ins.add("DEPEND TCPIP NETCARD");
		ins.add("DEPEND DNS TCPIP NETCARD");
		ins.add("DEPEND BROWSER TCPIP HTML");
		ins.add("ADD NETCARD");
		ins.add("ADD TELNET");
		ins.add("ADD foo");
		ins.add("REMOVE NETCARD");
		ins.add("ADD BROWSER");
		ins.add("ADD DNS");
		ins.add("LIST");
		ins.add("REMOVE TELNET");
		ins.add("REMOVE NETCARD");
		ins.add("REMOVE DNS");
		ins.add("REMOVE NETCARD");
		ins.add("ADD NETCARD");
		ins.add("REMOVE TCPIP");
		ins.add("REMOVE BROWSER");
		ins.add("EMOVE TCPIP");
		ins.add("LIST");
		managedependencies(ins);
	}

	private static void managedependencies(List<String> ins) {
		// build dependency graph- adjacency list
		HashMap<String, Set<String>> graph = new HashMap<>();
		HashSet<String> modules = new HashSet<>();
		for (int i = 0; i < ins.size(); i++) {
			if (ins.get(i).toLowerCase().startsWith("depend")) {
				// get all modules
				String[] dependencies = ins.get(i).split(" ");
				Collections.addAll(modules, Arrays.copyOfRange(dependencies, 1, dependencies.length));
				// build dependency graph
				HashSet<String> dependants = new HashSet<>();
				Collections.addAll(dependants, Arrays.copyOfRange(dependencies, 2, dependencies.length));
				graph.put(dependencies[1], dependants);
			}
		}
		for (String module : modules) {
			if (!graph.containsKey(module)) {
				graph.put(module, new HashSet<>());
			}
		}
		System.out.println(modules.toString());
		graph.forEach((k, v) -> System.out.println(k + ":" + v));
	}
}
