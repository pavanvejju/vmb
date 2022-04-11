package com.vmb.enterprise.examples2;


public class TestException {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method s
		
		TestException testE=new TestException();
		System.out.println(""+testE.test());
		
		
		

		/*int i=1;
		try{
		     i=10;
			System.out.println(""+i);
			//System.exit(0);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		finally{
		    // i=20;
			i++;
		     System.out.println(""+i);
		}*/
	
	}

	
	
	private int test(){
		int i;
		try{
		     i=10;
			return i;
		}catch (Exception e) {
			// TODO: handle exception
		}finally{
		     i=20;
			return i;
		}
	}
}
