/**
 * 
 * @author Zach Weiss
 * 
 * This is the class definition for a linked shopping list.
 *
 */
public class KeyedListWeiss
{
	
	/**
	 * The instance variable for the size of the list.
	 */
	private NodeWeiss myHead;
	
	/**
	 * The default constructor for the shopping list.
	 */
	public KeyedListWeiss()
	{
		myHead  = null;
	}//KeyedListWeiss
	
	/**
	 * The getter for the size.
	 * @return	The size of the list.
	 */
	public NodeWeiss getHead()
	{
		return myHead;
	}//getSize
	
	/**
	 * The setter for the size.
	 * @param newMySize	The incoming size of the list.
	 */
	public void setHead(NodeWeiss newMyHead)
	{
		myHead = newMyHead;
	}//setSize
	
	/**
	 * The clear method sets size to 0 so the
	 * 	list is empty at its default state.
	 */
	public void clear()
	{
		NodeWeiss curr = myHead;
		
		while(curr != null)
		{
			curr.setData(null);
			curr = curr.getNext();
			myHead = null;
		}//while
		
		curr = null;
	}//clear
	
	/**
	 * The add method adds a product to the list and orders the list.
	 * @param product	The incoming product
	 * @return	If the product was added successfully or not.
	 */
	public boolean add(ItemWeiss product)
	{
		boolean found = false;
		NodeWeiss curr = myHead;
		NodeWeiss prev = null;
		NodeWeiss newItem = null;
		
		if(curr == null)
		{
			myHead = new NodeWeiss(product);
			found = true;
		}//if
		
		while((!found) && (curr != null))
		{
				if(curr.getData().getMyName().equalsIgnoreCase(product.getMyName()) == false)
				{
					if(prev == null)
					{
						newItem = new NodeWeiss(product);
						myHead = newItem;
						newItem.setNext(curr);
						found = true;
					}//if
			
					else
					{
						if(myHead.getData().getMyName().
								compareToIgnoreCase(product.getMyName()) < 0)
						{
							prev = myHead;
							newItem = new NodeWeiss(product);
							curr = newItem;
							found = true;
						}//if
						else
						{
							prev.setNext(myHead);
							newItem = new NodeWeiss(product);
							prev = newItem;
							found = true;
						}//else		
					
					}//else
				}//if 
				else
					curr = curr.getNext();
			}//while
		
		return found;
	}//add
	
	/**
	 * The remove method removes a specific item from the list.
	 * @param keyValue	The item to be removed
	 * @return	If the item could be removed successfully.
	 */
	public boolean remove(String keyValue)
	{
		boolean success = false;
		NodeWeiss curr = myHead;
		NodeWeiss prev = null;
		
		while((curr != null) && (!success))
		{
			if(curr.getData().getMyName().equalsIgnoreCase(keyValue) == true)
				success = true;
			else
			{
				prev = curr;
				curr = curr.getNext();
			}//else
		}//while
		
		if(success)
		{
			if(prev == null)
			{
				myHead = curr.getNext();
			}//if
			
			else if(curr != null)
			{
				prev.setNext(curr.getNext());
			}//else if
		}//if
		
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
		NodeWeiss curr = myHead;
		ItemWeiss itemFound = null;
		
		while(curr != null)
		{
			if(curr.getData().getMyName().equalsIgnoreCase(keyValue) == true)
				itemFound = curr.getData();
			curr = curr.getNext();
		}//while
		
		return itemFound;
	}//ItemWeiss
	
	/**
	 * Checks if the list is empty
	 * @return	True if and only if empty. If
	 * 	anything is on the list, it returns false.
	 */
	public boolean isEmpty()
	{
		return (myHead == null);
	}//isEmpty
	
	/**
	 * isFull checks if the list is full.
	 * @return	True if and only if the list
	 * 	is completely full. False if it is not.
	 */
	public boolean isFull()
	{
		boolean full = false;
		
		return full;
	}//isFull
	
	/**
	 * Prints out the entire list, numbered
	 */
	public void print()
	{
		NodeWeiss curr = myHead;		
		int i = 0;
		if(curr == null)
			System.out.println("List was empty!");
		while(curr != null)
		{
			System.out.println(i + 1 + "." + curr.getData().toString());
			i++;
			curr = curr.getNext();
		}//while
	}//print
	
	/**
	 * getCount returns the total quantity of all items.
	 * @return	The amount of items in the cart.
	 */
	public int getCount()
	{
		NodeWeiss curr = myHead;
		int count = 0;
		
		while(curr != null)
		{
			count += curr.getData().getMyQuantity();
			curr = curr.getNext();
		}//while
		
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
		NodeWeiss curr = myHead;
		
		while(curr != null)
		{
			total += curr.getData().getMyPrice() * curr.getData().getMyQuantity();
			curr = curr.getNext();
		}//while
		
		return total;
	}//calcTotal
}//KeyedListWeiss