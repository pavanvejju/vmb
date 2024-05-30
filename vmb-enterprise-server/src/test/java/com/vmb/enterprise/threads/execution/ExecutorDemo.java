package com.vmb.enterprise.threads.execution;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorDemo {

	public static void main(String[] args) {

		PrintJob[] jobs	=	{new PrintJob("Lekhana"),
								new PrintJob("Juhit"),
								new PrintJob("Srihas"),
								new PrintJob("Yashika"),
								new PrintJob("Sahasra"),
								new PrintJob("Vejju")
								};
		ExecutorService executor	=	Executors.newFixedThreadPool(3);
		
		for(PrintJob job: jobs){
			executor.submit(job);
		}
		
		executor.shutdown();
		
	}
}

class PrintJob implements Runnable{

	String name;
	PrintJob(String name){
		this.name	=	name;
	}
	@Override
	public void run() {

		System.out.println(name+"..Job Started by Thread: "+Thread.currentThread().getName());
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println(name+"..Job Completed by Thread: "+Thread.currentThread().getName());
		
	}
	
}