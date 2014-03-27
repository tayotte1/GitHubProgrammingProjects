import java.util.Random;
import java.applet.*;
import java.awt.*;

public class Magic {

	public String[] thoughts;
	public Random randy;
	
	int stringLen;
	int ss;
	
	public void Magic() {
	}
	
	public void createMagic() {
		thoughts = new String[30];
		thoughts[0] = "Sexy";
		thoughts[1] = "Not A Chance";
		thoughts[2] = "Cloud The Future";
		thoughts[22] = "The Dark Side Does";
		thoughts[3] = "Go Home";
		thoughts[23] = "You're Drunk";
		thoughts[4] = "Find The";
		thoughts[24] = "Golden Ticket";
		thoughts[5] = "Yessir";
		thoughts[6] = "Dance";
		thoughts[7] = "Run Away";
		thoughts[8] = "Yup";
		thoughts[9] = "I Won't Say No";
		thoughts[10] = "You're Adorable";
		thoughts[11] = "Aww Hell Naw";
		thoughts[12] = "I Do Believe So";
		thoughts[13] = "Indubitaly";
		thoughts[14] = "Try Again";
	}
	
	public void printSaying(Graphics g) {
		randy = new Random();
		int r = randy.nextInt(14);
		System.out.println(r);
		g.setColor(Color.black);
		Font font = new Font("Arial",Font.PLAIN,18);
		stringLen = (int)g.getFontMetrics().getStringBounds(thoughts[r],g).getWidth();
		ss = 176/2 - stringLen/2;
		g.setFont(font);
		
		if(r == 2 || r == 3 || r == 4) {
			g.drawString(thoughts[r],ss+144,120);
			stringLen = (int)g.getFontMetrics().getStringBounds(thoughts[20+r],g).getWidth();
			ss = 170/2 - stringLen/2;
			g.drawString(thoughts[20+r],ss+155,140);
		}
		else {
			g.drawString(thoughts[r],ss+145,130);
		}
		font = new Font("Arial",Font.PLAIN,12);
		g.setFont(font);
	}

}