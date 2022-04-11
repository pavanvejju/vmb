package com.vmb.enterprise.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * Write a java method to delete every 5th element from a given ArrayList
 * */
public class Example9 {

	
	public static void removeElement(List l,int i){
		/*Iterator itr	=	l.iterator();
		while(itr.hasNext()){
			itr.next();
			itr.next();
			itr.remove();
		}*/
		
		if(l.size()>1){
			for(int j=0;j<l.size();j++){
				
				if(j%i==0){//Every nth element should be true
					l.remove(j);
				}
			}
		}
		
	}
	public static void main(String[] args) {

		List l	=	new ArrayList();
		Random r	=	new Random();
		
		for(int i=1;i<=100;i++){
			l.add(r.nextInt(i));
		}
		
			
		System.out.println(l.size());
		Example9.removeElement(l,5);
		
		System.out.println(l.size());
	}

}
