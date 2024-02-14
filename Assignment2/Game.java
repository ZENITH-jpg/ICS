/*
 *Name: Tristan Cao
 *Date: 02-14-2024
 *Teacher: Mr. Guglielmi
 *Description: 
*/
public class Game {
   Player p;
   Monster m;
   Scanner s;
   
   public Game(){
      p = new Player();
      n = new Monster();
      s = new Scanner(System.in);
   }
   void beginGame(){
      System.out.println("Choose an action (1 = attack 2 = defend)");
      
   }
   
}