package com.exercise.chap2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Problem Statement
 * Join all elements in a Stream<ArrayList<T>> to one ArrayList<T>. Show how to do
	this with the three forms of reduce.
 * @author Sudhir Mongia
 *
 */
public class Ex9StreamReduceMap {
	
	public static void main(String[] args) {
		
		List<List<String>> list = new ArrayList<>();
        list.add(Arrays.asList("a","b","c"));
        list.add(Arrays.asList("d","e","f"));
        list.add(Arrays.asList("g","h","i"));
        list.add(Arrays.asList("j","k","l"));
        List<String> flattenListOp1 = list.stream().flatMap(s->s.stream()).collect(Collectors.toList()); 	
        flattenListOp1.forEach(System.out::print);
      
        //Optional<List<String>> flattenListOp2 =  list.stream().reduce((x,y) -> Stream.concat(x.stream(),y.stream())).get();
        //List<String> flattenListOp3 =  list.stream().reduce((x,y) -> Stream.concat(x.stream(),y.stream())).get();
        		//.collect(Collectors.toList());
        List<String> flattenListOp2 = new ArrayList<>();
       // list.stream().reduce(flattenListOp2, (t, e) -> t.add(e));
	}
}
