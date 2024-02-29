/*
 *Name: Tristan Cao
 *Date: 02-14-2024
 *Teacher: Mr. Guglielmi
 *Description: Game class for project, has loop logic for the game and accessors
 */

import java.util.Scanner; // import classes
import java.util.Random;

public class Game {
   private Monster m; // player and monsters stored in superclass monster
   private Monster p;

   private static Scanner s; // input
   private static Random r; // random

   public Game() {
      p = new Monster("Player"); // make new instance of player
      m = new Zombie(); // make new instance of zombie

      s = new Scanner(System.in); // set up scanner and random
      r = new Random();
   }

   public void beginGame() {
      int[] order = {1, 2, 4, 3, 4, 2, 1, 2, 4, 3}; // order of monsters 1 = zombie, 2 = goblin, 4 = golem, 3 = wizard
      int turn = 1; // odd for player even for monster
      int curMon = 1; // variable for index of current monster
      while (p.getHp() > 0 && m.getHp() > 0) { // while either entity health > 0 continue loop
         System.out.printf("TURN %d: %s is at %d health and %s is at %d health.\n",
               turn, p.getName(), p.getHp(), m.getName(), m.getHp());  // print turn info
         if (turn % 2 == 0) { // monster turn
            m.turn(Game.chooseAttack(), p); // preform action
         } else { // player turn
            System.out.print("Enter 1 to attack, 2 to defend, and 3 to display stats: ");
            int in = input(3); // get input
            while (in == 3) { // loop until player preform non stat checking action
               m.printStats();
               p.printStats();
               System.out.print("Enter 1 to attack, 2 to defend, and 3 to display stats: ");
               in = input(3);
            }
            p.turn(in, m); // preform action
         }
         turn++; // increment turn
         if (m.getHp() <= 0) { // if monster has died
            System.out.printf("%s has been slain, %s has been healed by 4 health.\n", m.getName(), p.getName());
            // announce monster defeat
            p.setHp(p.getHp() + 4); // increase health by 4
            System.out.print("Continue game? 1 = yes, 2 = no: "); // give player continue option
            if (input(2) == 1) { // continue
               curMon++; // move to next monster
               if (curMon < 9) { // check if there is still a monster to fight
                  switch (order[curMon]) { // switch to choose monster
                     case 1:
                        m = new Zombie(); // spawn new monsters
                        break;
                     case 2:
                        m = new Goblin();
                        break;
                     case 3:
                        m = new Wizard();
                        break;
                     case 4:
                        m = new Golem();
                        break;
                  }
                  System.out.printf("%s has been awoken!\n", m.getName()); // announce new monster encounter
                  turn = 1; // reset turns
               }
            }
         }
         System.out.println(); // return line for spacing reasons
      }
      if (p.getHp() > 0) // after exit game, check if player wins or loses
         System.out.println("Player Wins.");
      else
         System.out.println("Player Loses.");
   }

   private static int input(int x) { // input method
      int in; // store input
      do {
         in = s.nextInt(); // get input
         if (in < 1 || in > x) { // check if in correct range (1-x)
            in = -1;
            System.out.println("Input must be an integer from 1 to " + x); // if not in range, re-get input
         }
      } while (in == -1);
      return in; // return input
   }

   private static int chooseAttack() {
      return r.nextInt(2) + 1; // pick random int 1-2
   }

   public static int makeAttack(int atk) {
      return atk + r.nextInt(20) + 1; // pick random int 1-20 add it to atk
   }

   public static Random getRandom() { // returns random instance
      return r;
   }
}