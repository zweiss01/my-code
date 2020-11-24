//
//Zach Weiss
//Prog 5
//Due Date and Time: 3/2/2020 before 9:00 A.M.
//
//Purpose: The purpose of this program is to 
//	draw steps using specific user input 
//	width, number of steps, and fill style,
//	as well as review classes and methods.
//
//Input: The inputs will be the action to be performed,
//	the width (an integer), 
//	number of steps (an integer), 
//	and fill style (a single character).
//
//Output: The program will output the step image
//	the amount of fill style characters used, 
//	the width and number of steps, a textual 
//	description of the steps, and Goodbye! at the 
//	end of the program.
//
//Certification of Authenticity:
//	I certify that this lab is entirely
//	my own work.

import java.util.*;
public class StepsDemoWeiss 
{
	
	//initializes the keyboard
	static Scanner keyboard = new Scanner(System.in);
	
	//This main method calls the stepDetails method
	//	to get the user input for the steps and 
	//	call methods from the Steps class.
	public static void main(String[] args)
	{
		stepDetails();
	}//main
	
	//Purpose: This method prints the menu and gets
	//	user input for the details of the steps.
	//Input: The input is the action to run through
	//	the switch statement and choose a specific method
	//	from the Steps class.
	//Output: The output of this method is Goodbye! when
	//	the user chooses Q.
	public static void stepDetails()
	{
		//initializes a new step object
		Steps newStep = new Steps();
		
		char action;
		
		//do loop to run the menu at least once
		do
		{
			System.out.println("Welcome to the Step Creator!");
			System.out.println("W: Assign the Step Width");
			System.out.println("N: Assign the Number of Steps");
			System.out.println("F: Assign The Fill Style");
			System.out.println("A: Calculate The Area");
			System.out.println("T: Text Description of the Steps");
			System.out.println("D: Draw the Steps");
			System.out.println("Q: Quit");
			
			action = keyboard.next().toUpperCase().charAt(0);
			
			//switch statement to call a method
			//	which works with the Steps class
			switch(action)
			{
				case 'W': readWidth(newStep);
						  break;
				case 'N': readNumSteps(newStep);
						  break;
				case 'F': readFillStyle(newStep);
						  break;
				case 'A': System.out.println("The amount of characters used was " 
						  	+ newStep.calcArea());
					      break;
				case 'T': System.out.println(newStep.toString());
						  System.out.println("The amount of characters used was " + 
								  newStep.calcArea());
						  break;
				case 'D': newStep.drawSteps();					
						  break;
				default: if (action == 'Q')
							System.out.println("Goodbye!");
						 else
							 System.out.println("Invalid choice. Try again.");
							  
			}
					
		}//do
		while (action != 'Q');
		
		//closes the keyboard
		keyboard.close();
	}//stepDetails
	
	//Purpose: This method calls setFillStyle to
	//	set the fill style for the steps.
	//Input: This method receives a user input
	//	character to set the fill style.
	//Output: This method outputs the character
	//	to the setFillStyle method of Steps.
	public static void readFillStyle(Steps stair) 
	{
		char stepStyle;
		
		System.out.print("Enter a single character "
				+ "for the fill style: ");
		stepStyle = keyboard.next().charAt(0);
		stair.setFillStyle(stepStyle);
	}//readFillStyle
	
	//Purpose: This method calls setNumSteps to
	//	set the number of steps.
	//Input: The input is a user input integer
	//	for the number of steps they wish to draw.
	//Output: The method outputs numberSteps to 
	//	setNumSteps in the Steps class.
	public static void readNumSteps(Steps stair) 
	{
		int numberSteps;
		
		System.out.print("Enter an integer greater than "
				+ "0 for the number of steps: ");
		numberSteps = keyboard.nextInt();
		
		//while loop to validate integer input
		while (numberSteps <= 0)
		{
			System.out.println("Number of steps must be greater than 0.");
			numberSteps = keyboard.nextInt();
		}//while
		
		stair.setNumSteps(numberSteps);
	}//readNumSteps
	
	//Purpose: This method gets the user input width
	//	to set the width of the first step.
	//Input: This method receives an integer for
	//	input to set the width of the first step.
	//Output: This method outputs user input width
	//	to the setStepWidth method of the Steps class.
	public static void readWidth(Steps stair) 
	{
		int width;
		
		System.out.print("Enter an integer greater than 0"
				+ " for the width of the first step: ");
		width = keyboard.nextInt();
		
		//while loop to validate integer input
		while (width <= 0)
		{
			System.out.println("Width must be greater than 0.");
			width = keyboard.nextInt();
		}//while
		
		stair.setStepWidth(width);
	}//readWidth
	
	
}//StepsDemoWeiss
