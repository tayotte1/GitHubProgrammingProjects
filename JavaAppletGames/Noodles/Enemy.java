import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Enemy extends Applet{

	int width;
	int height;
	int posX;
	int posY;
	Rectangle rect;
	Random rand = new Random();
	int speedX, speedY;
	int lastX = 100, lastY = 100;
	int multX = 1, multY = 1;
	
	public Enemy(int x, int y){
		width = 49;
		height = 48;
		posX = x;
		posY = y;
		rect = new Rectangle(posX, posY, width, height);
		if(rand.nextBoolean())
			multX = -1;
		if(rand.nextBoolean())
			multY = -1;
		speedX = multX*(rand.nextInt(3) + 10);
		speedY = multY*(rand.nextInt(3) + 10);
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
	
	public void move(){
		this.setX(speedX);
		this.setY(speedY);
		if((rect.getX()<=5 || rect.getX()>=751)&&(lastX<500)){
			speedX = -1*speedX;
			lastX = 508;
		}
		if((rect.getY()<=3||rect.getY()>=754)&&(lastY<500)){
			speedY = -1*speedY;
			lastY = 508;
		}
		lastX--;
		lastY--;
	}
	public void speedInc(){
		if(speedX>0)
		speedX += 1;
		if(speedX<0)
		speedX -= 1;
		if(speedY>0)
		speedY += 1;
		if(speedY<0)
		speedY -= 1;
	}
}