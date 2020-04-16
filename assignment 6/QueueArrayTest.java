package eg.edu.alexu.csd.datastructure.queue;


import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class QueueArrayTest {

	@Test
	public void test1() {
		IQueue q = new QueueArray(10);
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		q.enqueue(6);
		Assert.assertEquals(6, q.size());
	}

	@Test
	public void test2() {
		IQueue q = new QueueArray(10);
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		q.enqueue("hello");
		Assert.assertEquals(1, q.dequeue());
		Assert.assertEquals(2, q.dequeue());
		Assert.assertEquals(3, q.dequeue());
		Assert.assertEquals(4, q.dequeue());
		Assert.assertEquals(5, q.dequeue());
		Assert.assertEquals("hello", q.dequeue());
		Assert.assertEquals(0, q.size());
	}

	@Test
	public void test3() {
		IQueue q = new QueueArray(10);
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.dequeue();
		Assert.assertEquals(2, q.size());
		q.enqueue(4);
		q.enqueue(5);
		q.enqueue(6);
		q.dequeue();
		q.dequeue();
		Assert.assertEquals(3, q.size());
	}

	@Test
	public void test4() {
		IQueue q = new QueueArray(10);
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.dequeue();
		q.enqueue(4);
		q.dequeue();
		q.dequeue();
		q.dequeue();
		boolean x = false;
		try {
			q.dequeue();
		    x= true;
		} catch (Exception e) {
			x = false;
		}
		Assert.assertFalse(x);
	}

	@Test
	public void test5() {
		IQueue q = new QueueArray(10);
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.dequeue();
		q.enqueue(4);
		q.dequeue();
		q.dequeue();
		q.dequeue();
		Assert.assertTrue(q.isEmpty());
	}

	@Test
	public void test6() {
		IQueue q = new QueueArray(10);
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.dequeue();
		q.enqueue(4);
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.enqueue(1);
		Assert.assertTrue(!q.isEmpty());
	}

	@Test
	public void test7() {
		IQueue q = new QueueArray(10);
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		q.enqueue(6);
		q.enqueue(7);
		q.enqueue(8);
		q.enqueue('h');
		q.enqueue("hello");
		Assert.assertEquals(10, q.size());
	}

	@Test
	public void test8() {
		IQueue q = new QueueArray(10);
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		q.enqueue(6);
		q.enqueue(7);
		q.enqueue(8);
		q.enqueue(9);
		q.enqueue(10);
		boolean x = false;
		try {
			q.enqueue(1);
			x = true;
		} catch (Exception e) {
			x = false;
		}
		Assert.assertFalse(x);
	}

	@Test
	public void test9() {
		IQueue q = new QueueArray(10);
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		q.enqueue(6);
		q.enqueue(7);
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.enqueue(8);
		q.enqueue(9);
		q.enqueue(10);
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.dequeue();
		q.dequeue();
		q.enqueue(4);
		q.enqueue(3);
	}

	@Test
	public void test10() {
		IQueue q = new QueueArray(10);
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		q.enqueue(6);
		q.enqueue(7);
		q.enqueue(8);
		q.enqueue(9);
		q.enqueue(10);
		q.dequeue();
		q.dequeue();
		q.enqueue(1);
		q.enqueue(2);
		Assert.assertFalse(q.isEmpty());
	}

}
