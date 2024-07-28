package com.vmb.enterprise.collections.list;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListSetRemove {

	public static void main(String[] args) {

		List<Integer> l	=	new ArrayList<>();
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(4);
		l.add(5);
		l.remove(1);

        for (Integer i : l) {
            System.out.println(i);
        }

        System.out.println("=======For List, it will treat as a index where as for set it treat as a value==========");
		
		Set<Integer> s	=	new HashSet<>();
		s.add(1);
		s.add(2);
		s.add(3);
		s.add(4);
		s.add(5);
		s.remove(1);
        for (Integer j : s) {
            System.out.println(j);
        }

        System.out.println("=======================================");
	}

}
