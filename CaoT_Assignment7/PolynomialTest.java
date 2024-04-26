import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class PolynomialTest {

   Polynomial p;
   @Before public void setUp() {
      Term[] arr = new Term[5];
      arr[0] = new Term(1,2);
      arr[1] = new Term(2,1);
      arr[2] = new Term(1,3);
      arr[3] = new Term(5,5);
      arr[4] = new Term(-4,2);
      p = new Polynomial(arr);
   }


   @Test public void evaluateTest() {
      Assert.assertEquals(5, p.evaluate(1));
      Assert.assertEquals(160, p.evaluate(2));
      Assert.assertEquals(-11, p.evaluate(-1));
   }

   @Test public void swapTest(){
      p.sortPoly();
      Assert.assertTrue("Expected 5x^5 + 1x^3 + 1x^2 + -4x^2 + 2x^1, got "+ p,p.toString().equals("5x^5 + 1x^3 + 1x^2 + -4x^2 + 2x^1"));
   }

   @Test public void testAdd(){
      Term a = new Term(1,10);
      p.addTerm(a);
      Assert.assertEquals(p.getOrder(),10);
   }
}
