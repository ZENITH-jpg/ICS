import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class TermTest {

   Term a,b,c,d,e;
   @Before public void setUp() {
      a = new Term(1,2);
      b = new Term(2,1);
      c = new Term(1,3);
      d = new Term(5,5);
      e = new Term(-4,2);
   }
   @Test public void toStringTest(){
      Assert.assertTrue("Should have recieved 1x^2 got " + a.toString() + " instead", "1x^2".equals(a.toString()));
      Assert.assertTrue("Should have recieved -4x^2 got " + a.toString() + " instead", "-4x^2".equals(e.toString()));
      Assert.assertTrue("Should have recieved 5x^5 got " + a.toString() + " instead", "5x^5".equals(d.toString()));
   }
   @Test public void isGreaterTest() {
      Assert.assertTrue("recieved x^2 <= 2x",a.isGreater(b));
      Assert.assertTrue("recieved x^3 <= x^2",c.isGreater(a));
      Assert.assertTrue("recieved x^2 <= -4x^2",a.isGreater(e));
      Assert.assertFalse("recieved x^2 > x^2",a.isGreater(a));
      Assert.assertFalse("recieved -4x^2 > x^3",e.isGreater(c));
   }
   @Test public void evaluateTest(){
      Assert.assertEquals(160,d.evaluate(2));
      Assert.assertEquals(-4,e.evaluate(1));
      Assert.assertEquals(81,a.evaluate(9));

   }
}
