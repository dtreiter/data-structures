public class Main {
	public static void main(String[] args) {
		BoundedQueue myQueue = new BoundedQueue(4);
		myQueue.enqueue(1);
		myQueue.enqueue(2);
		myQueue.enqueue(3);
		myQueue.printQueue();
		myQueue.dequeue();
		myQueue.dequeue();
		myQueue.printQueue();
		myQueue.enqueue(4);
		myQueue.enqueue(5);
		myQueue.enqueue(2);
		myQueue.printQueue();
		myQueue.dequeue();
		myQueue.dequeue();
		myQueue.dequeue();
		myQueue.printQueue();
	}
}