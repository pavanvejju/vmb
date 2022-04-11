package com.vmb.enterprise.threads.execution;

public class ThreadLocalDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ThreadLocal<String> tl	=	new ThreadLocal<String>(){
			public String initialValue(){
				return "abc";
			}
		};
		System.out.println(tl.get());
		tl.set("pavan");
		tl.set("kumar");
		System.out.println(tl.get());
		tl.remove();
		System.out.println(tl.get());
	}

}
