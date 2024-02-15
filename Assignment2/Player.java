/*
 *Name: Tristan Cao
 *Date: 02-12-2024
 *Teacher: Mr. Guglielmi
 *Description: 
*/
import java.util.Scanner;
import java.util.Random;
public class Player extends Monster{
   public Player(){
      super.atk = 6;
      super.def = 16;
      super.hp = 15;
      super.dmg = 4;
      super.r = new Random();
   }
}
