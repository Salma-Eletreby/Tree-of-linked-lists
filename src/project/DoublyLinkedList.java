package project;

import java.io.Serializable;

//Class: for doubly linked list
public class DoublyLinkedList<Student>  implements Serializable
{
	private DNode<Student> header;	//refers to the beginning of the list
	private DNode<Student> trailer; //refers to the end of the list
	private int size=0;				//refers to the size and number of elements
	
	//Constructor - No parameters
	public DoublyLinkedList() 
	{ 
		header=new DNode<>(null,null,null);		//dummy header
		trailer=new DNode<>(null,header,null);	//empty list
		header.setNext(trailer);
	}
	
	//Getters and Setters 
	public DNode<Student> getHeader() 
	{
		return header;
	}

	public void setHeader(DNode<Student> header) 
	{
		this.header = header;
	}

	public DNode<Student> getTrailer() 
	{
		return trailer;
	}

	public void setTrailer(DNode<Student> trailer) 
	{
		this.trailer = trailer;
	}

	public int getSize() 
	{
		return size;
	}

	public void setSize(int size) 
	{
		this.size = size;
	}
	
	//returns size of list
	public int size() 
	{ 
		return size;
	}
	
	//Checks if list is empty - returns true if empty and false if not
	public boolean isEmpty()
	{
		return size==0;
	}
	
	//returns first element in list
	public Student first()
	{
		if (isEmpty()) 
			return null;
		
		return header.getNext().getData();
	}
	
	//returns last element in list
	public Student last()
	{
		if (isEmpty()) 
			return null;
		
		return trailer.getPrev().getData();
	}

	//adds new data between two existing nodes
	private void addBetween(Student e, DNode<Student> predecessor, DNode<Student> successor)
	{
		DNode<Student> newest=new DNode<>(e,predecessor,successor);
		predecessor.setNext(newest);
		successor.setPrev(newest);
		
		size++;
	}
	
	//deletes an existing node
	private Student remove(DNode<Student> node)
	{
		DNode<Student> predecessor=node.getPrev();
		DNode<Student> successor=node.getNext();
		
		predecessor.setNext(successor);
		successor.setPrev(predecessor);
		
		size--;
		
		return node.getData();
	}
	
	//adds new node to the beginning of the list - first position after dummy
	public void addFirst(Student e)
	{ 
		addBetween(e,header,header.getNext());
	}
	
	//adds new node to the end of the list - last position before dummy
	public void addLast(Student e)
	{ 
		addBetween(e,trailer.getPrev(),trailer);
	}

	//deletes first node that is after the dummy header
	public Student removeFirst()
	{
		if(isEmpty()) 
			return null;
		
		return remove(header.getNext());
	}

	//removes last node that is before the dummy tailer
	public Student removeLast()
	{
		if(isEmpty()) 
			return null;
		
		return remove(trailer.getPrev());
	}
	
	//displays elements from first to last - asc 
	public void printForward()
	{
		for (DNode<Student> tmp=header.getNext();tmp!=trailer;tmp=tmp.getNext())
			System.out.println(tmp.getData());
	}

	//displays elements from last to first - desc
	public void printBackward()
	{
		
		for (DNode<Student> tmp=trailer.getPrev();tmp!=header;tmp=tmp.getPrev())
			System.out.println(tmp.getData());
	}

	//Searches for a specific student using ID
	public Student find(int id) 
	{
		DNode<Student> tmp = header.getNext();
		
		System.out.println(tmp.getData());
			return tmp.getData();
	}
}
