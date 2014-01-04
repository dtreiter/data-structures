class TrinaryTest {
	static boolean testInsert0() {
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

		String breadth = head.printTreeBreadth();
		String preorder = head.printTreePreorder();
		if (!breadth.equals("1 1 4 2 4 6 2 3 5 6 7 5"))
			return false;
		if (!preorder.equals("1 1 4 2 2 3 4 6 5 5 6 7"))
			return false;

		return true;
	}

	static boolean testInsert1() {
		TrinaryNode head = new TrinaryNode(50);
		head.insert(25);
		head.insert(1);
		head.insert(30);
		head.insert(3);
		head.insert(1);
		head.insert(75);
		head.insert(100);
		head.insert(75);
		head.insert(50);
		head.insert(90);

		String breadth = head.printTreeBreadth();
		String preorder = head.printTreePreorder();
		if (!breadth.equals("50 25 50 75 1 30 75 100 1 3 90"))
			return false;
		if (!preorder.equals("50 25 1 1 3 30 50 75 75 100 90"))
			return false;

		return true;
	}

	static boolean testDelete0() {
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
		head.remove(4);

		String breadth = head.printTreeBreadth();
		String preorder = head.printTreePreorder();
		if (!breadth.equals("1 1 6 5 6 7 2 5 2 3"))
			return false;
		if (!preorder.equals("1 1 6 5 2 2 3 5 6 7"))
			return false;

		return true;
	}

	static boolean testDelete1() {
		TrinaryNode head = new TrinaryNode(50);
		head.insert(25);
		head.insert(1);
		head.insert(30);
		head.insert(3);
		head.insert(1);
		head.insert(75);
		head.insert(100);
		head.insert(75);
		head.insert(50);
		head.insert(90);
		head.remove(25);
		head.remove(100);

		String breadth = head.printTreeBreadth();
		String preorder = head.printTreePreorder();
		if (!breadth.equals("50 30 50 75 1 75 90 1 3"))
			return false;
		if (!preorder.equals("50 30 1 1 3 50 75 75 90"))
			return false;

		return true;
	}

	static boolean testDelete2() {
		TrinaryNode head = new TrinaryNode(50);
		head.insert(25);
		head.insert(1);
		head.insert(30);
		head.insert(3);
		head.insert(1);
		head.insert(75);
		head.insert(100);
		head.insert(75);
		head.insert(50);
		head.insert(90);
		head.remove(50);

		String breadth = head.printTreeBreadth();
		String preorder = head.printTreePreorder();
		System.out.println(breadth);
		if (!breadth.equals("75 25 75 100 1 30 90 1 3"))
			return false;
		if (!preorder.equals("75 25 1 1 3 30 75 100 90"))
			return false;

		return true;
	}

	public static void main(String[] args) {
		assert(testInsert0()) : "Insert0 failed";
		assert(testInsert1()) : "Insert1 failed";
		assert(testDelete0()) : "Delete0 failed";
		assert(testDelete1()) : "Delete1 failed";
		assert(testDelete2()) : "Delete2 failed";
		System.out.println("All assertions passed");
	}
}
