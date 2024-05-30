package com.vmb.enterprise.threads.join;

public class ThreadJoinDemo1 {

	public static void main(String[] args) {

		MyJoinThread mt1	=	new MyJoinThread();
		mt1.start();
		
		try {
			//mt1.join(); // once child thread completed, then only main thread will execute
			mt1.join(10000); // main thread will wait 10 sec and then continue
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i=0;i<10;i++){
		
			System.out.println("Main Thread");
		}
	}

}

class MyJoinThread extends Thread{
	
	@Override
	public void run(){
		for(int i=0;i<10;i++){
			System.out.println("Child Thread");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
