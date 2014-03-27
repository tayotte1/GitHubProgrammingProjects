/* 
Tom Ayotte
600.107
March 7, 2012
4a
781-771-7151
tayotte1
tayotte1@jhu.edu
*/

import java.util.Scanner;
import java.io.*;
import java.util.Random;

public class pg4a {


   public static void main(String[] args) throws IOException
   {
   
   // Add variable declarations and statements to get the data filename
      String fileName = "";
      int months = 0;
      Scanner kb = new Scanner(System.in);
   
      System.out.print("What is the name of the file? ");
      fileName = kb.nextLine();
		
		
		File newFile = new File(fileName);
		
		if(!newFile.exists())
			newFile.createNewFile();
			
   
   // and number of months from the user (keyboard).
      System.out.print("How many months? ");
      months = kb.nextInt();
   
   // Then call the makeData method with the filename and months.
      makeData(fileName,months);
   
   // Then call the processData method with the filename only.
      processData(fileName);
   
   }


/** Create a text file with monthly randomly generated cell phone data
* @param fileName the name of the file to create
* @param months how many months of data to generate
*/
   public static void makeData(String fileName, int months) throws IOException {
      Random rand = new Random();
      PrintWriter outFile = new PrintWriter(new FileWriter(fileName));
      for(int x = 1; x <= months; x++){
         if(x == months)
            outFile.print((int)(rand.nextInt(401) + 500) + " " + 
               		  (int)(rand.nextInt(1901) + 100) + " " + 
               		  (int)(rand.nextInt(249) + 8));
         else
            outFile.println((int)(rand.nextInt(401) + 500) + " " + 
               		  	 (int)(rand.nextInt(1901) + 100) + " " + 
               		  	 (int)(rand.nextInt(249) + 8));
      }
      outFile.close();
   }


/** Process a text file with monthly cell phone data, displaying
	results on the screen. Results should be the same as for pg2b:
	average calling minutes, minimum text messages, maximum data
	kilobytes. Read until the end of file is reached.
* @param fileName the name of the file to read and process
*/
   public static void processData(String fileName) throws IOException {
      Scanner inFile = new Scanner(new FileReader(fileName));
      int minutes, texts, data;
      int n = 1;
      int totM = 0;
      int minT = 0;
      int maxD = 0;
   
      while(inFile.hasNextLine()){
      
      //read and calculate texts, minutes, and data for n number of months
      //read the variables
         minutes = inFile.nextInt();
         texts = inFile.nextInt();
         data = inFile.nextInt();
      
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
      
         n++;
      }
   
   //print all outputs
      System.out.println("The average number of calling minutes is: " + totM/(n-1));
      System.out.println("the minimum number of text messages is: " + minT);
      System.out.println("The maximum amount of data (kilobytes) is: " + maxD);
   
   }

}

/*
There was no warm-up for this assignment

This program was pretty easy to write because it was basically just copying what we
done in pg2b and paste it into what we did in class. It took about an hour and a half
to write the whole program. The best part of the program was learning about how to
read and write to text files. I wouldn't change the assignment.

*/