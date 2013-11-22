import java.util.*;

/*
	An iterative solution to the Towers of Hanoi problem.
	Solves in least possible number of moves.
*/
class TowerOfHanoi {
	List <Stack <Integer>> rods = new ArrayList <Stack <Integer>> ();
	int  direction, smallDiskRod, largeDiskRod;

	public TowerOfHanoi(int numDisks) {
		for (int i = 0; i < 3; i++) {
			rods.add(new Stack <Integer> ());
		}

		for (int i = numDisks; i > 0; i--) {
			rods.get(0).push(i);
			smallDiskRod = 0;
			largeDiskRod = 0;
			direction = (numDisks % 2 == 0) ? 1 : -1;
		}
	}

	// public void solve() {
	// 	Boolean gameEnd = false;
	// 	Boolean moveSmall = true;
	// 	int largestSeen = 0;
	// 	while (!gameEnd) {
	// 		if (moveSmall) {
	// 			int nextRod = (smallDiskRod+direction) % rods.size();
	// 			this.moveDisk(rods.get(smallDiskRod), rods.get(nextRod);
	// 			smallDiskRod = nextRod;
	// 			moveSmall = false;
	// 			if (rods.get(smallDiskRod).peek() > largestSeen) {
	// 				largestSeen = rods.get(smallDiskRod).peek();
	// 			}
	// 		} else {
	// 			for (int i = 0; i < rods.size(); i++) {
	// 				if (rods.get(i).peek() > largestSeen) {
	// 					largestSeen = rods.get(smallDiskRod).peek();
	// 					largeDiskRod = i;
	// 				}
	// 			}

	// 			for (int i = 0; i < rods.size(); i++) {
	// 				if (isValidMove(rods.get(largeDiskRod), rods.get(i))) {
	// 					this.moveDisk(rods.get(largeDiskRod), rods.get(i));
	// 				}
	// 			}

	// 			moveSmall = true;
	// 		}

	// 		gameEnd = this.isGameOver();
	// 	}
	// }

	// public Boolean isValidMove(Stack <Integer> start, Stack <Integer> end) {
	// 	if (start.peek() < end.peek() || end.isEmpty())
	// 		return true;
	// 	return false;
	// }

	// public void moveDisk(Stack <Integer> start, Stack <Integer> end) {
	// 	int disk = start.pop();
	// 	end.push(disk);
	// }

	// public Boolean isGameOver() {
	// 	if (rods.get(0).isEmpty() && rods.get(1).isEmpty())
	// 		return true;
	// 	return false;
	// }

	public void printTowers() {
		Stack <Integer> tmp = new Stack <Integer> ();
		String[] towers = new String[rods.size()];
		for (int i = 0; i < rods.size(); i++) {
			towers[i] = "";
			while (!rods.get(i).isEmpty()) {
				Integer topDisk = rods.get(i).peek();
				towers[i] += topDisk.toString();
				tmp.push(rods.get(i).pop());
			}

			while (!tmp.isEmpty()) { // put back
				rods.get(i).push(tmp.pop());
			}
		}

		for (int i = 0; i < rods.size(); i++) { 
			System.out.println(rods.get(0).peek());
		}
	}

}
