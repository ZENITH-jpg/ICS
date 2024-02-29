/*
 *Name: Tristan Cao
 *Date: 02-24-2024
 *Teacher: Mr. Guglielmi
 *Description: The monster superclass, stats and methods for monsters stored here
 */

import java.util.Scanner;
import java.io.File;

public class Monster {
   private int atk; // stat vars
   private int def;
   private int hp;
   private int dmg;


   private String name; // name
   private boolean usedDef; // used defence last turn

   public void defend(int x) {
      this.def += x;
   }// mutators

   public void setHp(int hp) {
      this.hp = hp;
   }

   public int getAttack() {
      return this.atk;
   } // accessors

   public int getDefence() {
      return this.def;
   }

   public int getHp() {
      return this.hp;
   }

   public int getDamage() {
      return this.dmg;
   }

   public String getName() {
      return this.name;
   }

   public void turn(int attack, Monster b) { // turn for entities
      if (this.usedDef) { // check if def last turn
         this.defend(-2); // remove extra def
         this.usedDef = false; // flip variable;
      }
      if (attack == 1) {// if attack is chosen
         System.out.printf("%s Attacks!\n", this.name);
         if (b.getDefence() < Game.makeAttack(this.atk)) { // compare stats
            b.setHp(b.getHp() - this.dmg); // do damage
            System.out.printf("The attack succeeded! %s takes %d damage.\n", b.getName(), this.dmg);
         } else {
            System.out.println("The attack failed!");
         }
      } else {
         System.out.printf("%s Defends!\n", this.name); // if defend is chosen
         this.defend(2); // increase defence
         this.usedDef = true; // set defence to true
      }
   }

   public void printStats() {
      System.out.printf("%s: (HP: %d, DEF: %d, ATK: %d, DMG: %d)\n", name, hp, def, atk, dmg); // print default stats
   }

   public Monster(String name) { // constructor
      try {
         Scanner s = new Scanner(new File(name + ".txt")); // get stats from name.txt
         this.atk = s.nextInt(); // read stats
         this.def = s.nextInt();
         this.hp = s.nextInt();
         this.dmg = s.nextInt();
         this.name = name;
         s.close();
      } catch (Exception e) { // if error, inform and quit
         System.out.print("Error reading file!");
         System.exit(1);
      }
   }
}
