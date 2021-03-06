package com.udemy.paralleAlgo;

public class MergeSort {
	
	private int[] num;
	private int[] tempArray;
	
	public MergeSort(int[] num) {
		this.num = num;
		this.tempArray = new int[num.length];
	}
	
	public void mergerSort(int low, int high)
	{
		if(low >= high)
		{
			return;
		}
		
		int middle = (low+high)/2;
		mergerSort(low, middle);
		mergerSort(middle+1, high);
		merge(low,middle,high);
	}
	
	public void showResult()
	{
		for(int i=0;i<num.length-1;i++)
		{
			System.out.print(num[i]+ " ");
		}
	}
	
	private void merge(int low, int middle, int high)
	{
		for(int i=low;i<= high;i++)
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
	
	public boolean isSorted()
	{
		for(int i=0;i<num.length;i++)
		{
			if(num[i]>num[i+1]){
				return false;
			}
		}
		return true;
	}

}
