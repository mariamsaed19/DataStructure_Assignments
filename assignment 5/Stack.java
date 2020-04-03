package eg.edu.alexu.csd.datastructure.stack;

import java.util.EmptyStackException;
/**
 * Stack implementation using linked list
 * it supplies 6 functions
 * push,pop,IsEmpty,size,peek,printstack
 * @author DELL
 *
 */

public class Stack implements IStack {
	/**
	 * node class to represent the linked list
	 * 
	 */
	public class Node{
		private Object data ;
		private Node next ;
		public Node(Object d) {
			data=d;
			next=null;
		}
	}
	private Node head ;
	private int size;
	/**
	 * constructor to create new stack
	 */
	public Stack() {
		head = null;
		size=0;
	}
/**
* Removes the element at the top of stack and returns that element.
*
* @return top of stack element, or through exception if empty
*/
@Override
public Object pop() {
	if(isEmpty()) {
		throw new EmptyStackException();
	}
	Object x = head.data;
	head= head.next;
	size--;
	return x ;
}
/**
* Get the element at the top of stack without removing it from stack.
*
* @return top of stack element, or through exception if empty
*/
@Override
public Object peek() {
	if(isEmpty()) {
		throw new EmptyStackException();
	}
	Object x = head.data;
	return x ;
}
/**
* Pushes an item onto the top of this stack.
*
* @param element
* to insert
*/
@Override
public void push(Object element) {
	size++;
	if(isEmpty()) {
		head.data=element;
	}
	else {
	Node z = new Node(element);
	z.next=head;
	head=z;
	}

}
/**
* Tests if this stack is empty
*
* @return true if stack empty
*/
@Override
public boolean isEmpty() {
	return size ==0;
}
/**
* Returns the number of elements in the stack.
*
* @return number of elements in the stack
*/
@Override
public int size() {
	return size;
}
/**
 * print elements of the stack
 */
public void printStack() {
	Node curr = head;
	System.out.print("[ ");
	while(curr!=null) {
		System.out.print(curr.data);
		if(curr.next!=null) {
			System.out.print(" ,");
		}
		curr=curr.next;
	}
	System.out.print(" ]");
	System.out.println();
}
}