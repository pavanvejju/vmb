package com.vmb.enterprise.datastructure.tree;

public class Node {
	
	int data;
	Node right, left	=	null;
	
	public Node(int item){
		data	=	item;
		right=left=null;
	}
}
