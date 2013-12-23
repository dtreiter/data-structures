// Bounded Queue using only primitive data types
import java.util.*;

public class BoundedQueue {
	private int bound;
	private int[] data;
	private int front, back, size;

	BoundedQueue(int bound) {
		this.bound = bound;
		this.data = new int[bound];
		this.front = 0;
		this.back = 0;
		this.size = 0;
	}

	public void enqueue(int value) {
		if(size < bound) {
			data[back++] = value;
			if(back >= bound) back = back % bound;
			size++;
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	public int dequeue() {
		if(size <= 0) {
			throw new IndexOutOfBoundsException();
		} else {
			int value = data[front++];
			if(front >= bound) front = front % bound;
			size--;
			return value;
		}
	}

	public void printQueue() {
		String queue = "";
		int end = front+size;
		for(int i = front; i < end; i++) {
			if(i == end-1) {
				queue += data[i%bound];
			} else {
				queue += data[i%bound] + ", ";
			}	
		}
		System.out.println(queue);
	}
}
