package com.abhishek.dojo.intervals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

// LC- 78 / 78 test cases passed.
// Runtime: 244 ms, faster than 5.18% of Java online submissions for Meeting Rooms II.
// Memory Usage: 52.5 MB, less than 5.12% of Java online submissions for Meeting Rooms II.

public class MeetingRoomsII {
	class Meeting {
		int start;
		int end;
		public Meeting(int start, int end){
			this.start = start;
			this.end = end;
		}
	}

	public static void main(String[] args) {
		MeetingRoomsII m = new MeetingRoomsII();
		System.out.println(m.minMeetingRooms(new int[][] {{0, 30},{5, 10},{15, 20}}));
	}

	public int minMeetingRooms(int[][] intervals) {     
		List<Meeting> meetings = new ArrayList<>();
		for (int i = 0; i < intervals.length; i++){
			Meeting m = new Meeting(intervals[i][0], intervals[i][1]);
			meetings.add(m);
		}
		// meetings sorted by start time
		meetings = meetings.stream().sorted((a,b) -> (a.start - b.start)).collect(Collectors.toList());
		
		// create map of number of meeting rooms vs meetings (Set) that can be done in that room
		Map<Integer, Set<Meeting>> map = new HashMap<>();
		int index = 1;
		for (int i = 0; i < meetings.size(); i++) {
			boolean added = false;
			Meeting current = meetings.get(i);
			for (Map.Entry<Integer, Set<Meeting>> entry : map.entrySet()){
				if (current.start >= getLast(entry.getValue()).end){
					entry.getValue().add(current);
					added = true;
					break;
				}
			}
			if (!added) {
				Set<Meeting> set = new LinkedHashSet<>();
				set.add(current);
				map.put(index, set);
				index++;
			}
		}
		return map.size();
	}

	public Meeting getLast(Set<Meeting> meetings) {
		Meeting last = null;
		for (Meeting m : meetings) {
			last = m;
		}
		return last;
	}

}
