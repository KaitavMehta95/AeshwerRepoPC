package com.udemyCollectionConcurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

	class DelayedWorker implements Delayed
{
	private long duration;
	private String message; 
	
	public DelayedWorker(long duration, String message) {
		this.duration = System.currentTimeMillis() + duration;
		this.message = message;
	}

	@Override
	public int compareTo(Delayed otherDelay) {
		if(this.duration < ((DelayedWorker)otherDelay).getDuration())
			return -1;
		else if(this.duration > ((DelayedWorker)otherDelay).getDuration()) 
			return 1;
		else 
			return 0;
	}

	@Override
	public long getDelay(TimeUnit unit) {
		return unit.convert(duration - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
	}
	
	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString(){return ""+this.message;}
}
public class DelayQueueLearn {

	public static void main(String[] args) {
		BlockingQueue<DelayedWorker> queue = new DelayQueue();
		try {
			queue.put(new DelayedWorker(1000, "This is the first message"));  // this delay 1s expires first
			queue.put(new DelayedWorker(10000, "This is the second message")); // this delay 1s expires third
			queue.put(new DelayedWorker(4000, "This is the third message")); // this delay 1s expires second
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		while(!queue.isEmpty())
		{
			try {
				System.out.println(queue.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
