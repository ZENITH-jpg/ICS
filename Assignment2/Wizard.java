/*
 *Name: Tristan Cao
 *Date: 02-24-2024
 *Teacher: Mr. Guglielmi
 *Description:
 */
public class Wizard extends Monster{
    private int mana;
    public Wizard(){
        super("Wizard");
        this.mana = 0;
    }
    @Override
    public void turn(int attack, Monster m){
        this.mana ++;
        System.out.printf("%s's mana is at %d/3. When it reaches 3/3 %s will preform a magic attack\n", super.getName(),this.mana, super.getName());
        if(this.mana == 3){
            this.mana = 0;
            int a = Game.getRandom().nextInt(3);
            if(a == 0){
                System.out.printf("%s heals 5 HP\n", super.getName());
                super.setHp(super.getHp()+5);
            }else if(a == 1){
                System.out.printf("%s does 5 damage\n", super.getName());
                m.setHp(m.getHp()-5);
            }else{
                System.out.printf("%s increases defence by 3 forever\n", super.getName());
                defend(3);
            }
        }
        super.turn(attack,m);
    }

}