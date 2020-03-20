package eg.edu.alexu.csd.datastructure.linkedList.cs76_cs88;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Assert;
import org.junit.Test;


public class Polytest {

	
	@Test
	public void test() {
		 Polynomial poly = new Polynomial();
	        int[][] test1 = {{3, 7}, {45, 5}, {176, 3}, {128, 1}};
	        int[][] test2 = {{-120, 5}, {-1, 3}, {27, 2}, {1, 1}, {-1, 0}};
	        poly.setPolynomial('C',
	                test1);
	        poly.setPolynomial('B',
	                test2);
	        int[][] result1 = poly.add('B', 'C');
	        int[][] expected = {
	            {3, 7}, {-75, 5}, {175, 3}, {27, 2}, {129, 1}, {-1, 0}
	        };
	        assertArrayEquals(expected, result1);
	}

	@Test
	 public void testAdd() {
        Polynomial poly = new Polynomial();
        int[][] test1 = {{1, 2}, {1, 3}, {1, 4}};
        int[][] test2 = {{2, 2}, {2, 3}, {2, 4}};
        poly.setPolynomial('A', test1);
        poly.setPolynomial('B', test2);
        int[][] result = poly.add('A', 'B');
        int[][] expected = {
            {3, 4}, {3, 3}, {3, 2}
        };
        assertArrayEquals(expected, result);
    }
	@Test
	 public void testSubtract() {
        Polynomial poly = new Polynomial();
        int[][] test1 = {{1, 2}, {1, 3}, {1, 4}};
        int[][] test2 = {{1, 2}, {1, 3}, {1, 4}};
        poly.setPolynomial('A', test1);
        poly.setPolynomial('B', test2);
        int[][] result = poly.subtract('A', 'B');
        int[][] expected = {
            {0, 0}
        };
        assertArrayEquals(expected, result);
    }
	@Test
	 public void testSubtract2() {
        Polynomial poly = new Polynomial();
        int[][] test1 = {{1, 5}, {1, 6}, {1, 7}};
        int[][] test2 = {{1, 2}, {1, 3}, {1, 4}};
        poly.setPolynomial('A', test1);
        poly.setPolynomial('B', test2);
        int[][] result = poly.subtract('A', 'B');
        int[][] expected = {
            {1, 7}, {1, 6}, {1, 5}, {-1, 4}, {-1, 3}, {-1, 2}
        };
        assertArrayEquals(expected, result);
    }
 
	 @Test
	    public void testMultiply() {
	        Polynomial poly = new Polynomial();
	        int[][] test1 = {{1, 5}, {1, 6}, {1, 7}};
	        int[][] test2 = {{1, 2}};
	        poly.setPolynomial('A', test1);
	        poly.setPolynomial('B', test2);
	        int[][] result = poly.multiply('A', 'B');
	        int[][] expected = {
	            {1, 9}, {1, 8}, {1, 7}
	        };
	        assertArrayEquals(expected, result);
	    }

	@Test
	 public void testMultiply2() {
        Polynomial poly = new Polynomial();
        int[][] test1 = {{1, 5}, {1, 6}, {1, 7}};
        final int[][] test2 = {{10, 1}};
        poly.setPolynomial('A', test1);
        poly.setPolynomial('B', test2);
        int[][] result = poly.multiply('A', 'B');
        int[][] expected = {
            {10, 8}, {10, 7}, {10, 6}
        };
        assertArrayEquals(expected, result);
    }

	@Test
	 public void testSet() {
        Polynomial poly = new Polynomial();
        int[][] test1 = {{7, 25}, {1, 8}, {3, 9}};
        int[][] test2 = {{2, 3}};
        poly.setPolynomial('A', test1);
        poly.setPolynomial('A', test2);
        int[][] result = new int[][]{{2, 3}};
        int[][] expected = {
            {2, 3}
        };
        assertArrayEquals(expected, result);
    }

	
	 @Test
	    public void testEvaluate() {
	        Polynomial poly = new Polynomial();
	        int[][] test1 = {{3, 7}, {45, 5}, {176, 3}, {128, 1}};
	        poly.setPolynomial('B', test1);
	        float result = poly.evaluatePolynomial('B',5);
	        float expected = (float) 397640.0;
	        assertEquals(expected, result);
	    }

	 @Test
	    public void testEvaluate2() {
	        Polynomial poly = new Polynomial();
	        int[][] test1 = {{-120, 5}, {-1, 3}, {27, 2}, {1, 1}, {-1, 0}};
	        poly.setPolynomial('B', test1);
	        float result = poly.evaluatePolynomial('B',5);
	        float expected = (float) -374446.0;
	        assertEquals(expected, result);
	    }
	 
	 @Test
	    public void testEvaluate3() {
	        Polynomial poly = new Polynomial();
	        int[][] test1 = {{5, 25}, {1, 8}, {3, 9}};
	        poly.setPolynomial('B', test1);
	        float result = poly.evaluatePolynomial('B',2);
	        float expected = (float) (5*Math.pow(2, 25)+Math.pow(2, 8)+3*Math.pow(2, 9));
	        assertEquals(expected, result);
	    }
	

	 @Test
	    public void testprint() {
	        Polynomial poly = new Polynomial();
	        int[][] test1 = {{3, 7}, {45, 5}, {176, 3}, {128, 1}};
	        poly.setPolynomial('B', test1);
	        String result = poly.print('B');
	        String expected = "3x^7+45x^5+176x^3+128x";
	        assertEquals(expected, result);
	    }
	 

	 @Test
	    public void testprint2() {
	        Polynomial poly = new Polynomial();
	        int[][] test1 = {{3, 0}, {45, 7}, {176, 3}, {128, 1}};
	        poly.setPolynomial('C', test1);
	        String result = poly.print('C');
	        String expected = "45x^7+176x^3+128x+3";
	        assertEquals(expected, result);
	    }
	 @Test
	    public void testprint3() {
	        Polynomial poly = new Polynomial();
	        int[][] test1 = {{3, 1}, {1, 7}, {0, 2}, {5,0}};
	        poly.setPolynomial('C', test1);
	        String result = poly.print('C');
	        String expected = "x^7+3x+5";
	        assertEquals(expected, result);
	    }
	 @Test
	    public void testprint4() {
	        Polynomial poly = new Polynomial();
	        int[][] test1 = {{1, 2}, {2, 4}, {3, 6}};
	        poly.setPolynomial('C', test1);
	        String result = poly.print('C');
	        String expected = "3x^6+2x^4+x^2";
	        assertEquals(expected, result);
	    }


	@Test(expected = Exception.class)
	  public void testclear() {
        Polynomial poly = new Polynomial();
        int[][] test1 = {{3, 0}, {45, 7}, {176, 3}, {128, 1}};
        poly.setPolynomial('C', test1);
        poly.clearPolynomial('C');
        Assert.assertTrue(poly.Clinked.isEmpty());
        Assert.assertEquals(0,poly.Clinked.size());
        Assert.assertNull(poly.Clinked.get(0));
    }
}