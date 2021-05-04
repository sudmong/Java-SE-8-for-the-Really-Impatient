package com.exercise.chap2;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Problem Statement
 * Measure the difference when counting long words with a parallelStream instead
of a stream. Call System.currentTimeMillis before and after the call, and print the
difference. Switch to a larger document (such as War and Peace) if you have
a fast computer.
 * @author Sudhir Mongia
 *
 */
public class Ex3StreamVsParallelStreamComparison {
	
public static void main(String[] args)  throws Exception {
		
		
		List<String> lines = Files.readAllLines(Paths.get("resources/book-war-and-peace.txt")).stream().collect(Collectors.toList());
		List<String> words = lines.stream()
				//.peek(l -> System.out.println("Current thread is" + Thread.currentThread().getName()))
				.flatMap(l -> Stream.of(l.split(" "))).collect(Collectors.toList());
		
		     
		long startTime = System.currentTimeMillis();
		words.stream().parallel()
		 //.peek(l -> System.out.println("word is->" + l + "  its length is->" + l.length()))
		.filter(w -> w.length() > 12).count();
		
		System.out.println("total time with parallel Stream->" + (System.currentTimeMillis() - startTime));
		
		startTime = System.currentTimeMillis();
		words.stream()
		 //.peek(l -> System.out.println("word is->" + l + "  its length is->" + l.length()))
		.filter(w -> w.length() > 12).count();
		
		System.out.println("total time with sequential Stream->" + (System.currentTimeMillis() - startTime));			
	}

}
