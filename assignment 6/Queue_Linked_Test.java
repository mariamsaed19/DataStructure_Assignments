package eg.edu.alexu.csd.datastructure.queue;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Queue_Linked_Test {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void enqueue_dequeue() {
		Object[]result= {5,6,7,8,9};
		Queue x=new Queue();
		x.enqueue(5);
		x.enqueue(6);
		x.enqueue(7);
		x.enqueue(8);
		x.enqueue(9);
		assertEquals(5,x.size());
		for(int i=0;i<result.length;i++) {
			assertEquals(result[i],x.dequeue());
		}
		assertEquals(0,x.size());
		
	}

	@Test
	public void deQueue() {
		Queue x=new Queue();
		x.enqueue("x");
		x.enqueue(6);
		x.enqueue(99);
		x.enqueue(89);
		x.enqueue("asd");
		assertEquals(5,x.size());
		Object z=x.dequeue();
		assertEquals("x",z);
		assertEquals(4,x.size());
		
	}
	@Test
	public void deQueue2() {
		Queue x=new Queue();
		x.enqueue(null);
		x.enqueue(6);
		assertEquals(2,x.size());
		Object z=x.dequeue();
		assertEquals(null,z);
		assertEquals(1,x.size());
		
	}
	@Test
	public void deQueue3() {
		Queue x=new Queue();
		x.enqueue(9);
		x.enqueue(6);
		assertEquals(2,x.size());
		x.dequeue();
		x.enqueue(8);
		x.enqueue(10);
		x.dequeue();
		Object[]result= {8,10};
		for(int i=0;i<2;i++) {
			assertEquals(result[i],x.dequeue());
		}
		assertEquals(0,x.size());
		
		
	}
	@Test
	public void isEmpty() {
		Queue x=new Queue();
		assertEquals(true,x.isEmpty());
		
	}
	@Test
	public void isEmpty2() {
		Queue x=new Queue();
		x.enqueue("x");
		x.enqueue(6);
		x.enqueue(99);
		x.enqueue(89);
		assertEquals(false,x.isEmpty());
		x.dequeue();
		x.dequeue();
		x.dequeue();
		x.dequeue();
		assertEquals(true,x.isEmpty());
		
	}
	@Test(expected=NoSuchElementException.class)
	public void emptyQueue() {
		Queue x=new Queue();
		x.enqueue("x");
		x.enqueue(6);
		x.enqueue(99);
		x.enqueue(89);
		x.enqueue("asd");
		assertEquals(5,x.size());
		for(int i=0;i<5;i++) {
			x.dequeue();
		}
		assertEquals(0,x.size());
		x.dequeue();
		
	}
	@Test(expected=NoSuchElementException.class)
	public void emptyQueue2() {
		Queue x=new Queue();
		assertEquals(0,x.size());
		x.dequeue();
		
	}
	
	

}
