package com.exercise.chap1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Problem statement
 * Form a subclass Collection2 from Collection and add a default method void
forEachIf(Consumer<T> action, Predicate<T> filter) that applies action to each
element for which filter returns true. How could you use it?
 * @author Sudhir
 *
 */
public class Ex9CollectionForEachIf {
	
	public static void main(String[] args)
	{
	Collection2<Integer> collection2 = new ArrayList2<>();
	collection2.add(100);
	collection2.add(7);
	collection2.add(105);
	collection2.add(100);
	collection2.add(7);
	collection2.add(-5);
	collection2.add(-1);
	
     Set<Integer> set = new HashSet<>();
     collection2.forEachIf(set::add, e -> e > 0);
    // collection2.forEachIf(set::add, e -> e > 0);
     System.out.println(collection2);
     System.out.println(set);
	}
}

interface Collection2<T> extends Collection<T> {

	default void forEachIf(Consumer<T> consumer, Predicate<T> filter) {
		
	forEach(e ->  {if(filter.test(e)) consumer.accept(e); }
			
			);
		
	}

}


class ArrayList2<T> extends ArrayList<T> implements Collection2<T>
{
	
}