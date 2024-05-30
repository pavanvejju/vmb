package com.vmb.enterprise.threads;

public class MyRunnable implements Runnable{

	@Override
	public  void run() {
		// TODO Auto-generated method stub
		
		
		
		System.out.println("Thread Started--"+Thread.currentThread().getName());
		try {
			Thread.sleep(4000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("Thread Ended--"+Thread.currentThread().getName());
	}
	
	

}
