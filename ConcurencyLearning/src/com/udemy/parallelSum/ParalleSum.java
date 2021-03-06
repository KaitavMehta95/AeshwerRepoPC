package com.udemy.parallelSum;

public class ParalleSum {

	private ParallelWorker[] parallelWorkers;
	private int numberOfThreads;
	
	public ParalleSum(int numberOfThreads) {
		this.numberOfThreads = numberOfThreads;
		this.parallelWorkers = new ParallelWorker[numberOfThreads];
	}
	
	// this helps us divide the array into sub arrays based on numberOfThreads	
	public int sum(int[] nums)
	{
		int steps = (int)Math.ceil(nums.length*1.0/numberOfThreads);
		for(int i =0; i<numberOfThreads; i++)
		{
			parallelWorkers[i]= new ParallelWorker(nums, i*steps, (i+1)*steps);
			parallelWorkers[i].start();
		}
			
			try{
				for(ParallelWorker worker : parallelWorkers)
					{	
						worker.join();
					}
			}catch(InterruptedException e){e.printStackTrace();}
			
			
			// now total the partial sum
			int total = 0; 
			for(ParallelWorker worker : parallelWorkers)
			{
				total = worker.getPartialSum();
			}
			
			return total;
	}
}
