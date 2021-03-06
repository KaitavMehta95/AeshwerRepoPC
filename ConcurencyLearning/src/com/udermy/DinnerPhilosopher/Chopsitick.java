package com.udermy.DinnerPhilosopher;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Chopsitick {
	
	private int id;
	
	private Lock lock;

	public Chopsitick(int id) {
		this.id = id;
		this.lock = new ReentrantLock();
	}
	
	// checks if a philosopher is able to pick up the chopstick
	public boolean pickUp(Philosopher philosopher , State state) throws InterruptedException
	{
		if(lock.tryLock(10,TimeUnit.MILLISECONDS))    //able to wait for a lock acquire for a time interval
		{
			System.out.println(philosopher + " picked up "+ state.getDisplayString(state)+ id);
			return true;
		}
		
		return false;
	}
	
	public void putUp(Philosopher philosopher , State state) throws InterruptedException
 	{        // we unlock the lock on chopstick here
			lock.unlock();
			System.out.println(philosopher +" put down "+ id);
	}
}
