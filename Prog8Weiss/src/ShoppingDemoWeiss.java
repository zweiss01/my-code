/**
 * @ author Zach Weiss <br>
 * 
 * Prog 8 <br>
 * Due Date and Time: 4/9/20 before 12:00 P.M. <br>
 * 
 * Purpose: This program reads in a file of a
 * 			shopping list and orders it by
 * 			ascending name. The user can
 * 			then add and delete from the
 * 			list as well as search, count,
 * 			find the cost, and clear the
 * 			list. <br>
 * 
 * Input: The inputs are the name of the file,
 * 			which contains name, quantity, and 
 * 			price of each item. <br>
 * 
 * Output: The outputs are the details,
 * 			amount of items, the full list
 * 			, and the cost. <br>
 * 
 * Certification of Authenticity: <br>
 * 		I certify that this lab is entirely 
 * 			my own work.
 */
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.*;
public class ShoppingDemoWeiss 
{
	/**
	 * Creates the keyboard and money format
	 * 	for the songs. <br>
	 */
	static Scanner keyboard = new Scanner(System.in);
	static DecimalFormat moneyStyle = new DecimalFormat("0.00");
	
	/**
	 * Purpose: calls cart details to print
	 * 	menu and get user action.
	 */
	public static void main(String[] args) 
	{
		cartDetails();
	}//main
	
	/**
	 * Purpose: To print the menu and get
	 * 	the action the user wants to perform
	 * 	as well as the name of the file.
	 * 
	 * Input: The inputs are the file name
	 * 			and the action.
	 * 
	 * Output: The outputs are the details.
	 */
	public static void cartDetails()
	{
		KeyedListWeiss newShoppingList = new KeyedListWeiss();
		char action;
		String itemKeyName;
		boolean itemChanged = false;
		newShoppingList = readFile();
		
		/**
		 * The do loop runs the menu at least once
		 * 	and utilizes the switch to call methods
		 * 	of other classes. It quits when char action
		 * 	is '0'.
		 */
		do
		{
			System.out.println("Welcome to the shopping cart maker!");
			System.out.println("1: Add an item to the list");
			System.out.println("2: Delete an item from the list");
			System.out.println("3: Print each item in the list");
			System.out.println("4: Search for a user specified item in the list");
			System.out.println("5: Count the total number of items in the list");
			System.out.println("6: Total cost of the items in the list");
			System.out.println("7: Determine if the list is empty");
			System.out.println("8: Determine if the list is full");
			System.out.println("9: Clear the list");
			System.out.println("0: Quit");
			
			action = keyboard.next().charAt(0);
			switch(action)
			{
			case '1': ItemWeiss newItem = new ItemWeiss();
					  readItemName(newItem);
					  readItemQuantity(newItem);
					  readItemPrice(newItem);
					  itemChanged = newShoppingList.add(newItem);
					  if(itemChanged == false)
						  System.out.println("Item could not be added!");
					  else
						  System.out.println("Item added successfully!");
					  break;
			case '2': System.out.print("Enter the name of the item you want to delete: ");
					  itemKeyName = keyboard.next();
					  itemChanged = newShoppingList.remove(itemKeyName);
					  if(itemChanged == false)
						  System.out.println("The item could not be deleted because "
						  		+ "it was not found in your cart!");
					  else
						  System.out.println("The item was successfully deleted!");
					  break;
			case '3': newShoppingList.print();
					  break;
			case '4': System.out.print("Enter the item which you would like to search for: ");
					  itemKeyName = keyboard.next();
					  System.out.println(newShoppingList.retrieve(itemKeyName));
					  break;
			case '5': System.out.println("The amount of items was: " + 
					  	newShoppingList.getCount());
					  break;
			case '6': System.out.println("The total cost of the items was: $" + 
					  moneyStyle.format(newShoppingList.calcTotal()));
					  break;
			case '7': itemChanged = newShoppingList.isEmpty();
					  if(itemChanged == false)
						  System.out.println("List was not empty.");
					  else
						  System.out.println("List was empty!");
					  break;
			case '8': itemChanged = newShoppingList.isFull();
					  if(itemChanged == false)
						  System.out.println("List was not full.");
					  else
						  System.out.println("List was full!");
					  break;
			case '9': newShoppingList.clear();
					  break;
			case '0': System.out.println("Goodbye!");
					  break;
			default: System.out.println("Invalid menu option. Try again!");
			}//switch
		}//do
		while(action != '0');
	}//cartDetails
	
	/**
	 * This method reads in the 
	 * 	item name from the user.
	 * @param item	The item itself.
	 */
	public static void readItemName(ItemWeiss item)
	{
		String name;
		
		System.out.print("Enter the name of the item: ");
		name = keyboard.next();
		item.setMyName(name);
	}//readItemName
	
	/**
	 * This method reads in the quantity.
	 * @param item	The item itself.
	 */
	public static void readItemQuantity(ItemWeiss item)
	{
		int quantity = 0;
		
		System.out.print("Enter the quantity of the item: ");
		quantity = keyboard.nextInt();
		item.setMyQuantity(quantity);
	}//readItemQuantity
	
	/**
	 * This method reads in the unit price.
	 * @param item	The item itself.
	 */
	public static void readItemPrice(ItemWeiss item)
	{
		double price = 0.0;
		
		System.out.print("Enter the unit price of the item: ");
		price = keyboard.nextDouble();
		item.setMyPrice(price);
	}//readItemPrice
	
	/**
	 * readFile reads in the file and 
	 * 	processes it into a list.
	 * @return the shopping list from the file
	 */
	public static KeyedListWeiss readFile()
	{
		String fileName;
		System.out.print("Enter a filename: ");
		fileName = keyboard.next();
		File myFile = new File(fileName);
		KeyedListWeiss newShoppingList = new KeyedListWeiss();
		
		int numItems = 0;
		String itemName;
		int itemQuantity = 0;
		double itemPrice = 0.0;
		
		
		/**
		 * tries to open and use the file if possible
		 */
		try
		{
			/** 
			 * new scanner object for use in the reading of the file
			 */
			Scanner input = new Scanner(myFile);
			
			/**
			 * number of songs read from first line
			 */
			numItems = input.nextInt();
			
			/**
			 * uses for loop to create new song objects and input them to the playlist
			 */
			for(int i = 0; i < numItems; i++)
			{
				ItemWeiss itemFromFile = new ItemWeiss();
				newShoppingList.setSize(i);
				itemName = input.next();
				itemFromFile.setMyName(itemName);
				itemQuantity = input.nextInt();
				itemFromFile.setMyQuantity(itemQuantity);
				itemPrice = input.nextDouble();
				itemFromFile.setMyPrice(itemPrice);
				newShoppingList.add(itemFromFile);
			}//for i
			
			input.close();
		}//try
		
		catch(FileNotFoundException ex)
		{
			System.out.println("File " + myFile.getAbsolutePath() + " does not exist");
		}//catch
		
		catch(InputMismatchException ex)
		{
			System.out.println("Type mismatch for number I just tried to read");
			System.out.println(ex.getMessage());
		}//catch
		
		catch(NumberFormatException ex)
		{
			System.out.println("Failed to convert string text into an integer value.");
			System.out.println(ex.getMessage());
		}//catch
		
		catch(NullPointerException ex)
		{
			System.out.println("Null pointer exception.");
			System.out.println(ex.getMessage());
		}//catch
		
		catch(Exception ex)
		{
			System.out.println("Something went wrong! Uh oh!");
			ex.printStackTrace();
		}//catch
		
		return newShoppingList;
	}//readFile
}//ShoppingDemoWeiss
