public interface Database
{
	int STARTSIZE = 4;
	
	int size();
	void print();
	Object get(Object o);
	boolean add(Object o);
	boolean delete(Object o);
}