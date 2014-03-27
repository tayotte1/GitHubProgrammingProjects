import java.util.*; 
 
public class Frame 
{ 
    private double width, height; 
    private char mode;
    private int id; 
 
    private static int IDcounter = 1; 
 
    /**Create a frame object 
       @param w the width, in inches 
       @param h the height, in inches 
       @param m the mode of the frame 
    */ 
    public Frame(double w, double h, char m) 
    { 
	width = w; 
	height = h; 
	m = Character.toUpperCase(m); 
	if (m == 'D')
	    mode = m;
	else
	    mode = 'S';
	id = IDcounter; 
	IDcounter++; 
    } 
 
    /**Create a frame object 
       @param s contains the width, height, and mode in this format 
       width height mode 
    */ 
    public Frame(String s) 
    { 
	StringTokenizer tok = new StringTokenizer(s, " "); 
	width = Double.parseDouble(tok.nextToken()); 
	height = Double.parseDouble(tok.nextToken()); 
	mode = tok.nextToken().charAt(0);  
	id = IDcounter; 
	IDcounter++; 
    } 
 
    /**Make a string containing all the frame data 
       @return the string 
    */ 
    public String toString() 
    { 
	return "ID: " + id + " [" + width + "," + height + "] " + mode; 
    } 
 
    /**Determine if the frame is in dual mode 
       @return true if so, false otherwise 
    */ 
    public boolean isDual() 
    { 
	return mode == 'D'; 
    } 
 
    /**Returns ID of the frame 
       @return ID of the frame 
    */ 
    public int getID() 
    { 
	return id; 
    } 
     
    /**Returns width of the frame 
       @return width of the frame 
    */ 
    public double getWidth() 
    { 
	return width; 
    } 
     
    /**Returns height of the frame 
       @return height of the frame 
    */ 
    public double getHeight() 
    { 
	return height; 
    } 
}