package com.vmb.enterprise.threads;

public class MyRunnableThread implements Runnable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Starting Main method----");
		MyRunnableThread myRunnable= new MyRunnableThread();
		Thread thread= new Thread(myRunnable);
		//thread.start();

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		System.out.println("----inside run method----");
		
	}

}
