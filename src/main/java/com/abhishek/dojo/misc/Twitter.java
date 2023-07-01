package com.abhishek.dojo.misc;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

//Right now = 1543515494

//recordEvent(“retweet”, today at 9am)
//recordEvent(“retweet”, today at 9am)
//recordEvent(“retweet”, today at 10am)
//getEventCount(“retweet”, today at 9am, today at 11am, Granularity.HOUR) => [retweets between 9am and 10am, retweets between 10am and 11am] => [2, 1]

//recordEvent(“retweet”, today at 9am)
//recordEvent(“retweet”, today at 9:02am)
//getEventCount(“retweet”, today at 9am, today at 9:05am, Granularity.MINUTE) => [retweets between 9am and 9:01am, retweets between 9:01 and 9:02 am, …. ] => [1, 0, 1, 0, 0]

class EventCounter {
	// recordEvent(eventName String, time long): void
	// getEventCount(eventName String, startTime long, endTime long, granularity
	// Granularity): int[]
}

public class Twitter {

	public enum GRANULARITY {
		MIN, HOUR, DAY
	}

	// class level attribute to store all elements in map
	static HashMap<Date, List<String>> eventmap = new HashMap<Date, List<String>>();

	public static void main(String args[]) throws Exception {
		Twitter t = new Twitter();

		t.recrodEvent("retweet", new Date(2019, 01, 21, 11, 00, 00).getTime());
		t.recrodEvent("retweet", new Date(2019, 01, 21, 11, 00, 00).getTime());
		t.recrodEvent("retweet", new Date(2019, 01, 21, 12, 00, 00).getTime());
		List<Integer> eventCount = t.getEventCount("retweet", new Date(2019, 01, 21, 11, 00, 00).getTime(),
				new Date(2019, 01, 21, 12, 00, 00).getTime(), GRANULARITY.HOUR);
		eventCount.forEach(System.out::println);
		System.out.println("new analysis");

		eventmap = new HashMap<>();
		t.recrodEvent("retweet", new Date(2019, 01, 21, 11, 00, 00).getTime());
		t.recrodEvent("retweet", new Date(2019, 01, 21, 11, 02, 00).getTime());
		eventCount = new ArrayList<>();
		eventCount = t.getEventCount("retweet", new Date(2019, 01, 21, 11, 00, 00).getTime(),
				new Date(2019, 01, 21, 11, 05, 00).getTime(), GRANULARITY.MIN);
		eventCount.forEach(System.out::println);
	}

	public void recrodEvent(String eventName, long time) {
		List<String> events = eventmap.getOrDefault(new Date(time), new ArrayList<String>());
		events.add(eventName);
		eventmap.put(new Date(time), events);
	}

	public List<Integer> getEventCount(String eventName, long startTime, long endTime, GRANULARITY granularity) {
		ArrayList<Integer> result = new ArrayList();
		while (startTime <= endTime) {
			long bucketDuration = startTime + getIncrementalTime(granularity);
			int count = 0;
			while (startTime < bucketDuration) {
				List<String> matchedEvents = eventmap.containsKey(new Date(startTime))
						? eventmap.get(new Date(startTime))
						: new ArrayList();
				matchedEvents = matchedEvents.stream().filter(e -> e.equalsIgnoreCase(eventName))
						.collect(Collectors.toList());
				count += matchedEvents.size();
				startTime = startTime + 1000;
			}
			result.add(count);
		}
		return result;
	}

	long getIncrementalTime(GRANULARITY granularity) {
		if (granularity.equals(GRANULARITY.DAY)) {
			return 24 * 60 * 60 * 1000;
		} else if (granularity.equals(GRANULARITY.HOUR)) {
			return 60 * 60 * 1000;
		} else {
			return 60 * 1000;
		}
	}

}
