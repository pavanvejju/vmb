package com.vmb.enterprise.threads.execution;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class DemoExecutorUsage {

	private static ExecutorService executor	=	null;
	private static volatile Future taskOneResults =null;
	private static volatile Future taskTwoResults =null;
	
	public static void main(String[] args) {

		executor	=	Executors.newFixedThreadPool(2);
		
		while(true){
			try{
				checkTasks();
				Thread.sleep(100);
			}catch(Exception e){
				System.err.println("Caught exception: " + e.getMessage());
			}
		}
	}
	
	private static void checkTasks(){
		
		if(taskOneResults	==	null || taskOneResults.isDone() || taskOneResults.isCancelled()){
			taskOneResults		=	executor.submit(new TestOne());
		}
		
		if(taskTwoResults	==	null || taskTwoResults.isDone() || taskTwoResults.isCancelled()){
			taskTwoResults		=	executor.submit(new TestTwo());
		}
		
	}

}

class TestOne implements Runnable{

	@Override
	public void run() {
		while (true)
        {
            System.out.println("Executing task one");
            try
            {
                Thread.sleep(1000);
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }		
	}
	
}

class TestTwo implements Runnable{

	@Override
	public void run() {
		while (true)
        {
            System.out.println("Executing task two");
            try
            {
                Thread.sleep(1000);
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }		
	}
	
}
