package com.exercise.chap2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Problem Statement
 * Verify that asking for the first five long words does not call the filter method
once the fifth long word has been found. Simply log each method call.
 * @author Sudhir Mongia
 *
 */
public class Ex2VerifyOnlyRequiredTraversalWithFilter {

	public static void main(String[] args)  throws IOException {
		
		
		List<String> lines = Files.readAllLines(Paths.get("resources/RandomLines.txt")).stream().collect(Collectors.toList());
		List<String> words = lines.stream()
				//.peek(l -> System.out.println("Current thread is" + Thread.currentThread().getName()))
				.flatMap(l -> Stream.of(l.split(" "))).collect(Collectors.toList());
		
		
		words.stream().parallel()
		 .peek(l -> System.out.println("word is->" + l + "  its length is->" + l.length()))
		.filter(w -> w.length() > 12).limit(5).forEach(System.out::println);;		
		
	}

}
