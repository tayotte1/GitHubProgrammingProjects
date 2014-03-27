/* 
Tom Ayotte
600.107
April 4, 2012
7a
781-771-7151
tayotte1
tayotte1@jhu.edu
*/

import java.util.*;
import java.io.*;

public class pg7a{
	public static void main(String[] args) throws IOException{
		
		int choice;
		String picName;
		Scanner key = new Scanner(System.in);
		
		int firstChoice;
		
		System.out.println("1) Load a picture");
		System.out.println("2) Quit");
		System.out.print("What is Your Choice? ");
		
		firstChoice = key.nextInt();
				
		switch(firstChoice){
		
		case 1:
			key.nextLine();
			System.out.print("\nWhat is the name of your first picture file?: ");
			picName = key.nextLine();
			Picture pic = new Picture(picName);
		
//do loop menu
      do{
         
//print menu      
         System.out.println("\n1) Load a New Picture");
         System.out.println("2) Display Current Picture");
         System.out.println("3) Flip Along Horizontal Axis");
         System.out.println("4) Flip Along Vertical Axis");
			System.out.println("5) Shift Values");
			System.out.println("6) Save Changes");
         System.out.println("7) Quit");
         System.out.print("\nPlease Choose an Option: ");
      	
         choice = key.nextInt();
			      
         switch(choice){
				case 1:
					System.out.print("\nWhat is the name of your picture file? ");
					key.nextLine();
					picName = key.nextLine();
					pic = new Picture(picName);
					break;
				case 2:
					System.out.println("\nLast Saved Picture:");
					pic.display();
					break;
				case 3:
					System.out.println("\nYour Picture Flipped Horizontally:");
					pic.flipHoriz();
					break;
				case 4:
					System.out.println("\nYour Picture Flipped Vertically:");
					pic.flipVert();
					break;
				case 5:
					System.out.println("\nYour Picture With Shifted Values:");
					pic.shiftVals();
					break;
				case 6:
					System.out.println("\nThank You For Saving.");
					pic.save();
					break;
//quit         	
            case 7:
               System.out.println("\nBye.");
               break;
//default         		
            default:
               System.out.println("Please choose a number between 1 and 7");
         
         }
      }while(choice != 7);
			break;
		case 2:
			System.out.println("\nBye.");
			break;
			
		default:
			System.out.println("Please chose 1 or 2");
			
		}
	}//end main
}//end class