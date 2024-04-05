/* Author: Tristan Cao
Date: 30/03/2024
Description: Main class to test code and sorting algorithms
*/
import java.util.Scanner;
public class Main{
   static Scanner s;
   static Roster r;
   public static void main(String[] args){
      s = new Scanner(System.in); 
      System.out.println("Input file to read players from");
      r = new Roster(s.nextLine()); // get input
      System.out.println("Roster before changes: ");
      r.display(); // display roster before sorting
      System.out.println("Type 1 if you want to sort roster by goals and any other key if you want to sort by points");
      if(s.nextLine().equals("1")) r.sort(1); // sort roster by goals or points
      else r.sort(2);
      System.out.println("Roster after changes: ");
      r.display(); // display sorted roster
      boolean b = true;
      while(b){
         System.out.println("Type 1 to search for a player by name, 2 to search for a player by goals, and any other key to search by assists");
         String a = s.nextLine();
         int i = -1;
         if(a.equals("1")){
            System.out.println("Input player name");
            i = r.getPlayer(s.nextLine());
         }else if(a.equals("2")){
            System.out.println("Input player goals");
            i = r.getPlayerByGoals(Integer.parseInt(s.nextLine()));
         }else{
            System.out.println("Input player assists");
            i = r.getPlayerByAssists(Integer.parseInt(s.nextLine()));
         }
         if(i != -1){
            System.out.println(r.players[i].toString());
         }else{
            System.out.println("Player not found!");
         }
         System.out.println("Type 1 to break out the program, any other key to continue");
         if(s.nextLine().equals("1")) b = false;
      }
   }
}