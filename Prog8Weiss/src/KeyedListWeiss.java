/**
 * 
 * @author Zach Weiss
 * 
 * This is the class definition for a keyed shopping list.
 *
 */
public class KeyedListWeiss 
{
	/**
	 * The instance variable for the shopping list.
	 */
	private ItemWeiss [] myShoppingList;
	
	/**
	 * The instance variable for the size of the list.
	 */
	private int mySize;
	
	/**
	 * The default constructor for the shopping list.
	 */
	public KeyedListWeiss()
	{
		int i = 0;
		myShoppingList = new ItemWeiss[10];
		for(i = 0; i < 10; i++)
			myShoppingList[i] = null;
		mySize = 0;
	}//KeyedListWeiss
	
	/**
	 * The getter for the size.
	 * @return	The size of the list.
	 */
	public int getSize()
	{
		return mySize;
	}//getSize
	
	/**
	 * The setter for the size.
	 * @param newMySize	The incoming size of the list.
	 */
	public void setSize(int newMySize)
	{
		mySize = newMySize;
	}//setSize
	
	/**
	 * The clear method sets size to 0 so the
	 * 	list is empty at its default state.
	 */
	public void clear()
	{
		mySize = 0;
	}//clear
	
	/**
	 * The findIndex method is a private method
	 * 	accessed by add and remove to find where
	 * 	a key item is.
	 * @param keyValue	The key item name.
	 * @return	The index of the item.
	 */
	private int findIndex(String keyValue)
	{
		int i = 0;
		int index = -1;
		
		while((i < mySize) && 
				(keyValue.compareToIgnoreCase
						(myShoppingList[i].getMyName()) != 0))
			i++;
		if(i != mySize)
			index = i;
		else
			index = -1;
		return index;
	}//findIndex
	
	/**
	 * The add method adds a product to the list and orders the list.
	 * @param product	The incoming product
	 * @return	If the product was added successfully or not.
	 */
	public boolean add(ItemWeiss product)
	{
		boolean success = false;
		int i = 0;
		int j = 0;
		if((mySize != myShoppingList.length) && findIndex(product.getMyName()) == -1)
		{
			while((i < mySize) && 
					(product.getMyName().compareToIgnoreCase
							(myShoppingList[i].getMyName()) > 0))
				i++;
			
			for(j = mySize - 1; j >= i; j--)
				myShoppingList[j + 1] = myShoppingList[j];
			
			myShoppingList[i] = product;
			success = true;
			mySize++;
		}//if
		return success;
	}//add
	
	/**
	 * The remove method removes a specific item from the list.
	 * @param keyValue	The item to be removed
	 * @return	If the item could be removed successfully.
	 */
	public boolean remove(String keyValue)
	{
		boolean success = false;
		int i = 0;
		int j = 0;
		int pos = -1;
		if((mySize != 0) && (findIndex(keyValue) != -1))
		{	
			while((i < mySize) && (pos == -1))
			{
				if(keyValue.equalsIgnoreCase(myShoppingList[i].getMyName()) == true)
					pos = i;
				i++;
				if(pos == mySize - 1)
					i--;
			}//while
			if(pos != -1)
			{
				for(j = pos; j < mySize; j++)
				{
					if(j != 9)
						myShoppingList[j] = myShoppingList[j + 1];
					else
						myShoppingList[j] = null;
				}//for
				mySize--;
			}//if pos
			success = true;
		}//if mySize
		return success;
	}//remove
	
	/**
	 * The retrieve method retrieves a specific item and prints it 
	 * 	using toString from ItemWeiss.
	 * @param keyValue	The object to be retrieved.
	 * @return	The retrieved object.
	 */
	public ItemWeiss retrieve(String keyValue)
	{
		int i = 0;
		ItemWeiss itemRetrieved = null;
		for(i = 0; i < mySize; i++)
		{
			if(keyValue.compareToIgnoreCase(myShoppingList[i].getMyName()) == 0)
				itemRetrieved = myShoppingList[i];
		}//for
		return itemRetrieved;
	}//ItemWeiss
	
	/**
	 * Checks if the list is empty
	 * @return	True if and only if empty. If
	 * 	anything is on the list, it returns false.
	 */
	public boolean isEmpty()
	{
		boolean empty = false;
		
		if(mySize == 0)
			empty = true;
		
		return empty;
	}//isEmpty
	
	/**
	 * isFull checks if the list is full.
	 * @return	True if and only if the list
	 * 	is completely full. False if it is not.
	 */
	public boolean isFull()
	{
		boolean full = false;
		
		if(mySize == myShoppingList.length)
			full = true;
		return full;
	}//isFull
	
	/**
	 * Prints out the entire list, numbered
	 */
	public void print()
	{
		int i = 0;
		
		for(i = 0; i < mySize; i++)
		{
			System.out.println(i + 1 + ". \n"
					+ myShoppingList[i].toString());
		}//for
	}//print
	
	/**
	 * getCount returns the total quantity of all items.
	 * @return	The amount of items in the cart.
	 */
	public int getCount()
	{
		int i = 0;
		int count = 0;
		
		for(i = 0; i < mySize; i++) 
			count += myShoppingList[i].getMyQuantity();
		return count;
	}//getCount
	
	/**
	 * calcTotal finds the total price of the cart
	 * 	by multiplying unit price by quantity and adding
	 * 	all together.
	 * @return	A double for the total cost of the cart.
	 */
	public double calcTotal()
	{
		double total = 0.0;
		int i = 0;
		
		for(i = 0; i < mySize; i++)
			total += myShoppingList[i].getMyPrice() * myShoppingList[i].getMyQuantity();
		
		return total;
	}//calcTotal
}//KeyedListWeiss