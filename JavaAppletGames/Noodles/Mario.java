import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Mario extends Applet{

	int width;
	int height;
	int posX;
	int posY;
	Rectangle rect;

	public Mario(int x, int y){
		width = 40;
		height = 40;
		posX = x;
		posY = y;
		rect = new Rectangle(posX, posY, width, height);
	}
	
	public void setX(int x){
		posX += x;
	}
	public void setY(int y){
		posY += y;
	}
	public void resetX(int x){
		posX = x;
	}
	public void resetY(int y){
		posY = y;
	}
}