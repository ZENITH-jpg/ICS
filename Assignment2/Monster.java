/*
 *Name: Tristan Cao
 *Date: 02-24-2024
 *Teacher: Mr. Guglielmi
 *Description: 
*/
import java.util.Scanner;
import java.io.File;
import java.util.Random;
public class Monster{
   private int atk;
   private int def;
   private int hp;
   private int dmg;
   
   
   private String name;
   private boolean usedDef;
   
   public boolean usedDef(){
      return this.usedDef;
   }
   public void flipDef(){
      this.usedDef = !this.usedDef;
   }
   public void defend(int x){
      this.def += x;
   }
   public void setHp(int hp){
      this.hp = hp;
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
   public void turn(int attack, Monster b){
      if(this.usedDef){
         this.defend(-2);
         this.flipDef();
      }
      if(attack == 1){
         System.out.printf("%s Attacks!\n", this.name);
         if(b.getDefence() < Game.makeAttack(this.atk)){
            b.setHp(b.getHp() - this.dmg);
            System.out.printf("The attack suceeded! %s takes %d damage.\n",b.getName(), this.dmg);
         }else{
            System.out.println("The attack failed!");
         }
      } else {
         System.out.printf("%s Defends!\n", this.name);
         this.defend(2);
         this.flipDef();
      }
   }
   public Monster(String name){
      try{
         Scanner s = new Scanner(new File(name+".txt"));
         this.atk = s.nextInt();
         this.def = s.nextInt();       
         this.hp = s.nextInt();
         this.dmg = s.nextInt();
         this.name = name;
         s.close();
      }catch(Exception e){
      
      }
   }
}
