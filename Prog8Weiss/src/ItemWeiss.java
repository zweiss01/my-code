import java.text.*;

/**
 * 
 * @author Zach Weiss <br>
 * 
 * This is the class definition for an item.
 *
 */

public class ItemWeiss 
{
	/**
	 * Money format for the price <br>
	 */
	static DecimalFormat moneyStyle = new DecimalFormat("0.00");
	
	/**
	 * Instance variable for name of item <br>
	 */
	private String myName;
	
	/**
	 * Instance variable for item quantity <br>
	 */
	private int myQuantity;
	
	/**
	 * Instance variable for item price <br>
	 */
	private double myPrice;
	
	/**
	 * The default constructor for an item.
	 */
	public ItemWeiss()
	{
		myName = "";
		myQuantity = 0;
		myPrice = 0.0;
	}//ItemWeiss
	
	/**
	 * The full constructor for the item.
	 * @param newMyName
	 * @param newMyQuantity
	 * @param newMyPrice
	 */
	public ItemWeiss(String newMyName, int newMyQuantity, double newMyPrice)
	{
		myName = newMyName;
		myQuantity = newMyQuantity;
		myPrice = newMyPrice;
	}//ItemWeiss
	
	/**
	 * The getter for the name of the item.
	 * @return the name of the item
	 */
	public String getMyName()
	{
		return myName;
	}//getMyName
	
	/**
	 * The setter for the name if the item.
	 * @param newMyName	The incoming name of the item
	 */
	public void setMyName(String newMyName)
	{
		myName = newMyName;
	}//setMyName
	
	/**
	 * The getter for the quantity of the items.
	 * @return the quantity of the item.
	 */
	public int getMyQuantity()
	{
		return myQuantity;
	}//getMyQuantity
	
	/**
	 * The setter for the quantity of the items.
	 * @param newMyQuantity	the incoming quantity for the item
	 */
	public void setMyQuantity(int newMyQuantity)
	{
		myQuantity = newMyQuantity;
	}//setMyQuantity
	
	/**
	 * The getter for the unit price of the item.
	 * @return	The price of the item.
	 */	
	public double getMyPrice()
	{
		return myPrice;
	}//getMyPrice
	
	/**
	 * The setter for the price of the item.
	 * @param newMyPrice	The incoming price of the item.
	 */
	public void setMyPrice(double newMyPrice)
	{
		myPrice = newMyPrice;
	}//setMyPrice
	
	/**
	 * Returns details about each item as a string.
	 */
	public String toString()
	{
		String result;
		
		result = "Name: " + myName;
		result += "\nQuantity: " + myQuantity;
		result += "\nPrice: $" + moneyStyle.format(myPrice);
		return result;
	}//toString
}//ItemWeiss
