/*
Tom Ayotte
600.107
February 15, 2012
1a
781-771-7151
tayotte1
tayotte1@jhu.edu
*/

//start class
public class pg1a{

	//start main
	public static void main(String[] args){ 
	
	//declare variables
	String top = "**********************\n<                    >";
	String bottom = "<                    >\n**********************";
	
	System.out.print(top + "\n"  + "<        Tom         >" + "\n" + bottom + "\n");

	System.out.print(top + "\n" + "<  tayotte1@jhu.edu  >" + "\n" + bottom + "\n");
	
	
int[] a = {3,4,17,5,6};
	
	}//end main
	
	public static int[] merge(int[] x){
		if(x.length == 2){
			if(x[0]>x[1])
				{
				int[] temp = x[1];
				x[1] = x[0];
				x[0] = temp[0];				
				}
			return x;
		}
		
		
		return merge(x[0,(x.length/2)-1] + x[(x.length/2)-1]);
		
	}
}//end class

/*
There was no warm up excersize to this.

This program was not as easy as I had expected it to be. It took me a couple of tries to
get the code very efficient. I had a lot of variables at first, then I had a very long
print statement, finally I got it to what it is now.

I didn't really learn anything that I didn't already know.

It took about 20 minutes to write.

The best part of this assignment was that it was really simple. It was good to practice
writing the public, class static, void, etc.

I would not redesign this assignment.
*/