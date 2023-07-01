package com.abhishek.dojo.ddos;

import java.util.HashSet;
import java.util.Set;

public class DeliveryValidator {
	public static void main(String[] args) {
		DeliveryValidator dv = new DeliveryValidator();
		String[] deliveries = new String[] { "p1", "d1", "p2", "d2" };
		System.out.println(dv.validate(deliveries));
		deliveries = new String[] { "p1", "p2", "d1", "d2" };
		System.out.println(dv.validate(deliveries));
		deliveries = new String[] { "p1", "d2", "p2", "d1" };
		System.out.println(dv.validate(deliveries));
		deliveries = new String[] { "p1", "p2", "d2" };
		System.out.println(dv.validate(deliveries));
		deliveries = new String[] { "p1", "d1", "d1" };
		System.out.println(dv.validate(deliveries));
	}

	public boolean validate(String[] deliveries) {
		Set<String> processedActions = new HashSet<String>();
		for (int i = 0; i < deliveries.length; i++) {
			String current = deliveries[i];
			// push current item to stack
			if (current.toLowerCase().contains("d")) {
				//scan hashset for given pick
				if (processedActions.size() == 0 && !processedActions.contains("p" + current.toCharArray()[1])) {
					return false;
				} else {
					processedActions.remove("p" + current.toCharArray()[1]);
				}
			}
			else {
				processedActions.add(deliveries[i]);
			}
		}
		
		return processedActions.size() == 0;
	}
}
