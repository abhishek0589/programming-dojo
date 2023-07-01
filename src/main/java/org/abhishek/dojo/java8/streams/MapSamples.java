package org.abhishek.dojo.java8.streams;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MapSamples {

	public static void main(String[] args) {
		
		// Problem statement- Modify map such that all entries before T are removed
		
		Map<String, Map<LocalDate, String>> sensorData = new HashMap<>();
		String tag = "zoneSensor";
		Map<LocalDate, String> values= new HashMap<>();

		// 1st entry for zoneSensor (T-2)
		LocalDate date16 = LocalDate.of(2019, 8, 16);
		values.put(date16, "ON");

		// 2nd entry for zoneSensor (T-1)
		LocalDate date17 = LocalDate.of(2019, 8, 17);
		values.put(date17, "OFF");

		// 3rd entry for zoneSensor T
		LocalDate date18 = LocalDate.now();
		values.put(date18, "ON");
		sensorData.put(tag, values);
		
		// 4th entry for zoneSensor1
		tag = "zoneSensor1";
		values= new HashMap<>();
		values.put(LocalDate.now(), "NORMAL");

		sensorData.put(tag, values);

		sensorData.forEach((key, value) -> System.out.println("key=" + key + ", value = " + value.toString()));
		
		//code in java 7
		/*for (final Entry<String, Map<LocalDate, String>> entry : sensorData.entrySet()) {
			final Iterator<LocalDate> iter = entry.getValue().keySet().iterator();
			while (iter.hasNext()) {
				final LocalDate date = iter.next();
				if (date.isBefore(LocalDate.now())) {
					iter.remove();
				}
			}
		}*/
		
		// java 8
		// if map needs to be kept intact then use streams
		Map<String, Map<LocalDate, String>> result = sensorData.entrySet().stream()
			.collect(Collectors.toMap(
					Map.Entry::getKey, 
					entry -> entry.getValue().entrySet().stream()
												.filter(innerEntry -> !innerEntry.getKey().isBefore(LocalDate.now()))
												.collect(
														Collectors.toMap(Map.Entry::getKey, 
																Map.Entry::getValue))));
		
		System.out.println("stream approach =");
		result.forEach((key, value) -> System.out.println("key=" + key + ", value = " + value.toString()));
		// if map needs to be modified then you can use inline modification functions
		// like remove
		sensorData.values().forEach(entry -> entry.keySet().removeIf(item -> item.isBefore(LocalDate.now())));
		System.out.println("inline approach =");
		sensorData.forEach((key, value) -> System.out.println("key=" + key + ", value = " + value.toString()));
		


	}
}
