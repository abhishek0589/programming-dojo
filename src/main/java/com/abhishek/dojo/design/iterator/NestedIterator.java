package com.abhishek.dojo.design.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {

	List<Integer> flatList = new ArrayList<>();
	int cursor = 0;

	public NestedIterator(List<NestedInteger> nestedList) {
		flatten(nestedList);   
	}

	public void flatten(List<NestedInteger> list) {
		for (NestedInteger item : list){
			if (item.isInteger()){
				flatList.add(item.getInteger());
			} else {
				flatten(item.getList());
			}
		}
	}

	@Override
	public Integer next() {
		return hasNext() ? flatList.get(cursor++) : -1;
	}

	@Override
	public boolean hasNext() {
		return cursor < flatList.size();
	}
}

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
interface NestedInteger {

	// @return true if this NestedInteger holds a single integer, rather than a nested list.
	public boolean isInteger();

	// @return the single integer that this NestedInteger holds, if it holds a single integer
	// Return null if this NestedInteger holds a nested list
	public Integer getInteger();

	// @return the nested list that this NestedInteger holds, if it holds a nested list
	// Return null if this NestedInteger holds a single integer
	public List<NestedInteger> getList();
}
