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
   
   private Scanner s;
   private static Random r;
   
   public Game(){
      p = new Player();
      m = new Zombie();
      
      s = new Scanner(System.in);
      r = new Random();
   }
   
   public void beginGame(){
      int[] order = {2,4,3,4,2,1,2,4};
      int turn = 1; //odd for player even for monster
      int curMon = 0;
      while(p.getHp() > 0 && m.getHp() > 0){
         System.out.printf("TURN %d: %s is at %d health and %s is at %d health\n", turn, p.getName(), p.getHp(), m.getName(), m.getHp());
         if(turn % 2 == 0) {
            turn(Game.chooseAttack(),m,p);
            if(m.getAblity() == 2 && r.nextInt(4) == 3){
               System.out.printf("%s uses [Speedy] ablity! Preforms an attack after first action.\n", m.getName());
               if(p.getDefence() < Game.makeAttack(m.getAttack())){
                  p.setHp(p.getHp() - m.getDamage());
                  System.out.printf("The attack suceeded! %s takes %d damage.\n",p.getName(), m.getDamage());
               }else{
                  System.out.println("The attack failed!");
               }
            }
            
         }
         else {
            System.out.println("Enter 1 to attack and 2 to defend!");
            turn(input(),p,m);
         }
         turn++;
         if(m.getHp() <= 0){
            System.out.printf("%s has been slain\n", m.getName());
            if(m.getAblity() == 1){
               System.out.printf("%s uses [Undead] ablity! Preforms an attack after defeated.\n", m.getName());
               if(m.getDefence() < Game.makeAttack(m.getAttack())){
                  p.setHp(p.getHp()-m.getDamage());
                  System.out.printf("The attack suceeded! %s takes %d damage.\n",p.getName(), m.getDamage());
               }else{
                  System.out.println("The attack failed!");
               }
            }
            curMon++;
            if(curMon<9){
               switch(order[curMon]){
                  case 1:
                     m = new Zombie();
                     break;
                  case 2:
                     m = new Goblin();
                  case 3:
                     
                  case 4:
               }
            }
         }
      }
      if(p.getHp() > 0)
         System.out.println("Player Wins");
      else 
         System.out.println("Player Loses");
   }
   
   private void turn(int attack, Monster a, Monster b){
      if(a.usedDef()){
         a.defend(1);
         a.flipDef();
      }
      if(attack == 1){
         System.out.printf("%s Attacks!\n", a.getName());
         if(b.getDefence() < Game.makeAttack(a.getAttack())){
            b.setHp(b.getHp() - a.getDamage());
            System.out.printf("The attack suceeded! %s takes %d damage.\n",b.getName(), a.getDamage());
         }else{
            System.out.println("The attack failed!");
         }
      } else {
         System.out.printf("%s Defends!\n", a.getName());
         a.defend(0);
         a.flipDef();
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
   
   private static int chooseAttack(){
      return r.nextInt(2)+1;
   }
   private static int makeAttack(int atk){
      return atk + r.nextInt(20)+1;
   }
}