//Zachary Weiss
//Prog 3
//Due Date and Time: 2/17/2020 before 9:00 AM
//
//Purpose: This program will calculate 
//	how much a patient
//	owes after a hospital stay
//	based on the daily fees, admittance fee, 
//	service fee, and length of time.
//
//Input: The inputs to the program 
//	will be a patient ID, household income, 
//	the insurance plan (based on a single character),
//	and the number of days they were in the hospital.
//Output: The program will return a specific value 
//	for the amount owed by the individual, their
//	Patient ID, Household Income, Insurance Plan,
//	Number of days, admittance fee,
//	Per diem rate, service fee,
//	discount, and total bill.
//	It will also output the
//	number of patients processed,
//	the highest bill amount, 
//	the patient with the highest bill,
//	the lowest amount and the associated
//	patient, the total cost of all bills,
//	and the average cost of all bills.

//Certification of Authenticity: 
//	I certify that this lab is entirely my
//	own work.

import java.util.*;
import java.text.*;



public class HospitalWeiss
{
	static DecimalFormat moneyStyle = new DecimalFormat("0.00");
	//sets up money to be in a two decimal format
	
	static Scanner keyboard = new Scanner(System.in);
	//declares the keyboard for the project

	public static void main(String[] args) 
	{
		//initialize variables
		int patientID = 1;
		int oldPatientID = 1;
		int highestPatientID = 1;
		double income = 0;
		double perDiemRate = 0;
		double fee = 0;
		double longTermDiscount = 0;
		int patientsProcessed = 0;
		double highestBill = 0;
		double lowestBill = Integer.MAX_VALUE;
		int lowestPatientID = 1;
		double totalBills = 0;
		double billSum = 0;
		double averageBill = 0;
		int numDays = 0;
		char patientInsurance = ' ';
		double admittanceFee = 500;
		double results;
		
		System.out.print("Please enter your Patient ID: ");
		patientID = keyboard.nextInt();
		
		while (patientID != 0)
		{
		System.out.print("Please enter your household income: ");
		income = keyboard.nextDouble();
		
		//while loop to get 0 income if a negative is entered
		while (income < 0)
		{
			System.out.print("Income cannot be less than 0, "
					+ "please enter 0 for income: ");
			income = keyboard.nextDouble();			
		}//while
	
		System.out.print("Please enter your insurance plan,"
				+ " which is a single character"
				+ " 'B' for Blue Plus, 'M' for Med-Health,"
				+ " 'H' for Health Plan, and 'N' for none: ");
		patientInsurance = keyboard.next().toUpperCase().charAt(0);
		while ((patientInsurance != 'B') && (patientInsurance != 'M') &&
				(patientInsurance != 'H') && (patientInsurance != 'N'))
		{
			System.out.println("Invalid input for insurance."
					+ " Please try again: ");
			patientInsurance = keyboard.next().toUpperCase().charAt(0);
		}//while
		
		System.out.print("Please enter the number of days"
				+ " you were in the hospital: ");
		numDays = keyboard.nextInt();
		
		//while loop to get an integer for days
		//	between 1 and 365
		//	if user inputs something greater than 365
		//	or less than 1.
		while (numDays < 1 || numDays > 365)
		{
			System.out.print("The number of days must be an integer between 1 and 365"
					+ " please enter a new value between 1 and 365: ");
			numDays = keyboard.nextInt();
		}//while
		
		//get daily rate
		perDiemRate = calcPerDiem(patientInsurance, income);
		
		//get service fee
		fee = calcServiceFee(numDays, perDiemRate);
		
		//get discount (if applicable)
		longTermDiscount = calcDiscount(numDays);
		
		//get total bill
		totalBills = calcTotalBill(fee, longTermDiscount);
		
		//get results
		results = outputResults(patientID, income, patientInsurance,
				numDays, admittanceFee, perDiemRate, fee, longTermDiscount, 
				totalBills);
		
		System.out.print("Please enter the next patient ID: ");
		oldPatientID = patientID;
		patientID = keyboard.nextInt();
		while (patientID == oldPatientID)
		{
			System.out.print("Patient ID cannot be the same."
					+ " Please enter a new one: ");
			patientID = keyboard.nextInt();
		}//while
		
		patientsProcessed = patientsProcessed + 1;
		
		//find highest bill amount and the associated patient
		
		
		if (highestBill < totalBills)
		{
			if (highestBill < totalBills)
			{
				highestPatientID = patientID;
			}//if
			
			highestBill = totalBills;
			
		}//if
		
		//find lowest bill and associated patient
		if (totalBills < lowestBill)
		{
			if (totalBills < lowestBill)
				lowestPatientID = patientID;
			lowestBill = totalBills;
		}//if
		
		//find sum of all bills
		billSum = totalBills + billSum;
		
		//find average of all bills
		averageBill = billSum/patientsProcessed;
		
		
		}//while
		
		//output final results for all patients
		if (patientID == 0)
		{
			System.out.println("The amount of patients processed was "
					+ patientsProcessed + ".");
			System.out.println("The highest bill amount was $"
					+ moneyStyle.format(highestBill) + ".");
			System.out.println("The patient with the highest bill"
					+ " amount was " + highestPatientID + ".");
			System.out.println("The lowest bill amount was $" +
					moneyStyle.format(lowestBill) + ".");
			System.out.println("The patient with the lowest"
					+ " bill amount was " + lowestPatientID + ".");
			System.out.println("The bill sum was $" + 
					moneyStyle.format(billSum) + ".");
			System.out.println("The average bill was $" + 
					moneyStyle.format(averageBill) + ".");
		}//if
	}//main
	
	//Input: The user will input their insurance and the
	//	method will take their income input in main.
	//Output: This method will output the patient's
	//	insurance and the daily rate at which they pay.
	
	public static double calcPerDiem(char insurance, double householdIncome)
		{
		//initializes variables used in the method
		double dailyRate = 0;
		
		do
			{
				//switch statement to determine the patient's
				//	insurance plan
				
				switch (insurance)
				{
				case 'B': 
				//compute service fee using blue plus plan
					  	  if (householdIncome < 15000)
					  		  dailyRate = 50;
					  	  else if (householdIncome <= 67500)
					  		  dailyRate = 85;
					  	  else
					  		  dailyRate = 150;
					  	  break;
				case 'M': 
				//compute service fee using med-health plan
					      if (householdIncome < 20000)
					    	  dailyRate = 65;
					      else if (householdIncome <= 75000)
					    	  dailyRate = 100;
					      else
					    	  dailyRate = 200;
					      break;
				case 'H': 
				//compute service fee using health plan plan
						  if (householdIncome < 17500)
							  dailyRate = 55;
						  else if (householdIncome <= 63000)
							  dailyRate = 90;
						  else
							  dailyRate = 150;
						  break;
				case 'N': 
				//compute service fee for those with no insurance
					  	  dailyRate = 500;
					  	  break;
				default:;
						
						 
				}//switch
					
			}//do
			while ((insurance != 'B') && (insurance != 'M') &&
				(insurance != 'H') && (insurance != 'N'));
		
			
			return dailyRate;
		}//calcPerDiem
	
	
	//Input: This method receives the input
	//	days and the per diem rate.
	//Output: This method outputs the service fee
	//	based on the users input for 
	//	income and insurance plan
	//	as well as the days in 
	//	the hospital.
	
	public static double calcServiceFee(int days, double dailyRate)
	{
		double serviceFee = 0;
		serviceFee = days * dailyRate;
		return serviceFee;
	}//calcServiceFee
	
	//Input: This method will receive the input number of days
	//Output: This method will output the patients discount
	//	for over 25 days in the hospital.
	
	public static double calcDiscount(double days)
	{
		double discount = 0;
		double weeks = 0;
		if (days > 25)
			weeks = days/7;
		discount = weeks * 300;
		return discount;
	}//calcDiscount
	
	//Input: This method receives the input service fee and discount
	//Output: This method outputs the total bill for the patient.
	
	public static double calcTotalBill(double serviceFee, double discount)
	{
		double totalBill = serviceFee + 500 - discount;
		return totalBill;
	}//calcTotalBill
	
	//Input: This method receives inputs:
	//	patientID, household income, patient insurance
	//	number of days, admittance fee, daily rate, service fee,
	//	discount for time, and total bill.
	//Output: This method outputs all of the above 
	//	for an individual patient
	
	public static double outputResults(int id, double houseIncome, char patientIns, 
			int numberDays, double admitFee, double dayRate, 
			double feeForService, double timeDiscount, double totalMoney)
	{
		
		System.out.println("The patient ID for this patient is " + id + ".");
		System.out.println("The household income is $" + moneyStyle.format(houseIncome) + ".");
		if (patientIns == 'B')
			System.out.println("Insurance Plan: Blue Plus");
		else if (patientIns == 'M')
			System.out.println("Insurance Plan: Med-Health");
		else if (patientIns == 'H')
			System.out.println("Insurance Plan: Health Plan");
		else
			System.out.println("No insurance provided");
		System.out.println("The patient was in the hospital for " + numberDays + " days.");
		System.out.println("The admittance fee was $" + moneyStyle.format(admitFee) + ".");
		System.out.println("The daily rate for the patient was $" 
							+ moneyStyle.format(dayRate) + " per day.");
		System.out.println("The service fee was $" + moneyStyle.format(feeForService) + ".");
		System.out.println("The discount for extended length of stay totaled $"
							+ moneyStyle.format(timeDiscount) + ".");
		System.out.println("The total bill amounted to $" 
							+ moneyStyle.format(totalMoney) + ".");
		return totalMoney;
		
	}//outputResults
	
	
	
}//HospitalWeiss
