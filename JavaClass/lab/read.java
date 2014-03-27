import java.util.Scanner;
import java.io.*;
import java.util.Random;

public class read{

	public static void main(String[] args) throws IOException{
	
		String fileName = "";
		Scanner kb = new Scanner(System.in);
		String shape = "";
		char c;
		int size = 0, width = 0, height = 0;

		
		System.out.print("Enter a file name: ");
		fileName = kb.nextLine();
		
		Scanner inFile = new Scanner(new FileReader(fileName));
		
		do {
			shape = inFile.next();
			
			c = inFile.next().charAt(0);
			if(shape.equals("rectangle")){
				height = inFile.nextInt();
				width = inFile.nextInt();
				rectangle(c, height, width);
			}
			else if (shape.equals("triangle")){
				size = inFile.nextInt();			
				triangle(c, size);
			}
			else if (shape.equals("diamond")){
				size = inFile.nextInt();
				diamond(c, size);
			}
			
			System.out.println();
		}while (inFile.hasNextLine());
	}
	
	/** 	Draw a rectangle using the character c of the specified width and height
*/
	public static void rectangle(char c, int height, int width){

	// put statements here to display a rectangle on the screen using
	// character c and the width and height parameters
	
		for (int x = 0; x < height; x++){
			for (int i = 0; i < width; i++){
				System.out.print(c);
			}
			System.out.println();
		}
	}


/**	Draw a (right) triangle using the character c of the specified size
*/
	public static void triangle(char c, int size){

	// put statements here to display a triangle on the screen using
	// character c and the size parameter
		for (int x = 0; x < size; x++){
			for (int i = 0; i <= x; i++){
				System.out.print(c);
			}
			System.out.println();
		}
	}


/**	Draw a diamond using the character c of the specified size
*/
	public static void diamond(char c, int size){

	// put statements here to display a triangle on the screen using
	// character c and the size parameter
		int spaces = 0;
	
		for (int x = 1; x <= ((size+1)/2); x++){
			
			spaces = ((size + 1)/2 - x);
			for (int y = 0; y < spaces; y++){
				System.out.print(" ");
			}
		
			for (int i = 1; i <= 2*x-1; i++){
				System.out.print(c);
			}
			System.out.println();
		}
		
		
//----------------------------------------------		
		for (int x = (((size+1)/2)-1); x > 0; x--){
			
			spaces = ((size + 1)/2 - x);
			for (int y = 0; y < spaces; y++){
				System.out.print(" ");
			}
			
			for (int i = 0; i < 2*x-1; i++){
				System.out.print(c);
			}
			System.out.println();
		}	
		
	}


}