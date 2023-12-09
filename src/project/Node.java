package project;

import java.io.Serializable;

//Class for tree node
public class Node<E>  implements Serializable
{
	int key;			//key - determines position in tree
	E data;				//data - stores the data
	Node<E> leftChild;	//points to the child to the left
	Node<E> rightChild;	//points to the child to the right

	//constructor - key and data are parameters
	public Node(int k, E e) 
	{
		key = k;
		data = e;
		leftChild = null;
		rightChild = null;
	}

	//displays key and data
	public void display() 
	{
		System.out.print(key + ":");
		System.out.println(data);
	}
}
