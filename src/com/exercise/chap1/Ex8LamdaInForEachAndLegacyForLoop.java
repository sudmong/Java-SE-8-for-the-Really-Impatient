package com.exercise.chap1;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem statement
 * What happens when a lambda expression captures values in an enhanced
for loop such as this one?
String[] names = { "Peter", "Paul", "Mary" };
List<Runnable> runners = new ArrayList<>();
for (String name : names)
runners.add(() -> System.out.println(name));
Is it legal? Does each lambda expression capture a different value, or do they
all get the last value? What happens if you use a traditional loop for (int i = 0;
i < names.length; i++)?
 * @author Sudhir
 *
 */
public class Ex8LamdaInForEachAndLegacyForLoop {

	public static void main(String[] args) {
		method1();
		method2();
	}

	
	private static void method1()
	{
		String[] names = { "Peter", "Paul", "Mary" };
		List<Runnable> runners = new ArrayList<>();
		for (String name : names)
		runners.add(() -> System.out.println(name));
	
		runners.stream().forEach(r -> new Thread(r).start());
		
	}
	
	
	private static void method2()
	{
		String[] names = { "Peter", "Paul", "Mary" };
		List<Runnable> runners = new ArrayList<>();
		
		for (int i = 0; i<names.length;i++) {
			String name  = names[i];
			runners.add(() -> System.out.println(name));
			//can't do this as i is not final or effectively final here
			//runners.add(() -> System.out.println(names[i]));
		}
		
		// if we know the size, we can do this
		//runners.add(() -> System.out.println(names[0]));
		//runners.add(() -> System.out.println(names[1]));
		//runners.add(() -> System.out.println(names[2]));
		
		runners.stream().forEach(r -> new Thread(r).start());
		
	}
}
