import java.text.DecimalFormat;

public class recursion
{
static DecimalFormat three0s = new DecimalFormat("000");

public static void main(String[] args) {

	System.out.println(power(2,8));
	System.out.println(power(-4, 3));
	
	System.out.println(powerRecurse(2,8));
	System.out.println(powerRecurse(-4, 3));
	
	System.out.println(powerFast(2,8));
	System.out.println(powerFast(-4, 3));
	
	System.out.println(powerFast(3, -4));
	
	System.out.println(factorial(5));
	System.out.println(factorial(20));
	
	System.out.println("palindrome(ada) " + palindrome("ada"));
	System.out.println("palindrome(raceecar) " +palindrome("raceecar"));
	System.out.println("palindrome(java) " + palindrome("java"));
	System.out.println("palindrome(Yo banana boy) " + palindrome("Yo banana boy"));

	System.out.println(commas(23));
	System.out.println(commas(2345066));
	System.out.println(commas(241000342));
	
	System.out.println(balanced("()")); // valid, base
	System.out.println(balanced(")(")); // invalid
	System.out.println(balanced("((({{}}})))"));  // invalid
	System.out.println(balanced("((({{{}}})))"));  // valid, nested
	System.out.println(balanced("({[}])")); // invalid
	System.out.println(balanced("(){}[]")); // valid, sequenced
	System.out.println(balanced("({[]}(){[][]})"));  // valid, both
	
	System.out.println();
	hanoi(5, "a", "c", "b");
	System.out.println();
	hanoi(4, "washington", "philly", "baltimore");
	System.out.println();
}

public static void hanoi(int n, String start, String end, String temp) {

	if (n > 0)
	{
	hanoi(n-1, start, temp, end);
	System.out.println("move " + n + " from " + start + " to " + end);
	hanoi(n-1, temp, end, start);
	}
}

public static boolean balanced(String expr) {
	if(expr == null)
		return false;
	if (expr.length() == 0)
		return true;
	if (expr.length()%2 == 1) // odd
		return false;
	if (nested(expr))
		return true;
	// else test for sequenced
	return sequenced(expr);
}

public static boolean nested(String expr) {
	if (expr.length() == 0)
		return true;
	if (expr.length()%2 == 1) // odd
		return false;
	int last = expr.length()-1;
	return match(expr.charAt(0),expr.charAt(last)) && balanced(expr.substring(1,last));
}

public static boolean sequenced(String expr) {
	int split = 2;
	boolean valid = false;
	while (!valid && split < expr.length())
	{
		valid = balanced(expr.substring(0,split)) && balanced(expr.substring(split));
		split += 2;
	}
	return valid;
}

public static boolean match(char c1, char c2) {
	final String pairs = "()[]{}";
	int wherec1 = pairs.indexOf(c1);
	return wherec1 % 2 == 0 && pairs.indexOf(c2) == wherec1 + 1;
}

public static String commas(long number) {
	
	if (number < 1000)
		return number + "";  // convert to String
	return commas(number/1000) + "," + three0s.format(number%1000);
}

public static boolean palindrome(String s) {

	s = s.toLowerCase().trim();  // get rid of whitespace at front and back
	if (s.length() <= 1)
		return true;
	int last = s.length()-1;  // last valid index
	return s.charAt(0) == s.charAt(last) && palindrome(s.substring(1,last));
}

public static double factorial(int n) {
	// base case
	if (n <= 0)
		return 1;
	return n * factorial(n-1);
}

public static double power(double base, int exponent) {

	double result=1;
	for (int p=1; p <= exponent; p++)
		result = result * base;
	return result;
}

public static double powerRecurse(double base, int exponent) {
	if (exponent == 0)
		return 1;
	else if (exponent < 0)
		return 1.0 / powerRecurse(base,-exponent);
		
	return base * powerRecurse(base,exponent-1);
}

public static double powerFast(double base, int exponent) {
	if (exponent == 0)
		return 1;
	else if (exponent == 1)
		return base;
	else if (exponent < 0)
		return 1.0 / powerRecurse(base,-exponent);

	
	double half = powerFast(base, exponent/2);
	if (exponent%2 == 1)
		return half*half*base;
	else
		return half*half;
}

}