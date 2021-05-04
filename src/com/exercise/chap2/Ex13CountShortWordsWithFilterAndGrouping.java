package com.exercise.chap2;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex13CountShortWordsWithFilterAndGrouping {

	public static void main(String[] args) throws Exception {
		
		List<String> lines = Files.readAllLines(Paths.get("resources/RandomLines.txt")).stream().collect(Collectors.toList());
		List<String> words = lines.stream()
				//.peek(l -> System.out.println("Current thread is" + Thread.currentThread().getName()))
				.flatMap(l -> Stream.of(l.split(" "))).collect(Collectors.toList());
		
		Map<Integer, Long> wordsCount = words.parallelStream()
		.filter(s -> s.length() < 12)
		.collect(Collectors.groupingBy(l->l.length(), Collectors.counting()));
		System.out.println(wordsCount);
	}

}
