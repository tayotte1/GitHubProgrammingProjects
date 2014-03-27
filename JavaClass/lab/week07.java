// Driver program for lab #7
// Picture class tester

public class week07
{
	public static void main(String[] args)
	{
		// create a new picture of width 320, height 120
		Picture p1 = new Picture(320, 120, "Sleeping Cat");
		String s = p1.toString();
		int a = p1.area(); // in pixels
		double p = p1.perimeter(); // in inches
		System.out.println("p1: " + s);
		System.out.println(" area is: " + a + " sq. pixels,  " +
						   "perimeter is: " + p + " inches");

		Picture.setResolution(100);
		System.out.println("after resolution 100: p1 perimeter is " 
						   + p1.perimeter() + " inches");

		// create a new picture of width 80, height 220
		Picture p2 = new Picture("St. Patrick's Castle [80,220]");

		System.out.println("p2: " + p2 + " area " + p2.area() + 
				" sq. pixels, perimeter " + p2.perimeter() + " inches");

		if (p1.isLandscape())
			System.out.println("p1 in landscape orientation");
		if (p1.isPortrait())
			System.out.println("p1 in portrait orientation");
		if (p2.isPortrait())
			System.out.println("p2 in portrait orientation");

		int diff = p1.compareTo(p2);
		if (diff < 0)
			System.out.println("p1 perimeter smaller than p2's");
		else if (diff > 0)
			System.out.println("p1 perimeter larger than p2's");
		else
			System.out.println("p1 perimeter same as p2's");


		p1 = new Picture(120, 120, "Maze");
		System.out.println(p1.isLandscape());
		System.out.println(p1.isPortrait());

	}
}


/*	HERE IS WHAT YOU SHOULD GET WHEN YOU RUN IT, COMPLETED:

p1: Sleeping Cat [320,120]
 area is: 38400 sq. pixels,  perimeter is: 13.75 inches
after resolution 100: p1 perimeter is 8.8 inches
p2: St. Patrick's Castle [80,220] area 17600 sq. pixels, perimeter 6.0 inches
p1 in landscape orientation
p2 in portrait orientation
p1 perimeter larger than p2's
true
true

*/