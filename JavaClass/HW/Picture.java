/* 
Tom Ayotte
600.107
April 4, 2012
Picture
781-771-7151
tayotte1
tayotte1@jhu.edu
*/

import java.util.*;
import java.io.*;

public class Picture{

	//instance data members ===========================================
	private String name,temp;
	private char picture[][];
	private int width, height;
	
	
/** Set the name, height, and width of the picture then create an array to hold the
	 picture and create a string format of the picture from toString, all of this done
	 from an input file
	* @param picName the name of the file that everything is created from
*/
	
	public Picture(String picName) throws IOException{
		name = picName;
		System.out.println("Your new picture is: " + name);
		Scanner inFile = new Scanner(new FileReader(name));
		height = inFile.nextInt();
		width = inFile.nextInt();
		
		picture = new char[width][height];
		
		String holder = "";
		inFile.nextLine();
		
		for (int i = 0; i < height; i++){
    			holder = inFile.nextLine();      
				for (int x = 0; x < width; x++) {
               picture[x][i] = holder.charAt(x);
            }
         }
		this.toString();
		
	}
	
	
/** toString, creates a string version of the picture
	* @return the string form of the picture
*/
	public String toString(){
         String stringForm = "";
         for (int i=0; i < height; i++) {
            for (int x =0; x < width; x++) {
               stringForm += picture[x][i];
            }
            stringForm += "\n";
         }
			temp = stringForm;
         return stringForm;
      }
		
/** display, displays the last saved picture
*/	
		public void display() throws IOException{
		
			this.toString();
			System.out.println(temp);
		}
		
/** flipHoriz, flips the picture horizontally and prints it
*/

	public void flipHoriz() throws IOException{
		String horizontal = "";
         for (int i=0; i < height; i++) {
            for (int x =width-1; x >= 0; x--) {
               horizontal += picture[x][i];
            }
            horizontal += "\n";
         }
			temp = horizontal;
         System.out.println(horizontal);
			
	}
	
/** flipVert, flips the picture vertically and prints it
*/
	public void flipVert(){
         String vertical = "";
         for (int i=height-1; i >= 0; i--) {
            for (int x =0; x < width; x++) {
               vertical += picture[x][i];
            }
            vertical += "\n";
         }
			
			temp = vertical;
         System.out.println(vertical);
      }
		
/** shiftVal, shifts the characters in the picture by a random value and prints it
*/
	public void shiftVals(){
         String shift = "";
			Random rand = new Random();
			int shiftVal = rand.nextInt(21)-10;
         for (int i=0; i < height; i++) {
            for (int x =0; x < width; x++) {
     				if((int)picture[x][i] != 32) 
						shift += (char)((int)picture[x][i] + shiftVal);
					else
						shift += picture[x][i];
            }
            shift += "\n";
         }
			temp = shift;
         System.out.println(shift);
      }
		
/** save, saves the last transformation
*/
	public void save(){
		int place = 0, counter = 0;
		for (int i = 0; i < height; i++){      
				for (int x = 0; x < width; x++) {
               picture[x][i] = temp.charAt(place);
					if(counter != width-1){
					place++;
					counter++;
					}
					else{
					place=place+2;
					counter = 0;
					}
            }
         }
	}
	
}//end class

/*
No warmup
It took about 4 hours to complete. Saving was the hardest part of the assignment. 
I didn't realize that we weren't supposed to change the original file when we saved
at first so I programmed that.  Then I had to do a little bit of a round about way to 
save the image when I figured out the real save function. I realize creating
a new temporary picture would have been easier.
The best part of the assignment was creating our own real program. I would make it
more clear that we aren't supposed to change the original file.
*/