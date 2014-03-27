import java.util.*;

public class Matrix {

	// data members
	private int rows;
	private int cols;
	private double[][] table;
	
	public Matrix(int r, int c) {
		rows = r;
		cols = c;
		table = new double[rows][cols];  // make the memory for the table
	}
	
	public void randomFill() {
		Random rand = new Random();
		for (int r=0; r < rows; r++)
			for (int c=0; c < cols; c++)
				table[r][c] = rand.nextInt(1000)/100;
	}
	
	public boolean equals(Matrix m) {
		if (this.rows != m.rows || this.cols != m.cols)
			return false;  // size mis-match
			
		for (int r=0; r < rows; r++)
			for (int c=0; c < cols; c++)
				if (table[r][c] != m.table[r][c])
					return false;
		return true;
	}
	
	public String toString() {
		String t = "";
		for (int r=0; r < rows; r++)
		{	for (int c=0; c < cols; c++)
				t += table[r][c] + " ";
			t += "\n";
		}
		return t;
	}
	
	public Matrix transpose(){
		Matrix trans = new Matrix(cols,rows);
		for(int r = 0; r<rows; r++)
			for(int c=0;c<cols;c++)
				trans.table[c][r] = table[r][c];
				
		return trans;
	}
	
	public static void main(String[] args) {
		Matrix m1 = new Matrix(3, 5);
		Matrix m2 = new Matrix(10, 8);
		m2.randomFill();
		System.out.println("M1 is \n" + m1);  // calls toString
		System.out.println("M2 is \n" + m2);
		if (m1.equals(m2))
			System.out.println("m1 equals m2");
		if (m2.equals(m1))
			System.out.println("m2 equals m1");
		m1.randomFill();
		System.out.println(m1);
		Matrix m3 = m1.transpose();
		System.out.println("M1 transpose is \n" + m3);
	}
}