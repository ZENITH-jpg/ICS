/*
 *Name: Tristan Cao
 *Date: 02-24-2024
 *Teacher: Mr. Guglielmi
 *Description:
 */
public class Golem extends Monster{
    private boolean abilityUsed;
    public Golem(){
        super("Golem");
        this.abilityUsed = false;
    }
    @Override
    public void defend(int x){
        if(Game.getRandom().nextInt(6) == 5 && x > 0){
            System.out.printf("%s uses [Rock Shell] ability! 1/5 chance to defend by 1 more point and increase hp by 2.\n", super.getName());
            super.setHp(super.getHp()+2);
            this.abilityUsed = true;
            super.defend(1);
        }else if(this.abilityUsed){
            super.defend(-1);
            this.abilityUsed = false;
        }
        super.defend(x);
        System.out.println(super.getDefence());
    }
}