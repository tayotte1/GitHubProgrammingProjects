import java.util.*; 
 
public class PictureCollection {

	private Picture[] pictures;
	private int numPictures;

	public PictureCollection() {
		pictures = new Picture[5];
		numPictures = 0;
	}
	
	public void addPicture(Picture newPicture) {
		if(numPictures == pictures.length){
				Picture[] temp = new Picture[pictures.length*2];
				for(int i = 0; i < pictures.length; i++)
					temp[i] = pictures[i];
				pictures = temp;
			}
			
			pictures[numPictures++] = newPicture;
	}
	
	public void displayPictures() {
		System.out.println("Picture collection:");
		for(int i = 0; i < numPictures; i++){
			System.out.println(pictures[i].toString());
		}
	}
	
	public void deletePicture() {
	
	}

}