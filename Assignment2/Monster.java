/*
 *Name: Tristan Cao
 *Date: 02-12-2024
 *Teacher: Mr. Guglielmi
 *Description: The driver class for the project, main method runs the game from the Concentration
*/
import java.util.Scanner;
import java.util.Random;
public class Monster{
   Random r;
   int atk;
   int def;
   int hp;
   int dmg;
   int chooseAttack(){
      return r.nextInt(2);
   }
   int makeAttack(){
      return atk + r.nextInt(20)+1;
   }
   void defend(){
      def += 2;
   }
   int getDefence(){
      return def;
   }
   int getAttack(){
      return atk;
   }
   int getHp(){
      return hp;
   }
   int getDamage(){
      return dmg;
   }
   void setHp(int hp){
      this.hp = hp;
   }
   public Monster(){
      try{
         Scanner s = new Scanner("Monster.txt");
         atk = s.nextInt();
         def = s.nextInt();
         hp = s.nextInt();
         dmg = s.nextInt();
         r = new Random();
         s.close();
      }catch(Exception e){
      
      }
   }
}