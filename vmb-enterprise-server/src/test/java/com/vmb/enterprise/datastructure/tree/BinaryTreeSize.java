/**
 * 
 */
package com.vmb.enterprise.datastructure.tree;

/**
 * @author pavankumarv
 *@desc Write a program to Calculate Size of a tree | Recursion
 *
 *Size of a tree = Size of left subtree + 1 + Size of right subtree.
 *
 *@algorithm: 
 *
 *size(tree)
1. If tree is empty then return 0
2. Else
     (a) Get the size of left subtree recursively  i.e., call 
          size( tree->left-subtree)
     (a) Get the size of right subtree recursively  i.e., call 
          size( tree->right-subtree)
     (c) Calculate size of the tree as following:
            tree_size  =  size(left-subtree) + size(right-
                               subtree) + 1
     (d) Return tree_size
 *
 */

/* Class to find size of Binary Tree */
public class BinaryTreeSize {

	Node root;
	
	public int size() {
		return size(root);
	}
	public int size(Node node) {
		if(node==null) {
			return 0;	
		}
		return (size(node.left) + 1 + size(node.right));
	}
	
	
	
	public static void main(String args[])
	{
		BinaryTreeSize binaryTreeSize	=	new BinaryTreeSize();
		binaryTreeSize.root				=	new Node(1);
		binaryTreeSize.root.left			=	new Node(2);
		binaryTreeSize.root.right			=	new Node(3);
		binaryTreeSize.root.left.left		=	new Node(4);
		binaryTreeSize.root.left.right	=	new Node(5);
		binaryTreeSize.root.right.left	=	new Node(6);
		binaryTreeSize.root.right.right	=	new Node(7);
		
		 System.out.println("The size of binary tree is : "+ binaryTreeSize.size());
		
		
	}
	
}


