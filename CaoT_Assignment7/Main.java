/* Author: Tristan Cao
Date: 28/04/2024
Description: Main class that runs the program. Things must be fixed so this works
*/
public class Main{
   public static void main (String[] args){
   	Term t[] = {new Term (3, 2), new Term (2, 1), new Term (3, 3), new Term (4, 2)};
   	Polynomial p = new Polynomial (t);
   	System.out.println (p.toString());
   	System.out.println (p.evaluate (1));
   	p.sortPoly();
   	System.out.println (p.toString());
   	System.out.printf ("%s is a greater term than %s: ", t[0].toString(), t[1].toString());
   	System.out.println (t[0].isGreater(t[1]));
   	System.out.printf ("%s is a greater term than %s: ", t[0].toString(), t[3].toString());
   	System.out.println (t[0].isGreater(t[3]));
   	System.out.printf ("%s is a greater term than %s: ", t[2].toString(), t[0].toString());
   	System.out.println (t[2].isGreater(t[0]));
   }
}
