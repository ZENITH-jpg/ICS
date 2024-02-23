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
      Monster.createRandom();
      while(p.getHp() > 0 && m.getHp() > 0){
         System.out.printf("TURN %d: %s is at %d health and %s is at %d health\n", turn, p.getName(), p.getHp(), m.getName(), m.getHp());
         if(turn % 2 == 0) {
            turn(m,p,m.chooseAttack());
         }
         else {
            System.out.println("Enter 1 to attack and 2 to defend!");
            turn(p,m,input());
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
   
   private void turn(Monster a, Monster b, int attack){
      if(a.usedDef()){
         a.undefend();
         a.flipDef();
      }
      if(attack == 1){
         System.out.printf("%s Attacks!\n", a.getName());
         if(b.getDefence() < a.makeAttack()){
            b.setHp(b.getHp() - a.getDamage());
            System.out.printf("The attack suceeded! %s takes %d damage.\n",b.getName(), m.getDamage());
         }else{
            System.out.println("The attack failed!");
         }
      } else {
         System.out.printf("%s Defends!\n", a.getName());
         a.defend();
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
}