package project;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) 
	{
		TreeOfDoubly studentsProgram = new TreeOfDoubly();
		
		studentsProgram = FileManagment.readData();
	
		Scanner input = new Scanner(System.in).useDelimiter("\r\n");

		System.out.println("--Welcome to QU students' records--");

		int choice=0;

		while(choice != 4)
		{
			System.out.println("\nEnter your choice number: ");
			System.out.println(" 1- New Student. \n 2- Search for a student \n 3- Delete a student \n 4- Exit ");

			do
			{
				System.out.print("Your Choice: ");
				choice = input.nextInt();
				if(choice > 5 || choice < 0)
				{
					System.out.println("Invalid Choice! Please enter a number from 1 to 4. ");
				}
			}while(choice < 0 || choice >5);
			

			switch(choice) 
			{
			case 1:
			{
				System.out.print("Enter Student Name: ");
				String name = input.next();

				System.out.print("Enter Student ID: ");
				int id = input.nextInt();

				System.out.print("Enter Student GPA: ");
				double gpa = input.nextDouble();

				Student s = new Student(id,name,gpa);
				studentsProgram.insert(s);

				break;
			}

			case 2:
			{
				System.out.print("Enter Student ID: ");
				int id = input.nextInt();

				Student s = studentsProgram.search(id);
				
				if(s!= null)
				{
					System.out.print(s);
				}
				else
				{
					System.out.println("Student not Found!");
				}
				break;
			}

			case 3: 
			{
				System.out.print("Enter Student ID: ");
				int id = input.nextInt();

				boolean s = studentsProgram.delete(id);
				if(s == true)
				{
					System.out.print("Student Deleted Succesfully.");
				}
				else
				{
					System.out.println("Student not Found!");
				}
				break;
			}

			case 4:
			{
				System.out.println("--END THE PROGRAM--");
				FileManagment.saveData(studentsProgram);
				System.exit(0);
			}
			}
		}
		input.close();
	}	
}
