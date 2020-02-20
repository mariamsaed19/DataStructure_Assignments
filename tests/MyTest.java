package m;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.*;

public class MyTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	Calculator d=new Calculator();
	//Test cases for addition
	@Test
	public void test1() {
		
		assertEquals(11,d.add(5,6));

	}
	@Test
	public void test2() {
		assertEquals(0,d.add(5,-5));

	}
	@Test
	public void test3() {
		assertEquals(1,d.add(-6,7));
	
	}
	
	@Test
	public void test4() {
		assertEquals(7,d.add(-6*0,7));
	
	}
	
	@Test
	public void test5() {
		assertEquals(-6,d.add(-6,7*0));
	
	}
	@Test
	public void test6() {
		assertEquals(0,d.add(0*6,0*7));
	
	}
	
	// Test cases for division
	
	@Test(expected=java.lang.RuntimeException.class)
	public void test7() {
	  d.divide(10,0);
	}
	@Test(expected=java.lang.RuntimeException.class)
	public void test8() {
	  d.divide(10,5*0);
	}
	@Test
	public void test9() {
		float z = d.divide(5, 2);
		int x =5;
		int y=2;
		float expected =(float)x/y;
	    assertTrue(expected==z);
	}
	@Test
	public void test10() {
		float z = d.divide(0, 2);
		float expected =0;
	    assertTrue(expected==z);
	}
	@Test
	public void test11() {
		float z = d.divide(-5, 2);
		int x =-5;
		int y=2;
		float expected =(float)x/y;
	    assertTrue(expected==z);
	}
	@Test
	public void test12() {
		float z = d.divide(9,-3);
		int x =9;
		int y=-3;
		float expected =(float)x/y;
	    assertTrue(expected==z);
	}
	@Test
	public void test13() {
		float z = d.divide(-35, -5);
		int x =-35;
		int y=-5;
		float expected =(float)x/y;
	    assertTrue(expected==z);
	}
	
}
