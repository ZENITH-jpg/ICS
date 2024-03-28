import java.util.Scanner;
public class Main{
   static Scanner s;
   static Roster r;
   public static void main(String[] args){
      s = new Scanner(System.in);
      System.out.println("Input file to read players from");
      r = new Roster(s.nextLine());
      System.out.println("Roster before changes: ");
      r.display();
      System.out.println("Type 1 if you want to sort roster by goals and any other key if you want to sort by points");
      if(s.nextLine().equals("1")) r.sort(1);
      else r.sort(2);
      System.out.println("Roster after changes: ");
      r.display();
   }
}