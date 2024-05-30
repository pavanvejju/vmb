package com.vmb.enterprise.threads;

public class EvenOddThreadSleepTest{

public static void main(String[] args) {
		EvenNumbersWithSleep et	=	new EvenNumbersWithSleep();
		et.start();
		
		OddNumbersWithSleep ot	=	new OddNumbersWithSleep();
		ot.start();
	}
	
}


/* sample program to print even and odd numbers sequentially with two threads*/
class EvenNumbersWithSleep extends Thread{

	@Override
	public void run(){
		for(int i=0; i<10;i+=2){
			try {
				System.out.println(i);
				Thread.sleep(1000);

			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
/* sample program to print even and odd numbers sequentially with two threads*/
class OddNumbersWithSleep extends Thread{
	
	@Override
	public void run(){
		for(int j=1; j<10;j+=2){
			try {
				System.out.println(j);
				Thread.sleep(1000);

			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
