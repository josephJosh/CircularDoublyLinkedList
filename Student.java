//*************************************************************************************************************************************//
// Josh Joseph
// CS3810 Data Structures and Algorithms
// Assignment 3 (Linked List and its Applications)
// 11-20-2015
// Professor Hai

// Class: Student

// ** DESCRIPTION **
// This program encapsulates the concept of Student record. It has two attributes: id (int), and name (String).
// This class stores id and name of Student. It provides accessor and mutator methods of both instance variables.
// It also provides a toString() method which overwrites and returns Student object representation
//*************************************************************************************************************************************//

public class Student
{
	// instance variable
	private int id;
	private String name;

	// Accessor method:
	// returns current value of id
	public int getId()
	{
		return id;
	}

	// Accessor method:
	// returns current value of name
	public String getName()
	{
		return name;
	}

	// Mutator method:
	// allows client to set id
	public void setId(int newId)
	{
		id = newId;
	}

	// Mutator method:
	// allows client to set name
	public void setName(String newName)
	{
		name = newName;
	}

	// toString: return a string of instance variable values
	public String toString()
	{
		return "ID: " + id + ", Name: " + name;
	}
}
