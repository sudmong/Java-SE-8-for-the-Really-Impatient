package com.exercise.chap2;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;

/**
 * problem statement
 * Write a call to reduce that can be used to compute the average of a Stream<Double>.
	Why can’t you simply compute the sum and divide by count()?
 * @author Sudhir Mongia
 *
 */
public class Ex10ReduceAndComputeAverage {

	public static void main(String[] args) {
		
		List<Double> numbers = new ArrayList<>();
		numbers.add(Double.valueOf(45));
		numbers.add(Double.valueOf(35));
		numbers.add(Double.valueOf(40));
		
		Double average = computeAverageOnDoubleStream1(numbers.stream());
		System.out.println("Average is->" + average );
		
		average = computeAverageOnDoubleStream2(numbers.stream());
		System.out.println("Average is->" + average );
		
		average = computeAverageOnDoubleStream3(numbers.stream());
		System.out.println("Average is->" + average );
		
		//this will error, putting in try catch
		try {
			average = computeAverageOnDoubleStream4(numbers.stream());
			System.out.println("Average is->" + average );
		}catch(Exception e) {
			System.err.println("Stream Error while calculating average:"+ e.getMessage());
		}
		
	}
	
	
	private static Double computeAverageOnDoubleStream1(Stream<Double> stream)
	{
		OptionalDouble result = stream.mapToDouble(x->x).average();
		return result.isPresent() ? result.getAsDouble(): null;
	}
	
	
	
	private static Double computeAverageOnDoubleStream2(Stream<Double> stream)
	{
		Double result = stream.collect(Collectors.averagingDouble(x->x));
		return result;		
	}
	
	
	private static Double computeAverageOnDoubleStream3(Stream<Double> stream)
	{
		DoubleSummaryStatistics result = stream.collect(Collectors.summarizingDouble(x->x));
		return result.getAverage();		
	}
	
	private static Double computeAverageOnDoubleStream4(Stream<Double> stream)
	{
		//can't do this, stream.count can't be invoked, stream is already closed.
		Optional<Double> result = stream.reduce((x,y) ->x+y);
		return result.isPresent() ? result.get() /stream.count(): null;		
	} 

}
