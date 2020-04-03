package eg.edu.alexu.csd.datastructure.stack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StackTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	/**
	 * test for peek and pop in empty stack
	 */
	void EmptyStack() {
		Stack s = new Stack();
		Assertions.assertThrows(RuntimeException.class,()->s.pop());
		Assertions.assertThrows(RuntimeException.class,()->s.peek());
	}
	@Test
	/**
	 * check function of size 
	 */
	void SizeofStack() {
		Stack s = new Stack();
		s.push(5);
		s.push(9);
		s.push("iu");
		s.push("5*9");
		assertEquals(4,s.size());
	}
	@Test
	/**
	 * check pop ,peek and size
	 */
	void peek_pop() {
		Stack s = new Stack();
		s.push(5);
		s.push(9);
		s.push("iu");
		s.push("5*9");
		assertEquals("5*9",s.peek());
		assertEquals("5*9",s.pop());
		assertEquals("iu",s.peek());
		assertEquals(3,s.size());
	}
	@Test
	/**
	 * check IsEmpty
	 */
	void isEmpty() {
		Stack s = new Stack();
		assertEquals(true,s.isEmpty());
		s.push(5);
		s.push(9);
		s.push("iu");
		s.push("5*9");
		s.push(88);
		assertEquals(false,s.isEmpty());
	}
	@Test
	/**
	 * check push and whether the elements in correct order or not
	 */
	void push() {
		Stack s = new Stack();
		s.push(5);
		s.push(9);
		s.push(10);
		s.push(11);
		s.push(88);
		int[] arr= {88,11,10,9,5};
		for(int i=0;i<arr.length;i++) {
		assertEquals(arr[i],s.pop());
		}
		assertEquals(0,s.size());
	}
	
	
	

}
