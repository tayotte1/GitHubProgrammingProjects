/*
Tom Ayotte
600.107
February 15, 2012
1b
781-771-7151
tayotte1
tayotte1@jhu.edu
*/

//import scanner
import java.util.Scanner;

//start class
public class pg1b{

	//start main
	public static void main(String[] args){
	
	//declare variables and keyboard
	int minutes, texts, planAM, planBT, minO, txtO;
	double planAO, planAB, planBO, planBB, totalA, totalB;
	Scanner keyboard = new Scanner(System.in);
	
	//prompt user for average month
	System.out.print("How many minutes do you use in an average month? (ex. 500) ");
	minutes = keyboard.nextInt();
	System.out.print("How many texts do you send in an average month? (ex. 500) ");
	texts = keyboard.nextInt();
	//prompt user for plan A
	System.out.print("What is the base price of plan A? (ex. 40.00) ");
	planAB = keyboard.nextDouble();
	System.out.print("How many minutes do you get with plan A? (ex. 500) ");
	planAM = keyboard.nextInt();
	System.out.print("What is the overage charge per minute of plan A? (ex. 0.40) ");
	planAO = keyboard.nextDouble();
	//prompt user for plan B
	System.out.print("What is the base price of plan B? (ex. 40.00) ");
	planBB = keyboard.nextDouble();
	System.out.print("How many texts do you get with plan B? (ex. 500) ");
	planBT = keyboard.nextInt();
	System.out.print("What is the overage charge per text of plan B? (ex. 0.40) ");
	planBO = keyboard.nextDouble();
	
	//calculate the minutes and texts over
	minO = minutes - planAM;
	txtO = texts - planBT;
	
	//if you go over the minutes or texts keep as min and txt over else set them to 0
	if (minO > 0)
		minO = minO;
	else
		minO = 0;
		
	if (txtO > 0)
		txtO = txtO;
	else
		txtO = 0;
	
	//calculate the total monthly charge
	totalA = (minO * planAO) + planAB;
	totalB = (txtO * planBO) + planBB;
	
	//print plans
	System.out.println("\nPlan A (unlimited texts " + planAM + " minutes):");
	System.out.printf("	Minutes over = %d \n	Fee due to overage = $%.2f \n	Base price = $%.2f", minO, (minO*planAO), planAB);
	System.out.printf("\nTotal price for plan A = $%.2f\n", totalA);
	
	System.out.println("\nPlan B (unlimited minutes " + planBT + " texts):");
	System.out.printf("	Minutes over = %d \n	Fee due to overage = $%.2f \n	Base price = $%.2f", txtO, (txtO*planBO), planBB);
	System.out.printf("\nTotal price for plan B = $%.2f\n", totalB);
		
	//print which plan would be cheaper
	if(totalA > totalB)
		System.out.printf("\nPlan B would be cheaper for an average month by $%.2f.", (totalA-totalB));
	else if (totalB > totalA)
		System.out.printf("\nPlan A would be cheaper for an average month by $%.2f.", (totalB-totalA));
	else
		System.out.print("\nThey would be the same price for an average month.");

	}//end main
}//end class

/*
The warm up excersize was really useful in helping realize what was needed in the input
and output.

This program was fairly straightforward. There was only a couple of simple if statements
to go with the input and outputs. The most difficult part of this was making sure all of
the variables were in the right places.

I learned that printf also works in java as well as c++.

It took about 45 mins to write the program and debug.

The best part of the assignment was that this was easy example of programming similar to
what was done in class so that I could remember all of the correct formatting for java
that was taught in class.

I would have the plan minutes and texts pre programmed into it instead of prompting for
them.  It just made the input really long without teaching anything.

*/
