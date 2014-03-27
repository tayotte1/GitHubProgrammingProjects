public class Picture {

	public int width, height;
	public String name;
	
	public static int resolution = 64;

/** Set the width, height, and name of a picture
		 @param w the width of a picture in pixels
		 @param h the height of a picture in pixels
		 @param n the picture name
	*/
	public Picture(int w, int h, String n) {
		width = w;
		height = h;
		name = n;
	}
	
/** Set the width, height, and name of a picture
		 @param multiword a String with the name, width, and height of the picture
	*/
	public Picture(String multiword) {
		int bracket1 = multiword.indexOf('[');
		int comma = multiword.indexOf(',');
		int bracket2 = multiword.indexOf(']');
		name = multiword.substring(0,bracket1-1);
		width = Integer.parseInt(multiword.substring(bracket1+1,comma));
		height = Integer.parseInt(multiword.substring(comma+1,bracket2));
	}
	
/** converts the three primary parameters into one string
	@return String in format "name [width,height]"
*/
	public String toString() {
		return name + " [" + width + "," + height + "]";
	}


/** Gets the area of a picture, in square pixels
	@return area the area in square pixels
*/
	public int area() {
		return width*height;
	}
	
/** Determines if the picture is in Landscape mode
	@return true if width >= height, false otherwise
*/
	public boolean isLandscape() {
		if (width >= height)
			return true;
		return false;
	}
	
/** Determines if the picture is in Portrait mode
	@return true if width <= height, false otherwise
*/
	public boolean isPortrait() {
		if (width <= height)
			return true;
		return false;
	}
	
/** Finds the perimeter of a picture in inches
	@return double with the perimeter of the picture in inches
*/
	public double perimeter() {
		return (2.0/resolution)*(width+height);
	}
	
/** Determines which perimeter of two pictures is larger
	@return integer the difference in perimeter of the two pictures
*/
	public int compareTo(Picture other) {
		return (int) this.perimeter() - (int) other.perimeter();
	}
	
/** Changes the resolution to a new resolution, in pixels per inch
	@param newvalue The new resolution in pixels per inch
*/
	public static void setResolution(int newvalue) {
		resolution = newvalue;
	}
	
}