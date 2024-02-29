/*
 *Name: Tristan Cao
 *Date: 02-24-2024
 *Teacher: Mr. Guglielmi
 *Description: The golem subclass for monster
 */
public class Golem extends Monster {
   private boolean abilityUsed;

   public Golem() {
      super("Golem"); // read from file Golem.txt
      this.abilityUsed = false;
   }

   @Override
   public void defend(int x) { // golem's turn with special action
      if (Game.getRandom().nextInt(6) == 5 && x > 0) { // conditions for ability
         System.out.printf("%s uses [Rock Shell] ability!\n", super.getName());
         super.setHp(super.getHp() + 2);
         this.abilityUsed = true;
         super.defend(1);
      } else if (this.abilityUsed) {
         super.defend(-1);
         this.abilityUsed = false;
      }
      super.defend(x);
   }

   @Override
   public void printStats() { // prints golem stats and ability info
      super.printStats();
      System.out.println("Ability: [Rock Shell], 1/5 chance to defend by 1 more point and increase hp by 2.");
   }
}