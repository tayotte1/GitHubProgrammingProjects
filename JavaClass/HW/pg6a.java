/** Tester program for the WirelessAccount class, assignment 6.
	@author Joanne Selinski
	@date 3/13/2012
*/

public class pg6a {

	public static void main(String[] args) {
		
		WirelessAccount joe = new WirelessAccount("Joe Smith", 443, 2302980);
		WirelessAccount may = new WirelessAccount("May Jones", "(310)243-0293");
		WirelessAccount copy = new WirelessAccount("Copy Cat", "(443)230-2980");

		String jstring = joe.toString();
		System.out.println("accounts: " + jstring + " -- " + may);

		int n = joe.areaCode();
		System.out.println("codes: " + n + ", " + may.areaCode());

		n = may.logCall("1114", "1440");
		System.out.println("May's minutes: " + n + " (should be 180+40-14=206)");
		joe.logCall("1300", "1330");   // 30
		System.out.println(joe.logCall("2330", "0100"));   // 90
		joe.logCall("1015", "1045");   // 30

		for (int i=0; i < 12; i++)
			may.logText();
		
		for (int i=0; i < 8; i++)
			joe.logData(i*2 + 5);  // 5 + 7 + 9 + 11 + 13 + 15 + 17 + 19 = 96

		System.out.print("Joe's Bill: ");
		joe.displayBill();
		System.out.print("May's Bill: ");
		may.displayBill();
		System.out.print("Copy's Bill: ");
		copy.displayBill();
		
		for (int i=1; i <= 10; i++) {
			joe.logText();
			joe.logData(i);
		}
		System.out.print("Joe's New Bill: ");
		joe.displayBill();
		
		if (joe.equals(copy))
			System.out.println("Joe & Copy have the same number");

		if (joe.equals(may))
			System.out.println("Joe & May have the same number");
		else
			System.out.println("Joe & May have different numbers");

		WirelessAccount first;
		if (joe.compareTo(may) <= 0)
			first = joe;
		else
			first = may;
		n = first.compareTo(copy);
		if (n > 0)
			first = copy;
		System.out.println("first one: " + first);
	}

}

/* =========================================================

THIS IS THE OUTPUT YOU SHOULD GET WHEN YOU RUN THE PROGRAM:

accounts: Joe Smith (443)230-2980 -- May Jones (310)243-0293
codes: 443, 310
May's minutes: 206 (should be 180+40-14=206)
90
Joe's Bill: Joe Smith (443)230-2980
minutes: 150, messages: 0, data: 96 kb
May's Bill: May Jones (310)243-0293
minutes: 206, messages: 12, data: 0 kb
Copy's Bill: Copy Cat (443)230-2980
minutes: 0, messages: 0, data: 0 kb
Joe's New Bill: Joe Smith (443)230-2980
minutes: 0, messages: 10, data: 55 kb
Joe & Copy have the same number
Joe & May have different numbers
first one: Copy Cat (443)230-2980

========================================================= */