/* 
Tom Ayotte
600.107
March 14, 2012
5a
781-771-7151
tayotte1
tayotte1@jhu.edu
*/

import java.util.Scanner;
import java.util.Random;

public class pg5a{

	public static Random rand = new Random();

	public static void main(String[] args){
	
		printCourse();
	
	}//end main
	
/** Generate a random course number with the department between 010 and 650 inclusive
	 and a course number between 101 to 510 or 601 to 810, inclusive at all ends.
	 Finally, return it.
	*@return the random course number.
*/	 
	public static String courseNumber(){
	
		int dep = 0, c = 0;
		String department = "", number = "";
		
		
		dep = (rand.nextInt(65)+1)*10;
		if(dep < 90)
			department = "0" + Integer.toString(dep);
		else
			department = Integer.toString(dep);
			
		c = rand.nextInt(2);
		if(c == 0)
			number = Integer.toString(rand.nextInt(410)+101);
		else
			number = Integer.toString(rand.nextInt(210)+601);
			
		department = department + "." + number;
						
		return department;	
	}
	
/** Generate a random set of designators with 50% chance of each and return a string
	 of them.
	*@return the string of randomly generated designators.
*/
	
	public static String designator(){
	
		String DES = "HSNQEW", des = "";
		int decider;
		
		for(int x = 0 ; x < 6; x++){
			decider = rand.nextInt(2);
			
			if(decider == 1)
				des = des + DES.charAt(x);
		}
		return des;
	}

/** Generate a random credit number between 1 and 4.5 with 50% chance of 3, 15% chance
	 of 4, 10% chance of 1 and 25% chance of the rest.
	*@return the number of credits.
*/

	public static String credits(){
	
		String credits = "";
		int decider, half;
		
			decider = rand.nextInt(20);
			half = rand.nextInt(2);
			
			if(decider<10)
				credits = "3";
			
			else if(decider > 9 && decider < 13)
				credits = "4";
				
			else if(decider > 12 && decider < 15)
				credits = "1";
			else{
				if(half == 1)
					credits = Integer.toString(rand.nextInt(4)+1)+".5";
				else
					credits = "2";
			}
		return credits;
	}
	
/** Combine methods courseNumber, credits, and designator, and return a string of them.
	*@return the course string.
*/	
	
	public static String course(){
	
		String course = courseNumber() + " " + credits() + " " + designator();
		return course;
	}
	
/** print the generated course from course() and ask if the user wants another course.
If yes print another course, if no then end. Once the user inputs no then print how
many courses they asked for.
*/	
	public static void printCourse(){
		
		Scanner kb = new Scanner(System.in);
		char choice = 'y';
		int counter = 0;
		
		do{
			
			System.out.println(course());
			
			System.out.print("Would you like another course(y/n)? ");
			choice = kb.next().toLowerCase().charAt(0);
			
			counter++;
			
		}while(choice == 'y');
		
		if(counter == 1)
			System.out.println("\nYou asked for one course");
		else
			System.out.println("\nYou asked for " + counter + " courses");
	}
	
}//end class

/* The warm up didn't really help me cause I didn't really know what I wanted the
methods to do until I wrote the program. I actually ended up writing the program
before I did the warm up.

This program wasn't really that hard. The most difficult part was figuring out the
proper random numbers to produce. It took about an hour and a half to program
everything. The best part of the assignment was the random variables. I would clarify
what needs to be in each method because the programming wasn't that hard I'm just not
sure if I broke the methods up right.
*/
