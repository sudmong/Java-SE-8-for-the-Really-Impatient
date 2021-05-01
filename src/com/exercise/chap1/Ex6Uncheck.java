package com.exercise.chap1;

/**
 * Problem statement
 * Given an array of File objects, sort it so that the directories come before the
files, and within each group, elements are sorted by path name. Use a lambda
expression, not a Comparator.
 * @author Sudhir
 *
 */
public class Ex6Uncheck {

	public static void main(String[] args) {

		Thread t = new Thread(uncheck(() -> {
			System.err.println("Invoked");
			Thread.sleep(1000);	
			}));
		t.start();

	}
	
	@FunctionalInterface
	public interface RunnableEx {		
		public void run() throws Exception;			
	}
	
	public static Runnable uncheck(RunnableEx runnableEx) 
	{
		return () -> {
					try {
					runnableEx.run();
					}catch(Exception e)
					{
						e.printStackTrace();
					}
				};			
	}

}
