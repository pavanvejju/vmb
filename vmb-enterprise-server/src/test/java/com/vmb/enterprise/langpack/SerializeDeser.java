package com.vmb.enterprise.langpack;

  
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
 
class MyClass1  {}
 
class Employee implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private Integer id;
    private MyClass1 myClass ;
    
    public Employee(Integer id) {
           this.id = id;
           myClass=new MyClass1();
    }
 
    @Override
    public String toString() {
           return "Employee [id=" + id + "]";
    }
 
}
 
public class SerializeDeser {
 
    public static void main(String[] args) {
 
           Employee object1 = new Employee(8);
 
           try {
                  OutputStream fout = new FileOutputStream("ser.txt");
                  ObjectOutput oout = new ObjectOutputStream(fout);
                  System.out.println("Serialization process has started, serializing objects...");
                  oout.writeObject(object1);
                  System.out.println("Object Serialization completed.");
                  fout.close();
         oout.close();
           
           } catch (IOException  e) {
                  e.printStackTrace();
           }
 
    }
 
}