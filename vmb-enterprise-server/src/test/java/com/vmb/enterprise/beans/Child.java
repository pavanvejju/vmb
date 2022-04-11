package com.vmb.enterprise.beans;
import java.io.Serializable;

public class Child extends Parent implements Serializable {
 int age = 11;
 public String toString() {
 return "age=" + age + " hello=" + hello;
 }
}