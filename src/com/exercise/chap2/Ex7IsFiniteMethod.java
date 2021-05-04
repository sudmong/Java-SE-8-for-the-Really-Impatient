package com.exercise.chap2;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Problem Statement
 * Your manager asks you to write a method public static <T> boolean
isFinite(Stream<T> stream). Why isn’t that such a good idea? Go ahead and
write it anyway.
 * @author Sudhir Mongia
 *
 */
public class Ex7IsFiniteMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static <T> Optional<Boolean> isFinite(Stream<T> stream) 
	{
		//There is no way to find out if a Stream is finite or not.
		return Optional.empty();
	}

}
