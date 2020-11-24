/**
 * 
 * @author Zach Weiss
 * 
 * This is the class definition for a playlist.
 *
 */
public class PlaylistWeiss
{
	/**
	 * Instance variable for the playlist array.
	 */
	private SongWeiss [] mySongs;
	/**
	 * Instance variable for the amount of songs in the array.
	 */
	private int mySize;
	
	/**
	 * The null constructor for the playlist.
	 */
	public PlaylistWeiss()
	{
		int i = 0;
		mySongs = new SongWeiss[10];
		for (i = 0; i < 10; i++)
			mySongs[i] = null;
		mySize = 0;
	}//PlaylistWeiss
	
	/**
	 * The getter for the size.
	 * @return	The amount of songs in the playlist currently.
	 */
	public int getSize()
	{
		return mySize;
	}//getSize
	/**
	 * The add to playlist method receives input from
	 * 	the MusicDemoWeiss class to add a song to the playlist
	 * @param newSong	The incoming song to the playlist.
	 * @return	If the song was able to be added or not.
	 */
	public boolean addToPlaylist(SongWeiss newSong)
	{
		boolean success = false;
		
		if (mySize < mySongs.length)
		{
				mySongs[mySize] = newSong;
				mySize++;
				success = true;
		}//if
		return success;
	}//addToPlaylist
	/**
	 * The find longest method looks for the longest song and returns it
	 * 	to the console.
	 * @return	The longest song in the playlist.
	 */
	public SongWeiss findLongest()
	{
		int longest = Integer.MIN_VALUE;
		int i = 0;
		SongWeiss longestSong = null;
		
		for(i = 0; i < mySize; i++)
		{
			if(mySongs[i].getMyMinutes() * 60 + mySongs[i].getMySeconds() > longest)
			{
				longest = mySongs[i].getMyMinutes() * 60 + mySongs[i].getMySeconds();
				longestSong = mySongs[i];
			}//if
		}//for
		
		return longestSong;
	}//findLongest
	/**
	 * The find shortest method looks for the shortest song
	 * 	and returns it to the console.
	 * @return	The shortest song in the playlist.
	 */
	public SongWeiss findShortest()
	{
		int shortest = Integer.MAX_VALUE;
		int i = 0;
		SongWeiss shortestSong = null;
		
		for(i = 0; i < mySize; i++)
		{
			if(mySongs[i].getMyMinutes() * 60 + mySongs[i].getMySeconds() < shortest)
			{
				shortest = mySongs[i].getMyMinutes() * 60 + mySongs[i].getMySeconds();
				shortestSong = mySongs[i];
			}//if
		}//for
		
		return shortestSong;
	}//findShortest
	/**
	 * The calc total method finds the total cost of the playlist.
	 * @return 	The total cost of the playlist.
	 */
	public double calcTotal()
	{
		double total = 0.0;
		int i = 0;
		
		for(i = 0; i < mySize; i++)
			total += mySongs[i].getMyPrice();
		
		return total;
	}//calcTotal
	/**
	 * The print full playlist method prints out the entire
	 * 	playlist as it stands and does not return any values.
	 */
	public void printFullPlaylist()
	{
		int i = 0;
		
		for(i= 0; i < mySize; i++)
		{
			System.out.println((i + 1) + ". \n" 
						+ mySongs[i].toString());
		}//for
	}//printFullPlaylist
	/**
	 * Delete longest deletes the longest song from the playlist
	 * 	by calling the find longest method and replacing
	 * 	the longest song with the last song in the playlist.
	 * @return	If the song was able to be deleted or not.
	 */
	public boolean deleteLongest()
	{
		boolean success = false;
		int i = 0;
		int loc = -1;
		SongWeiss songToDelete = findLongest();
		
		while((i < mySize) && (loc == -1))
		{
			if(mySongs[i] == songToDelete)
			{
				loc = i;
				mySongs[loc] = mySongs[mySize - 1];
			}//if
			i++;
		}//while
		
		if(loc == i - 1)
		{
			mySize--;
			success = true;
		}//if
		return success;
		
	}//deleteLongest
	
}//PlaylistWeiss
