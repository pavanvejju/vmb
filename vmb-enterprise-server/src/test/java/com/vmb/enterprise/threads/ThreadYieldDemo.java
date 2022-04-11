package com.vmb.enterprise.threads;

public class ThreadYieldDemo {

	public static void main(String[] args) {

		MyYieldThread mt1	=	new MyYieldThread();
		mt1.start();
		
		for(int i=0;i<10;i++){
		
			System.out.println("Main Thread");
		}
	}

}

class MyYieldThread extends Thread{
	
	@Override
	public void run(){
		for(int i=0;i<10;i++){
			System.out.println("Child Thread");
			Thread.yield();
		}
	}
}
