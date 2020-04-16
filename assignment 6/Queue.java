package eg.edu.alexu.csd.datastructure.queue;

import java.util.NoSuchElementException;

public class Queue implements IQueue,ILinkedBased {
public class Node{
	private Object data ;
	private Node next ;
	public Node(Object d) {
		data=d;
		next=null;
		}
	}
private Node front,rear;
private int size;
public Queue() {
	front=null;
	rear=front;
	size=0;
}

/**
* Inserts an item at the queue front.
*/
public void enqueue(Object item) {
	Node z=new Node(item);
	if(isEmpty()) {
		front= z;
	}
	else {

		rear.next=z;
	}
	rear=z;
	size++;
}
/**
* Removes the object at the queue rear and returns it.
*/
public Object dequeue() {
	if(isEmpty()) {
	throw new NoSuchElementException("queue is Empty !");	
	}
	size--;
	Object item = front.data;
	front=front.next;
	return item;
}
/**
* Tests if this queue is empty.
*/
public boolean isEmpty() {
	return size==0;
}
/**
* Returns the number of elements in the queue
*/
public int size() {
	return size;
}
public void printQueue() {
	Node curr=front;
	while(curr!=null) {
		System.out.print(curr.data);
		curr=curr.next;
	}
	System.out.println("\n****");
}
}