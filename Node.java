//*************************************************************************************************************************************//
// Josh Joseph
// CS3810 Data Structures and Algorithms
// Assignment 3 (Linked List and its Applications)
// 11-20-2015
// Professor Hai

// Class: Node

// ** DESCRIPTION **
// This program encapsulates the concept of Node. It has three attributes: data (Student), next (Node), previous (Node).
// This class stores data of the Student and two references (next and previous) of the linked list.
// It provides accessor and mutator methods of all three instance variables.
// It also provides a toString() method which overwrites and returns data of Node representation
//*************************************************************************************************************************************//

public class Node
{
	// instance variables
	private Student data;
	private Node next;
	private Node previous;

	// costructor
	// Node takes in a Student object as the parameter
	public Node(Student d)
	{
		data = d;
	}

	// Accessor method:
	// returns current value of data
	public Student getData()
	{
		return data;
	}

	// Mutator method:
	// allows user to set data
	public void setData(Student newData)
	{
		data = newData;
	}

	// Accessor method:
	// returns current value of next
	public Node getNext()
	{
		return next;
	}

	// Mutator method:
	// allows user to set next reference
	public void setNext(Node newNext)
	{
		next = newNext;
	}

	// Accessor method:
	// returns current value of previous
	public Node getPrevious()
	{
		return previous;
	}

	// Mutator method:
	// allows user to set previous reference
	public void setPrevious(Node newPrevious)
	{
		previous = newPrevious;
	}

	// toString: return a string representation of data of Node
	public String toString()
	{
		return data.toString();
	}
}
