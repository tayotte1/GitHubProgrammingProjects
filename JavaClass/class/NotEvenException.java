public class NotEvenException extends Exception
{
	private int number;

public NotEvenException()
{
	super("number not even");
	number = -1;
}

public NotEvenException(String msg)
{	super(msg);
	number = -1;
}

public NotEvenException(int num)
{
	super(num + " is not even");
	number = num;
}

public int getNumber()
{
	return number;
}

public int fix()
{
	return number+1;
}

}