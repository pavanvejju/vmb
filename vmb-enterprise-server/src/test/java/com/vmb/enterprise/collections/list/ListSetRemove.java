package com.vmb.enterprise.collections.list;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListSetRemove {

	public static void main(String[] args) {

		List<Integer> l	=	new ArrayList<Integer>();
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(4);
		l.add(5);
		l.remove(1);

		l.stream().forEach(i->System.out.println(i));
		
		System.out.println("=======For List, it will treat as a index where as for set it treat as a value==========");		
		
		Set<Integer> s	=	new HashSet<Integer>();
		s.add(1);
		s.add(2);
		s.add(3);
		s.add(4);
		s.add(5);
		s.remove(1);
		s.stream().forEach(j->System.out.println(j));
		
		System.out.println("=======================================");	
	}

}
