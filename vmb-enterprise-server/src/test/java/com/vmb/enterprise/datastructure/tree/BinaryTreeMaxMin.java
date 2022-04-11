/**
 * 
 */
package com.vmb.enterprise.datastructure.tree;

/**
 * @author pavankumarv
 *@desc <b>Find maximum (or minimum) in Binary Tree</b>
 *
 *In Binary Search Tree, we can find maximum by traversing right pointers until we reach rightmost node. But in Binary Tree, we must visit every node to figure out maximum. So the idea is to traverse the given tree and for every node return maximum of 3 values.
1) Node�s data.
2) Maximum in node�s left subtree.
3) Maximum in node�s right subtree.

Below is the implementation of above approach.
 *
 */


/* Class to find min/max of Binary Tree */
public class BinaryTreeMaxMin {

	Node root;
	
	
	public int findMax(Node node) {
		
		if(node==null) {
			return Integer.MIN_VALUE;	
		}
		
		int res		=	node.data;
		int lres	=	findMax(node.left);
		int rres	=	findMax(node.right);
		
		if(lres>res)
			res	=	lres;
		
		if(rres>res)
			res	=	rres;
		
		return res;
	}
	
	public int findMin(Node node) {
		
		if(node==null) {
			return Integer.MAX_VALUE;	
		}
		
		int res	=	node.data;
		int lres	=	findMin(node.left);
		int rres	=	findMin(node.right);
		
		if (lres < res)
	        res = lres;
	    if (rres < res)
	        res = rres;
	   
	    return res;
	}
	
	
	public static void main(String args[])
	{
		 	BinaryTreeMaxMin tree = new BinaryTreeMaxMin();
	        tree.root = new Node(2);
	        tree.root.left = new Node(7);
	        tree.root.right = new Node(5);
	        tree.root.left.right = new Node(6);
	        tree.root.left.right.left = new Node(3);
	        tree.root.left.right.right = new Node(11);
	        tree.root.right.right = new Node(9);
	        tree.root.right.right.left = new Node(4);
		
		 System.out.println("The Max element of binary tree is : "+ tree.findMax(tree.root));
		System.out.println("The Min element of binary tree is : "+ tree.findMin(tree.root));
		
		
	}
	
}


