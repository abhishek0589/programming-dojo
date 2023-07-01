package com.abhishek.dojo.misc;

import java.util.function.BiFunction;

public class SkylineUtil {

	// below are set of compute functions-
	// these are similar to put but can do put as well as update. 
	// in example below, if for a given key, value is not null, add 1 to existing value or add 1 as a fresh value
	// if value is not found, put 1. If value is found, increment it by 1
	public static BiFunction<Integer, Integer, Integer> remap_increment = (key, value) -> {
		if (value != null) return value + 1;// update condition
		return 1; // default operation
	};
	// if value is not found, put null. If value is found, decrement it by 1
	public static BiFunction<Integer, Integer, Integer> remap_decrement = (key, value) -> {
		if (value == 1) return null;
		return value - 1;
	};
}
