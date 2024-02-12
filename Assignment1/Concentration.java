/*
 *Name: Tristan Cao
 *Date:
 *Teacher: Mr. Guglielmi
 *Description: This is portion of code that sets the game and its rules.
               Concentration is a game where you turn over 2 cards at a time denoted by X.
               If these cards have the same letter on its oposite side, then the cards remain turnt over.
               If the cards have different letters, the letter on each card will be revealed, then hidden.
               Each turn where the player picks cards with different letters, it will consume a try (total 10)
               The game will end as a win if all possible matches are made or if the player runs out of turns as a loss
*/
import java.util.Scanner; // import Scanner class
public class Concentration {

   char[][] bank = {
      {'E','A','F','E'},
      {'B','D','C','G'},
      {'A','G','C','F'},
      {'D','H','H','B'}
   }; // the array which contains the letter on each card
   boolean[][] found; // if a card is found as a match or is temporarily selected for a turn, it is indicated here
   int matches; // counts the matches the player makes
   int misses; // counts each turn that isn't a match
   Scanner s; // input
   
   public Concentration() { // constructor for game class
      found = new boolean[4][4]; // initialize varibles
      matches = 0;
      misses = 0;
      s = new Scanner(System.in);
   }
   
   void game() { // the method that runs the game start to finish
      display(); // display the grid with all X's
      while (matches < 8 && misses < 10) { // end game when all mactches are made or misses reaches 10
         int x1, y1, x2, y2; // indexes varibles 
         
         do { // looping to re-get input in case invalid
            System.out.println("Enter the column for first card (1-4)."); // columns are from left to right
            x1 = input(); // get input for first card selection
            
            System.out.println("Enter the row for first card (1-4)."); // rows are from top down
            y1 = input(); 
            
            if (found[y1][x1]) { // check if card was already matched
               System.out.println("Cannot pick a card that is already found.");
               x1 = -1; // set condition for loop to true
            }
         } while (x1 == -1); 
         
         do { // looping to re-get input in case invalid
            System.out.println("Enter the column for second card (1-4)."); // getting input for second card
            x2 = input();
            
            System.out.println("Enter the row for second card (1-4).");
            y2 = input();
            
            if (x1 == x2 && y1 ==y2) { // if card one and card two is the same
               System.out.println("Cannot choose the same card for card 1 and 2.");
               x2 = -1; // set condition for loop to true
            } else if (found[y2][x2]) { // already matched card selected
               System.out.println("Cannot pick a card that is already found.");
               x2 = -1; // set condition for loop to true
            }
         } while (x2 == -1);
         
         if (bank[y1][x1] == bank[y2][x2]) 
            matches++; // increment matches by 1 if card 1 = card 2
         else 
            misses++; // otherwise increase misses
            
         found[y1][x1] = true; //set cards as temporarily found for displaying
         found[y2][x2] = true;
         
         display(); // show selected cards and all other matches
         
         if (bank[y1][x1] != bank[y2][x2]) { // if cards aren't a match, re-hide cards
            found[y1][x1] = false;
            found[y2][x2] = false;
         }
      }
      
      if (matches == 8) {
         System.out.println("You win!"); // if all matches are made, display win
      } else {
         System.out.println("You lose."); // otherwise, display loss
      }
   }
   
   int input() { // method for getting input for index selections
      int in; // varible that stores player's number
      do { // loop in case invalid input
         in = s.nextInt()-1; // minus one from input for indexing purposes
         if(0>in || in>=4) { // make sure input is in range
            System.out.println("Invalid input, must be a integer from 1-4.");// if not, loop
            in = -1;
         }
      } while(in == -1);
      return in; // return input
   }
   
   void display() { // method that prints the grid and information about matches
      for (int i = 0; i < 4; i ++) { // itterating through array
         for (int j = 0; j < 4; j ++) {
            if (found[i][j])  // if the card is found or matches, flip over to reveal letter
               System.out.print(bank[i][j]);
            else 
               System.out.print("X");  // otherwise display X
         }
         System.out.println(); // move to next row
      }
      System.out.println((10-misses) + " tries left, " + matches + " matches made.");  // print game info
   }
   
}