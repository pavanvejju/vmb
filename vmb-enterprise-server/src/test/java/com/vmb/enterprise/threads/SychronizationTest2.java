package com.vmb.enterprise.threads;
 class MyRunnable4 implements Runnable{
 
    @Override
    public void run(){
          // if(Thread.currentThread().getName().equals("Thread-1"))
                  method1();
          // else
                  method2(); 
    }
 
    synchronized void method1(){
           System.out.println(Thread.currentThread().getName()+
                        " in  synchronized void method1() started");
           try {
                  Thread.sleep(2000);
           } catch (InterruptedException e) {
                  e.printStackTrace();
           }
           System.out.println(Thread.currentThread().getName()+
                        " in  synchronized void method1() ended");
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
 
public class SychronizationTest2 {
    public static void main(String args[]) throws InterruptedException{
           
           MyRunnable4 myRunnable=new MyRunnable4();
           
           Thread thread1=new Thread(myRunnable,"Thread-1");
           Thread thread2=new Thread(myRunnable,"Thread-2");
           thread1.start();        
           thread2.start();        
           
           
    }
 
}