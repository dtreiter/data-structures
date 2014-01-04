import java.util.LinkedList; // for printing out the tree

class TrinaryNode {
	int data;
	TrinaryNode parent, leftChild, middleChild, rightChild;

	TrinaryNode(int val) {
		this.data = val;
		this.parent = null;
		this.leftChild = null;
		this.middleChild = null;
		this.rightChild = null;
	}

	public void insert(int val) {
		if (val < this.data) {
			if (this.leftChild == null) {
				this.leftChild = new TrinaryNode(val);
				this.leftChild.parent = this;
			} else
				this.leftChild.insert(val);
		}
		else if (val == this.data) {
			if (this.middleChild == null) {
				this.middleChild = new TrinaryNode(val);
				this.middleChild.parent = this;
			} else
				this.middleChild.insert(val);
		}
		else {
			if (this.rightChild == null) {
				this.rightChild = new TrinaryNode(val);
				this.rightChild.parent = this;
			} else
				this.rightChild.insert(val);
		}
	}

	/**
	* Deletes all occurences of val from the tree.
	* 
	* Removes a node by changing the parent's child reference
	* of this node to point to the first node's right child,
	* or then left child if no right child, or then null if neither.
	*/
	public void remove(int val) {
		if (val == this.data) {
			if (this.rightChild != null) {
				TrinaryNode curNode = this.rightChild;
				while (curNode.leftChild != null) {
					curNode = curNode.leftChild;
				}
				curNode.leftChild = this.leftChild;
				this.leftChild.parent = curNode;

				if (this.data < this.parent.data)
					this.parent.leftChild = this.rightChild;
				else
					this.parent.rightChild = this.rightChild;
				this.rightChild.parent = this.parent;
			}
			else if (this.leftChild != null) {
				if (this.data < this.parent.data)
					this.parent.leftChild = this.leftChild;
				else
					this.parent.rightChild = this.leftChild;
				this.leftChild.parent = this.parent;
			}
			else {
				if (this.data < this.parent.data) {
					this.parent.leftChild = null;
				} else
					this.parent.rightChild = null;
			}
		} else if (val < this.data) {
			this.leftChild.remove(val);
		} else if (val > this.data) {
			this.rightChild.remove(val);
		}
	}

	public void printTreeBreadth() {
		LinkedList <TrinaryNode> q = new LinkedList <TrinaryNode> ();
		q.add(this);
		do {
			TrinaryNode curNode = q.poll();
			System.out.println (curNode.data);
			if (curNode.leftChild != null)
				q.add(curNode.leftChild);
			if (curNode.middleChild != null)
				q.add(curNode.middleChild);
			if (curNode.rightChild != null)
				q.add(curNode.rightChild);
		} while (!q.isEmpty());
	}

	public void printTreePreorder() {
		System.out.println(this.data);
		if (this.leftChild != null)
			this.leftChild.printTreePreorder();
		if (this.middleChild != null)
			this.middleChild.printTreePreorder();
		if (this.rightChild != null)
			this.rightChild.printTreePreorder();
	}


	public static void main(String[] args) {
		TrinaryNode head = new TrinaryNode(1);
		head.insert(4);
		head.insert(2);
		head.insert(3);
		head.insert(2);
		head.insert(4);
		head.insert(1);
		head.insert(6);
		head.insert(5);
		head.insert(6);
		head.insert(7);
		head.insert(5);
		System.out.println("Breadth-first traversal");
		head.printTreeBreadth();
		System.out.println("\nPreorder traversal");
		head.printTreePreorder();

		head.remove(4);
		System.out.println("\n\nRemoved 4");
		System.out.println("Breadth-first traversal");
		head.printTreeBreadth();
		System.out.println("\nPreorder traversal");
		head.printTreePreorder();
		System.out.println("\nRan");
	}
	
}
