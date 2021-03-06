package com.udemy.paralleAlgo;

import java.util.Random;


public class AppParallel {

	public static Random random = new Random();
	
	public static void main(String[] args) {
		int numOfThreads  = Runtime.getRuntime().availableProcessors();
		int[] nums = {4,2,6,5,44,78,-4,0,1};
		
		System.out.println("Number of threads/cores: " + numOfThreads);
		
	/*	ParallelMergeSort mergeSort = new ParallelMergeSort(nums);
		mergeSort.parallelMergeSort(0, nums.length-1, numOfThreads);
		mergeSort.showResult();
		*/
		
		// check if its better than sequential sort 
		int[] numbers = createRandomArray();
		ParallelMergeSort mergeSort = new ParallelMergeSort(numbers);
		
		// run the algorithm and time how long it takes ======PARALLEL
		long startTime1 = System.currentTimeMillis();
		mergeSort.parallelMergeSort(0, numbers.length-1, numOfThreads);
		long endTime1 = System.currentTimeMillis();
		System.out.printf("Time taken in parallel =>  %6d ms \n", endTime1 - startTime1);
		
		
		// run the algorithm and time how long it takes ======SEQUENTIAL
		long startTime2 = System.currentTimeMillis();
		mergeSort.mergerSort(0, numbers.length-1);
		long endTime2 = System.currentTimeMillis();
		System.out.printf("Time taken in sequential =>  %6d ms \n", endTime2 - startTime2);
	}
	
	public static int[] createRandomArray() {
		int[] a = new int[100000000];
		for (int i = 0; i < 100000000; i++) {
			a[i] = random.nextInt(100000000);			
		}
		return a;
	}
}
