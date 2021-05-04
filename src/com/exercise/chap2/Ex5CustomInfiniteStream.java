package com.exercise.chap2;

import java.util.stream.Stream;

/**
 * problem statement
 * Using Stream.iterate, make an infinite stream of random numbers—not by
calling Math.random but by directly implementing a linear congruential generator.
In such a generator, you start with x0 = seed and then produce xn + 1 =
(a xn + c) % m, for appropriate values of a, c, and m. You should implement a
method with parameters a, c, m, and seed that yields a Stream<Long>. Try out a =
25214903917, c = 11, and m = 248.
 * @author Sudhir Mongia
 *
 */
public class Ex5CustomInfiniteStream {

	public static void main(String[] args) {
		
		long a = 25214903917l;
		long c = 11;
		double m = Math.pow(2, 48);
		// limiting the results to 100 on infinite stream
		Stream<Long> longStream = Stream.iterate(0L, n->  ((long)((a*n + c) % m))).limit(100);
		longStream.forEach(System.out::println);		

	}

}
