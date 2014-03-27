/*
Tom Ayotte
600.107
February 22, 2012
2b
781-771-7151
tayotte1
tayotte1@jhu.edu
*/

//import the scanner utility
import java.util.Scanner;

//start the public class
public class pg2b{

	//start the main program
	public static void main(String[] args){
		
		//initialize scanner and variables
		Scanner kb = new Scanner(System.in); //scanner
		int months, minutes, texts, data; //input months, minutes, data, and texts
		int totM = 0; //average minutes
		int minT = 0; //minimum texts
		int maxD = 0; //maximum data
		int n = 1; //counting variable
		
		//ask how many months to analyze
		System.out.print("Enter how many months we will be analyzing: ");
		//read number of months
		months = kb.nextInt();
		
		//ask for the minutes, texts, and data
		System.out.println("For each month enter the calling minutes, text messages, and data (kilobytes):\nExample: 1) 500 625 100");
		
		//read and calculate texts, minutes, and data for n number of months
		while(n <= months){
			System.out.print(n + ") ");
			
			//read the variables
			minutes = kb.nextInt();
			texts = kb.nextInt();
			data = kb.nextInt();
			
			//if it is the first month just store values as totM, minT, and maxD
 			if(n==1){
				totM = minutes;
				minT = texts;
				maxD = data;
			}
			
			//otherwise edit totM, minT, and maxD
			else{	
				//add to total monthly minutes
				totM = (totM + minutes);
				
				//if new input texts are fewer than previous then change minT
				if(minT > texts)
					minT = texts;
				//if new input data is more than previous then change maxD
				if(maxD < data)
					maxD = data;		
			}//end else
			
			//increase n	
			n = n+1;
		
		}//end while
		
		//print all outputs
		System.out.println("The average number of calling minutes is " + totM/(n-1));
		System.out.println("the minimum number of text messages is " + minT);
		System.out.println("The maximum amount of data (kilobytes) is " + maxD);
		
	}//end main

}//end class