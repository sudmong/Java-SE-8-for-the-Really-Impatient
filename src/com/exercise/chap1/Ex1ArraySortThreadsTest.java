package com.exercise.chap1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Problem Statement
 * Is the comparator code in the Arrays.sort method called in the same thread as
	the call to sort or a different thread?
 * @author Sudhir
 *
 */
public class Ex1ArraySortThreadsTest {
	
	public static void main(String [] args) {	
		
		int []  myNums = new int[]{11,2,3,14,5};
		
		//get integer stream on array and print using foreach
		IntStream.of(myNums).forEach(System.out::print);
		
		Arrays.sort(myNums);
		
		System.out.println();
		
		IntStream.of(myNums).forEach(System.out::print);
		
		System.out.println("This Thread is " +  Thread.currentThread().getName());
		
		List<Long> threadIds = new ArrayList<>();
		Integer []  myNumsInteger = new Integer[]{11,2,3,14,5,1,2,2,2,2,2,2,2,2,4,4,5,5,6,67,7,8,8,8,8,45,6,74,3,3,3,3,};
		Arrays.sort(myNumsInteger, (a,b) -> {
			threadIds.add(Thread.currentThread().getId());
			if(a > b) return 1;
			if(a<b) return -1;
			return 0;
		});
		
		threadIds.clear();
		Stream.of(myNumsInteger).forEach(System.out::print);
		System.out.println();
		Arrays.parallelSort(myNumsInteger, (a,b) -> {
			threadIds.add(Thread.currentThread().getId());
			if(a > b) return 1;
			if(a<b) return -1;
			return 0;
		});
		System.out.println();
		Stream.of(myNumsInteger).forEach(System.out::print);
		System.out.println();
		System.err.println(threadIds);	
		
	}
}