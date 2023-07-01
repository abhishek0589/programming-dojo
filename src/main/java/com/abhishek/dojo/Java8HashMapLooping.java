package com.abhishek.dojo;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Java8HashMapLooping {
	public static void main(String[] args) {
		Map<String, Map<Date, String>> tagsdtl = new HashMap<String, Map<Date, String>>();
		String tagName = "zoneSensor";
		Map<Date, String> values = new HashMap<Date, String>();
		// day before yesterday
		Calendar datekey1 = Calendar.getInstance();
		datekey1.set(2018, 12, 01, 12, 30, 45);
		values.put(datekey1.getTime(), "9");
		// yesterdys date
		Calendar datekey = Calendar.getInstance();
		datekey.set(2018, 12, 02, 12, 30, 45);
		values.put(datekey.getTime(), "9.5");
		// today
		Calendar instance = Calendar.getInstance();
		instance.set(2018, 12, 03, 12, 30, 45);
		values.put(instance.getTime(), "10");
		// + 10 sec
		instance.add(Calendar.MILLISECOND, 10000);
		tagsdtl.put(tagName, values);
		values.put(instance.getTime(), "10.5");
		tagsdtl.put(tagName, values);
		tagName = "zoneSensor1";
		values = new HashMap<Date, String>();
		values.put(Calendar.getInstance().getTime(), "11");
		tagsdtl.put(tagName, values);
		/*
		 * tagsdtl .entrySet() .stream() .map(Map.Entry::getValue) .filter(y ->
		 * y.containsKey(datekey));
		 */
		// tagsdtl
		// .entrySet()
		// .stream()
		// .map(Map.Entry::getValue)
		// .filter(value -> ((Date)value).before(datekey.getTime()))
		tagsdtl.values().forEach(m -> m.keySet().removeIf(key -> key.after(datekey.getTime())));
		System.out.println(tagsdtl.toString());
	}
	/*
	 * final Map<String, Map<Date, String>> tagsdtl = row.getMap(1, new
	 * TypeToken<String>() {}, new TypeToken<Map<Date, String>>() {}); for (final
	 * Entry<String, Map<Date, String>> entry : tagsdtl.entrySet()) { final
	 * Iterator<Date> iter = entry.getValue().keySet().iterator(); while
	 * (iter.hasNext()) { final Date date = iter.next(); // may get some backdated
	 * data for first bucket // TODO- if there are multiple values of a tag in last
	 * bucket of previous day, take last value if (date.getTime() <
	 * (startDate.getTime()- INTERVAL_MS)|| date.getTime() > endDate.getTime()) {
	 * LOGGER.debug("removed tag readTimeSeriesByAsset {} : {} -> {}", date,
	 * startDate, endDate); iter.remove(); } } } return tagsdtl;
	 * 
	 */
}
