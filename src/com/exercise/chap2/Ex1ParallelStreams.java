package com.exercise.chap2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Problem statement
 * Write a parallel version of the for loop in Section 2.1, “From Iteration to
Stream Operations,” on page 22. Obtain the number of processors. Make that
many separate threads, each working on a segment of the list, and total up
the results as they come in. (You don’t want the threads to update a single
counter. Why?)
 * @author Sudhir Mongia
 *
 * I need to learn about concurrency in order to attempt this.
 */
public class Ex1ParallelStreams {

	public static void main(String [] args) throws IOException {
		
		
		
		/* Stream version
		List<String> lines = Files.readAllLines(Paths.get("resources/RandomLines.txt")).stream().collect(Collectors.toList());
		Stream<String> words = lines.stream()
				//.peek(l -> System.out.println("Current thread is" + Thread.currentThread().getName()))
				.flatMap(l -> Stream.of(l.split(" ")));
		
		
		long count =words.parallel()
		 .peek(l -> System.out.println("Current thread is" + Thread.currentThread().getName()))
		.filter(w -> w.length() > 12).count();
		System.out.println(count);
		*/
		
		
		
	}
}
