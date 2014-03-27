   import java.util.*;
   import java.io.*;

   public class Sudoku{
   
      private int[][] answer = new int[9][9];
   
   
      public Sudoku(String fileName) throws IOException {
         Scanner inFile = new Scanner(new FileReader(fileName));
         for (int i = 0; i < 9; i++){
            for (int x = 0; x < 9; x++) {
               answer[i][x] = inFile.nextInt();
            }
         }
      }
   
      public void checkRow(){
         int[] row = new int[9];
         String invalid = "Invalid Rows are:";
      
         for(int i = 0; i < 9; i++){
            for(int x = 0; x < 9; x++)
               row[x] = answer[i][x];
         	
            if(!Sudoku.check9(row))
               invalid = invalid + " " + (i+1);
         
         }
			
			if(invalid.equals("Invalid Rows are:"))
				System.out.println("Valid Rows");
			else
         	System.out.println(invalid);
      }
   
      public void checkColumn(){
         int[] column = new int[9];
         String invalid = "Invalid Columns are:";
      
         for(int i = 0; i < 9; i++){
            for(int x = 0; x < 9; x++)
               column[x] = answer[x][i];
         	
            if(!Sudoku.check9(column))
               invalid = invalid + " " + (i+1);
         
         }
			if(invalid.equals("Invalid Columns are:"))
				System.out.println("Valid Columns");
			else
         	System.out.println(invalid);
      
      }
   
      public void checkBox(){
         int[] box = new int[9];
         String invalid = "Invalid Boxes are:";
   		int x = 0; 
			int counter = 1;  	
			
         for(int row = 0; row < 7; row = row+3){
            for(int column = 0; column < 7; column = column+3){
               for(int i = row; i < row + 3; i++){
						for(int q = column; q < column + 3; q++){
	                     box[x] = answer[i][q];
               			x++;
						}
					}
						x = 0;
                  if(!Sudoku.check9(box))
                     invalid = invalid + " " + (counter); 
						counter++;              
            }
         }
			
			if(invalid.equals("Invalid Boxes are:"))
				System.out.println("Valid Boxes");
			else
         	System.out.println(invalid);
      
      }
   
      public static boolean check9(int[] data){
         int number = 0;
         int c1 = 0,c2 = 0,c3 = 0,c4 = 0,c5 = 0,c6 = 0,c7 = 0,c8 = 0,c9 = 0;
      
         for(int x = 0; x < 9; x++){
            number = data[x];
            switch(number){
               case 1: c1++; 
                  break;
               case 2: c2++; 
                  break;
               case 3: c3++; 
                  break;
               case 4: c4++; 
                  break;
               case 5: c5++; 
                  break;
               case 6: c6++; 
                  break;
               case 7: c7++; 
                  break;
               case 8: c8++; 
                  break;
               case 9: c9++; 
                  break;
            }
         }	
         if(c1 != 1 || c2 != 1 || c3 != 1 || c4 != 1 || c5 != 1 || c6 != 1 || c7 != 1 || c8 != 1 || c9 != 1)
            return false;
         else
            return true;
      }
   
      public String toString(){
         String t = "";
         for (int r =0; r < 9; r++) {
            for (int c=0; c < 9; c++) {
               t += answer[r][c] + " ";
            }
            t += "\n";
         }
         return t;
      }
		
		public void validate(){
			this.checkRow();
			this.checkColumn();
			this.checkBox();
		}
   }