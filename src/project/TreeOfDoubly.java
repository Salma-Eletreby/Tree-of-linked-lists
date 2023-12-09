package project;

import java.io.Serializable;

//ADT Class - Tree of Doubly Linked
public class TreeOfDoubly  implements Serializable
{
	private Tree<DoublyLinkedList<Student>> t;
	private int size;

	public TreeOfDoubly() 
	{
		t = new Tree<DoublyLinkedList<Student>>();
		size =0;
	}
	
	public int size()
	{
		return size;
	}

	public void insert(Student s) 
	{
		int key = Integer.parseInt(Integer.toString(s.getId()).substring(0, 4));
		if (t.isEmpty()) {
			DoublyLinkedList<Student> list = new DoublyLinkedList<Student>();
			list.addLast(s);
			t.insert(key, list);
			
			++size;
			System.out.println("Student added succesfully!");
		} else if (t.getRoot().key == key) {
			t.getRoot().data.addLast(s);
			
			++size;
			System.out.println("Student added succesfully!");
		}

		else {
			DoublyLinkedList<Student> list = t.search(key);
			if (list == null) {
				list = new DoublyLinkedList<Student>();
				list.addLast(s);
				t.insert(key, list);
				
				++size;
				System.out.println("Student added succesfully!");
			} else {
				list.addLast(s);
				
				++size;
				System.out.println("Student added succesfully!");
			}
		}

	}

	public Student search(int id) {
		int yearAdmission = Integer.parseInt(Integer.toString(id).substring(0, 4));
		// validity of ID
		int validID = Integer.toString(id).length();
		if (validID > 9 || validID < 9) {
			System.out.println("Invalid ID! ID must be 9 digits");
			return null;
		}

		// if tree empty
		if (t.isEmpty()) {
			return null;
		}

		else if (t.getRoot().key == yearAdmission) {
			DNode<Student> tmp = t.getRoot().data.getHeader().getNext();
			DNode<Student> tail = t.getRoot().data.getTrailer();
			if (tmp != null) {
				while (tmp != tail) {
					if (tmp.getData().getId() == id) {
						
						return tmp.getData();
					}
					tmp = tmp.getNext();

				}

			}

		} else {

			DoublyLinkedList<Student> list = t.search(yearAdmission);
			
			//new in case not found
			if(list == null)
			{
				return null;
			}
			else {
			DNode<Student> tmp = list.getHeader().getNext();
			DNode<Student> tail = list.getTrailer();
			if (tmp != null) {
				while (tmp != tail) {
					if (tmp.getData().getId() == id) {
						
						return tmp.getData();
					}
					tmp = tmp.getNext();

				}
			}
		}
		}
		return null;
	}
	
	
	//delete
	public boolean delete ( int id) {
		int yearAdmission = Integer.parseInt(Integer.toString(id).substring(0, 4));
		// validity of ID
		int validID = Integer.toString(id).length();
		if (validID > 9 || validID < 9) {
			System.out.println("Invalid ID! ID must be 9 digits");
			return false;
		}

		// if tree empty
		if (t.isEmpty()) {
			return false;
		}

		else if (t.getRoot().key == yearAdmission) {
			DNode<Student> tmp = t.getRoot().data.getHeader().getNext();
			DNode<Student> tail = t.getRoot().data.getTrailer();
			if (tmp != null) {
				while (tmp != tail) {
					if (tmp.getData().getId() == id) {
						
						tmp.getPrev().setNext(tmp.getNext());
						tmp.getNext().setPrev(tmp.getPrev());
						--size;
						return true;
					}
					tmp = tmp.getNext();

				}

			}

		} else {

			DoublyLinkedList<Student> list = t.search(yearAdmission);
			if(list == null)
			{
				
				return false;
			}
			else {
			DNode<Student> tmp = list.getHeader().getNext();
			DNode<Student> tail = list.getTrailer();
			if (tmp != null) {
				while (tmp != tail) {
					if (tmp.getData().getId() == id) {
						
						tmp.getPrev().setNext(tmp.getNext());
						tmp.getNext().setPrev(tmp.getPrev());
						
						--size;
						return true;
					}
					tmp = tmp.getNext();

				}
			}
		}
		}
		
		return false;
		
	}
}
