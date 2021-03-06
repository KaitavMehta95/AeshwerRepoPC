package com.udemy.StudentLibrarySimulation;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StartApp {

	public static void main(String[] args) {

		Student[] student = null;
		Book[] books = null;
		ExecutorService executorService =Executors.newFixedThreadPool(ConstantNumber.NUMBER_OF_STUDENTS);
		
		try{
			
			books = new Book[ConstantNumber.NUMBER_OF_BOOKS];
			student = new Student[ConstantNumber.NUMBER_OF_STUDENTS];
			
			for(int i=0;i<ConstantNumber.NUMBER_OF_BOOKS;i++)
			{
				books[i] = new Book(i); 
			}
			
			for(int i=0;i<ConstantNumber.NUMBER_OF_STUDENTS;i++)
			{
				student[i] = new Student(i, books);
				executorService.execute(student[i] );
			}
		}
		catch(Exception e){
			e.printStackTrace();
			executorService.shutdown();
		}
		finally
		{
			executorService.shutdown();
		}
		
	}

}
