import java.util.*; 
import java.io.*; 
 
public class driver9
{ 
	private static Scanner keyboard = new Scanner(System.in); 
	 
	public static void main( String[] args) throws IOException  
	{ 
		PictureCollection picColl = new PictureCollection(); 
		FrameCollection frameColl = new FrameCollection(); 

		Picture pic1;	// for temporary use
		Frame frame1; 	// for temporary use
 
		String filename, line; 
 
		System.out.println("Welcome to the Picture Framing Program!"); 
		System.out.print("Please enter the filename of the picture file: "); 
		filename = keyboard.nextLine(); 
		 
		Scanner input = new Scanner( new FileReader(filename));//read input from pictures file 
		while( input.hasNextLine()) 
		{ 
			line = input.nextLine(); 
			picColl.addPicture(new Picture(line)); 
		}  
		 
		System.out.println(); 
		System.out.print("Please enter the filename of the frame file: "); 
		filename = keyboard.nextLine(); 
		 
		input = new Scanner( new FileReader(filename)); //read input from frames file 
		while( input.hasNextLine()) 
		{ 
			line = input.nextLine(); 
			frameColl.addFrame(new Frame(line));
		} 		 
		 
		System.out.println(); 
		System.out.print("Please enter the filename of the transactions file: "); 
		filename = keyboard.nextLine(); 
		 
		input = new Scanner( new FileReader(filename)); //read input from transactions file 
		while(input.hasNextLine()) 
		{ 
			line = input.nextLine(); 
			StringTokenizer tok = new StringTokenizer(line); 
			char trans = tok.nextToken().charAt(0); 
			switch( trans)  
			{ 
				case 'F': frameColl.printFrames(); 
							 break; 
				case 'P': picColl.bubblePerimeter();
							 break; 
				case 'A': frameColl.addFrame( new Frame( line.substring(2))); 
							 break; 
				case 'D': picColl.deletePic(line.substring(2));
							 break; 
				case 'M': 
				
				int picID = Integer.parseInt(tok.nextToken());
				int frameID = Integer.parseInt(tok.nextToken());
				int picNum = picColl.find(picID);
				
				
				
				
				if(picNum > -1){
							if(frameColl.find(frameID)>-1){
									Frame tempF = frameColl.returnFrame(frameID);
									Picture tempP = picColl.returnPic(picNum);
										if(tempF.isDual()){
											if(tempF.getHeight() > tempP.heightIn() && tempF.getWidth() > tempP.widthIn())
												System.out.println("Picture " + picID + " and Frame " + frameID + " match");
											else if(tempF.getWidth() > tempP.heightIn() && tempF.getHeight() > tempP.widthIn())
												System.out.println("Picture " + picID + " and Frame " + frameID + " match");
											else
												System.out.println("Picture " + picID + " and Frame " + frameID + " don't match");
										}
										
										else{
											if(tempF.getHeight() > tempP.heightIn() && tempF.getWidth() > tempP.widthIn())
												System.out.println("Picture " + picID + " and Frame " + frameID + " match");
											else
												System.out.println("Picture " + picID + " and Frame " + frameID + " don't match");
										}
									}
									
									else
										System.out.println("Frame " + frameID + " doesn't exist");
							}
							else
								System.out.println("Picture " + picID + " doesn't exist");
									
							 break; 
				case 'R':
				
					frameID = Integer.parseInt(tok.nextToken());
					if(frameColl.find(frameID)>-1){
						Frame f = frameColl.returnFrame(frameID);
						Picture p = picColl.returnPic(picColl.lastPic());
						
						int heightResolution = p.getHeight()/(int)f.getHeight();
						int widthResolution = p.getWidth()/(int)f.getWidth();
						
						if (heightResolution > widthResolution)
							System.out.println("The maximum resolution is " + heightResolution);
						else
							System.out.println("The maximum resolution is " + widthResolution);
						}
					else
						System.out.println("Frame " + frameID + " does not exist"); 
				
				
							 break; 
				default:	 System.out.println("Error: Invalid Transaction Code"); 
			} 
		}  
		 
	}	 
} 