/**
 * @ author Zach Weiss <br>
 * 
 * Prog 6 <br>
 * Due Date and Time: 3/12/20 before 9:00 A.M. <br>
 * 
 * Purpose: This program creates and adds to a playlist using
 * 			classes. It allows the user to enter song details
 * 			and adds them to the playlist. It also allows 
 * 			the user to delete the longest song. <br>
 * 
 * Input: The inputs are the name, artist, minutes, seconds, and cost of
 * 			the song. <br>
 * 
 * Output: The outputs are the song details, the total cost of the playlist,
 * 			and each song in the playlist. <br>
 * 
 * Certification of Authenticity: <br>
 * 		I certify that this lab is entirely my own work. <br>
 */
import java.util.*;
import java.text.*;
public class MusicDemoWeiss 
{
	/**
	 * Creates the keyboard and the decimal format for the cost
	 * 		of the songs. <br>
	 */
	static Scanner keyboard = new Scanner(System.in);
	static DecimalFormat moneyStyle = new DecimalFormat("0.00");
	
	public static void main(String[] args) 
	{
		songDetails();
	}//main
	
	public static void songDetails()
	{
		PlaylistWeiss newPlaylist = new PlaylistWeiss();
		char action;
		boolean newSong;
		
		/**
		 * The do loop goes through the menu at least once
		 * 	and utilizes the switch to invoke methods throughout the
		 * 	rest of the code. It quits when the user inputs q.
		 */
		do
		{
			System.out.println("Welcome to the playlist maker!");
			System.out.println("A: Add a Song to the Playlist");
			System.out.println("L: Find the Longest Song in the Playlist");
			System.out.println("S: Find the Shortest Song in the Playlist");
			System.out.println("N: Find the Number of Songs in the Playlist");
			System.out.println("T: Find the Total Cost of All Songs In the Playlist");
			System.out.println("P: Print out the Details about all Songs in the Playlist");
			System.out.println("D: Delete the Longest Song from the Playlist");
			System.out.println("Q: Quit");
			
			action = keyboard.next().toUpperCase().charAt(0);
			
			switch(action)
			{
				case 'A': SongWeiss songOne = new SongWeiss();
						  readSongName(songOne);
						  readSongArtist(songOne);
						  readSongMinutes(songOne);
						  readSongSeconds(songOne);
						  readSongPrice(songOne);
						  newSong = newPlaylist.addToPlaylist(songOne);
						  if(newSong == false)
							  System.out.println("Song could not be added. Sorry!");
						  else
							  System.out.println("Song added successfully!");
						  break;
				case 'L': if(newPlaylist.findLongest() == null)
					    	  System.out.println("Playlist is empty!");
						  else
							  System.out.println("The longest song was: \n" + newPlaylist.findLongest());
					      break;
				case 'S': if(newPlaylist.findShortest() == null)
							  System.out.println("Playlist is empty!");
						  else
							  System.out.println("The shortest song was: \n" + newPlaylist.findShortest());
						  break;
				case 'N': System.out.println("The length of the playlist was: " + newPlaylist.getSize());
				          break;
				case 'T': System.out.println("The total cost was: $" + moneyStyle.format(newPlaylist.calcTotal()));
						  break;
				case 'P': newPlaylist.printFullPlaylist();
						  break;
				case 'D': newSong = newPlaylist.deleteLongest();
						  if(newSong == false)
							  System.out.println("Could not delete song.");
						  else
							  System.out.println("Deleted longest successfully!");
						  break;
				case 'Q': System.out.println("Goodbye!");
						  break;
				default: System.out.println("Invalid menu option. Try Again.");
			}//switch
		}//do
		while (action != 'Q');
	}//songDetails
	/**
	 * This method reads in the song name for the new song object.
	 * @param song	A new song object to read the name.
	 */
	public static void readSongName(SongWeiss song)
	{
		String name;
		
		System.out.print("Enter the name of the song: ");
		name = keyboard.next();
		song.setMyName(name);
	}//readSongName
	/**
	 * This method reads in the artist for the new song object.
	 * @param song	A new song object to read the artist.
	 */
	public static void readSongArtist(SongWeiss song)
	{
		String artist;
		
		System.out.print("Enter the artist: " );
		artist = keyboard.next();
		song.setMyArtist(artist);
	}//readSongArtist
	/**
	 * This method reads in the length in minutes of the song.
	 * @param song	A new song object to be used to read the length.
	 */
	public static void readSongMinutes(SongWeiss song)
	{
		int minutes;
		
		System.out.print("Enter the minutes: " );
		minutes = keyboard.nextInt();
		song.setMyMinutes(minutes);
	}//readSongMinutes
	/**
	 * This method reads in the length in seconds of the song.
	 * @param song 	A new song object to be used to read the length.
	 */
	public static void readSongSeconds(SongWeiss song)
	{
		int seconds;
		
		System.out.print("Enter the seconds: " );;
		seconds = keyboard.nextInt();
		while(seconds > 59)
		{
			System.out.print("Seconds must be 59 or below"
					+ " Enter the seconds:");
			seconds = keyboard.nextInt();
		}//while
		song.setMySeconds(seconds);
	}//readSongSeconds
	/**
	 * This methods reads in the price of the song.
	 * @param song 	A new song object to be used to read the price.
	 */
	public static void readSongPrice(SongWeiss song)
	{
		double cost;
		
		System.out.print("Enter the price: " );;
		cost = keyboard.nextDouble();
		song.setMyPrice(cost);
	}//readSongPrice
}//MusicDemoWeiss
