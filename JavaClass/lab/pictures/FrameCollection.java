import java.util.*; 
 
public class FrameCollection {

	private Frame[] frames;
	private int numFrames;

	public FrameCollection() {
		frames = new Frame[5];
		numFrames = 0;
	}
	
	public void addFrame(Frame newFrame) {
		if(numFrames == frames.length){
				Frame[] temp = new Frame[frames.length*2];
				for(int i = 0; i < frames.length; i++)
					temp[i] = frames[i];
				frames = temp;
			}
			
			frames[numFrames++] = newFrame;
	}
	
	public void displayFrames() {
		System.out.println("Frame collection:");
		for(int i = 0; i < numFrames; i++){
			System.out.println(frames[i].toString());
		}
	}
	
	public void deleteFrame() {
	
	}

}