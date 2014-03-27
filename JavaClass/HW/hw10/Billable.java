public interface Billable
{
	double getCost(Plan p);
	void payment(double money);
	void interest(double percent);
	double bill();
}