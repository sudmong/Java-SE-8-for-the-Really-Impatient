package com.exercise.chap1;

import java.io.File;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Problem statement
 * Given an array of File objects, sort it so that the directories come before the
files, and within each group, elements are sorted by path name. Use a lambda
expression, not a Comparator.
 * @author Sudhir
 *
 */
public class Ex4SortFiles {

	public static void main(String[] args) {
		
		File f = new File("c://sudhir-work");
		sortAndPrintFilesLamda(f);
		
	}
	
	public static void sortAndPrintFilesLamda(File path)
	{
		File[] subdirectoris =  path.listFiles();
		
		Arrays.sort(subdirectoris, (File f1, File f2 ) -> 
		{
			if(f1.isDirectory() && f2.isFile())
				return -1;
			if(f1.isFile() && f2.isDirectory() )
				return 1;
			return f1.getName().toLowerCase().compareTo(f2.getName().toLowerCase());		
			
		}
		);
		Stream.of(subdirectoris).forEach(System.out :: println);		
	}
	
	}
