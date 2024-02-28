/*
 *Name: Tristan Cao
 *Date: 02-24-2024
 *Teacher: Mr. Guglielmi
 *Description: 
*/
public class Zombie extends Monster{
   public Zombie(){
      super("Zombie");
   }
   @Override
   public void turn(int attack, Monster b){
      super.turn(attack,b);
      if(super.getHp()<5 && Game.getRandom().nextInt(5) == 4){
         System.out.printf("%s uses [Undead] ability! 1/4 chance to heal health to 6 if it is under 5.\n", super.getName());
         super.setHp(6);
      }
   }
}