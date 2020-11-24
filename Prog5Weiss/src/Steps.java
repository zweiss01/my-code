//The steps class will be used to 
//	be called by the main StepsDemoWeiss
//	class and sets and gets the 
//	number of steps, width, and fill style.
//	This class also has a toString method
//	to return string values for the step
//	width, number, and fill style.
public class Steps 
{
	//initializes variables for Steps
	//	that will be called by the methods
	//	of the Steps class.
	private int myStepWidth;
	private int myNumSteps;
	private char myFillStyle;
	
	//This method is the default constructor
	//	for the steps.
	public Steps()
	{
		myStepWidth = 2;
		myNumSteps = 5;
		myFillStyle = '*';
	}//Steps
	
	//This method is the full constructor for
	//	the Steps class.
	public Steps(int newMyStepWidth, int newMyNumSteps,
					char newMyFillStyle)
	{
		myStepWidth = newMyStepWidth;
		myNumSteps = newMyNumSteps;
		myFillStyle = newMyFillStyle;
	}//Steps
	
	//This method gets the step width and returns it.
	public int getStepWidth()
	{
		return myStepWidth;
	}//getStepWidth
	
	//This method sets the step width and receives
	//	an input from the call from the StepsDemoWeiss
	//	class.
	public void setStepWidth(int newStepWidth)
	{
		myStepWidth = newStepWidth;
	}//setStepWidth
	
	//This method gets the number of steps and returns it.
	public int getNumSteps()
	{
		return myNumSteps;
	}//getNumSteps
	
	
	//This method sets the number of steps and receives
	//	the user input number of steps from its call
	//	from StepsDemoWeiss.
	public void setNumSteps(int newNumSteps)
	{
		myNumSteps = newNumSteps;
	}//setNumSteps
	
	//This method gets the fill style and returns it.
	public char getFillStyle()
	{
		return myFillStyle;
	}//getFillStyle
	
	//This method sets the fill style and receives
	//	input from its call from the StepsDemoWeiss
	//	class.
	public void setFillStyle(char newFillStyle)
	{
		myFillStyle = newFillStyle;
	}//setFillStyle
	
	//Purpose: calcArea calculates the number of
	//	fill style characters used.
	//Input: This method receives step width and number
	//	of steps from the class.
	//Output: This method outputs the area into
	//	StepsDemoWeiss.
	public int calcArea()
	{
		int area = 0;
		int i = 0;
		for (i = 0; i <= myNumSteps; i++)
			area += (myStepWidth * i);
		return area;
	}//calcArea
	
	//Purpose: This method draws the steps.
	//Input: This method receives step width, fill
	//	style, and number of steps from the class.
	//Output: This method prints the steps.
	public void drawSteps()
	{
		int step = 0;
		int numStep = 0;
		int count = 0;
		
		//for loop to print each step until
		//	number of steps is reached.
		for (step = 1; step <= myNumSteps; step++)
		{
			numStep = myStepWidth * step;
			
			//for loop to print the steps and then
			//	a line when the number of steps
			//	for the step is reached.
			for (count = 1; count <= numStep; count++)
			{
				System.out.print(myFillStyle);
				if (numStep == count)
					System.out.println();
			}//for count
		}//for step
	}//drawSteps
	
	//The toString method returns the results as a 
	//	string for the user when they call for a 
	//	text description.
	public String toString()
	{
		String result = "Steps: " + myNumSteps;
		result += " Step Width: " + myStepWidth;
		result += " Fill Style: " + myFillStyle;
		return result;
	}//toString

}//Steps
