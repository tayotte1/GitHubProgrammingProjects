public class TimeMain{
	
	public static void main(String[] args){
		
		Time t1 = new Time("0400");
		Time t2 = new Time("4:00pm");
		Time t3 = new Time("4:00am");
		Time t4 = new Time("12:15am");
		
		System.out.println("times are " + t1 + " " +  t2 + " " + t3 + " " + t4);
	
		if(t1.equals(t3))
			System.out.println("t1 same as t3");
		
		int minutes = t1.elapsed(t2);
		Time t3plus45 = t3.addMinutes(45);
		System.out.println("t4 plus 4 hours is " +  t4.addHours(3));
		t4 = t4.addHours(20);
		System.out.println(minutes + " " + t3plus45 + " " + t4);
		
		if(t2.compareTo(t3) < 0)
			System.out.println("t3 before t2");
		else
			System.out.println("t2 >= t3");
		
		
		Time t1copy = new Time(t1);
		System.out.println("copy = " + t1copy);
		
		System.out.println(t1.addMinutes(2360));
		
		
	}// end main
}// end class