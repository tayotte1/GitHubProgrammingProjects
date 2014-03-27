   import java.util.*;

    public class SorterMain
   {
	
	   public static void main(String[] args)
      {
         double dra[] = new double[20];
         Random rand = new Random();
         for (int i=0; i < 20; i++)
         {	dra[i] = rand.nextDouble();
            System.out.print(dra[i] + " ");
         }
         System.out.println();
         Sorter.bubbleSort(dra, 5);
         Sorter.print(dra);
         
         Sorter.bubbleSort(dra, dra.length);
         Sorter.print(dra);
      	
         String words[] = {"JAVA", "word", "homework", "homecoming", "program", "Popcorn"};
         Sorter.selectionSort(words, words.length);
         Sorter.print(words);
      	
         for (int i=0; i < 20; i++)
         {	dra[i] = rand.nextDouble();
            System.out.printf("%.4f ", dra[i]);
         }
         System.out.println();
         Sorter.mergeSort(dra, 0, dra.length-1);
         Sorter.print(dra);
         
         if (Sorter.binarySearch(dra, .243532))
            System.out.println("found .243532");
         if (Sorter.binarySearch(dra, dra[3]))
            System.out.println("found " + dra[3]);
      }
   
   
   }