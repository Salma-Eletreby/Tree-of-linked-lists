package project;

import java.io.Serializable;

//Class for object Student
public class Student  implements Serializable
{
	private int id;
	private String name;
	private double gpa;
	
	public Student(int id, String name, double gpa) 
	{
		this.id = id;
		this.name = name;
		this.gpa= gpa;
	}
	
	public int getId() 
	{
		return id;
	}
	
	public void setId(int id) 
	{
		this.id = id;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	@Override
	public String toString() 
	{
		return "\nID: " + id + "\nName: " + name + "\nGPA: " + gpa;
	}
}
