/*
 *Name: Tristan Cao
 *Date: 02-12-2024
 *Teacher: Mr. Guglielmi
 *Description: 
*/
import java.util.Scanner;
import java.util.Random;
import java.io.File;
public class Player{
   private int atk;
   private int def;
   private int hp;
   private int dmg;
   private String name;
   
   public int makeAttack(Random r){
      return this.atk + r.nextInt(20)+1;
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

   public Player(){
      try{
          Scanner s = new Scanner(new File("Player.txt"));
          this.atk = s.nextInt();
          this.def = s.nextInt();
          this.hp = s.nextInt();
          this.dmg = s.nextInt();
          this.name = s.next();
          s.close();
      }catch(Exception e){

      }
   }
}