package com.exercise.chap2;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Problem Statement
 *  Count all short words in a parallel Stream<String>, as described in Section 2.13,
“Parallel Streams,” on page 40, by updating an array of AtomicInteger. Use
the atomic getAndIncrement method to safely increment each counter.
 * @author Sudhir Mongia
 *
 */
public class Ex12CountShortWords {

	public static void main(String[] args) throws Exception {
		
		List<String> lines = Files.readAllLines(Paths.get("resources/RandomLines.txt")).stream().collect(Collectors.toList());
		List<String> words = lines.stream()
				//.peek(l -> System.out.println("Current thread is" + Thread.currentThread().getName()))
				.flatMap(l -> Stream.of(l.split(" "))).collect(Collectors.toList());
		
		AtomicInteger counter = new AtomicInteger();
		words.parallelStream().forEach(s -> { if(s.length() < 12) counter.incrementAndGet(); });
		System.out.println("Count is:" + counter.get());
		
		AtomicInteger counter2 = new AtomicInteger();
		words.stream().forEach(s -> { if(s.length() < 12) counter2.incrementAndGet(); });
		System.out.println("Count is:" + counter2.get());		
	
	}

}
