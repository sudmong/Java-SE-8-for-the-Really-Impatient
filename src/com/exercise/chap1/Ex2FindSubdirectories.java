package com.exercise.chap1;

import java.io.File;
import java.io.FileFilter;
import java.util.stream.Stream;

/**
 * Problem statement
 * Using the listFiles(FileFilter) and isDirectory methods of the java.io.File class,
write a method that returns all subdirectories of a given directory. Use a
lambda expression instead of a FileFilter object. Repeat with a method
expression.
 * @author Sudhir
 *
 */
public class Ex2FindSubdirectories {
	
	public static void main(String [] args) {	
		
		File f = new File("c://");
		//printSubDirectories(f);
		printSubDirectoriesWithLamda(f);
	}
	
	
	/**
	 * Print sub directories pre-Lamdas
	 * @param f
	 */
	public static void printSubDirectories(File f)
	{
		File[] subdirectoris = f.listFiles(new FileFilter() {
			public boolean accept(File f) {
				return f.isDirectory();
			}
		});
		
		Stream.of(subdirectoris).forEach(System.out:: println);
	}
	
	public static void printSubDirectoriesWithLamda(File f)
	{
		// Lamda
		//File[] subdirectories = f.listFiles(file -> file.isDirectory());	
		
		//Method expression /Method reference / double colon operator
		File[] subdirectories = f.listFiles(File::isDirectory);
		
		//print it
		Stream.of(subdirectories).forEach(System.out:: println);
	}
}
