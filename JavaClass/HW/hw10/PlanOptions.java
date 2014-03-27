public class PlanOptions implements Database {

	private Plan[] plans;
	private int size;

	public PlanOptions() {
		plans = new Plan[STARTSIZE];
		size = 0;
	}

	public int size() {
		return size;
	}

	public void print() {
		for (int i=0; i < size; i++)
			System.out.println(plans[i]);
	}
	
	public Object get(Object o) {
		if (! (o instanceof Plan))
			return null;
		Plan p = (Plan) o;
		for (int i=0; i < size; i++)
			if (plans[i].equals(p))
				return plans[i];
		return null;
	}

	public boolean add(Object o) {
		if (! (o instanceof Plan))
			return false;
		if (size == plans.length) {
			Plan[] temp = new Plan[size*2];
			System.arraycopy(plans, 0, temp, 0, size);
			plans = temp;
		}
		plans[size++] = (Plan) o;
		return true;
	}

	public boolean delete(Object o) {
		if (! (o instanceof Plan))
			return false;
		Plan p = (Plan) o;
		for (int i=0; i < size; i++)
			if (plans[i].equals(p)) {
				plans[i] = plans[--size];
				return true;
			}
		return false;
	}

} // PlanOptions class