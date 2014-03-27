import java.util.*;

public class Picture
{
	private int width, height;
	private String subject;
	private int id;

	private static int resolution = 64;  // pixels per inch
	private static int IDcounter = 1;

/**	Create a picture object
	@param w the width, in pixels
	@param h the height, in pixels
	@param s the subject (description) of the picture
*/
	public Picture(int w, int h, String s)
	{
		width = w;
		height = h;
		subject = s;
		
		id = IDcounter; 
		IDcounter++; 
	}

/**	Create a picture object
	@param s contains the subject, width, height in this format
		Subject Matter [width,height]
*/
	public Picture(String s)
	{
		StringTokenizer tok = new StringTokenizer(s, " [,]");
		subject = tok.nextToken();
		while (tok.countTokens() > 2)
			subject += " " + tok.nextToken();
		width = Integer.parseInt(tok.nextToken());
		height = Integer.parseInt(tok.nextToken());
		
		id = IDcounter; 
		IDcounter++;
	}

/**	Set the pixels/inch for the class
	@param r the new value
*/
	public static void setResolution(int r)
	{
		resolution = r;
	}

/**	Get the area of the picture, in pixels
	@return the area
*/
	public int area()
	{
		return width * height;
	}

/** 	Get the perimeter of the picture, in inches based on the current
		resolution
	@return the perimeter
*/
	public double perimeter()
	{
		return 2*(width + height)/ (double) resolution;
	}

/**	Make a string containing all the picture data
	@return the string
*/
	public String toString()
	{
		return "ID: " + id + " " + subject + " [" + width + "," + height + "]";
	}

/**	Determine if the picture is in landscape mode
	@return true if so, false otherwise
*/
	public boolean isLandscape()
	{
		return width >= height;
	}

/**	Determine if the picture is in portrait mode
	@return true if so, false otherwise
*/
	public boolean isPortrait()
	{
		return height >= width;
	}

/**	Compare pictures based on their perimeters
	@param other the picture to compare this to
	@return negative if this < other, 0 if =, positive if this > other
*/
	public int compareTo(Picture other)
	{
		double d = perimeter() - other.perimeter();
		if (d < 0) return -1;
		else if (d > 0) return 1;
		else return 0;
	}
	
/** returns the picture's subject
*/
	public String subject(){
		return subject;
	}
	
	public int id(){
		return id;
	}
	
	public int widthIn(){
		int widthIn = width/resolution;
		return widthIn;
	}
	
	public int heightIn(){
		int heightIn = height/resolution;
		return heightIn;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	

}