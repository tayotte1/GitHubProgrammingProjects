import java.util.*;
import java.io.*;

public class SudokuMain{

	public static void main(String[] args) throws IOException{
		Scanner keys = new Scanner(System.in);
		String filename;
		
		System.out.println("Please enter the filename");
		filename = keys.nextLine();
		Sudoku puzzle = new Sudoku(filename);
		System.out.print(puzzle.toString());
		puzzle.validate();
	}
}