   import java.util.*;

/** helper library class for sorting and searching
*/
    public class Sorter
   {
       public static void print(double[] ra)
      {
         for (int i=0; i < ra.length; i++)
         {		System.out.printf("%.4f ", ra[i]);
         }
         System.out.println();
      }
   	
       public static void print(String[] ra)
      {
         for (int i=0; i < ra.length; i++)
         {		System.out.print(ra[i] + " ");
         }
         System.out.println();
      }
   
   
       public static void bubbleSort(double[] ra, int size)
      {
         double temp;  // used for swapping array elements
         int last;     // index of where to stop
         boolean swap = true;  // used to check if done or not

         for (last = size-1; last > 0 && swap; last--)
         {
            swap = false;
            for (int curr = 0; curr < last; curr++)
            {
               if (ra[curr] > ra[curr+1])
               {	temp = ra[curr];
                  ra[curr] = ra[curr+1];
                  ra[curr+1] = temp;
                  swap = true;
               }
            		
            }
         }
      }
   
       public static void selectionSort(Comparable[] ra, int size )
      {
         int maxindex;  // holds index of current largest value
         Comparable temp;  // use for swapping
         int last;
			
         for (last = size-1; last > 0; last--)
         {
            maxindex = 0;
            for (int curr=1; curr <= last; curr++)
            {
               if (ra[curr].compareTo(ra[maxindex]) > 0)  // better max
                  maxindex = curr;
            }
            temp = ra[maxindex];  // current maximum
            ra[maxindex] = ra[last];  // swap into place
            ra[last] = temp;
         } 
      }
      
		/** Sort a range within an array
			@param left the left index, inclusive
			@param right the right index, inclusive
			*/
       public static void mergeSort(double[] ra, int left, int right)
      {
         int size = right-left+1;
        // if have more than one thing in ra section to sort
         if (size > 1)
         {
         // divide collection in half
            int mid = (left + right) / 2;
         // mergesort each half
            mergeSort(ra, left, mid);
            mergeSort(ra, mid+1, right);
         // merge halves together
            double temp[] = new double[size];
            int ti, li, ri;
            ti = 0;
            li = left;
            ri = mid+1;
            while (li <= mid && ri <= right)
            {
               if (ra[li] <= ra[ri])
                  temp[ti] = ra[li++];  // take from left, increment index
               else
                  temp[ti] = ra[ri++];  // take from right, increment index
               ti++;
            }
            while (li <= mid)  // only stuff on the left to move
               temp[ti++] = ra[li++];
            while (ri <= right)  // only stuff on the right to move
               temp[ti++] = ra[ri++];
         // copy from temp array to original
            System.arraycopy(temp, 0, ra, left, size);
         }
      }
   	
       public static boolean binarySearch(double ra[], double value)
      {
         return binarySearch(ra, value, 0, ra.length-1);
      }
   	
		
		/**
			Do a binary search for a value in some part of an array
			@param ra the array to search in
			@param value the value to search for
			@param left the left index of the range to look in, inclusive
			@param right the right index of the range to look in, inclusive
			@return true if found, false otherwise
			*/
       public static boolean binarySearch(double ra[], double value, int left, int right)
      {
      	// check if there is something to search
      	
         if (left <= right) // something to compare
         {	int mid = (right + left) / 2;
            if (ra[mid] == value)
               return true;
            if (ra[mid] < value) // search in right half
               return binarySearch(ra, value, mid+1, right);
            else  // search in left half
               return binarySearch(ra, value, left, mid-1);
         }
         return false;
      }
   
   } // end of class Sorting