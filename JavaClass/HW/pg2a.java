/*
Tom Ayotte
600.107
February 22, 2012
2a
781-771-7151
tayotte1
tayotte1@jhu.edu
*/

//import scanner and string tokenizer utility
import java.util.Scanner;
import java.util.StringTokenizer;

//start class
public class pg2a{

//start main
   public static void main(String[] args){
   
//initialize keyboard and variables
      Scanner kb = new Scanner(System.in);
      String major, course, courseNum;
      int q = 0;
      int elective = 1;
      int i,n;
		int w = 0;
		String courseDep = " ";
		String credits = " ";
		String des = " ";

//Input  
   //ask for and read major
      System.out.print("Enter major department code: ");
      major = kb.next();
		major = major.substring(0,3);
   //ask for and read as one line all the input
      System.out.print("Enter course data (dpt.num credits HSEQNW): ");
      kb.nextLine();
      course = kb.nextLine();

//Edit Input				
		//initialize the string tokenizer and tell it to split apart course by spaces
		StringTokenizer st = new StringTokenizer(course, " ");
		
		//while there are still tokens
		while(st.hasMoreTokens()){
			//set courseDep = to the first token
			if(w==0)
			courseDep = st.nextToken();
			//set credits = to the second token
			else if(w==1)
			credits = st.nextToken();
			//set des to the third token
			else if(w==2)
			des = st.nextToken().toUpperCase();
			//increase w
			w = w + 1;
		}
		
		//set the courseNum and courseDep values
		courseNum = courseDep.substring(4,7);
		courseDep = courseDep.substring(0,3);
   

			
//Major
	//if the course is in your major      
   	if(courseDep.equals(major)){
		//if it is a lower level course
   		if(Integer.parseInt(courseNum)<300)
   			System.out.println("This course can be counted towards your lower level major requirement.");
  		//if it is an upper level class 		
			else
	   		System.out.println("This course can be counted towards your upper level major requirement.");
	  	//if it is in your major then it won't only count toward your electives so set it = 0		
			elective = 0;
		}
		
//Math
	//if the course is in the math department				
   	if((courseDep.equals("110") || courseDep.equals("550"))){
   		System.out.println("This course can be counted towards your math requirement.");
   //set elective to 0	
		elective = 0;
		}
		
//Designation
	//read each letter of the designation		
	   for(i=0;i<des.length();i++){
		//if the course has enough credits and is in H or S
         if((Double.parseDouble(credits)>=3) && (des.charAt(i)=='H' || des.charAt(i)=='S')){
      	//read the rest of the letters
		      for(n=i+1;n<des.length();n++){
        		//if one of the letters is an H or S after the initial H or S then it counts toward HS     
				   if(des.charAt(n)=='H' || des.charAt(n)=='S')
                  q = 1;
					else if(des.charAt(n)=='W')
						System.out.println("This course can be counted towards your W requirement.");

            }
			//if it was both H and S print both	
            if (q == 1)
               System.out.println("This course can be counted towards your HS requirement.");
     		//if it was only one then print that type      
			   else
               System.out.printf("This course can be counted towards your %c requirement.\n", des.charAt(i));
			//set elective to 0	
				elective = 0;
			//breaks the original for loop because we have already read all of the letters in this loop
            break;
         }
			else if(des.charAt(i)=='W'){
				System.out.println("This course can be counted towards your W requirement.");
   			elective = 0;
			}
		}
		
//Elective
	//if none of the requirements were filled then elective will still be 1 and can only be an elective course
      if (elective == 1){
         System.out.println("This course can be counted as elective credit only.");
      }
		
		
   }//end main
}//end class


/*I thought the warm up excersize was somewhat helpful because it made me think about
the different cases there would be so when I wrote my program it was easy to see that
there were four main sections that I needed to worry about.

Program 2a was on the harder side for a couple of reasons. I have never really dealt
with strings before so I had to learn all of the syntax that goes with it. It was
also hard because everything had to be input on one line. Figuring out how to account
for that was hard because the length was not always the same and sometimes there
would be no designation. It took me about 5 hours to code, debug, and edit it. The
best part of the program was that it forced me to learn about strings. I wouldn't
redesign this assignment I thought it was clever for something so simple.

Program 2b was pretty easy because it was basically a simple version of the GPA program
that we wrote in class. Referring back to the GPA program I was able to complete it
in a relatively short amount of time. I didn't really see the point to this program
because it was so similar to the GPA program that we wrote in class.
*/
