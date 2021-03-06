package com.udemy.paralleAlgo;

// assign single thread to each left ad right sub array .. the divide is the part where we apply the parallelism 
public class ParallelMergeSort
{
		private int[] num;
		private int[] tempArray;
		
		public ParallelMergeSort(int[] num) {
			this.num = num;
			this.tempArray = new int[num.length];
		}
	
		public void parallelMergeSort(int low, int high, int numOfThreads) {
	
			// go for sequential if single core available
			if (numOfThreads <= 1) {
				mergerSort(low, high);
				return;
			}

			int middle = (low+high) / 2;
			Thread leftSorter = mergeSortParallel(low, middle, numOfThreads);
			Thread rightSorter = mergeSortParallel(middle+1 ,high, numOfThreads);

			leftSorter.start();
			rightSorter.start();
			
			try {
				leftSorter.join();
				rightSorter.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			merge(low, middle, high);
		}

		private Thread mergeSortParallel(int low , int high, int numOfThreads) {
	
			return new Thread() {
				@Override
				public void run() {
					parallelMergeSort(low , high, numOfThreads / 2);
				}
			};
		}

		public void mergerSort(int low , int high) {
			if(low >= high)
			{
				return;
			}
			int middle = (low+high)/2;
			mergerSort(low, middle);
			mergerSort(middle+1, high);
			merge(low,middle,high);
		}

		// Logic to merge two sorted arrays
		private void merge(int low, int middle, int high)
		{
			for(int i=low;i<=high;i++)
			{
				tempArray[i]=num[i];
			}
	
			int i = low;    // to sweep in left sub array 
			int j = middle+1; // to sweep in right sub array
			int k = low;   // to sweep in main array
	
			// main comparison done here
			while((i <= middle) && (j <= high))
			{
				if(tempArray[i]  <= tempArray[j])
				{
					num[k]= tempArray[i];
					i++;
				}
				else
				{
					num[k]= tempArray[j];
					j++;
				}
				k++;
			}
			//copy rest of the left side array to the main array 
			while(i<=middle)
			{
				num[k]= tempArray[i];
				k++;
				i++;
			}
			//copy rest of the right side array to the main array
			while(j<=high)
			{
				num[k]= tempArray[j];
				k++;
				j++;
			}
	
		}
		
		public void showResult()
		{
			for(int i=0;i<num.length-1;i++)
			{
				System.out.print(num[i]+ " ");
			}
		}
}
