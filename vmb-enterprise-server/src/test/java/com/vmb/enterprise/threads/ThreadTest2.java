package com.vmb.enterprise.threads;

public class ThreadTest2 {

    
    static volatile int x = 0, y = 0;
    
    static void method1() {
           x++; y++;
          System.out.println("Thread1 x=" + x + " y=" + y);
    }
    static void method2() {
           System.out.println("x=" + x + " y=" + y);
    }
    
    public static void main(String[] args) {
           Thread thread1=new Thread(){
                  public void run(){
                        for(int i=0; i<10;i++)
                               method1();
                        
                  }
           };
 
           Thread thread2=new Thread(){
                  public void run(){
                        for(int i=0; i<10;i++)
                               method2();
                        
                  }
           };
           
           thread1.start();
           thread2.start();
    }
}