import java.text.DecimalFormat;

/**
 * 
 * @author Zach Weiss <br>
 * 
 * This is the class definition for a song.
 *
 */
public class SongWeiss 
{
	static DecimalFormat moneyStyle = new DecimalFormat("0.00");
	/**
	 * Instance variable for the name of the song.
	 */
	private String myName;
	/**
	 * Instance variable for the artist of the song.
	 */
	private String myArtist;
	/**
	 * Instance variable for the minutes of the song.
	 */
	private int myMinutes;
	/**
	 * Instance variable for the seconds of the song.
	 */
	private int mySeconds;
	/**
	 * Instance variable for the price of the song.
	 */
	private double myPrice;
	
	/**
	 * The default constructor for the song.
	 */
	public SongWeiss()
	{
		myName = "";
		myArtist = "";
		myMinutes = 0;
		mySeconds = 0;
		myPrice = 0.0;
	}//SongWeiss
	
	/**
	 * The full constructor for the song.
	 * @param newMyName	The incoming name of the song.
	 * @param newMyArtist	The incoming artist of the song.
	 * @param newMyMinutes	The incoming minutes of the song.
	 * @param newMySeconds 	The incoming seconds of the song.
	 * @param newMyPrice	The incoming price of the song.
	 */
	public SongWeiss(String newMyName, String newMyArtist,
			int newMyMinutes, int newMySeconds,
			double newMyPrice)
	{
		myName = newMyName;
		myArtist = newMyArtist;
		myMinutes = newMyMinutes;
		mySeconds = newMySeconds;
		myPrice = newMyPrice;
	}//SongWeiss
	/**
	 * The getter for the name.
	 * @return Returns the name for the song.
	 */
	public String getMyName()
	{
		return myName;
	}//getMyName
	/**
	 * The setter for the name.
	 * @param newMyName	The incoming name for this song.
	 */
	public void setMyName(String newMyName)
	{
		myName = newMyName;
	}//setMyName
	/**
	 * The getter for the artist.
	 * @return	The artist for this song.
	 */
	public String getMyArtist()
	{
		return myArtist;
	}//getMyArtist
	/**
	 * The setter for the artist.
	 * @param newMyArtist	The incoming artist of the song.
	 */
	public void setMyArtist(String newMyArtist)
	{
		myArtist = newMyArtist;
	}//setMyArtist
	/**
	 * The getter for the minutes
	 * @return	The minutes of the song.
	 */
	public int getMyMinutes()
	{
		return myMinutes;
	}//getMyMinutes
	/**
	 * The setter for the minutes.
	 * @param newMyMinutes	The incoming minutes of the song.
	 */
	public void setMyMinutes(int newMyMinutes)
	{
		myMinutes = newMyMinutes;
	}//setMyMinutes
	/**
	 * The getter for the seconds.
	 * @return	The seconds of the song.
	 */
	public int getMySeconds()
	{
		return mySeconds;
	}//getMySeconds
	/**
	 * The setter for the seconds.
	 * @param newMySeconds	The incoming seconds of the song.
	 */
	public void setMySeconds(int newMySeconds)
	{
		mySeconds = newMySeconds;
	}//setMySeconds
	/**
	 * The getter for the price.
	 * @return	The price of the song.
	 */
	public double getMyPrice()
	{
		return myPrice;
	}//getMyPrice
	/**
	 * The setter for the price.
	 * @param newMyPrice	The incoming price of the song.
	 */
	public void setMyPrice(double newMyPrice)
	{
		myPrice = newMyPrice;
	}//setMyPrice
	
	/**
	 * Returns details about each song as a string.
	 */
	public String toString()
	{
		String result = "Name: " + myName;
		result += "\nArtist: " + myArtist;
		result += "\nMinutes: " + myMinutes;
		result += "\nSeconds: " + mySeconds;
		result += "\nPrice: $" + moneyStyle.format(myPrice);
		return result;
	}//toString
}//SongWeiss
