import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class game extends Applet implements MouseListener, KeyListener{
	boolean click = false;
	Timer timer = new Timer();
	Mario player = new Mario(5,5);
	TimerTask task = new MyTimerTask();
	boolean start = true;
	Random rand = new Random();
	boolean up=false,down=false,left=false,right=false;
	boolean playing = true;
	int score = 10000;
	int coinCount;
	int coinCount2;
	int playCount = 0;
	int marioSpeed = 8;
	int level = 1;
	int inst = 0;
	int enemyCount;
	
	Enemy[] enStore = new Enemy[100];
	Coin[] coinStore = new Coin[100];
	
	
	public void init(){
		setSize(850, 850);
      addMouseListener( this );
		addKeyListener( this );
		timer.scheduleAtFixedRate(task, 0, 70);
		enemyCount = 2;
		
		for(int i=0; i<enemyCount; i++){
			enStore[i] = new Enemy(rand.nextInt(620)+100,rand.nextInt(620)+100);
		}
		
		coinCount = 3;
		coinCount2 = 3;
		for(int i=0; i<coinCount; i++){
			coinStore[i] = new Coin(rand.nextInt(620)+100,rand.nextInt(620)+100);
		}
	}
	
	public void start(){
		if(level%2==0){
			for(int i=enemyCount-1; i<enemyCount; i++){
				enStore[i] = new Enemy(rand.nextInt(620)+100,rand.nextInt(620)+100);
			}
		}

		for(int i=0; i<enemyCount; i++){
			enStore[i].resetX(rand.nextInt(620)+100);
			enStore[i].resetY(rand.nextInt(620)+100);
		}

		if(level%4==0){
			for(int i=coinCount-1; i<coinCount; i++){
				coinStore[i] = new Coin(rand.nextInt(620)+100,rand.nextInt(620)+100);
			}
		}

		for(int i=0; i<coinCount; i++){
			coinStore[i].resetX(rand.nextInt(620)+100);
			coinStore[i].resetY(rand.nextInt(620)+100);
		}
		
		for(int i=0; i<coinCount; i++){
			coinStore[i].moveRect();
		}
		
		start = true;
	}
	
	public void paint(Graphics g){
		Image pic = getImage(getCodeBase(),"mario.jpg");
		Image enPic = getImage(getCodeBase(),"Goldfish.png");
		Image noodlesPic = getImage(getCodeBase(),"noodles.gif");
		
		if(inst==0){
			setBackground(Color.black);
			g.setColor(Color.yellow);
			g.drawString("*******************************************",310,250);
			g.drawString("       Welcome to this amazing game!",310,260);
			g.drawString("                      INSTRUCTIONS:",310,274);
			g.drawString("   Collect as many noodles as possible!",310,288);
			g.drawString("               Use j,k,l,i to move Mario",310,302);
			g.drawString("             Avoid the fishys at all cost!",310,316);
			g.drawString("      Your score prints in the I/O screen",310,330);
			g.drawString("           Go until you run out of points",310,344);
			g.drawString("              Click anywhere to begin.",310,358);
			g.drawString("*******************************************",310,373);
		}
		
		else if(!start){
			setBackground(Color.black);
			g.drawImage(pic, player.posX, player.posY, this);

			for(int i=0; i<coinCount; i++){
				g.drawImage(noodlesPic, coinStore[i].posX, coinStore[i].posY, this);
			}

			for(int i=0; i<enemyCount; i++){
				g.drawImage(enPic, enStore[i].posX, enStore[i].posY, this);
			}
			
			g.setColor(Color.yellow);
			g.drawRect(0, 0, 800, 800);
		}
		
		else{
			setBackground(Color.black);
			g.setColor(Color.yellow);
 			g.drawString("Click anywhere to play level " + level, 320, 250);
		}
	}
	
	private class MyTimerTask extends TimerTask {
   	public void run(){
			if(!start){
				if(right){
					player.setX(marioSpeed);
					repaint();
				}
				if(left){
					player.setX(-marioSpeed);
					repaint();
				}
				if(down){
					player.setY(marioSpeed);
					repaint();
				}
				if(up){
					player.setY(-marioSpeed);
					repaint();
				}

				for(int i=0; i<enemyCount; i++){
					enStore[i].move();
				}

				for(int i=0; i<enemyCount; i++){
					enStore[i].rect.move(enStore[i].posX,enStore[i].posY);
				}
				
				
				if((player.rect.getX()<=0 || player.rect.getX()>=760)){
					score-=10;
					System.out.println("Get Back In the Arena! You're Losing Points!");
				}
				if((player.rect.getY()<=0||player.rect.getY()>=760)){
					score-=10;
					System.out.println("Get Back In the Arena! You're Losing Points!");
				}
				
				player.rect.move(player.posX,player.posY);

				for(int i=0; i<enemyCount; i++){
					if(player.rect.intersects(enStore[i].rect)){
						score -= 1000;
						System.out.println("You died...by fishy");
						start = true;
						player.resetX(5);
						player.resetY(5);
					}
				}

				for(int i=0; i<coinCount; i++){
					if(player.rect.intersects(coinStore[i].rect)){
						coinStore[i].dissapear();
						score += 1000;
						coinCount2--;
					}
				}
				
				
				if(coinCount2<1){
					start = true;
					
					for(int i=0; i<enemyCount; i++){
						enStore[i].speedInc();
					}
					
					if(level%2==0)
						enemyCount++;
						
					if(level%4==0)
						coinCount++;
					
					coinCount2=coinCount;
					
					
					start();
					playCount++;
					level++;

					System.out.println("Congratualtions you have beaten the fishys " + playCount + " times!");
					System.out.println("See how many times you can!");
					if(level%2==0)
						System.out.println("New Enemy Added");
					if(level%4==0)
						System.out.println("New Noodles Added.");
					
				}
				
				if(score<1){
					System.out.println("You ran out of points...therefore you lose.");
					System.out.println("You got through this stupid game " + playCount + " times.");
					System.out.println("You must restart the game cause I'm stupid and don't know how to program.");
					start = true;
					score = 0;
					start();
					timer.cancel();
				}
				
				repaint();
				System.out.println("Your Current Score: " + score);
				score -= 25;
			}
	 	}
	}
	
	public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseClicked(MouseEvent e){
		if(inst<1)
			inst++;
		else
			start = false;
		repaint();
	}
	
	public void keyPressed (KeyEvent event)
	{
		char key = event.getKeyChar();
		if (key == 'j')
		{
			left = true;
		}
		else if (key == 'i')
		{
			up = true;
		}
		else if (key == 'l')
		{
			right = true;
		}
		else if (key == 'k')
		{
			down = true;
		}
	}
	public void keyTyped(KeyEvent event){
	}
	public void keyReleased (KeyEvent event){
		char key = event.getKeyChar();
		if (key == 'j')
		{
			left = false;
		}
		else if (key == 'i')
		{
			up = false;
		}
		else if (key == 'l')
		{
			right = false;
		}
		else if (key == 'k')
		{
			down = false;
		}
		else{
			System.out.println("Please use j,k,l,i buttons to move");
			System.out.println("j == 'left'\nk == 'down'\nl == 'right'\ni == 'up'");
		}
	}
	
	

}