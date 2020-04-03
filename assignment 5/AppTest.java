package eg.edu.alexu.csd.datastructure.stack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	/**
	 * some invalid infix expressions that throw runtime exception
	 */
	void Invalid_Expressions_infix() {
		ExpressionEvaluator x=new ExpressionEvaluator();
		String str1 ="-5+-*6+5",
				str2="5+*9",
				str3="5---9+3/2",
				str4="8*9/2-";
		Assertions.assertThrows(RuntimeException.class,()->x.infixToPostfix(str1));
		Assertions.assertThrows(RuntimeException.class,()->x.infixToPostfix(str2));
		Assertions.assertThrows(RuntimeException.class,()->x.infixToPostfix(str3));
		Assertions.assertThrows(RuntimeException.class,()->x.infixToPostfix(str4));
		
	}
	@Test
	/**
	 * some invalid posfix expressions that throw runtime exception
	 */
	void Invalid_Expressions_postfix() {
		ExpressionEvaluator x=new ExpressionEvaluator();
		String str1 ="5+6+5",
				str2="5 +",
				str3="a 3 +",
				str4="+ 9",
				str5="6 2 / +";
		Assertions.assertThrows(RuntimeException.class,()->x.evaluate(str1));
		Assertions.assertThrows(RuntimeException.class,()->x.evaluate(str2));
		Assertions.assertThrows(RuntimeException.class,()->x.evaluate(str3));
		Assertions.assertThrows(RuntimeException.class,()->x.evaluate(str4));
		Assertions.assertThrows(RuntimeException.class,()->x.evaluate(str5));
		
	}
	@Test
	/**
	 * check the result of infixTopostfix method
	 */
	void valid_Expressions_instfix() {
		ExpressionEvaluator x=new ExpressionEvaluator();
		String str1 ="5+6+5",
				str2="5 +   9  - 3  ",
				str3="8 / a   ",
				str4="a / b - c + d * e - a * c",
				str5="a * b + 5",
				str6="(a/(b-c+d))*(e-a)*c";
		String r1="5 6 + 5 +",
				r2="5 9 + 3 -",
				r3="8 a /",
				r4="a b / c - d e * + a c * -",
				r5="a b * 5 +",
				r6="a b c - d + / e a - * c *";
		
		assertEquals(x.infixToPostfix(str1),r1);
		assertEquals(x.infixToPostfix(str2),r2);
		assertEquals(x.infixToPostfix(str3),r3);
		assertEquals(x.infixToPostfix(str4),r4);
		assertEquals(x.infixToPostfix(str5),r5);
		assertEquals(x.infixToPostfix(str6),r6);
		

		
	}
	@Test
	/**
	 * check the result of evaluate method
	 */
	void valid_Expressions_postfix() {
		ExpressionEvaluator x=new ExpressionEvaluator();
		String str1 ="6 2 / 3 - 4 2 * +", //   6/2 -3 +4*2
				str2="5 9 + 3 - ",       //  5+9-3
				str3="4 5 7 2 + - *",    //  4*(5-(7+2))
				str4="10 2 8 * + 3 -";   // 2*8 +10 -3
		assertEquals(x.evaluate(str1),8);
		assertEquals(x.evaluate(str2),11);
		assertEquals(x.evaluate(str3),-16);
		assertEquals(x.evaluate(str4),23);
		

		
	}
	
	
	

}
