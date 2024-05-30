package com.vmb.enterprise.threads;

public class MyThread extends Thread {

	public static int mycount = 0;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("--inside Main method---");
		MyThread mythread = new MyThread();
		mythread.start();
		while (MyThread.mycount <= 10) {
			try {
				System.out.println("Main thread==" + (++MyThread.mycount));
				Thread.sleep(200);
				Thread.yield();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Exception in thread: " + e.getMessage());
			}

		}

	}

	public void run() {
		System.out.println("--inside run method---");
		while (MyThread.mycount <= 10) {
			try {
				System.out.println("Expl thread==" + (++MyThread.mycount));
				Thread.sleep(200);
				Thread.yield();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Exception in thread: " + e.getMessage());
			}

		}

	}

}
