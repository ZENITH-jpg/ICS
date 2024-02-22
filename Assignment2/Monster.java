/*
 *Name: Tristan Cao
 *Date: 02-12-2024
 *Teacher: Mr. Guglielmi
 *Description: The driver class for the project, main method runs the game from the Concentration
*/
import java.util.Scanner;
import java.util.Random;
import java.io.File;
public class Monster{
   private Random r;
   private int atk;
   private int def;
   private int hp;
   private int dmg;
   public int chooseAttack(){
      return r.nextInt(2)+1;
   }
   public int makeAttack(){
      return atk + r.nextInt(20)+1;
   }
   public void defend(){
      def += 2;
   }
   public void undefend(){
      def -= 2;
   }
   public int getDefence(){
      return def;
   }
   public int getHp(){
      return hp;
   }
   public int getDamage(){
      return dmg;
   }
   public void setHp(int hp){
      this.hp = hp;
   }
   public Monster(int id){
      this.r = new Random();
      if(id == 0){
         this.atk = 6;
         this.def = 16;
         this.hp = 15;
         this.dmg = 4;
      } else {
         try{
            Scanner s = new Scanner(new File("Monster.txt"));
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
}