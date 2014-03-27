import java.util.Scanner;

public class JavaStringSplitExample{
	
	public static void main(String args[]){
	
		int width = 23, height = 11;
		char top[];
		top = new char[width];
		char[] bottom = new char[width];
		char[][] middle = new char[width][height];
		
		for(int x=0; x<width; x++)
			top[x] = '_';
		for(int x=0; x<width; x++)
			bottom[x] = '^';
			
		for(int i=0;i<height;i++){
			for(int x=0; x<width; x++)
				if(x==0 || x==width-1)
					middle[x][i] = '|';
				else
					middle[x][i] = ' ';
			}
			
		for(int x=0; x<height; x+=2)
			middle[2][x] = 'x';
		
			
//print =======================================================		
		System.out.println(top);
		for(int i=0;i<height;i++){
			for(int x=0; x<width; x++)
				System.out.print(middle[x][i]);
			System.out.println("");
		}
		System.out.println(bottom);
		

	
	}//end main
}//end main