package eg.edu.alexu.csd.datastructure.linkedList.cs76_cs88;

public class DoublyLinkedList implements ILinkedList{
	private int size ;
	private Dlinked_Node head = new Dlinked_Node(null) , tail = new Dlinked_Node(null);
	public class Dlinked_Node{
		private Object element ;
		private Dlinked_Node next , prev;
		Dlinked_Node(Object e){
			element = e;
			next = prev = null ;
		}
	}
	public DoublyLinkedList(){
	this.size=0;
	head.next=tail;
	tail.prev=head;
	
	}
	
		/**
		* Inserts a specified element at the specified position in the list.
		* @param index
		* @param element
		*/
		public void add(int index, Object element) {
			if(index-1<=size) {
			Dlinked_Node a = new Dlinked_Node(element);
			Dlinked_Node curr = head ;
			if(size==0) {
				size++;
				head.next=a;
				tail.prev=a;
				a.prev=head;
				a.next=tail;
				return;
			}
			for(int i= 1;i<=index&&curr!=tail;i++) {
				curr = curr.next;
			}
			size++;
			a.prev = curr.prev ;
			curr.prev.next=a;
			a.next = curr ;
			curr.prev = a ;
			}
			else {
				return;
			}
		}
		/**
		* Inserts the specified element at the end of the list.
		* @param element
		*/
		public void add(Object element) {
			size++;
			Dlinked_Node a = new Dlinked_Node(element);
			Dlinked_Node temp = tail.prev;
			a.next = tail;
			tail.prev=a;
			a.prev=temp;
			temp.next=a;
		}
		/**
		* @param index
		* @return the element at the specified position in this list.
		*/
		public Object get(int index) {
			if(index>size) {
				return null;
			}
			Dlinked_Node curr = head ;
			for(int i = 1;i<=index&&curr!=tail;i++) {
				curr = curr.next;
			}
			return curr.element ;
		}
		/**
		* Replaces the element at the specified position in this list with the
		* specified element.
		* @param index
		* @param element
		*/
		public void set(int index, Object element) {
			Dlinked_Node curr = head ;
			for(int i = 1;i<=index&&curr!=tail;i++) {
				curr =curr.next;
			}
			if(curr!=tail&&curr!=head)
			curr.element=element;
		}
		/**
		* Removes all of the elements from this list.
		*/
		public void clear() {
			size =0;
			head.next=tail;
			tail.prev = head ;
		}
		/**
		* @return true if this list contains no elements.
		*/
		public boolean isEmpty() {
			return (size==0);
		}
		/**
		* Removes the element at the specified position in this list.
		* @param index
		*/
		public void remove(int index) {
			if(index<=size) {
			size--;
			Dlinked_Node curr = head ;
			for(int i = 1;i<=index&&curr!=tail;i++) {
				curr = curr.next;
			}
			curr.prev.next=curr.next;
			curr.next.prev=curr.prev;
			
			}
			else {
				return;
			}
		}
		/**
		* @return the number of elements in this list.
		*/
		public int size() {

			return size;
		}
		/**
		* @param fromIndex
		* @param toIndex
		* @return a view of the portion of this list between the specified
		* fromIndex and toIndex, inclusively.
		*/
		public ILinkedList sublist(int fromIndex, int toIndex) {
		//get initial index
		ILinkedList sub = new DoublyLinkedList();
		if(fromIndex<0||toIndex>size) {
			throw null;
		}
		Dlinked_Node curr = head ;
		for(int i=0 ;i<fromIndex;i++) {
			curr=curr.next;
		}
		for(int i = fromIndex ;i<=toIndex;i++) {
			sub.add(curr.element);
			curr=curr.next;
		}
			return sub;
			
		}
		/**
		* @param o
		* @return true if this list contains an element with the same value as the
		* specified element.
		*/
		public boolean contains(Object o) {
			Dlinked_Node curr = head ;
			while(curr!=tail) {
				curr = curr.next;
				if(curr.element==o) {
					return true;
				}
			}
			return false;
		}
		public void printList() {
			Dlinked_Node curr =head;
			while(curr.next!=tail) {
			System.out.println(curr.next.element);
			curr=curr.next;
			}
			System.out.println("end print");
		}

	
			 


	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		 
		 int first = 1;
		 int second = 2;
		 int third = 3;
		 int fourth = 4;
		 int fifth = 5;
		
		list.add(first,first);
		list.add(second,second);
		list.add(third,third);
		list.add(fourth,fourth);
		list.add(fifth,fifth);
		list.printList();
		list.remove(first);
		list.printList();
		System.out.println(list.size);
		
		
	}

}