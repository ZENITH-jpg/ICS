/*
 *Name: Tristan Cao
 *Date: 02-24-2024
 *Teacher: Mr. Guglielmi
 *Description: The goblin subclass for monster
 */
public class Goblin extends Monster {
   public Goblin() {
      super("Goblin"); // read from file Goblin.txt
   }

   @Override
   public void turn(int attack, Monster b) { // goblin's turn with special action
      super.turn(attack, b);
      if (Game.getRandom().nextInt(4) == 3) { // conditions for action
         System.out.printf("%s uses [Speedy] ability!\n", super.getName());
         if (b.getDefence() < Game.makeAttack(super.getAttack())) { // attack
            b.setHp(b.getHp() - super.getDamage());
            System.out.printf("The attack succeeded! %s takes %d damage.\n", b.getName(), super.getDamage());
         } else {
            System.out.println("The attack failed!");
         }
      }
   }

   @Override
   public void printStats() { // prints goblin stats and ability info
      super.printStats();
      System.out.println("Ability: [Speedy], 1/3 chance to preform an attack after first action.");
   }
}