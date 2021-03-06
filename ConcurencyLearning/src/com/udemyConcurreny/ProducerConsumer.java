package com.udemyConcurreny;

import java.util.ArrayList;
import java.util.List;

class Process{
	
	private List<Integer> list = new ArrayList<Integer>();
	
	private final int LIMIT = 5;
	
	private final int BOTTOM  = 0;
	
	private final  Object lock=new Object();
	
	private int values = 0;
	
	public void produce() throws InterruptedException
	{
		synchronized (lock) {    // Intrinsic class levellock
			
			while(true){
				if(list.size() == LIMIT)
				{
					System.out.println("Waiting for removing items from list");
					lock.wait(); // be carefull... u cant use just wait() as that will be for the wait of the class level lock 	
				}
				
				else
				{
					System.out.println("Adding values:" +values);
					list.add(values);
					values++;
					lock.notify();
				}
				Thread.sleep(500);
			}
		}
	}
	
	public void consume() throws InterruptedException
	{
		synchronized (lock){
			
			while(true){
				if(list.size() == BOTTOM)
				{
					System.out.println("Waiting for items to add to the list");
					lock.wait(); // be carefull... u cant use just wait() as that will be for the wait of the class level lock 	
				}
				
				else
				{
					System.out.println("Removed values:" +list.remove(--values));
					lock.notify();
				}
				
				Thread.sleep(500);
			}
		}
		
	}
	
}

public class ProducerConsumer {
	public static void main(String[] args) {
		
		Process process = new Process(); 
		Thread t1 = new Thread(new Runnable(){
			 
			@Override
			public void run() 
			{
				try {
					process.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		);
		
		Thread t2 = new Thread(new Runnable(){
			 
			@Override
			public void run() 
			{
				try {
					process.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		);
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	} 
}
