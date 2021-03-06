package TerminateThreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import namingTheThread.NamedThreadFactory;

// Terminate at non blocking Point

public class ExecutorWayTerminateFirstWay {

	public static void main(String[] args) throws InterruptedException {
		String currentThread = Thread.currentThread().getName(); 
		System.out.println(currentThread + "Main Thread Starts Here");
		
		ExecutorService executorService = Executors.newCachedThreadPool(new NamedThreadFactory());
		
		LoopTaskE t1 = new LoopTaskE();
		FactorialTaskA t2 = new FactorialTaskA(30, 1000);
		
		executorService.execute(t1);
		executorService.submit(t2);
		
		executorService.shutdown();
		
		TimeUnit.MILLISECONDS.sleep(3000);
		
		t1.cancle();
		t2.cancle();
		
		System.out.println(currentThread + "Main Thread ENDS Here");
		}
}

