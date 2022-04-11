package com.vmb.enterprise.datastructure;

import java.util.Arrays;
import java.util.stream.IntStream;

public class StackImpl{


	private int top;
	private int stackSize;
	private int[] stackArray;
	
	
	public StackImpl(int size) {
		super();
		this.stackSize = size;
		this.top=-1;
		this.stackArray	=	new int[stackSize];
	}
	
	public void push(int entry) throws Exception {
		
		if(this.isStackFull()) {
			System.out.println("Stack full so increasing twise");
			this.increaseStackFull();
			//throw new Exception("Stack is full");
		}
		System.out.println("Adding: "+entry);
		this.stackArray[++top]=entry;
	}
	public int pop() throws Exception {
		
		if(this.isStackEmpty()) {
			throw new Exception("Stack is empty");
		}
		
		int entry	=	this.stackArray[top--];
		System.out.println("Removed: "+entry);
		return entry;
	}
	public int peek() {
		int entry	=	this.stackArray[top];
		return entry;
	}
	public boolean isStackFull() {
		
		if(top==stackArray.length-1) {
			return true;	
		}
		return false;
	}
	public boolean isStackEmpty() {
		return (top==-1);
	}	

	public void increaseStackFull() {
		int[] newStackArray	=	new int[2*this.stackSize];
		Arrays.stream(stackArray).forEach(element ->  {
			newStackArray[element]=stackArray[element];});
		this.stackArray	=	newStackArray;
		this.stackSize	=	this.stackSize * 2;
	}
	
	public static void main(String[] args) {

		 StackImpl stack = new StackImpl(5);
	        try {
	            stack.push(4);
	            stack.push(8);
	            stack.push(3);
	            stack.push(89);
	            stack.pop();
	            stack.push(34);
	            stack.push(45);
	            stack.push(78);
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	        try {
	            stack.pop();
	            stack.pop();
	            stack.pop();
	            stack.pop();
	            stack.pop();
	            stack.pop();
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	        
	        System.out.println("::::::::::::::::::::::");
	        
	        StackImpl dynamicStack = new StackImpl(2);

	        IntStream.range(0, 10).forEach(i ->{
		        try {
					dynamicStack.push(i);
				} catch (Exception e) {
					e.printStackTrace();
				}
	        } );
	      
	        IntStream.range(0, 4).forEach(i -> {
	            try {
	            	dynamicStack.pop();
	            } catch (Exception e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	        });
	}
}
