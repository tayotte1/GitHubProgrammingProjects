import java.util.*; 
 
public class FrameCollection 
{ 
	private int num; 
	private Frame[] frames; 
 
/**	Create a frameCollection object 
*/ 
	public FrameCollection() 
	{ 
		frames = new Frame[10]; 
		num = 0; 
	} 
 
/**	Add a frame object to the collection 
	@param f frame to be added to the collection 
*/ 
	public void addFrame(Frame f) 
	{ 
		if( num == frames.length)  
			resize(); 
			 
		frames[num] = f; 
		num++; 
	} 
 
/**	Double the size of the collection 
*/ 
	private void resize() 
	{ 
		Frame[] temp = new Frame[2*frames.length]; 
		for( int i = 0; i < frames.length; i++) 
			temp[i] = frames[i]; 
		frames = temp; 
	} 
 
/**	Print the collection of frames  
*/ 
	public void printFrames() 
	{ 
		for( int i = 0; i < frames.length; i++)  
			if( frames[i] != null) 
				System.out.println( frames[i]); 
	} 
	
	
	public int find(int ID){
		for(int i=0;i<num;i++){
			if(frames[i].getID()== ID){
				return i;
			}
		}
			return -1;
	}
	
	public Frame returnFrame(int ID){
		if(this.find(ID)>-1)
			return frames[this.find(ID)];
		return null;
	}
} 