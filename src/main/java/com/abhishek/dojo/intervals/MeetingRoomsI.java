package com.abhishek.dojo.intervals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// LC- 77 / 77 test cases passed.
// Runtime: 42 ms, faster than 5.20% of Java online submissions for Meeting Rooms.
// Memory Usage: 38.3 MB, less than 43.59% of Java online submissions for Meeting Rooms.

public class MeetingRoomsI {

	public static void main(String[] args) {
		MeetingRoomsI m = new MeetingRoomsI();
		System.out.println(m.canAttendMeetings(new int[][] {{0,30},{5,10},{15,20}}));//false
		System.out.println(m.canAttendMeetings(new int[][] {{7,10}, {2,4}}));//true
	}

	class Meeting {
		int start;
		int end;
		public Meeting(int start, int end){
			this.start = start;
			this.end = end;
		}
	}
	public boolean canAttendMeetings(int[][] intervals) {
		List<Meeting> meetings = new ArrayList<>();
		for (int i = 0; i < intervals.length; i++){
			Meeting m = new Meeting(intervals[i][0], intervals[i][1]);
			meetings.add(m);
		}
		meetings = meetings.stream().sorted((a,b) -> (a.end - b.end)).collect(Collectors.toList());
		for (int i =0; i < meetings.size() - 1; i++){
			if (meetings.get(i).end > meetings.get(i+1).start){
				return false;
			}
		}
		return true;
	}
}
