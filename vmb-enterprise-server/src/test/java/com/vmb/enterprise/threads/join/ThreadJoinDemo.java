package com.vmb.enterprise.threads.join;

public class ThreadJoinDemo {

	public static void main(String args[]) throws InterruptedException {

		System.out.println(Thread.currentThread().getName() + " is Started111");

		Thread exampleThread = new Thread() {
			public void run() {
				try {
					System.out.println(Thread.currentThread().getName()+ " is Started");
					Thread.sleep(2000);
					System.out.println(Thread.currentThread().getName()+ " is Completed");
					
				} catch (InterruptedException ex) {
					
					// System.out.println(ex.printStackTrace());
					ex.printStackTrace();
				}
			}
		};

		exampleThread.start();
		exampleThread.join();

		System.out.println(Thread.currentThread().getName() + " is Completed11");
	}

}
