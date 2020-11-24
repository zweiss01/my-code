//Zachary Weiss
//Prog 4
//Due Date and Time: 2/24/2020 before 9:00 A.M.
//
//Purpose: This program will take user input 
//	for the game they want to play
//	and prompt the user to play this
//	game. It will then print out the 
//	output for the selected game.
//
//Input: The user will input a number 1, 2,
//	3, or 0 to choose a game to play.
//	They will then input numbers into an
//	array.
//
//Output: The program will output the number
//	of eagles, birdies, pars, bogeys, double
//	bogeys, and others for input of 1.
//	For 2, it will output whether there
//	are more even or odd numbers and 
//	print those numbers and the amount.
//	For 3 it will output the min value 
//	in the array and the amount of 
//	times it occurs.
//
//Certification of Authenticity:
//	I certify that this lab is entirely my own work.

import java.util.*;


public class ArraysWeiss 
{
	static Scanner keyboard = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		int game;
		do
		{
		System.out.println("Welcome to the game!");
		System.out.println("1) Let's Go Golfing!");
		System.out.println("2) More Evens or More Odds?");
		System.out.println("3) How Many Mins?");
		System.out.println("0) Quit");
		game = keyboard.nextInt();
		
		//switch to select the game
		switch (game)
			{
			case 1:	System.out.println("Welcome to the golf game!");
					goGolfing();
					break;
			
			case 2: System.out.println("Welcome to count "
					+ "evens and odds!");
					moreEvenOrOdd();
					break;
			case 3: System.out.println("Welcome to count mins!");
					findMin();
					break;
			default: if (game == 0)
						System.out.println("Goodbye! "
								+ "Thanks for playing!");
					 else
						 System.out.println("Invalid"
						 		+ " menu choice. Try again: ");
			}//switch
		}//do
		while (game != 0);
		
	}//main
	
	//Input: The user will input 9 par values
	//	and 9 stroke values.
	//Output: This is a method
	// with no output.
	public static void goGolfing()
	{
		int hole = 0;
		int [] par = new int [9];
		
		//for which puts par values into an array
		for (hole = 0; hole < 9; hole++)
		{
			System.out.println("Please enter an amount for"
					+ " par for hole " + (hole + 1));
			par[hole] = keyboard.nextInt();
		}//for
		
		int [] strokes = new int [9];
		
		//for which places stroke values into an array
		for (hole = 0; hole < 9; hole++)
		{
			System.out.println();
			System.out.println("Please enter the stroke values "
					+ "for hole " + (hole + 1) + ":");
			strokes[hole] = keyboard.nextInt();
		}//for hole
		
		countStrokes(strokes, par);
		
	}//goGolfing
	
	//Input: This method takes two arrays as
	//	input parameters.
	//Output: This helper method prints the number of 
	//	eagles, birdies, pars, bogeys, double bogeys,
	//	and other values.
	public static int countStrokes(int [] strokes, int [] par)
	{
		int numPar = 0;
		int numEagles = 0;
		int numBirdies = 0;
		int numBogeys = 0;
		int numDoubleBogeys = 0;
		int numOther = 0;
		int i = 0;
		
		//for to find the proper type of score
		for(i = 0; i < 9; i++)
		{
			if (strokes[i] == par[i] - 2)
				numEagles++;
			else if (strokes[i] == par[i] - 1)
				numBirdies++;
			else if (strokes[i] == par[i])
				numPar++;
			else if (strokes[i] == par[i] + 1)
				numBogeys++;
			else if (strokes[i] == par[i] + 2)
				numDoubleBogeys++;
			else
				numOther++;
		}//for
		
		//prints amounts for each 
		System.out.println("The number of eagles was " + 
							numEagles);
		System.out.println("The number of birdies was " + 
							numBirdies);
		System.out.println("The number of pars was " + 
							numPar);
		System.out.println("The number of bogeys was " + 
							numBogeys);
		System.out.println("The number of double bogeys was " + 
							numDoubleBogeys);
		if (numOther == 1)
			System.out.println("There was " + numOther + 
					" other stroke");
		else 
			System.out.println("There were " + numOther + 
					" other strokes");
		return i;
	}//countStrokes
	
	//Input: This method asks for the input of up to
	//	10 integers.
	//Output: This method will not output anything.
	public static void moreEvenOrOdd()
	{
		int [] evenOdd = new int [10];
		int num = 1;
		int i = 0;
		
		//for to create array of up to 10 integers
		for (i = 0; i < 10; i++)
		{
			if (num != 0)
			{
				System.out.println("Enter an integer "
						+ "or 0 to end: ");
				num = keyboard.nextInt();
				evenOdd[i] = num;
			}//if
			
		}//for
		countEvenOdd(evenOdd);
	}//moreEvenOrOdd
	
	//Input: This method takes the input of the integer
	//	array from the countEvenOdd method.
	//Output: This method outputs the amount of even
	//	and odd numbers in the array.
	public static int countEvenOdd(int [] values)
	{
		int i = 0;
		int numEven = 0;
		int numOdd = 0;
		
		//for to determine evens and odds in array
		for (i = 0; i < values.length; i++)
		{
			//quits if 0
			if ((values[i] % 2 == 0) && (values[i] != 0))
				numEven++;
			else if (values[i] % 2 == 1)
				numOdd++;
		}//for
		
			//if and elses to determine more evens or odds
			if (numEven > numOdd)
			{
				System.out.println("There were more even"
						+ " numbers.");
				for (i = 0; i < values.length; i++)
					if (values[i] % 2 == 0)
						System.out.println(values[i]);
			}//if
			else if (numOdd > numEven)
			{
				System.out.println("There were more"
						+ " odd numbers.");
				for(i = 0; i < values.length; i++)
					if (values[i] % 2 == 1)
						System.out.println(values[i]);
			}//else if
			else
			{
				System.out.println("It's a tie!");
				for (i = 0; i < values.length; i++)
					System.out.println(values[i]);
			}//else
		return i;
	}//countEvenOdd
	
	//Input: This method asks for input of up to
	//	8 positive integers.
	//Output: This method does not output anything.
	public static void findMin()
	{
		int [] pos = new int [8];
		int num = 1;
		int i = 0;
		
		//for to create array of up to 8 integers
		for (i = 0; i < 8; i++)
		{
			if (num != 0)
			{
				System.out.println("Enter a positive integer "
						+ "or 0 to end: ");
				num = keyboard.nextInt();
				if (num > 0)
					pos[i] = num;
				if (num < 0)
				{
					System.out.println("A negative integer "
							+ "is invalid.");
				}//if less than 0
			}//if not equal to 0			
		}//for i
		countMins(pos);
	}//findMin
	
	//Input: This method does not ask for input, 
	//	but takes the input of the positive array.
	//Output: This method outputs the minimum value and 
	//	the number of times it occurs.
	public static int countMins(int [] values)
	{
		int min = Integer.MAX_VALUE;
		int i = 0;
		int numMin = 0;
		
		//for that reads array to determine minimum
		//	and number of occurrences
		for (i = 0; i < values.length; i++)
		{
			if ((values[i] < min) && (values[i] != 0))
				min = values[i];				
			if (values[i] == min)
				numMin++;
		}//for
		if (numMin == 1)
			System.out.println("The minimum of " + min + 
					" occurred " + numMin + " time.");
		else
			System.out.println("The minimum of " + min + 
					" occurred " + numMin + " times.");
		return min;
	}//countMin
	
}//ArraysWeiss
