/** Sample sorting methods
*/

public class Sorter {

public static void main(String[] args) {

	int[] values = {3, 14, 20, 52, 15, 30, -23, 0};
	print(values);
	System.out.println();
	bubble(values, values.length);
	print(values);
	System.out.println();
	System.out.println();
	System.out.print("search values for 17: ");
	System.out.println(binarySearch(values, 17));
	System.out.print("search values for 30: ");
	System.out.println(binarySearch(values, 30));
	
	String[] words = {"Java", "help", "sunny", "Baltimore", "desk", "computer", " ", " ", " "};
	print(words);
	System.out.println();
	selectMax(words, 6);
	print(words);
	System.out.println();
	System.out.println();
	
	double[] reals = {4.5, 35.42, 2.23, -34.4, 24.34, 14};
	print(reals);
	System.out.println();
	mergeSort(reals, reals.length);
	print(reals);
	System.out.println();
	System.out.println();

}

public static void print(int[] ra) {
	for (int i=0; i < ra.length; i++)
		System.out.print(ra[i] + " ");
}

public static void print(String[] ra) {
	for (int i=0; i < ra.length; i++)
		System.out.print(ra[i] + " ");
}

public static void print(double[] ra) {
	for (int i=0; i < ra.length; i++)
		System.out.print(ra[i] + " ");
}

public static int binarySearch(int[] ra, int value) {
	return binarySearch(ra, 0, ra.length, value);
}

/** Recursively do a binary search for value in an ra between indices start and end
	@param ra the array of values to search
	@param start the starting index of search range, inclusive
	@param end the ending index of the search range, exclusive
	@param value what we're looking for
	@return the index position of the value in the array, -1 if not found
	*/
public static int binarySearch(int[] ra, int start, int end, int value) {
	
	if (end <= start) // nothing to search, not found
		return -1;
		
	int mid = (start+end) / 2;
	if (ra[mid] == value)
		return mid;  // found it
	else if (ra[mid] < value) // search right
		return binarySearch(ra, mid+1, end, value);
	else // search left
		return binarySearch(ra, start, mid-1, value);
}

public static void bubble(int[] ra, int size) {
	int temp;
	for (int last = size-1; last > 0; last--)
		for (int curr = 0; curr < last; curr++)
			if (ra[curr] > ra[curr+1]) { // out of order
				temp = ra[curr];
				ra[curr] = ra[curr+1];
				ra[curr+1] = temp;
			}
}

public static void selectMax(Comparable[] ra, int size) {
	int maxIndex;  // where is the current max value
	Comparable temp;
	for (int last = size-1; last > 0; last--) {
		maxIndex = 0;
		// find the next maximum value
		for (int curr = 1; curr <= last; curr++)
			if (ra[curr].compareTo(ra[maxIndex]) > 0)
				maxIndex = curr;
		// swap max into place
		temp = ra[last];
		ra[last] = ra[maxIndex];
		ra[maxIndex] = temp;
	}
}

public static void mergeSort(double[] ra, int size) {
	mergeSort(ra, 0, size-1);
}

/** Mergesort part of an array (recursive)
	@param left the index of the leftmost value to include
	@param right the index of the rightmost value to include
*/
public static void mergeSort(double[] ra, int left, int right) {

	// how big a section do I have?
	int size = right - left + 1;
	if (size <= 1) // nothing to do, base case
		return;

	int middle = (right + left) / 2;
	mergeSort(ra, left, middle);
	mergeSort(ra, middle+1, right);
	
	// merge two parts
	double[] temp = new double[size];
	int li = left, ri = middle+1, ti = 0;
	while (li <= middle && ri <= right) {
		if (ra[li] < ra[ri])  // pull from left
			temp[ti++] = ra[li++];
		else // pull from right
			temp[ti++] = ra[ri++];
	}
	// clean up left side
	while (li <= middle)
		temp[ti++] = ra[li++];
	// clean up right side
	while (ri <= right)
		temp[ti++] = ra[ri++];
		
	// copy from temp into ra
	for (ti=0; ti < size; ti++)
		ra[left+ti] = temp[ti];
}

}