package eg.edu.alexu.csd.datastructure.queue;

public class QueueArray implements IQueue,IArrayBased {

	int front,rear,length,max;
	Object[] arr;
	
	
	
	public QueueArray(int n) {
        front = 0;
        rear = 0;
        length = 0;
        max = n;
        arr = new Object[n];

    }
	@Override
	public void enqueue(Object item) {
		// TODO Auto-generated method stub
		 if (this.size() == max) {
	            throw new UnsupportedOperationException("the queue is full");
	        }
		 arr[rear] = item;
	        if (rear == max - 1) {
	            rear = 0;
	        } else {
	            rear++;
	        }
	        length++;
	}

	@Override
	public Object dequeue() {
		// TODO Auto-generated method stub
		 if (this.isEmpty()) {
	            throw new UnsupportedOperationException("the queue is empty");
	        }
		    Object temp = arr[front];
	        arr[front] = null;
	        if (front == max - 1) {
	            front = 0;
	        } else {
	            front++;
	        }
	        length--;
	        return temp;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return length==0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return length;
	}

	

}