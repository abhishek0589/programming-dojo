package com.abhishek.concepts;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MethodReferenceExample {

	public static Comparator<Person> name = (a, b) -> a.getName().compareTo(b.getName());
	public static Comparator<Person> age = (a, b) -> a.getAge().compareTo(b.getAge());

	public static void main(String[] args) {
		// methodReferences();
		 sequentialVsParallelStreams();

	}

	private static void sequentialVsParallelStreams() {
		List<Integer> numbers = Arrays.asList(1, 2, 4, 5, 6, 7, 8, 9, 10);
		useStreams(numbers.stream());
	}

	public static void useStreams(Stream<Integer> stream) {
		Instant start = Instant.now();
		stream.parallel().map(e -> transform(e)).forEach(e -> {});
		System.out.println("Time taken- " + Duration.between(start, Instant.now()).toMillis()); // in millis
	}

	public static int transform(Integer e) {
		 System.out.println("current thread- " + Thread.currentThread());
		return e;
	}

	private static void methodReferences() {
		Person a = new Person("Abhishek", 32);
		Person b = new Person("Random", 33);
		List<Person> ppl = Arrays.asList(b, a);
		List<Person> ageSorted = ppl.stream().sorted(age).collect(Collectors.toList());
		ppl.forEach(System.out::println);
		ageSorted.forEach(PersonFilter::printPersonDetails);
	}
}
