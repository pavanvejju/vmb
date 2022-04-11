package com.vmb.enterprise.designpatterns.creational.singleton;


/**
 * @author pavankumarv
 * Private constructor <b>private SingletonExample2() {}</b> with public factory method
 * public static SingletonExample2 getSingletonInstance() {}
 *
 *Runtime class is internally implemented by using this approach but in public factory method added null condition.
 */
public class SingletonExample1 {
	 
    // Static member holds only one instance of the
    private static SingletonExample1 singletonInstance	=	null;
    // private constructor
    // SingletonExample prevents any other class from instantiating
    private SingletonExample1() {
    }
 
    // It's a public factory method
    // Providing Global point of access
    public static SingletonExample1 getSingletonInstance() {   
    
    	 if (null == singletonInstance) {
             singletonInstance = new SingletonExample1();
         }
         return singletonInstance;
    }
 
    public void printSingleton(){
        System.out.println("Inside print Singleton");
    }
}
