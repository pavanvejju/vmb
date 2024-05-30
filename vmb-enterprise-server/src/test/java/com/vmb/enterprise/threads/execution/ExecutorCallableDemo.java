package com.vmb.enterprise.threads.execution;

import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class ExecutorCallableDemo {

	public static void main(String[] args) throws Exception {

		PrintCallJob[] jobs	=	{new PrintCallJob(10),
								new PrintCallJob(30),
								new PrintCallJob(20),
								new PrintCallJob(40),
								new PrintCallJob(50),
								new PrintCallJob(60)
								};
		ExecutorService executor	=	Executors.newFixedThreadPool(3);
		
		Arrays.asList(jobs).stream().forEach(job ->{
			Future future 	=	executor.submit(job);
			try {
				System.out.println("Sum value is "+future.get());
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
				);
		/*for(PrintCallJob job: jobs){
			Future future =	executor.submit(job);
			System.out.println(future.get());
		}*/
		
		executor.shutdown();
		
		
		
		
	}
}

class PrintCallJob implements Callable<Object>{

	int num;
	
	PrintCallJob(int num){
		this.num	=	num;
	}
	
	@Override
	public Object call(){

		System.out.println(Thread.currentThread().getName()+" is responsible to find sum of first "+num+" Number");
	
	/*	int sum	=	0;
		for(int i=0;i<=num;i++){
			sum	=	sum+i;
		}*/
		
		
		IntStream intStream = IntStream.rangeClosed(1, num);
		int resultSum	=	intStream.sum();
		
	 return resultSum;
	
	}
	
}