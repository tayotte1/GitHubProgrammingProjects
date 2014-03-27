/**
 * This class creates a randomly generated, balanced expression.
 * It also demonstrates some exception handling.
 *
 * @author Zachary Peterson & Joanne Houlahan
 */


   import java.util.*;
   import java.io.*;

   public class exceptions2 { 
   
      static Random rand = new Random(); 
    
      public static void main(String[] args) 
      { 
       
         BufferedReader in = new BufferedReader(new
            InputStreamReader(System.in));
         
         String expression = ""; 
         int length; 
       
         for(int numTimes = 0; numTimes < 5; numTimes++){ 
            try {
               System.out.print("Enter length: "); 
               length = Integer.parseInt(in.readLine());
            // might throw IOException
            // might throw NumberFormatException
            
               if(length%2 != 0)
                  throw new NotEvenException(length);
            
               expression = generateExpression(length); 
               System.out.println(expression); 
            }
               catch (IOException badin) {
                  System.err.print(badin);
               //  throw badin;  // would stop program at this point
               }
               catch (NumberFormatException ne) {	    
                  System.err.println("Bad input: not an integer");
                  ne.printStackTrace();
                  numTimes--;
               }
               catch (NotEvenException badeven) {
                  System.err.println(badeven);
                  System.err.println(badeven.fix());
                  try {
                     expression = generateExpression(badeven.fix()); 
                  }
                     catch (Exception be) {
                     // empty catch
                        System.err.println(be);
                        expression = null;  // unresolved error
                     }
                  finally {
                     System.out.println(expression); 
                  }
               }
               catch (Exception e) {
                  System.err.println(e + " " + e.getMessage());
                  e.printStackTrace();
                  numTimes--;	
               }
            finally {
               System.out.println("attempted expression");
            }
            System.out.println("loop iteration");
         } 
      } 
    
   /** 
   * A recursive function that generates a balanced expression 
   * of ()s, {}s, []s, and <>s.  A pair of braces may either be 
   * sequential or nested. 
   * @param length The desired length of the expression. 
     @return the expression generated 
   */ 
      public static String generateExpression(int length) throws NotEvenException
      { 
       
      /* Determine if we're go to be nested or sequential */ 
         boolean sequence = rand.nextBoolean(); 
         String expression = ""; 
      
         if (length < 0) throw new IllegalArgumentException("length must be >= 0");
      
         if (length%2==1) throw new NotEvenException();
       
         if(length > 2 && sequence){ 
            /* Create a sequence, so randomly choose a split point  
            * and recurse before and after the split */ 
            int split = chooseSplit(length); 
            expression += generateExpression(split); 
            expression += generateExpression(length-split); 
         } 
         else if (length > 0) { 
            /* We're nested */ 
            char openBrace = getRandomOpenBrace(); 
            expression += openBrace; 
            expression += generateExpression(length - 2); 
            expression += getMatchingBrace(openBrace); 
         } 
      	
         return expression; 
      } 
    
   /** 
   * Returns an even, random number between 2 (inclusive) and max (exclusive) 
   * @param max the maximum return value 
   * @return An even between 2 (inclusive) and max 
   */ 
      public static int chooseSplit(int max){ 
         if (max % 2 == 1) max--;  // make max even 
         int split = rand.nextInt(max/2-1);  // rand between 0 and max/2-2 inclusive 
         return (split+1)*2;	 
      } 
    
   /** 
   * Returns an open brace at random. 
   * @return The randomly generated open brace. 
   */ 
      public static char getRandomOpenBrace(){ 
       
         int which = rand.nextInt(4); 
       
         switch(which){ 
            case 0:  
               return '['; 
            case 1:  
               return '{'; 
            case 2:  
               return '('; 
            case 3:  
               return '<'; 
            default:  
               return ' '; 
         } 
      } 
    
   /** 
   * Returns the matching closing brace for the given open brace. 
   * @param openBrace The open brace to match. 
   * @return The matching closing brace, or space if the openBrace 
   * is invalid  
   */ 
      public static char getMatchingBrace(char openBrace){ 
       
         switch(openBrace){ 
            case '[':  
               return ']'; 
            case '{':  
               return '}'; 
            case '(':  
               return ')'; 
            case '<':  
               return '>'; 
            default:  
               return ' '; 
         } 
      } 
    
   }