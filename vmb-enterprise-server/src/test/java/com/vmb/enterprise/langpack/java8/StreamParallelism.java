/**
 * 
 */
package com.vmb.enterprise.langpack.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author pavankumarv
 *
 */
public class StreamParallelism {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		 List<Integer> list = new ArrayList<Integer>();
         for(int i = 1; i< 10; i++){
             list.add(i);
         }
         
         Stream<Integer> stream	=	list.parallelStream();
         	stream.filter(j->j%2==0).forEach(System.out::println);;
         //System.out.println(evenNumbers);
		
	}

}
