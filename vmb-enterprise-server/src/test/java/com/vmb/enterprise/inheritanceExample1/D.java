/**
 * 
 */
package com.vmb.enterprise.inheritanceExample1;

/**
 * @author pavankumarv
 *
 */
public interface D {
	
	public default void xmethod() {
		System.out.println("Hello I am interface default");
	};
}
