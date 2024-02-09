/*
 *Name: Tristan Cao
 *Date:
 *Teacher: Mr. Guglielmi
 *Description: The driver class for the project, main method runs the methods contained in the other files
*/
import java.util.Scanner;
public class Concentration{

   char[][] bank = {
      {'E','A','F','E'},
      {'B','D','C','G'},
      {'A','G','C','F'},
      {'D','H','H','B'}
   };
   boolean[][] found;
   int matches;
   int misses;
   Scanner s;
   
   public Concentration(){
      found = new boolean[4][4];
      matches = 0;
      misses = 0;
      s = new Scanner(System.in);
   }
   void game(){
      display();
      while(matches < 8 && misses < 10){
         int x1, y1, x2, y2;
         while(true){
            System.out.println("Enter the column for first card (1-4).");
            x1 = input();
            System.out.println("Enter the row for first card (1-4).");
            y1 = input();
            if(found[y1][x1]) 
               System.out.println("Cannot pick a card that is already found.");
            else
               break;
         }
         while(true){
            System.out.println("Enter the column for second card (1-4).");
            x2 = input();
            System.out.println("Enter the row for second card (1-4).");
            y2 = input();
            if(x1 == x2 && y1 ==y2)
               System.out.println("Cannot choose the same card for card 1 and 2.");
            else if(found[y1][x1]) 
               System.out.println("Cannot pick a card that is already found.");
            else
               break;
         }
         if(bank[y1][x1] == bank[y2][x2]) matches++;
         else misses++;
         found[y1][x1] = true;
         found[y2][x2] = true;
         display();
         if(bank[y1][x1] != bank[y2][x2]){
            found[y1][x1] = false;
            found[y2][x2] = false;
         }
      }
      if(matches = 8){
         System.out.println("You win!");
      }else{
         System.out.println("You lose.");
      }
   }
   int input(){
      while(true){
         int in = s.nextInt()-1;
         if(0>in || in>=4)
            System.out.println("Invalid input, must be a integer from 1-4.");
         else 
            return in;
      }
   }
   void display(){
      for(int i = 0; i < 4; i++){
         for(int j = 0; j < 4; j++){
            if(found[i][j]) System.out.print(bank[i][j]);
            else System.out.print("X");
         }
         System.out.println();
      }
      System.out.println((10-misses) + " tries left, " + matches + " matches made.");
   }
}