package com.udemy.paralleAlgo;

import java.util.Random;

public class App {

	public static void main(String[] args) {
		
		Random random = new Random();
		int[] num = new int [30];
		
		int[] nums = {4,2,6,5,44,78,-4,1,0};
		
		for(int i=0;i<num.length;i++)
		{
			num[i]= random.nextInt(1000)-500;
		};

		MergeSort mergeSort = new MergeSort(nums);
		mergeSort.mergerSort(0, nums.length-1);
		mergeSort.showResult();	
		
	}
}
