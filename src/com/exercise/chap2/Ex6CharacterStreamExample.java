package com.exercise.chap2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * problem Statement
 * The characterStream method in Section 2.3, “The filter, map, and flatMap Methods,”
on page 25, was a bit clumsy, first filling an array list and then turning it
into a stream. Write a stream-based one-liner instead. One approach is to
make a stream of integers from 0 to s.length() - 1 and map that with the
s::charAt method reference.
 * @author Sudhir Mongia
 *
 */
public class Ex6CharacterStreamExample {
	
	public static void main(String [] args)
	{
		/**
		 * public static Stream<Character> characterStream(String s) {
				List<Character> result = new ArrayList<>();
			for (char c : s.toCharArray()) result.add(c);
			return result.stream();
			}
		 */
		String s = "This is the String";
		characterStreamAsIntegers(s).forEach( i -> System.out.println((char)i));
		System.out.println("--------------");
		characterStream(s).forEach(System.out::println);
		
	}
		
	public static Stream<Character> characterStream(String s) {
		return IntStream.rangeClosed(0, s.length() -1).mapToObj(s::charAt);
	
	}
	
	
	public static IntStream characterStreamAsIntegers(String s) {
		
		return s.chars();
	}
	
	
	
	

}
