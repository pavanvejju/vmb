package com.vmb.enterprise.threads;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPoolExample1 {

	
	private BlockingQueue<Runnable> taskQueue;
	public ThreadPoolExample1(int nThreads) {
		taskQueue	=	new LinkedBlockingQueue<Runnable>(nThreads);
		for(int i=1;i<nThreads;i++) {
		}
	}
	
	public static void main(String[] args) {

		
	}

}
