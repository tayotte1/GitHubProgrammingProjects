import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Coin extends Applet{

	int width;
	int height;
	int posX;
	int posY;
	Rectangle rect;

	public Coin(int x, int y){
		width = 40;
		height = 40;
		posX = x;
		posY = y;
		rect = new Rectangle(posX, posY, width, height);
	}
	
	public void dissapear(){
		posX = 1000000;
		posY = 1000000;
		rect.move(1000000,10000000);
	}
	public void resetX(int x){
		posX = x;
	}
	public void resetY(int y){
		posY = y;
	}
	public void moveRect(){
		rect.move(posX,posY);
	}
}