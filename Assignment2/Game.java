/*
 *Name: Tristan Cao
 *Date: 02-14-2024
 *Teacher: Mr. Guglielmi
 *Description: 
*/
import java.util.Scanner;
import java.util.Random;
public class Game {
   private Monster m;
   private Monster p;
   
   private static Scanner s;
   private static Random r;
   
   public Game(){
      p = new Monster("Player");
      m = new Zombie();
      
      s = new Scanner(System.in);
      r = new Random();
   }
   
   public void beginGame(){
      int[] order = {2,4,3,4,2,1,2,4,3};
      int turn = 1; //odd for player even for monster
      int curMon = 0;
      while(p.getHp() > 0 && m.getHp() > 0){
         System.out.printf("\nTURN %d: %s is at %d health and %s is at %d health\n", turn, p.getName(), p.getHp(), m.getName(), m.getHp());
         if(turn % 2 == 0) {
            m.turn(Game.chooseAttack(),p);
            
         }
         else {
            System.out.print("Enter 1 to attack and 2 to defend: ");
            p.turn(input(),m);
         }
         turn++;
         if(m.getHp() <= 0){
            System.out.printf("%s has been slain\n", m.getName());
            curMon++;
            if(curMon<9){
               switch(order[curMon]){
                  case 1:
                     m = new Zombie();
                     break;
                  case 2:
                     m = new Goblin();
                     break;
                  case 3:
                     m = new Wizard();
                     break;
                  case 4:
                     m = new Golem();
                     break;
               }
            }
         }
      }
      if(p.getHp() > 0)
         System.out.println("Player Wins");
      else 
         System.out.println("Player Loses");
   }
   
   private static int input(){
      int in;
      do {
         in = s.nextInt();
         if(in < 1 || in > 2){
            in = -1;
            System.out.println("Input must be an integer from 1 to 2");
         } 
      } while (in == -1) ;
      return in;
   }
   
   private static int chooseAttack(){
      return r.nextInt(2)+1;
   }
   public static int makeAttack(int atk){
      return atk + r.nextInt(20)+1;
   }
   public static Random getRandom(){
      return r;
   }
}