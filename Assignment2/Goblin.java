/*
 *Name: Tristan Cao
 *Date: 02-24-2024
 *Teacher: Mr. Guglielmi
 *Description: 
*/
import java.util.Scanner;
import java.io.File;
import java.util.Random;
public class Goblin{
   private int atk;
   private int def;
   private int hp;
   private int dmg;
   private int ablity;
   private String name;
   public int getAblity(){
      return this.ablity;
   }
   public int getAttack(){
      return this.atk;
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
   public String getName(){
      return this.name;
   }

   public Goblin(){
      try{
          Scanner s = new Scanner(new File("Goblin.txt"));
          this.atk = s.nextInt();
          this.def = s.nextInt();
          this.hp = s.nextInt();
          this.dmg = s.nextInt();
          this.name = s.next();
          this.ablity = s.nextInt();
          s.close();
      }catch(Exception e){

      }
   }
}