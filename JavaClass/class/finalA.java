public class finalA
{
public static void main(String[] args)
{
	int x = 3;
	int y = 9;
	method1(x, y);
	System.out.println("after method1:  " + x + "  " + y);


	x = 3;
	y = 9;
	x = method2(x, y);
	System.out.println("after method2:  " + x + "  " + y);
}

public void method1(int x, int y)
{
	x = x + 2;
	y = x * 10;
}

public int method2(int x, int y)
{
	y = y * 2;
	x = y - 5;
	return y;
}
}