/*
 *Name: Tristan Cao
 *Date: 02-14-2024
 *Teacher: Mr. Guglielmi
 *Description: 
*/
import java.util.Scanner;
import java.util.Random;
public class Game {
   private Player p;
   private Zombie m;
   private Scanner s;
   private int turn; //odd for player even for monster
   private int monLeft;
   private static Random r;
   
   public Game(){
      p = new Player();
      m = new Zombie();
      s = new Scanner(System.in);
      r = new Random();
      turn = 1;
      monLeft = 9;
   }
   
   public void beginGame(){
      while(p.getHp() > 0 && m.getHp() > 0){
         System.out.printf("TURN %d: %s is at %d health and %s is at %d health\n", turn, p.getName(), p.getHp(), m.getName(), m.getHp());
         if(turn % 2 == 0) {
            turn(Game.chooseAttack());
         }
         else {
            System.out.println("Enter 1 to attack and 2 to defend!");
            turn(input());
         }
         turn++;
         if(m.getHp() <= 0){
            System.out.println("A monster has been slain");
            m = new Zombie();
         }
      }
      if(p.getHp() > 0)
         System.out.println("Player Wins");
      else 
         System.out.println("Player Loses");
   }
   
   private void turn(int attack){
      /*if(a.usedDef()){
         a.undefend();
         a.flipDef();
      }
      if(attack == 1){
         System.out.printf("%s Attacks!\n", a.getName());
         if(b.getDefence() < a.makeAttack(r)){
            b.setHp(b.getHp() - a.getDamage());
            System.out.printf("The attack suceeded! %s takes %d damage.\n",b.getName(), m.getDamage());
         }else{
            System.out.println("The attack failed!");
         }
      } else {
         System.out.printf("%s Defends!\n", a.getName());
         a.defend();
         a.flipDef();
      }*/
   }
   
   private int input(){
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
}