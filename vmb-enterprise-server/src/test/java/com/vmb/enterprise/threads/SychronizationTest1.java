package com.vmb.enterprise.threads;
 class MyRunnable3 implements Runnable{
 
    @Override
    public void run(){
           if(Thread.currentThread().getName().equals("Thread-1"))
                  method1();
           else
                  method2();
    }
 
    static synchronized void method1(){
           System.out.println(Thread.currentThread().getName()+
                        " in static synchronized void method1() started");
           try {
                  Thread.sleep(2000);
           } catch (InterruptedException e) {
                  e.printStackTrace();
           }
           System.out.println(Thread.currentThread().getName()+
                        " in static synchronized void method1() ended");
    }
    
    synchronized void method2(){
           System.out.println(Thread.currentThread().getName()+
                        " in synchronized void method2() started");
           try {
                  Thread.sleep(2000);
           } catch (InterruptedException e) {
                  e.printStackTrace();
           }
           System.out.println(Thread.currentThread().getName()+
                        " in synchronized void method2() ended");
    }
    
}
 
public class SychronizationTest1 {
    public static void main(String args[]) throws InterruptedException{
           
           MyRunnable3 myRunnable1=new MyRunnable3();
           
           Thread thread1=new Thread(myRunnable1,"Thread-1");
           Thread thread2=new Thread(myRunnable1,"Thread-2");
           thread1.start();        
           Thread.sleep(10);//Just to ensure Thread-1 starts before Thread-2
           thread2.start();        
           
           
    }
 
}