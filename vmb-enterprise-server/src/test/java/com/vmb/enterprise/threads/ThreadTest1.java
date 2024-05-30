package com.vmb.enterprise.threads;

public class ThreadTest1 implements Runnable{
	
	
	public static void main(String[] args) {

		ThreadTest1 tt1	=	 new ThreadTest1();
		//ThreadTest1 tt2	=	 new ThreadTest1();
		
		Thread t1	= new Thread(tt1);
		t1.start();
		
		Thread t2	= new Thread(tt1);
		t2.start();

	}

	@Override
	public void run() {
		int a=10;
		System.out.println(Thread.currentThread().getName()+"==a=="+a);	
		a=50;
		System.out.println(Thread.currentThread().getName()+"==update : a=="+a);	
	}
}
