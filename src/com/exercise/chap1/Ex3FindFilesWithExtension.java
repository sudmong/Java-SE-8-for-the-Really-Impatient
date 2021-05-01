package com.exercise.chap1;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.stream.Stream;

/**
 * Problem statement
 * Using the list(FilenameFilter) method of the java.io.File class, write a method
that returns all files in a given directory with a given extension. Use a lambda
expression, not a FilenameFilter. Which variables from the enclosing scope does
it capture?
 * @author Sudhir
 *
 */
public class Ex3FindFilesWithExtension {
	
	public static void main(String [] args) {	
		
		File f = new File("c://sudhir-work");
		printFiles(f, "pdf");
		//printFilesLamda(f, "pdf");
		
	}
	
	
	public static void printFiles(File f, String extn)
	{
		File[] subdirectoris = f.listFiles(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {				
				return name.endsWith(extn);
			}
		});
		
		Stream.of(subdirectoris).filter(file -> !file.isDirectory()).forEach(System.out :: println);
	}
	
	public static void printFilesLamda(File f, String extn)
	{
		File[] subdirectoris =  f.listFiles((file, name) ->name.endsWith(extn));
		
		Stream.of(subdirectoris).filter(file -> !file.isDirectory()).forEach(System.out :: println);
	}
}
