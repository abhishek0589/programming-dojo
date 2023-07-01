package com.abhishek.dojo.intervals;

import java.util.Arrays;


public class MeetingRoomsIIA2 {
	class Meeting {
		int start;
		int end;
		public Meeting(int start, int end){
			this.start = start;
			this.end = end;
		}
	}
	public static void main(String[] args) {
		MeetingRoomsIIA2 m = new MeetingRoomsIIA2();
		int [][] intervals = new int[][] {{0, 30},{5, 10},{15, 20}};
		Meeting[] meetings = new Meeting[intervals.length];
		for (int i = 0; i < intervals.length; i++){
			meetings[i] = m.new Meeting(intervals[i][0], intervals[i][1]);
		}
		System.out.println(m.minMeetingRooms(meetings));
	}

	public int minMeetingRooms(Meeting[] intervals) {
		int[] starts = new int[intervals.length];
		int[] ends = new int[intervals.length];
		for(int i=0; i<intervals.length; i++) {
			starts[i] = intervals[i].start;
			ends[i] = intervals[i].end;
		}
		Arrays.sort(starts);
		Arrays.sort(ends);
		int rooms = 0;
		int endsItr = 0;
		for(int i=0; i<starts.length; i++) {
			if(starts[i]<ends[endsItr])
				rooms++;
			else
				endsItr++;
		}
		return rooms;

	}


}
