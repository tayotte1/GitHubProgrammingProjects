   import java.util.Scanner;

   public class menu{
      public static void main(String args[]){
      
         int choice,tom,smells, yucky;
         char start, end, bad;
			String line, num;
      
         do{
         
            Scanner key = new Scanner(System.in);
         
         
            System.out.println("0) quit");
            System.out.println("1) letters");
            System.out.println("2) rectangle");
            System.out.println("3) graph");
         
            choice = key.nextInt();
         
            switch(choice){
            
               case 1:
                  System.out.print("Enter 2 letters: ");
               
                  start = key.next().charAt(0);
                  start = Character.toUpperCase(start);
                  end = key.next().charAt(0);
                  end = Character.toUpperCase(end);
               	
						if (start < end)
						{ 
                     for(char x = start; x <= end; x++)
							{
                        System.out.print(x + " ");
                     }
                     System.out.print("\n");
                  }
						else
						{ 
                     for(char x = end; x <= start; x++)
							{
                        System.out.print(x + " ");
                     }
                     System.out.print("\n");
						}
                  break;
            
               case 2:
                  System.out.print("Enter height, width, $ display character: ");
						
						tom = key.nextInt();
						smells = key.nextInt();
						bad = key.next().charAt(0);
						
						for(int x = 1; x <= tom; x++){
							for(int y = 1; y <= smells; y++){
								System.out.print(bad);
							}
							System.out.println();
						}
                  break;
            
               case 3:
					
                  System.out.print("Enter all the numbers to process on one line: ");
						key.nextLine();
						line = key.nextLine();
            		Scanner scanLine = new Scanner(line);
						
						do{
							num = scanLine.next();
							yucky = Integer.parseInt(num);
							for (int x = 1; x <= yucky; x++){
								System.out.print("*");
							}
							System.out.println();
						
						} while (scanLine.hasNext());
						
                  break;
            
               case 0:
                  System.out.println("quit");
                  break;
            
               default:
                  System.out.println("you're a dumbass");
            
            }
         
         
         }while(choice != 0);
      
         System.out.print("Tom smells.");

      
      }//end main
   }//end class