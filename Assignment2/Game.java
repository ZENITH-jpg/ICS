/*
 *Name: Tristan Cao
 *Date: 02-14-2024
 *Teacher: Mr. Guglielmi
 *Description: 
*/
import java.util.Scanner;
public class Game {
   private Monster p;
   private Monster m;
   private Scanner s;
   private boolean pUsedDefense;
   private boolean mUsedDefense;
   private int turn; //odd for player even for monster
   private int monLeft;
   
   public Game(){
      p = new Monster(0);
      m = new Monster(1);
      s = new Scanner(System.in);
      turn = 1;
      monLeft = 9;
   }
   
   public void beginGame(){
      while(p.getHp() > 0 && m.getHp() > 0){
         System.out.printf("Player is at %d health and Monster is at %d health\n", p.getHp(), m.getHp());
         if(turn % 2 == 0) {
            mTurn();
         }
         else {
            pTurn();
         }
         turn++;
         if(m.getHp() <= 0){
            System.out.println("A monster has been slain");
            m = new Monster(1);
         }
      }
      if(p.getHp() > 0)
         System.out.println("Player Wins");
      else 
         System.out.println("Player Loses");
   }
   
   private void mTurn(){
      if(mUsedDefense){
         m.undefend();
         mUsedDefense = false;
      }
      if(m.chooseAttack() == 1){
         System.out.println("Monster Attacks!");
         int atk = m.makeAttack();
         if(p.getDefence() < atk){
            p.setHp(p.getHp() - m.getDamage());
            System.out.println("The attack suceeded! Player takes " + m.getDamage() + " damage.");
         }else{
            System.out.println("The attack failed!");
         }
      } else {
         System.out.println("Monster Defends!");
         m.defend();
         mUsedDefense = true;
      }
      
   }
   
   private void pTurn(){
      if(pUsedDefense) {
         p.undefend();
         pUsedDefense = false;
      }
      System.out.println("Choose an action (1 = attack 2 = defend)");
      if(input() == 1){
         int atk = p.makeAttack();
         if(m.getDefence() < atk){
            m.setHp(m.getHp() - p.getDamage());
            System.out.println("The attack suceeded! Monster takes " + p.getDamage() + " damage.");
         }else{
            System.out.println("The attack failed!");
         }
      } else {
         p.defend();
         pUsedDefense = true;
      }
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
}