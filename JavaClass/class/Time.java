import java.text.DecimalFormat;

/** Class to manipulate a time of day
*/

public class Time{

	//instance data members
	private int hour;
	private int mins;

	//class variable
	private static DecimalFormat two0s = new DecimalFormat("00");

	//constructor
	public Time(String time){
		if(time.indexOf(':')<0)
			setMilitary(time);
		else
			setVerbose(time);
	}
	
	public void setMilitary(String mil){
		int time = Integer.parseInt(mil);
		hour = time/100;
		mins = time%100;
	}
	
	public void setVerbose(String time){
		int colon = time.indexOf(':');
		hour = Integer.parseInt(time.substring(0,colon));
		mins = Integer.parseInt(time.substring(colon+1, colon+3));
		time = time.toLowerCase();
		if(time.indexOf('a') < 0){
			if(hour != 12)
				hour = hour + 12;
		}
		
		else if(hour == 12)
				hour = 0;		
	}
	
	public String toString(){	
		return two0s.format(hour) + ":" + two0s.format(mins);
	}
	
	public int elapsed(Time other){
		int diff;
		
		if(this.compareTo(other) >= 0)
			diff = this.minsSinceMidnight() - other.minsSinceMidnight();
		else
			diff = other.minsSinceMidnight() - this.minsSinceMidnight();
		
		return diff;
	}
	
	public Time addHours(int hrs){
		Time t = new Time(this);
		t.hour = (t.hour + hrs)%24;
		return t;
	}
	
	public Time addMinutes(int mins){
		Time t = new Time(this);
		t.mins += mins;
		t.hour += t.mins/60;
		t.mins = t.mins%60;
		t.hour %= 24;
		return t;
	}
	
	public int compareTo(Time other){		
		return this.minsSinceMidnight() - other.minsSinceMidnight();
	}
	
	public boolean equals(Time other){
		return hour == other.hour && mins == other.mins;
	}
	
	private int minsSinceMidnight(){
		return hour*60 + mins;
	}
	
	public Time(Time other){
		hour = other.hour;
		mins = other.mins;
	}
}