
   import java.util.Scanner;

   public class pig_latin{
   
      public static void main(String[] args){
      
         Scanner keyboard = new Scanner(System.in);
         String word,piggy;
         char first;
         String result = "";
         String paragraph = "";
         Scanner scanLine;
			String line = "";
      
         System.out.println("paragraph to translate: ");
      
         while(keyboard.hasNextLine()){
         
            line = keyboard.nextLine();
            scanLine = new Scanner(line);
				result = "";
         
            do
            {
               word = scanLine.next();
               first = word.charAt(0);
               first = Character.toLowerCase(first);
            
               if(first != 'a'  && first != 'e' && first != 'i' && first !=  'o' && first !=  'u')
                  piggy = word.substring(1) + first + "ay";
               else
                  piggy = word+"hay";
            
               result = result + piggy + " ";
            }while(scanLine.hasNext());
         
				paragraph += result + "\n";
            //System.out.print("piglatin: " + result);
         }
      	
         
         System.out.print("Piglatin:\n" + paragraph);
      }
   
   }