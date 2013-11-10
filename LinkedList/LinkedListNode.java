public class LinkedListNode {
	public int data;
	public LinkedListNode next;

	LinkedListNode(int data) {
		this.data = data;
		this.next = null;
	}

	public void insertAfter(int nodeData, int newNodeData) {
		if(this.data == nodeData) {
			LinkedListNode oldNext = this.next;
			this.next = new LinkedListNode(newNodeData);
			this.next.next = oldNext;
		} else {
			this.next.insertAfter(nodeData, newNodeData);
		}
	}

	public void removeNode(int nodeData) {
		if (this.data == nodeData) {
			this.next = this.next.next;
		} else if (this.next != null) {
			this.next.removeNode(nodeData);
		}
	}

	public void printList() {
		System.out.println(this.data);
		if(this.next != null) this.next.printList();
	}

	// public static void main(String[] args) {
	// 	LinkedListNode head = new LinkedListNode(10);
	// 	head.insertAfter(10, 4);
	// 	head.insertAfter(10, 3);
	// 	head.insertAfter(4, 5);
	// 	head.removeNode(3);
	// 	head.printList();
	// }

}