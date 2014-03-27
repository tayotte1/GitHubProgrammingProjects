import java.util.*; 
 
public class PictureCollection 
{ 
	private int num; 
	private Picture[] pics; 
 
/**	Create a pictureCollection object 
*/ 
	public PictureCollection() 
	{ 
		pics = new Picture[10]; 
		num = 0; 
	} 
 
/**	Add a picture object to the collection 
	@param p picture to be added to the collection 
*/ 
	public void addPicture(Picture p) 
	{ 
		if( num == pics.length)  
			resize(); 
			 
		pics[num] = p; 
		num++; 
	} 
 
/**	Double the size of the collection 
*/ 
	private void resize() 
	{ 
		Picture[] temp = new Picture[2*pics.length]; 
		for( int i = 0; i < pics.length; i++) 
			temp[i] = pics[i]; 
		pics = temp; 
	} 
	
/** Delete a picture from the collection
	@param picture name
*/
	public void deletePic(String name){
		int x = 0;
		for(int i=0; i<num; i++){
			if(name.equalsIgnoreCase(pics[i].subject())){
				pics[i] = pics[num-1];
				num--;
				pics[num] = null;
				x = 1;
				System.out.println("Deleted picture " + name);
			}
		}
		if(x==0)
			System.out.println(name + " doesn't exist in collection");
	}
	
	public void bubblePerimeter() {
		Picture temp;
		for (int last = num-1; last > 0; last--)
			for (int curr = 0; curr < last; curr++)
				if (pics[curr].perimeter() > pics[curr+1].perimeter()) { // out of order
					temp = pics[curr];
					pics[curr] = pics[curr+1];
					pics[curr+1] = temp;
				}
		this.printPics();
	}
 
	/**	Print the collection of pictures  
	*/ 
	public void printPics() 
	{ 
		for( int i = 0; i < pics.length; i++)  
			if(pics[i] != null) 
				System.out.println(pics[i]); 
	}
	
	public int find(int ID){

		for(int i=0;i<num;i++){
			if(pics[i].id()== ID){
				return i;
			}
		}
			return -1;
	}
	
	public int lastPic(){
		return num-1;
	}
	
	public Picture returnPic(int index){
			return pics[index];
	}
} 