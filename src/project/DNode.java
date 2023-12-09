package project;

import java.io.Serializable;

//Class: Node for Doubly linked list
public class DNode <Student> implements Serializable
{
	private Student data;			//data: ID + Name + GPA
	private DNode<Student> prev;	//previous node: points to the node before
	private DNode<Student> next;	//next node: points to the node after

	//Constructor:passes student, header, next node
	public DNode(Student d, DNode<Student> header,DNode<Student> n)
	{
		data=d;
		prev=header;
		next=n;
	}

	//returns the data: Student details
	public Student getData()
	{ 
		return data; 
	}

	//returns the node after
	public DNode<Student> getNext()
	{ 
		return next; 
	}
	
	//returns the node before
	public DNode<Student> getPrev()
	{ 
		return prev; 
	}
	
	//sets the value of the node that comes next
	public void setNext(DNode<Student> trailer) 
	{ 
		next=trailer;
	}
	
	//sets the value of the node that comes before
	public void setPrev(DNode<Student> p) 
	{ 
		prev=p;
	}
}
