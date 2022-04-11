package com.vmb.enterprise.datastructure;

import java.util.Arrays;

public class DynamicQueueImpl {

	
	private int capacity	=	2;
	private int[] queueArray;
	private int front=0;
	private int rear=-1;
	private int currentSize	=	0;
	
	public DynamicQueueImpl() {
		queueArray	=	new int[this.capacity];
	}

	public void enqueue(int item) {
		
		if(this.isQueueFull()) {
			//System.out.println("Queue size full, unable to add "+item);
			this.increaseCapacity();
		}else {
			rear++;
			if(rear	>=	queueArray.length && currentSize != queueArray.length) {
				rear	=	0;
			}
			queueArray[rear]	=	item;
			currentSize++;
			System.out.println("Element " + item+ " is pushed to Queue !");	
		}
	}
	
	public void dequeue() {
		
		if(this.isQueueEmpty()) {
			System.out.println("Queue size empty");
		}else {
			front++;
			if(front	==	capacity-1) {
				System.out.println("pop operation done! removed"+ queueArray[front-1]);
				front = 0;
			}else {
				System.out.println("pop operation done! removed"+ queueArray[front-1]);
			}
			currentSize--;
		}
		
	}
	
	private void increaseCapacity() {
		
		int newCapacity	=	this.queueArray.length*2;
		int newArray[]	=	new int[newCapacity];
		int tmpFront = front;
		int index	=	-1;
		
		
		 while(true){
	            newArray[++index] = this.queueArray[tmpFront];
	            tmpFront++;
	            if(tmpFront == this.queueArray.length){
	                tmpFront = 0;
	            }
	            if(currentSize == index+1){
	                break;
	            }
	        }
		

		this.queueArray	=	newArray;
		
		this.front	=	0;
		this.rear 	=	index;
	}
	public boolean isQueueFull() {
		
		if(currentSize==capacity) {
			return true;
		}
		return false;
	}
	
	public boolean isQueueEmpty() {
		if(currentSize==0) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {

		DynamicQueueImpl queue	=	new DynamicQueueImpl();
		 queue.enqueue(4);
	        queue.dequeue();
	        queue.enqueue(56);
	        queue.enqueue(2);
	        queue.enqueue(67);
	        queue.dequeue();
	        queue.dequeue();
	        queue.enqueue(24);
	        queue.dequeue();
	        queue.enqueue(98);
	        queue.enqueue(45);
	        queue.enqueue(23);
	        queue.enqueue(435);
	}

}
