package com.udemyConcurreny;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.management.ReflectionException;

public class ReEntrantLocksLearn {
	
	private static int counter = 0;

	private static Lock lock= new ReentrantLock();
	
	public static void increment()
	{
		lock.lock();     // reentrant lock used 
		
		try{
		for(int i=0;i<100;++i){          // of this logic throws exception then we never get to unlock the lock and so we use finally , try/catch block
		counter++;
		}
		}finally{
		lock.unlock();
		}
	}

	public static void main(String[] args) {
		
		Thread t1 = new Thread(new Runnable(){
			@Override
			public void run() 
			{
					increment();
			}
		}
		);
		
		Thread t2 = new Thread(new Runnable(){
			@Override
			public void run() 
			{
					increment();
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
		
		System.out.println("Count is : "+ counter);
	}
}
