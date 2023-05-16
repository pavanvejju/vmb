package com.vmb.enterprise.collections.list;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailFastTest1 {

	public static void main(String[] args) {
	
		List<Integer> l	=	new CopyOnWriteArrayList<Integer>();
		//List<Integer> l	=	new ArrayList<Integer>();
			l.add(1);
			l.add(2);
			l.add(3);
			l.add(4);
			l.add(5);
	
/*If we use for loop, we not get any ConcurrentModificationException */
			for(int i=0;i<l.size();i++){
				l.remove(2);
				l.add(5);
			}
			System.out.println("Used For Loop::"+l);
/*If we use "for each" or "iterator" loop, we get Exception saying java.util.ConcurrentModificationException
 * So instead of ArrayList, need to use CopyOnWriteArrayList() */
			for (Integer k: l){
				l.remove(3);
				l.add(4);
			}
			System.out.println("Result:::"+l);
			
		
	}

}
