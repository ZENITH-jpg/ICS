/*
 *Name: Tristan Cao
 *Date: 02-24-2024
 *Teacher: Mr. Guglielmi
 *Description: 
*/
public class Goblin extends Monster{
   public Goblin(){
      super("Goblin");
   }
   @Override
   public void turn(int attack, Monster b){
      super.turn(attack,b);
      if(Game.getRandom().nextInt(4) == 3){
         System.out.printf("%s uses [Speedy] ability! Preforms an attack after first action.\n", super.getName());
         if(b.getDefence() < Game.makeAttack(super.getAttack())){
            b.setHp(b.getHp() - super.getDamage());
            System.out.printf("The attack succeeded! %s takes %d damage.\n",b.getName(), super.getDamage());
         }else{
            System.out.println("The attack failed!");
         }
      }
   }
}