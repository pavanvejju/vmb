package com.vmb.enterprise.datastructure;

public class QueueImpl {

	
	private int capacity;
	private int[] queueArray;
	private int front=0;
	private int rear=-1;
	private int currentSize	=	0;
	
	
	
	
	public QueueImpl(int queueSize) {
		super();
		this.capacity = queueSize;
		queueArray	=	new int[queueSize];
	}

	public void enqueue(int item) {
		
		if(this.isQueueFull()) {
			System.out.println("Queue size full, unable to add "+item);
		}else {
			rear++;
			if(rear	==	capacity-1) {
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

		QueueImpl queue	=	new QueueImpl(4);
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
