import java.util.*;
import java.io.*;

public class week9{
	public static void main(String[] args)throws IOException{
		String transFile = "";
		String picFile = "";
		String frameFile = "";
		FrameCollection f = new FrameCollection();
		PictureCollection p = new PictureCollection();
		int numFrames=0;
	
		Scanner input = new Scanner(System.in);
		System.out.print("What is the name of your transaction file? ");
		transFile = input.nextLine();
		System.out.print("What is the name of your picture file? ");
		picFile = input.nextLine();
		System.out.print("What is the name of your frame file? ");
		frameFile = input.nextLine();
		
		Scanner picScan = new Scanner(new FileReader(picFile));
		Picture newPic;
		String multiword;
		String name;
		int width;
		int height;
		
		while(picScan.hasNext()){
			multiword = picScan.nextLine();
			
			int bracket1 = multiword.indexOf('[');
			int comma = multiword.indexOf(',');
			int bracket2 = multiword.indexOf(']');
			name = multiword.substring(0,bracket1-1);
			width = Integer.parseInt(multiword.substring(bracket1+1,comma));
			height = Integer.parseInt(multiword.substring(comma+1,bracket2));
			
			newPic = new Picture(width,height,name);
			p.addPicture(newPic);
		}
		
		Scanner frameScan = new Scanner(new FileReader(frameFile));
		char choice;
		double h;
		double w;
		char c;
		Frame newFrame;
				
		while(frameScan.hasNext()){
			w = frameScan.nextDouble();
			h = frameScan.nextDouble();
			c = frameScan.next().charAt(0);
			newFrame = new Frame(w,h,c);
			f.addFrame(newFrame);
		}
		
		Scanner transScan = new Scanner(new FileReader(transFile));

		while(transScan.hasNext()){
			choice = transScan.next().toUpperCase().charAt(0);
			
			switch(choice){
				case 'F':
					f.displayFrames();
					break;
				case 'A':
					w = transScan.nextDouble();
					h = transScan.nextDouble();
					c = transScan.next().charAt(0);
					newFrame = new Frame(w,h,c);
					f.addFrame(newFrame);
					break;
			}
		}
		
	}
}