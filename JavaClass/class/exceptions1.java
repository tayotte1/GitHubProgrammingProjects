   import java.io.*;
   import java.util.*;

   public class exceptions1
   {
      public static void main(String[] args)
      {
         String filename;
         Scanner kb = new Scanner(System.in);
         Scanner file = null;
      
         while (file == null)
         {
            System.out.print("enter filename: ");
            filename= kb.nextLine();
            try {
               file = new Scanner(new FileReader(filename));
            // might throw FileNotFoundException
            }
               catch (FileNotFoundException e)
               {
                  System.err.println(e);  // calls toString
                  System.err.print("sorry, try again  ");
                  file = null;
               }	
         }
      // ready to process file
         System.out.println(file.nextLine());
         System.out.println(getInt(kb));
      }
   
      public static int getInt(Scanner kb)
      {
         int number = 0;
         try {
            System.out.print("enter an integer: ");
            number = kb.nextInt();
         }
            catch (InputMismatchException e)
            {
               System.err.println("e.toString(): " + e);
               System.err.println("e.getMessage(): " + e.getMessage());
               e.printStackTrace();
            }
            catch (Exception e)
            {
               System.err.println(e);
               e.printStackTrace();
            }
         return number;
      }
   }