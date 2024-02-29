/*
 *Name: Tristan Cao
 *Date: 02-24-2024
 *Teacher: Mr. Guglielmi
 *Description: The wizard subclass for monster
 */
public class Wizard extends Monster {
   private int mana; // new mana field

   public Wizard() {
      super("Wizard"); // get stats from Wizard.txt
      this.mana = 0; // set mana to zero
   }

   @Override
   public void turn(int attack, Monster m) {
      this.mana++; // increase mana
      System.out.printf("%s's mana is at %d/3.\n", super.getName(), this.mana);
      if (this.mana == 3) { // ability if mana = 3
         this.mana = 0; // reset mana
         int a = Game.getRandom().nextInt(3); //get int 1-3
         System.out.printf("%s uses [Magic Ability], ", super.getName());
         if (a == 0) {
            System.out.printf("%s heals 5 HP\n", super.getName()); // heal hp
            super.setHp(super.getHp() + 5);
         } else if (a == 1) {
            System.out.printf("%s does 5 damage\n", super.getName()); // do damage
            m.setHp(m.getHp() - 5);
         } else {
            System.out.printf("%s increases defence by 3 forever\n", super.getName()); // increase def
            defend(3);
         }
      }
      super.turn(attack, m); // do normal attack
   }

   @Override
   public void printStats() { // prints wizard stats and ability info
      super.printStats();
      System.out.println("Ability: [Magic Ability], Preforms a random magic ability when mana reaches 3");
   }
}