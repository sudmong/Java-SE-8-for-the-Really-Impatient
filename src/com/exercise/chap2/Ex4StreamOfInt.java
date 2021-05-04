package com.exercise.chap2;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Problem Statement
 * Suppose you have an array int[] values = { 1, 4, 9, 16 }. What is
Stream.of(values)? How do you get a stream of int instead?
 * @author Sudhir Mongia
 *
 */
public class Ex4StreamOfInt {

	public static void main(String[] args) {

		int[] values = { 1, 4, 9, 16 };
		
		// this gives Stream of int[] which is 1
		System.out.println(Stream.of(values).count());
		
		// these gives Stream of int value which is 4
		System.out.println(Arrays.stream(values).count());		
		
		System.out.println(IntStream.of(values).count());
				
	}

}
