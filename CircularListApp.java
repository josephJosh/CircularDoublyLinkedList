//*************************************************************************************************************************************//
// Josh Joseph
// CS3810 Data Structures and Algorithms
// Assignment 3 (Linked List and its Applications)
// 11-20-2015
// Professor Hai

// Class: CirularListApp

// This program prompts user to enter selection between 0 and 4 inclusive
// with each key performing different function. The choices for user are:
//							1: Insert
//							2: Remove
//							3: Search
//							4: Display
//							0: Quit
// Based on the user input, the program calls methods of CircularList class to perform corresponding operations.
// A do while loop is used to allow user stop when the user enters 0 (zero)
// Methods getAnID (any positive integer) and getAChoice (any intergers between 0 and 4 inclusive) validates the user input.
//*************************************************************************************************************************************//

import java.util.Scanner; // for input

public class CircularListApp
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);

		System.out.println("!!!Welcome to Circular List Application!!!\n"); // Header

		CircularList theList = new CircularList(); // creates an instance of CisularList class

		// Header
		System.out.println("Your Selections are:");
		System.out.println("Enter 1 to Insert");
		System.out.println("Enter 2 to Remove");
		System.out.println("Enter 3 to Search");
		System.out.println("Enter 4 to Display");
		System.out.println("Enter 0 to Quit\n");

		int choice; // variable to hold user's selection

		do
		{
			choice = getAChoice("Enter Selection: "); // calls getAChoice method to validate input

			if (choice == 1)
			{
				int input = getAnID("\nEnter The ID: "); // calls getAnID method to validate user input

				while (theList.search(input) != null) // if entered id is already in the list
				{
					System.out.print("ID must be unique\n" + "\nEnter The ID: ");  // prints an errors message and re-prompts
					input = Integer.parseInt(scan.nextLine());
				}

				System.out.print("Enter The Data: ");
				String input1 = scan.nextLine();

				Student elm = new Student();
				elm.setId(input);
				elm.setName(input1);

				Node ND = new Node(elm);

				theList.add(ND);				// add the node to the list
				System.out.println();
			}

			else
				if (choice == 2)
				{
					if (!theList.isEmpty())   // if the list is not empty
					{
						int input = getAnID("Please enter The ID to remove: ");

						if (theList.search(input) != null)   // if the search method doesn't return null
						{
							System.out.println();
							System.out.println(theList.setCursor(theList.remove()) + " has been deleted\n");  // removes the node with the given key
						}
						else
						{
							System.out.println("\nID: " + input + " is not in the list\n");  // // if the search method returns null, prints an error message
						}
					}
					else
						System.out.println("List is Empty\n");  // if the list is empty, it prints an appropriate message

				}

			else
				if (choice == 3)
				{
					if (!theList.isEmpty())     // if the list is not empty
					{
						int input = getAnID("Please enter The ID to search: ");

						if (theList.search(input) != null)  // if the search method doesn't return null
						{
							System.out.println();
							System.out.println(theList.search(input) + " has been found\n");  // prints the node that is found
						}
						else
						{
							System.out.println("\nID: " + input + " is not in the list\n");   // else prints key is not found
						}

					}
					else
						System.out.println("List is Empty\n");   // if the list is empty, it prints an appropriate message
				}

			else
				if (choice == 4)
				{
					if (!theList.isEmpty())   // if the list is not empty
					{
						System.out.println("Elements: \n" + theList.toString()); // calls toString method to print elements of the list
					}
					else
						System.out.println("List is Empty\n"); // prints a message if list is empty
				}

		} while (choice != 0); // end loop when user enter 0

			System.out.println("Good Bye!!!");
	}

	/* This method returns the input data (ID of student). If the user
	 * enters an invalid input, it prints an error message and re-promts the
	 * user for a valid input.
	 */
	private static int getAnID(String prompt)
	{
		Scanner scan = new Scanner(System.in);
		int input;
		System.out.print(prompt);

		do
		{
			try
			{
				input = Integer.parseInt(scan.nextLine());

				// prints an error message if input is less than 1 and re-prompts
				while (input < 1)
				{
					System.out.print("ID must be a positive number ( ID > 0 )\n" + prompt);
					input = Integer.parseInt(scan.nextLine());
				}
				return input;
			}
			catch (NumberFormatException e)
			{
				System.out.print("ID must be a number\n" + prompt); // prints an error message if input is not a number by catching NumberFormatException and re-prompts
			}
		} while (true);
	}

	/* This method returns the input data (selection of operations) of user. If
	 * the user enters an invalid input, it prints an error message and
	 * re-promts the user for a valid input.
	 */
	private static int getAChoice(String prompt)
	{
		Scanner scan = new Scanner(System.in);
		int input;
		System.out.print(prompt);

		do
		{
			try
			{
				input = Integer.parseInt(scan.nextLine());

				// prints an error message if input is less than 0 or greater than 4 and re-prompts
				while (input < 0 || input > 4)
				{
					System.out.print("Selection must be between 0 and 4\n\n" + prompt);
					input = Integer.parseInt(scan.nextLine());
				}
				return input;
			}

			catch (NumberFormatException e)
			{
				System.out.print("Selection must be a number between 0 and 4\n\n" + prompt); // prints an error message if input is not a number by catching NumberFormatException and re-prompts
			}
		} while (true);
	}
}