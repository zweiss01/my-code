//Zachary Weiss
//Prog 2
//Due Date and Time: 2/10/2020 before 9:00 AM

//Purpose: This program will be used to find a tax bracket and find the taxes owed by 
//	an individual based on the inputs of the user.
//Input: Taxpayer ID (any integer), Filing Status (single character I, J, H), 
//	Gross Income, Number of Exemptions
//Output: The program will return a specific value for the taxes owed by the individual, their
//	taxpayer number, filing status, taxable income, tax rate, and tax amount owed.
//	It will also output the number of people who were processed, the average value, 
// 	the total amount, the greatest amount, 
// 	and the user who paid the greatest amount.
//Certification of Authenticity:
//	I certify that this lab is my own work, but I discussed it with: Michael Wise.

import java.util.*;
import java.text.*;

public class TaxesWeiss 
{
	
	static DecimalFormat moneyStyle = new DecimalFormat("0.00"); 
	//sets up money to be shown as a decimal with two places
	
	static Scanner keyboard = new Scanner(System.in); 
	//declares the keyboard for the project
	
	public static void main(String [] args)
	{
		//initialize variables
		int taxpayerID = 1;
		double oldTaxesOwed = 0;
		double averageTaxValue = 0;
		int taxpayersProcessed = 0;
		int highestTaxpayerID = 0;
		double taxesPaid = 0;
		double oldSum = 0;
		double grossIncome = 0;
		int exemptions = 0;
		int exemptionsValue = 0;
		double taxableIncome = 0;
		double taxRate = 0;
		double taxOwed = 0;
		char status = 'a';
		
		//asks the user for their taxpayer ID or uses 0 to quit
		System.out.print("Please enter your taxpayerID or enter 0 to quit: ");
		taxpayerID = keyboard.nextInt();
		
		//main while loop to perform the math for more than one user
		while (taxpayerID != 0)
		{		
			//gets the users income
			System.out.print("Please enter your gross income: ");
			grossIncome = keyboard.nextDouble();
			
			//gets the users exemptions
			System.out.print("Please enter the number of exemptions: ");
			exemptions = keyboard.nextInt();
			
			//while loop that makes sure there are no more than 10 exemptions
			while (exemptions > 10)
				{
				System.out.println("You cannot have more than 10 exemptions. "
						+ "Please input a number from 0 to 10");
				exemptions = keyboard.nextInt();
				}//while
			
		//calculates exemption value	
		exemptionsValue = exemptions * 1200;
		System.out.println("Your exemption value is $" +
		moneyStyle.format(exemptionsValue));
		
		//calculates taxable income
		taxableIncome = grossIncome - exemptionsValue;
		
		if (taxableIncome < 0)
		{
			taxableIncome = taxableIncome * -1;
			System.out.println("Your taxable income is -$" + 
			moneyStyle.format(taxableIncome) + ".");
			taxableIncome = -taxableIncome;
		}//if
		else
			System.out.println("Your taxable income is $" + 
			moneyStyle.format(taxableIncome));
		
		//asks for filing status
		System.out.print("Please enter your filing status (Either I, J or H): ");
		status = keyboard.next().toUpperCase().charAt(0);
		
		do
		{
				
				//switch statement to determine filing status
				switch (status)
				{
				case 'I':System.out.println("Filing Status: Individual"); 
				//compute taxes for Individual
						  if (taxableIncome < 17000)
							  taxRate = 0.11;
						  else if (taxableIncome >= 17000 && taxableIncome < 58000)
							  taxRate = .20;
						  else
							  taxRate = .31;				  
				          break;
				case 'J': System.out.println("Filing Status: Married Filing Jointly"); 
				//compute taxes for Married Filing Jointly
						  if (taxableIncome < 20000)
							  taxRate = .14;
						  else if (taxableIncome >= 20000 && taxableIncome < 110000)
							  taxRate = .22;
						  else
							  taxRate = .39;
				          break;
				case 'H': System.out.println("Filing Status: Head of Household"); 
				//compute taxes for Head of Household
				          if (taxableIncome < 34000)
				        	  taxRate = .15;
				          else if (taxableIncome >= 34000 && taxableIncome < 75000)
				        	  taxRate = .23;
				          else
				        	  taxRate = .38;
				          break;
				default: System.out.println("Invalid Filing Status. "
						+ "Please enter an I, J, or H, for filing status."
						+ "Put in the correct status, press enter, "
						+ "and do the same again to find your Filing Status.");
						
		
				}//switch
		}//do
		while ((status != 'I') && (status != 'J') && (status != 'H'));
		
		//shows the users tax rate as a percentage
		System.out.println("Your tax rate is " + taxRate * 100 + "%");
		
		//calculates tax owed
		taxOwed = taxableIncome * taxRate;
		
		if (taxOwed < 0)
		{
			taxOwed = -taxOwed;
			System.out.println("Congratulations! The government is paying you $" +
			moneyStyle.format(taxOwed) + "!");
		}//if
		else
			System.out.println("Your tax owed is $" + moneyStyle.format(taxOwed) + 
					". I know this is disappointing. I hate taxes, too.");
		
		//shows which taxpayer ID was just used
		System.out.println("TaxpayerID " + taxpayerID + " has been used.");
		
		System.out.print("Please enter a different TaxpayerID, or use 0 to quit: ");
		taxpayerID = keyboard.nextInt();
		
		//calculates the amount of taxpayers processed
		taxpayersProcessed = taxpayersProcessed + 1;
		
		//calculates the total amount of taxes paid across all users
		oldSum = taxOwed;
		taxesPaid = taxesPaid + oldSum;
		
		//calculates the average tax value
		averageTaxValue = taxesPaid/taxpayersProcessed;
		
		if (oldTaxesOwed < taxOwed)
		{
			oldTaxesOwed = taxOwed;
			
			if (taxpayerID != 0)
				highestTaxpayerID = taxpayerID;
			
		}//if
		
		
		if (taxpayerID == 0)
			{
				System.out.println("The amount of taxpayers processed was: " 
				+ taxpayersProcessed);
				System.out.println("The greatest tax amount was: $" + 
				moneyStyle.format(oldTaxesOwed));
				System.out.println("The user who paid the greatest tax amount was: " + 
				highestTaxpayerID);
				System.out.println("The total amount of taxes paid was: $" +
				moneyStyle.format(taxesPaid));
				System.out.println("The average tax value paid was: $" +
				moneyStyle.format(averageTaxValue));
			}//if
		
		}//while
	
	}//main

}//TaxesWeiss
