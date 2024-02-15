/*
 *Name: Tristan Cao
 *Date: 02-14-2024
 *Teacher: Mr. Guglielmi
 *Description: 
*/
import java.util.Scanner;
public class Game {
   Player p;
   Monster m;
   Scanner s;
   boolean pUsedDefense;
   boolean mUsedDefense;
   int turn; //odd for player even for monster
   
   public Game(){
      p = new Player();
      m = new Monster();
      s = new Scanner(System.in);
      turn = 1;
   }
   void beginGame(){
      while(p.getHp() > 0 && m.getHp() > 0){
         if(turn % 2 == 0) {
            mTurn();
         }
         else {
            pTurn();
         }
         turn++;
         System.out.printf("Player is at %d health and Monster is at %d health\n", p.getHp(), m.getHp());
      }
      if(p.getHp() > 0)
         System.out.println("Player Wins");
      else 
         System.out.println("Player Loses");
   }
   void mTurn(){
      if(mUsedDefense){
         m.undefend();
         mUsedDefense = false;
      }
      if(m.chooseAttack() == 1){
         System.out.println("Monster Attacks!");
         int atk = m.makeAttack();
         if(p.getDefence() < atk){
            p.setHp(p.getHp() - m.getDamage());
         }
      } else {
         System.out.println("Monster Defends!");
         m.defend();
         mUsedDefense = true;
      }
      
   }
   void pTurn(){
      if(pUsedDefense) {
         p.undefend();
         pUsedDefense = false;
      }
      System.out.println("Choose an action (1 = attack 2 = defend)");
      if(input() == 1){
         int atk = p.makeAttack();
         if(m.getDefence() < atk){
            m.setHp(m.getHp() - p.getDamage());
         }
      } else {
         p.defend();
         pUsedDefense = true;
      }
   }
   int input(){
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