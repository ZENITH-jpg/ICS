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
   private static Random r;
   private int atk;
   private int def;
   private int hp;
   private int dmg;
   private String name;
   private boolean usedDefense;
   public static void createRandom(){
      r = new Random();
   }
   public static int chooseAttack(){
      return r.nextInt(2)+1;
   }
   public int makeAttack(){
      return this.atk + r.nextInt(20)+1;
   }
   public boolean usedDef(){
      return this.usedDefense;
   }
   public void flipDef(){
      this.usedDefense = !this.usedDefense;
   }
   public void defend(){
      this.def += 2;
   }
   public void undefend(){
      this.def -= 2;
   }
   public int getDefence(){
      return this.def;
   }
   public int getHp(){
      return this.hp;
   }
   public int getDamage(){
      return this.dmg;
   }
   public void setHp(int hp){
      this.hp = hp;
   }
   public String getName(){
      return this.name;
   }
   public Monster(int id){
      if(id == 0){
         this.atk = 6;
         this.def = 16;
         this.hp = 15;
         this.dmg = 4;
         this.name = "Player";
      } else {
         try{
            Scanner s = new Scanner(new File("Monster.txt"));
            this.atk = s.nextInt();
            this.def = s.nextInt();
            this.hp = s.nextInt();
            this.dmg = s.nextInt();
            this.name = "Monster";
            s.close();
         }catch(Exception e){

         }
      }
   }
}