import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class MagicEight extends Applet implements KeyListener{

	public String state = "";
	public String q = "";
	public boolean star = true;
	public int rgb = 1;
	Color bg;
	int r = 0;
	int green = 0;
	int b = 0;
	int prer = 0;
	int preg = 0;
	int preb = 0;
	String preState = "";
	Image rango, tho;
	Magic m;

	public void init() {
		setFocusable(true);
		addKeyListener(this);
		rango = getImage(getDocumentBase(),"u.jpg");
		tho = getImage(getDocumentBase(),"thought.png");
		m = new Magic();
		m.createMagic();
	}
	public void start() {
	}
	
	public void paint (Graphics g) {
		if(star) {
			g.setColor(Color.white);
			g.fillRect(2,3,80,35);
			g.setColor(Color.black);
			g.drawString("RGB:",5,15);
			g.drawString(state, 5,28);
		}
		else if(!star) {
			bg = new Color(255-r,255-green,255-b);
			g.setColor(bg);
			g.fillRect(2,3,80,35);
			bg = new Color(r,green,b);
			g.setColor(bg);
			g.drawString("RGB:",5,15);
			g.drawString(state, 5,28);
		
		
		
			bg = new Color(255-r,255-green,255-b);
			g.setColor(bg);
			g.fillRect(10,297,375,41);
			bg = new Color(r,green,b);
			g.setColor(bg);
			Font font = new Font("Arial",Font.PLAIN,15);
			g.setFont(font);
			g.drawString("What Is Your Question?",13,312);
			g.drawString(q, 13,330);
			font = new Font("Arial",Font.PLAIN,12);
			g.setFont(font);
		
			g.drawImage(rango,115,190,135,75,this);
			g.drawImage(tho,150,50,200,170,this);
			if(r == 10) {
				m.printSaying(g);
			}
		}
		
		
	}
	
	public void keyPressed(KeyEvent e) {
		if(!star) {
		int code = e.getKeyCode();
			switch(code){
				case 10:
					r = 10;
					repaint();
					break;
				case 8:
					if(q.length()>0) {
					q = q.substring(0,q.length()-1);
					repaint();
					}
					break;
				case 16:
					break;
				default:
					if(code>=65 && code<=90 || code == 32 || code == 47) {
						if(r == 10) {
							r = 0;
							q = "";
						}
						q = q + "" + e.getKeyChar();
						repaint();
					}
					break;
			}
			
		}
		else {
			if(e.getKeyCode() == 10) {
				if(r>255 || green>255 || b>255 || r<0 || green<0 || b<0) {
					state = preState;
					r = prer;
					green = preg;
					b = preb;
					repaint();
				}
				else {
					rgb++;
					state = state + "  ";
					preState = state;
					prer = r;
					preg = green;
					preb = b;
					if(rgb == 4) {
						star = false;
					}
					bg = new Color(r,green,b);
					setBackground(bg);
				}
			}
			else {
				switch(rgb){
					case 1:
					state = state + "" + e.getKeyChar();
					r = r*10 + e.getKeyChar()-48;
					break;
					case 2:
					state = state + "" + e.getKeyChar();
					green = green*10 + e.getKeyChar()-48;
					break;
					case 3:
					state = state + "" + e.getKeyChar();
					b = b*10 + e.getKeyChar()-48;
					break;
				}
				repaint();
			}
		}
	}
	
	public void keyReleased(KeyEvent e) {
	
	
	}
	public void keyTyped(KeyEvent e) {
	
	}

}