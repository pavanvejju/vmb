package com.vmb.enterprise.designpatterns.creational.singleton;


/**
 * @author pavankumarv
 * Private constructor <b>private SingletonExample2() {}</b> with public factory method
 * public static SingletonExample2 getSingletonInstance() {}
 * 
 * class is not final but we are not allowing to create child class, how it is possible.
 *declare every constructor as final
 *
 *Runtime class is internally implemented by using this approach
 */
public class SingletonExample2 {
	 
    // Static member holds only one instance of the
    private static SingletonExample2 singletonInstance	=	new SingletonExample2();
    // private constructor
    // SingletonExample prevents any other class from instantiating
    private SingletonExample2() {
    }
 
    // It's a public factory method
    // Providing Global point of access
    public static SingletonExample2 getSingletonInstance() {   
    
        return singletonInstance;
    }
 
    public void printSingleton(){
        System.out.println("Inside print Singleton");
    }
}
