//***********************************************************************************************************************************//
// Josh Joseph
// CS3810 Data Structures and Algorithms
// Assignment 3 (Linked List and its Applications)
// 11-20-2015
// Professor Hai

// Class: CircularList

// ** DESCRIPTION **
// This program encapsulates the concept of doubly linked circular list. It has a default constructor.
// This class contains methods to add a Node after the cursor, remove and search a Node with given key,
// check if the list is empty. It also provides a toString() method which overwrites and returns all the
// elements of the list.
//*************************************************************************************************************************************//

public class CircularList
{
	private Node cursor;
	private int size = 0;

	// constructor:
	// no items on list yet
	public CircularList()
	{
		cursor = null;
		size = 0;
	}

	// insert method:
	// inserts a Node after the cursor
	public void add(Node newNode)
	{
		if (size == 0)                              // if list is empty
		{
			cursor = newNode;
			newNode.setNext(cursor);	            // newNode.next points to itself
			newNode.setPrevious(cursor);            // newNode.previous points to itself
		}

		if (size == 1)                              // if list has one element
		{
			cursor.setNext(newNode);                // cursor.next --> newNode
			cursor.setPrevious(newNode);            // cursor.previous --> newNode
			newNode.setNext(cursor);                // newNode.next --> cursor
			newNode.setPrevious(cursor);            // newNode.previous --> cursor
			cursor = newNode;
		}

		else                                        // general case (size>1)
		{
			newNode.setNext(cursor.getNext());      // newNode.next --> Node after the cursor
			newNode.setPrevious(cursor);            // newNode.previous --> cursor
			cursor.getNext().setPrevious(newNode);  // previous of Node after cursor --> newNode
			cursor.setNext(newNode);                // cursor.next --> newNode
			cursor = newNode;
		}
		size++;
	}

	// remove method:
	// delete the Node at the cursor
	// (search method is used to delete the Node with a given a key)
	public Node remove()
	{
		if (size == 1)                                          // if there is one elements in the list
		{
			cursor.setNext(null);                               // cursor.next --> null
			cursor.setPrevious(null);                           // cursor.previous --> previous
			size--;											    // decrement the size
			return cursor;                                      // return the cursor
		}

		else													// general case (size>1)
		{
			cursor.getNext().setPrevious(cursor.getPrevious()); // previous of node after the cursor points to Node before the cursor
			cursor.getPrevious().setNext(cursor.getNext());     // next of node before the cursor points to Node after the cursor
			size--;                                             // decrement the size
			return cursor;                                      // return the cursor
		}
	}

	// search method:
	// finds the Node with a given a key
	public Node search(int key)
	{
		for (int i = 0; i < size; i++)
		{
			if (cursor.getData().getId() == key)  // if key is found
			{
				return cursor;                    // return the node
			}
			else
				cursor = cursor.getNext();        // else move the cursor to next node
		}
		return null;                              // return null if it is not found
	}

	// isEmpty:
	// returns true if list is empty (number of items equals 0)
	public boolean isEmpty()
	{
		return size == 0;
	}

	// setCursor:
	// moves the cursor to next node and
	// returns the node passed in
	// (used for removing a node)
	public Node setCursor (Node currentCursor)
	{
		cursor = currentCursor.getNext();
		return currentCursor;
	}

	// toString: returns a string represenation of list from cursor to the end of the list
	public String toString()
	{
		String list = "";

		for (int i = 0; i < size; i++)
		{
			list += cursor.toString() + "\n";
			cursor = cursor.getNext();
		}
		return list;
	}
}