package com.vmb.enterprise.threads;


/* sample program to print even and odd numbers sequentially with two threads*/
public class EventOddNumbers extends Thread{
	public static int myCount=1;
	Object lock;
	
	public EventOddNumbers(Object lock) {
		// TODO Auto-generated constructor stub
		this.lock=lock;
	}
	
	@Override
	public void run(){
		while (myCount <= 9) {
		//System.out.println("run started"+Thread.currentThread().getName());
		if (myCount%2==0 && Thread.currentThread().getName().equals("even")){
			synchronized (lock) {
				System.out.println("even number"+myCount);
				myCount++;
				 try {
	                    lock.wait();
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }

			}
			
		}
		else if (myCount%2!=0 && Thread.currentThread().getName().equals("odd")){
			synchronized (lock) {
				System.out.println("odd number"+myCount);
				myCount++;
				lock.notify();

			}
			
			
			
		}
	}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("--inside Main method---");
		Object obj = new Object();
		EventOddNumbers evenThread = new EventOddNumbers(obj);
		EventOddNumbers oddThread = new EventOddNumbers(obj);
		evenThread.setName("even");
		oddThread.setName("odd");
		evenThread.start();
		oddThread.start();
		
	}
	
}
