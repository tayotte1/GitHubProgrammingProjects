/*
Tom Ayotte
600.107
February 29, 2012
3a
781-771-7151
tayotte1
tayotte1@jhu.edu
*/

//import scanner
import java.util.Scanner;

//start class
public class pg3a{
	//start main
   public static void main(String args[]){
   	
		//menu
		int choice;
		
		//monthly statement
      int totTexts = 0, totMins = 0, totData = 0;
		
		//minutes
		String start, end;
		int startMin, startHR, endMin, endHR;
		int minutes = 0;
		
		//texts
      String word = "", text = "";
      String encrypted = "", encWord = "";
		Scanner scanText;
		char letter;
		int wordLength = 0;
		int counter = 1;
		
		//data
		int kilobytes = 0;  	
		
//do loop menu
      do{
      
         Scanner key = new Scanner(System.in);
//print menu      
         System.out.println("\n1) Log a Call");
         System.out.println("2) Log a Text Message");
         System.out.println("3) Log a Data Transmission");
         System.out.println("4) Get a Monthly Statement");
         System.out.println("5) Quit");
         System.out.print("Choose an option: ");
      	
         choice = key.nextInt();
//cases      
         switch(choice){
//call         
            case 1:
               System.out.print("Log a Call: ");
					System.out.print("Enter the start and end time of the call (ex. 0820 0830): ");
					start = key.next();
					
					startHR = Integer.parseInt(start.substring(0,2));
					startMin = Integer.parseInt(start.substring(2));
					
					end = key.next();
					
					endHR = Integer.parseInt(end.substring(0,2));
					endMin = Integer.parseInt(end.substring(2));
					
					if(endHR >= startHR && endMin > startMin){
						minutes = ((endHR - startHR)*60) + (endMin - startMin);
					}
					else if(startHR == endHR && endMin < startMin)
						minutes = 1440 + endMin - startMin;
					else
						minutes = (((endHR+24)-startHR)*60) + (endMin - startMin);
						
					totMins = totMins + minutes;
					
					System.out.println("Number of minutes for the call: "+minutes);
					
					minutes = 0;
            
               break;
//text         
            case 2:
               System.out.println("Log a Text Message: ");
               System.out.print("Enter your text message: ");
            	key.nextLine();
               text = key.nextLine();
               scanText = new Scanner(text);
               encrypted = "";
					
					do{
					
						word = scanText.next();
						wordLength = word.length();
						
						for(int x = 0; x <= (wordLength-1); x++){
							
							letter = word.charAt(x);
							if('a' <= letter && letter < 'y' || 'A' <= letter && letter < 'Y')
								letter = (char)((int)letter + 2);
							else if(letter == 'y' || letter == 'z' || letter == 'Y' || letter == 'Z')
								letter = (char)((int)letter-24);
							
							encWord = encWord + letter;
						
						}
						
						if(counter > 1)
							encrypted = encrypted + " " + encWord;
						else
							encrypted = encWord;
						
						encWord = "";
						counter++;
					
					}while(scanText.hasNext());
					
					System.out.println("Encrypted text: " + encrypted);
					counter = 1;
					totTexts++;
            
               
               break;
//data         
            case 3:
               System.out.println("Log a Data Transmission:");
               System.out.print("Enter the number of kilobytes used: ");
               kilobytes = key.nextInt();
               for(int x = 1; x <= kilobytes; x++){
                  System.out.print("+");
               }
               System.out.println();
               totData = totData + kilobytes;
               kilobytes = 0;
               break;
//monthly statment         		
            case 4:
               System.out.println("Your Monthly Statement:");
               System.out.println("--------------------------------");
               System.out.println("Your Total Monthly Minutes: " + totMins);
               System.out.println("Your Total Monthly Texts: " + totTexts);
               System.out.println("Your Total Monthly Data: " + totData + " kB");
               System.out.println("--------------------------------");
               totMins = 0;
               totTexts = 0;
               totData = 0;
               break;
//quit         	
            case 5:
               System.out.println("\nBye.");
               break;
//default         		
            default:
               System.out.println("Please choose a number between 1 and 5");
         
         }
      }while(choice != 5);
		   
   }//end main
}//end class


/*
There was no warmup excersize.

This program was not as hard as pg2a but it was somewhat challenging. It was very
similar to what we had done in class which helped a lot. I didn't really need help in
any particular instance but I did need to look up some of the syntax that I had
forgotten from the previous homeworks. I learned how to use do loops much better than
what I learned in class, which was the best part of this assignment. It took about 4
hours to complete the whole assignment. I wouldn't change the assignment.
*/