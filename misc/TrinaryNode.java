import java.util.*; // for printing out the tree

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
	* Removes a node by changing this parent's child reference
	* of this node to point to this node's right child,
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

				if (this.parent == null) { // head
					this.data = this.rightChild.data;
					this.leftChild = this.rightChild.leftChild;
					this.leftChild.parent = this;
					this.middleChild = this.rightChild.middleChild;
					this.middleChild.parent = this;
					this.rightChild = this.rightChild.rightChild;
					this.rightChild.parent = this;
				} else {
					if (this.data < this.parent.data)
						this.parent.leftChild = this.rightChild;
					else
						this.parent.rightChild = this.rightChild;
					this.rightChild.parent = this.parent;
				}
			}
			else if (this.leftChild != null) {
				if (this.parent == null) { // head
					this.data = this.leftChild.data;
					this.rightChild = this.leftChild.rightChild;
					this.rightChild.parent = this;
					this.middleChild = this.leftChild.middleChild;
					this.middleChild.parent = this;
					this.leftChild = this.leftChild.leftChild;
					this.leftChild.parent = this;
				} else {
					if (this.data < this.parent.data)
						this.parent.leftChild = this.leftChild;
					else
						this.parent.rightChild = this.leftChild;
					this.leftChild.parent = this.parent;
				}
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

	/**
	* Returns the breadth first traversal
	* as a space delimited string.
	*/
	public String treeBreadth() {
		StringBuilder res = new StringBuilder();
		LinkedList <TrinaryNode> q = new LinkedList <TrinaryNode> ();
		q.add(this);
		do {
			TrinaryNode curNode = q.poll();
			res.append(curNode.data + " ");
			if (curNode.leftChild != null)
				q.add(curNode.leftChild);
			if (curNode.middleChild != null)
				q.add(curNode.middleChild);
			if (curNode.rightChild != null)
				q.add(curNode.rightChild);
		} while (!q.isEmpty());

		res.deleteCharAt(res.length()-1); // remove trailing space
		
		return res.toString();
	}

	/**
	* Returns the pre-order traversal
	* as a space delimited string.
	*/
	public String treePreorder() {
		StringBuilder res = new StringBuilder();
		res.append(this.data + " ");
		if (this.leftChild != null)
			res.append(this.leftChild.treePreorder() + " ");
		if (this.middleChild != null)
			res.append(this.middleChild.treePreorder() + " ");
		if (this.rightChild != null)
			res.append(this.rightChild.treePreorder() + " ");
	
		String result = res.toString().replaceAll("\\s+", " "); // remove extra spaces

		return result.substring(0, result.length()-1);
	}

}
