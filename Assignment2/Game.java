/*
 *Name: Tristan Cao
 *Date: 02-14-2024
 *Teacher: Mr. Guglielmi
 *Description: 
*/
import java.util.Scanner;
import java.util.Random;
public class Game {
   private int pAtk;
   private int pDef;
   private int pHp;
   private int pDmg;
   private boolean pUsedDef;
   private String pName;
   
   private Zombie z;
   private Goblin g;
   
   private int mAtk;
   private int mDef;
   private int mHp;
   private int mDmg;
   private int ablity;
   private String mName;
   private boolean mUsedDef;
   
   private Scanner s;
   private static Random r;
   
   public Game(){
      pAtk = 6;
      pDef = 16;
      pHp = 15;
      pDmg = 5;
      pUsedDef = false;
      pName = "Player";
   
      z = new Zombie();
      g = new Goblin();
      
      mAtk = z.getAttack();
      mDef = z.getDefence();
      mHp = z.getHp();
      mDmg = z.getDamage();
      mUsedDef = false;
      mName = z.getName();
      ablity = z.getAblity();
      
      s = new Scanner(System.in);
      r = new Random();
   }
   
   public void beginGame(){
      int[] order = {2,4,3,4,2,1,2,4};
      int turn = 1; //odd for player even for monster
      int curMon = 0;
      while(pHp > 0 && mHp > 0){
         System.out.printf("TURN %d: %s is at %d health and %s is at %d health\n", turn, pName, pHp, mName, mHp);
         if(turn % 2 == 0) {
            mTurn(Game.chooseAttack());
            if(ablity == 2 && r.nextInt(4) == 3){
               System.out.printf("%s uses [Speedy] ablity! Preforms an attack after first action.\n", mName);
               if(mDef < Game.makeAttack(mAtk)){
                  pHp -= mDmg;
                  System.out.printf("The attack suceeded! %s takes %d damage.\n",pName, mDmg);
               }else{
                  System.out.println("The attack failed!");
               }
            }
            
         }
         else {
            System.out.println("Enter 1 to attack and 2 to defend!");
            pTurn(input());
         }
         turn++;
         if(mHp <= 0){
            System.out.printf("%s has been slain\n", mName);
            if(ablity == 1){
               System.out.printf("%s uses [Undead] ablity! Preforms an attack after defeated.\n", mName);
               if(mDef < Game.makeAttack(mAtk)){
                  pHp -= mDmg;
                  System.out.printf("The attack suceeded! %s takes %d damage.\n",pName, mDmg);
               }else{
                  System.out.println("The attack failed!");
               }
            }
            curMon++;
            if(curMon<9){
               switch(order[curMon]){
                  case 1:
                     mAtk = z.getAttack();
                     mDef = z.getDefence();
                     mHp = z.getHp();
                     mDmg = z.getDamage();
                     mName = z.getName();
                     ablity = z.getAblity();
                     break;
                  case 2:
                     mAtk = g.getAttack();
                     mDef = g.getDefence();
                     mHp = g.getHp();
                     mDmg = g.getDamage();
                     mName = g.getName();
                     ablity = g.getAblity();
                  case 3:
                     
                  case 4:
               }
               mUsedDef = false;
            }
         }
      }
      if(pHp > 0)
         System.out.println("Player Wins");
      else 
         System.out.println("Player Loses");
   }
   
   private void pTurn(int attack){
      if(pUsedDef){
         pDef -= 2;
         pUsedDef = false;
      }
      if(attack == 1){
         System.out.printf("%s Attacks!\n", pName);
         if(mDef < Game.makeAttack(pAtk)){
            mHp -= pDmg;
            System.out.printf("The attack suceeded! %s takes %d damage.\n",mName, pDmg);
         }else{
            System.out.println("The attack failed!");
         }
      } else {
         System.out.printf("%s Defends!\n", pName);
         pDef += 2;
         pUsedDef = true;
      }
   }
   
   private void mTurn(int attack){
      if(mUsedDef){
         mDef -= 2;
         mUsedDef = false;
      }
      if(attack == 1){
         System.out.printf("%s Attacks!\n", mName);
         if(mDef < Game.makeAttack(mAtk)){
            pHp -= mDmg;
            System.out.printf("The attack suceeded! %s takes %d damage.\n",pName, mDmg);
         }else{
            System.out.println("The attack failed!");
         }
      } else {
         System.out.printf("%s Defends!\n", pName);
         mDef += 2;
         mUsedDef = false;
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