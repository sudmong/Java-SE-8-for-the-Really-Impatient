package com.exercise.chap1;

/**
 * Problem statement
 * Write a static method andThen that takes as parameters two Runnable instances
and returns a Runnable that runs the first, then the second. In the main method,
pass two lambda expressions into a call to andThen, and run the returned
instance.
 * @author Sudhir
 *
 */
public class Ex7RunnableAndThenRunnable {
	
	public static void main(String[] args) {
		
		Runnable R1 = () -> { System.out.println("Runnable 1");};
		Runnable R2 = () -> { System.out.println("Runnable 2");};
		
		Runnable r = andThen(R1, R2);
		Thread t = new Thread(r);
		t.start();
		
	}

	
	private static Runnable andThen(Runnable r1, Runnable r2)
	{
		Runnable r = () -> {
			r1.run();
			r2.run();
		};
		
		return r;
	}
}
