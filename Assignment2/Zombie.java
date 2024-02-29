/*
 *Name: Tristan Cao
 *Date: 02-24-2024
 *Teacher: Mr. Guglielmi
 *Description: The zombie subclass for monster
 */
public class Zombie extends Monster {
   public Zombie() {
      super("Zombie"); // read from file Zombie.txt
   }

   @Override
   public void turn(int attack, Monster b) { // zombies turn with special action
      super.turn(attack, b);
      if (super.getHp() < 5 && Game.getRandom().nextInt(5) == 4) { // conditions for action
         System.out.printf("%s uses [Undead] ability!\n", super.getName());
         super.setHp(6);
      }
   }

   @Override
   public void printStats() { // prints zombies stats and ability info
      super.printStats();
      System.out.println("Ability: [Undead], 1/4 chance to heal health to 6 if it is currently under 5.");
   }
}