//Zachary Weiss
//Prog 1
//Due Date and Time: 2/3/2020 before 9:00 AM

//Purpose: This program will be used to calculate the number of bills and coins
//used to make change of a certain amount of cents input by the user.
//Input: Amount to be changed
//Output: The program will return a specific amount of twenty, ten,
//five, and one dollar bills, along with quarters, dimes, nickels, and pennies.
//It will also output how many total bills and coins were used and 
//change the plurality of each bill or coin accordingly.
//Certification of Authenticity:
//	I certify that this lab is entirely my own work.

import java.util.*;

public class ChangeMakerWeiss 
{
	static Scanner keyboard = new Scanner(System.in); //declares a keyboard for the project
	
	public static void main(String[] args)
	{
		//initialize variables
		int totalBillsCoins = 0;
		int money = 0;
		int originalMoney = 0;
		int twenties = 0;
		int tens = 0;
		int fives = 0;
		int singles = 0;
		int quarters = 0;
		int dimes = 0;
		int nickels = 0;
		int pennies = 0;
		
		//describes what the program performs
		System.out.println("Welcome to Change Maker!");
		System.out.println("Enter an amount of money to be converted.");
		System.out.println("I will output a combination of bills and coins");
		System.out.println("that equals that amount in change.");
		
		//gets input from user
		System.out.print("\nEnter amount to be changed: ");
		money = keyboard.nextInt();
		
		//calculates change
		originalMoney = money;
		twenties = money / 2000;
		money = money % 2000;
		tens = money / 1000;
		money = money % 1000;
		fives = money / 500;
		money = money % 500;
		singles = money / 100;
		money = money % 100;
		quarters = money / 25;
		money = money % 25;
		dimes = money / 10;
		money = money % 10;
		nickels = money / 5;
		money = money % 5;
		pennies = money;
		totalBillsCoins = twenties + tens + fives + singles + quarters + dimes + nickels + pennies;
		
		//output the results
		System.out.println(originalMoney + " cents can be given as: ");
		if (twenties == 1)
			System.out.println(twenties + " twenty");
		else
			System.out.println(twenties + " twenties");
		if (tens == 1)
			System.out.println(tens + " ten");
		else
			System.out.println(tens + " tens");
		if (fives == 1)
			System.out.println(fives + " five");
		else
			System.out.println(fives + " fives");
		if (singles == 1)
			System.out.println(singles + " single");
		else
			System.out.println(singles + " singles");
		if (quarters == 1)
			System.out.println(quarters + " quarter");
		else
			System.out.println(quarters + " quarters");
		if (dimes == 1)
			System.out.println(dimes + " dime");
		else
			System.out.println(dimes + " dimes");
		if (nickels == 1)
			System.out.println(nickels + " nickel");
		else
			System.out.println(nickels + " nickels");
		if (pennies == 1)
			System.out.println(pennies + " penny");
		else
			System.out.println(pennies + " pennies");
		if (totalBillsCoins == 1)
			System.out.println("One bill or coin was used.");
		else
			System.out.println("The total number of bills and coins used was: " + totalBillsCoins);
		
		System.out.println("\nThanks! Goodbye.");
		keyboard.close(); //closes the keyboard
			
	}//main
}//ChangeMakerWeiss
