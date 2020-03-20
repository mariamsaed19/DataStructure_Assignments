package eg.edu.alexu.csd.datastructure.linkedList.cs76_cs88;

import org.junit.Assert;
import org.junit.Test;


public class Singletest {

	// Add nodes and check list.
	@Test
	public void addNodes() {
		ILinkedList list = new SingleLinked();
		 int zero = 0;
		 int first = 1;
		 int second = 2;
		 int third = 3;
		 int fourth = 4;
		 int fifth = 5;
		 int sixth = 6;
		list.add(first);
		list.add(second);
		list.add(third);
		list.add(fourth);
		list.add(fifth);
		list.add(sixth);
		for (int i = zero; i < sixth; i++) {
			 int number = (int) list.get(i);
			Assert.assertEquals(i + first, number);
		}}

	 // Insert Node at the middle of List.	 
	@Test
	public void insertInMiddle() {
		ILinkedList list = new SingleLinked();
		 int zero = 0;
		 int first = 1;
		 int second = 2;
		 int third = 3;
		 int fourth = 4;
		 int fifth = 5;
		 int sixth = 6;
		list.add(zero, first);
		list.add(first, third);
		list.add(second, fourth);
		list.add(third, fifth );
		list.add(fourth, sixth);
		list.add(first, second);

		for (int i = zero; i < sixth; i++) {
			 int number = (int) list.get(i);
			Assert.assertEquals(i + first, number);
		}}


	 // Insert a node at the end of the list.
	@Test
	public void insertAtEnd() {
		ILinkedList list = new SingleLinked();
		final int zero = 0;
		final int first = 1;
		final int second = 2;
		final int third = 3;
		final int fourth = 4;
		final int fifth = 5;
		final int sixth = 6;
		final int seventh = 7;
		list.add(zero, first);
		list.add(first, second);
		list.add(second, third);
		list.add(third, fourth);
		list.add(fourth, fifth);
		list.add(sixth);
		list.add(seventh);

		for (int i = zero; i < seventh; i++) {
			 int number = (int) list.get(i);
			Assert.assertEquals(i + first, number);
		}}

	
	 // change a value of a node. 
	@Test(expected = Exception.class)
	public void changeNodeValue() {
		ILinkedList list = new SingleLinked();
		 int zero = 0;
		 int first = 1;
		 int second = 2;
		 int third = 3;
		 int fourth = 4;
		 int fifth = 5;
		 int sixth = 7;
		list.add(zero, first);
		list.add(first, third);
		list.add(second, third);
		list.add(third, fourth);
		list.add(fourth, fourth);

		list.set(first, second);
		 int num = (int) list.get(first);
		Assert.assertEquals(second, num);

		list.set(sixth, fifth);
		for (int i = zero; i < fifth; i++) {
			 int number = (int) list.get(i);
			Assert.assertEquals(i + first, number);
		}}

	
	 // removing an element and check to see if size decreased.
	@Test
	public void removeAndCheckSize() {
		ILinkedList list = new SingleLinked();
		 int zero = 0;
		 int first = 1;
		 int second = 2;
		 int third = 3;
		 int fourth = 4;
		 int fifth = 5;

		list.add(zero, first);
		list.add(first, second);
		list.add(second, third);
		list.add(third, fourth);
		list.add(fourth, fifth);
		list.remove(first);
		list.remove(third);
		 int size = list.size();
		Assert.assertEquals(third, size);
	}

	 // Remove all elements one by one.
	@Test
	public void removeAllElements() {
		ILinkedList list = new SingleLinked();
		 int zero = 0;
		 int first = 1;
		 int second = 2;
		 int third = 3;
		 int forth = 4;
		 int fifth = 7;
		list.add(first);
		list.add(second);
		list.add(third);
		list.add(forth);
		list.add(fifth);

		list.remove(forth);
		list.remove(third);
		list.remove(second);
		list.remove(first);
		list.remove(zero);
		 int size = list.size();
		Assert.assertEquals(zero, size);
	}

	 // Remove first Node.
	@Test
	public void removeFirst() {
		ILinkedList list = new SingleLinked();
		 int zero = 0;
		 int first = 1;
		 int second = 2;
		 int third = 3;
		 int fourth = 4;
		 int fifth = 5;
		list.add(zero, first);
		list.add(first, second);
		list.add(second, third);
		list.add(third, fourth);
		list.add(fourth, fifth);

		list.remove(zero);
		 int size = list.size();
		Assert.assertEquals(fourth, size);

		 int numb = (int) list.get(zero);
		Assert.assertEquals(second, numb);
	}

	 // Remove last Node.
	@Test
	public void removeLast() {
		ILinkedList list = new SingleLinked();
		 int zero = 0;
		 int first = 1;
		 int second = 2;
		 int third = 3;
		 int fourth = 4;
		 int fifth = 5;
		list.add(zero, first);
		list.add(first, second);
		list.add(second, third);
		list.add(third, fourth);
		list.add(fourth, fifth);

		list.remove(fourth);

		Assert.assertEquals(fourth, list.size());
		Assert.assertEquals(fourth, list.get(third));
	}

	 // Remove a non-existing Node.
	@Test(expected = Exception.class)
	public void removeNENode() { // NE = Non-Existing
		ILinkedList list = new SingleLinked();
		 int zero = 0;
		 int first = 1;
		 int second = 2;
		 int third = 3;
		 int fourth = 4;
		 int fifth = 5;
		 int negative = -1;
		list.add(zero, first);
		list.add(first, second);
		list.add(second, third);
		list.add(third, fourth);
		list.add(fourth, fifth );

		list.remove(negative);

		Assert.assertEquals(fifth , list.size());
	}

	 // removing a node that is not included in list boundaries.
	@Test
	public void removeNodeOFB() { // OFB = Out of Boundaries
		ILinkedList list = new SingleLinked();
		 int zero = 0;
		 int first = 1;
		 int second = 2;
		 int third = 3;
		 int fourth = 4;
		 int fifth = 5;
		list.add(zero, first);
		list.add(first, second);
		list.add(second, third);
		list.add(third, fourth);
		list.add(fourth, fifth);

		list.remove(first);

		Assert.assertEquals(fourth, list.size());
	}

	 // test contain function.
	@Test
	public void containFun() { // OFB = Out of Boundaries
		ILinkedList list = new SingleLinked();
		 int zero = 0;
		 int first = 1;
		 int second = 2;
		 int third = 3;
		 int fourth = 4;
		 int fifth = 5;
		 int sixth  = 20;
		list.add(zero, first);
		list.add(first, second);
		list.add(second, third);
		list.add(third, fourth);
		list.add(fourth, fifth );

		Assert.assertTrue(list.contains(first));
		Assert.assertTrue(!list.contains(sixth));
	}

	
	 // Choosing sublist out of the boundaries of original list.
	@Test(expected = Exception.class)
	public void getNode() { // OFB = Out of Boundaries
		ILinkedList list = new SingleLinked();
		 int zero = 0;
		 int first = 1;
		 int second = 2;
		 int third = 3;
		 int fourth = 4;
		 int fifth = 5;
		 int sixth = 7;
		list.add(zero, first);
		list.add(first, second);
		list.add(second, third);
		list.add(third, fourth);
		list.add(fourth, fifth);

		Assert.assertEquals(fourth, list.get(third));
		Assert.assertNull(list.get(sixth));
	}

	 // check that getting an element doesn't remove nodes.
	@Test
	public void getNodeCheckSize() {
		ILinkedList list = new SingleLinked();
		 int zero = 0;
		 int first = 1;
		 int second = 2;
		 int third = 3;
		 int fourth = 4;
		 int fifth = 5;
		list.add(zero, first);
		list.add(first, second);
		list.add(second, third);
		list.add(third, fourth);
		list.add(fourth, fifth );

		Assert.assertEquals(fourth, list.get(third));
		Assert.assertEquals(fifth , list.size());
	}

	 // Clear the elements of the list Assure that the list is Empty.
	@Test(expected = Exception.class)
	public void clearList() {
		ILinkedList list = new SingleLinked();
		 int zero = 0;
		 int first = 1;
		 int second = 2;
		 int third = 3;
		 int fourth = 4;
		 int fifth = 5;
		list.add(zero, first);
		list.add(first, second);
		list.add(second, third);
		list.add(third, fourth );
		list.add(fourth , fifth);
		list.clear();

		Assert.assertEquals(zero, list.size());
		Assert.assertTrue(list.isEmpty());
		Assert.assertNull(list.get(second));
	}

	 // Choosing sublist within the list boundaries.
	@Test
	public void chooseSubList() {
		ILinkedList list = new SingleLinked();
		 int zero = 0;
		 int first = 1;
		 int second = 2;
		 int third = 3;
		 int fourth = 4;
		 int fifth = 5;
		list.add(zero, first);
		list.add(first, second);
		list.add(second, third);
		list.add(third, fourth);
		list.add(fourth, fifth);

		ILinkedList newList = new SingleLinked();
		newList = list.sublist(first, third);
		for (int i = first; i < fourth; i++) {
	Assert.assertEquals(i + first, newList.get(i - first));
		}}

	 // Choosing sublist equals that of the original list.
	@Test
	public void subListAsOriginal() {
		ILinkedList list = new SingleLinked();
		 int zero = 0;
		 int first = 1;
		 int second = 2;
		 int three = 3;
		 int fourth = 4;
		 int fifth = 5;
		list.add(zero, first);
		list.add(first, second);
		list.add(second, three);
		list.add(three, fourth);
		list.add(fourth, fifth);

		ILinkedList newList = new SingleLinked();
		newList = list.sublist(zero, fourth);
		for (int i = zero; i < fifth; i++) {
			Assert.assertEquals(list.get(i), newList.get(i));
		}}

	 // Choosing sublist out of the boundaries of original list.
	@Test(expected = Exception.class)
	public void subListOFB() {
		ILinkedList list = new SingleLinked();
		 int zero = 0;
		 int first = 1;
		 int second = 2;
		 int third = 3;
		 int fourth = 4;
		 int fifth = 5;
		 int negative = -1;
		list.add(zero, first);
		list.add(first, second);
		list.add(second, third);
		list.add(third, fourth);
		list.add(fourth, fifth);

		ILinkedList newList = new SingleLinked();
		newList = list.sublist(negative, third);
		Assert.assertNull(newList);
	}
}
