import java.util.Scanner;
import java.io.*;

public class WordSearch {
	//instance data member
	private char[][] grid;
	private String[] words;
	private int rows;
	private int cols;
	private int numWords;
	
	
	public WordSearch(String fileName)throws IOException{
		Scanner inFile = new Scanner(new FileReader(fileName));
		rows = inFile.nextInt();
		cols = inFile.nextInt();
		inFile.nextLine();	
		String line;	
		grid = new char[rows][cols];
		for(int r = 0; r < rows; r++){
		line = inFile.nextLine().toLowerCase();
			for(int c = 0; c < cols; c++)
				grid[r][c]=line.charAt(c);
		}
		words = new String[2];
		numWords = 0;
		inFile.nextLine();
		while(inFile.hasNextLine()){
			line = inFile.nextLine().toLowerCase();
			addWord(line);
		}
		
	}
	
/**
*/
	public void play(){
		for(int i = 0; i < numWords; i++){
			System.out.println("Searching for " + words[i] + " ...");
			if(!findWord(words[i])){
				System.out.println("Searching for " + reverse(words[i]) + "...");
				findWord(reverse(words[i]));
			}
			display();
		}
	}
	
/**
*/
	public String reverse(String w){
		String s = "";
		for(int i = 0; i< w.length(); i++)
			s = w.charAt(i) + s;
			
		return s;
	}	
	
/**
*/
	public void display(){
		for(int r = 0; r < rows; r++){
			for(int c = 0; c < cols; c++)
				System.out.print(grid[r][c]);
			System.out.println();
		}
	}
	
/**
*/
	public boolean findWord(String w){
		boolean found = false;
		found = searchRows(w);
		if(!found)
			found = searchCols(w);
		if(!found)
			found = searchDiag(w);
		if(!found)
			found = searchRows(w);
		if(!found)
			System.out.println("Can't Find " + w);
		if(found)
			System.out.println("Found " + w);
		
		return found;
	}
	
	
	public boolean searchCols(String w){
		int len = w.length();
		boolean match = true;
		
		for(int r = 0; r <= rows - len; r++){
			for(int c = 0; c < cols; c++){
				match = true;
				for(int i = 0; i < len && match; i++){
					if(w.charAt(i) != Character.toLowerCase(grid[r+i][c]))
						match = false;
					if(match){
						for(i = 0; i < len; i++){
							grid[r+i][c] = Character.toUpperCase(grid[r+i][c]);
							return true;
						}
					}
				}
			}
		}
			
		return false;
	}
	
	public boolean searchDiag(String w){
		return false;
	}
	
	public boolean searchRows(String w){
		return false;
	}
	
/**
*/
	public void addWord(String word){
		if(numWords == words.length){
			String[] temp = new String[words.length*2];
			for(int i = 0; i < words.length; i++)
				temp[i] = words[i];
			words = temp;
		}
		
		words[numWords++] = word;
	}
	
/**
*/
	public static void main(String[] args) throws IOException{
		WordSearch game = new WordSearch("mySearch.txt");
		game.display();
		game.addWord("tablet");
		game.addWord("veg");
		game.play();
	}
}