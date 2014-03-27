import java.util.Scanner;
import java.io.*;
import java.util.Random;

public class shapes{

	public static void main(String[] args)throws IOException{
	
		Random rand = new Random();
		int numberShapes = 0;
		int shape = 0;
		String shapeType = "";
		char symbol = ' ';
		int num, number, number2;
		
		PrintWriter outFile = new PrintWriter(new FileWriter("shapeData"));
		numberShapes = rand.nextInt(11)+5;
		
		for(int x = 1; x <= numberShapes; x++){
			shape = rand.nextInt(3);
			number2 = 0;
			
			if(shape == 0){
				shapeType = "rectangle";
				number = rand.nextInt(39) + 2;
				number2 = rand.nextInt(39) + 2;
			}
			else if(shape ==1){
				shapeType = "triangle";
				number = rand.nextInt(10) + 1;
			}
			else{
				shapeType = "diamond";
				number = rand.nextInt(17) + 3;
				if (number%2 == 0)
					number--;
			}
				
			num = rand.nextInt(8);
			switch (num){
				case 0:
					symbol = '*';
					break;
				case 1:
					symbol = '+';
					break;
				case 2:
					symbol = '-';
					break;
				case 3:
					symbol = '=';
					break;
				case 4:
					symbol = '%';
					break;
				case 5:
					symbol = '^';
					break;
				case 6:
					symbol = '#';
					break;
				case 7:
					symbol = '@';
					break;
			}
			//System.out.println(num);
			
			if(x == numberShapes){
				if (number2 == 0)
					outFile.print(shapeType + " " + symbol + " " + number);
				else
					outFile.print(shapeType + " " + symbol + " " + number + " " + number2);
			}
			
			else{
				if (number2 == 0)
					outFile.println(shapeType + " " + symbol + " " + number);
				else
					outFile.println(shapeType + " " + symbol + " " + number + " " + number2);
			}
			
		}
		
		outFile.close();
	}
}